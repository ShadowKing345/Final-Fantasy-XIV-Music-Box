package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Deprecated
class Settings extends JPanel{

    static KeyBindComponent[] keyBinds = {new KeyBindComponent("Note C", KeyEvent.VK_Q), new KeyBindComponent("Note Cs", KeyEvent.VK_2), new KeyBindComponent("Note D", KeyEvent.VK_W), new KeyBindComponent("Note Eb", KeyEvent.VK_3),
            new KeyBindComponent("Note E", KeyEvent.VK_E), new KeyBindComponent("Note F", KeyEvent.VK_R), new KeyBindComponent("Note Fs", KeyEvent.VK_5), new KeyBindComponent("Note G", KeyEvent.VK_T),
            new KeyBindComponent("Note Gs", KeyEvent.VK_6), new KeyBindComponent("Note A", KeyEvent.VK_Y), new KeyBindComponent("Note Bb", KeyEvent.VK_7), new KeyBindComponent("Note B", KeyEvent.VK_U),
            new KeyBindComponent("Note C+1", KeyEvent.VK_I), new KeyBindComponent("-1 Octave", KeyEvent.VK_CONTROL), new KeyBindComponent("+1 Octave", KeyEvent.VK_SHIFT)};
    JLabel tempoLabel = new JLabel("Tempo");
    JTextField tempoField = new JTextField();
    int tempo = 2500;
    JButton save = new JButton("Save");

    Settings() {
        this.setFromConfig();
        this.setBackground(References.innerPanelCol);
        this.setLayout(null);
        keyBinds[0].setBounds(3,3, References.buttonSize.width, References.buttonSize.height);

        for (int i = 1; i < keyBinds.length; i++) {
            if (i == keyBinds.length / 2 + 1){
                keyBinds[keyBinds.length / 2 + 1].setBounds(keyBinds[0].getButton().getX() + keyBinds[0].getButton().getWidth() + 20,keyBinds[0].getButton().getY(), References.buttonSize.width, References.buttonSize.height);
                continue;
            }
            keyBinds[i].setBounds(keyBinds[i-1].getLabel().getX(),keyBinds[i-1].getLabel().getY() + keyBinds[i-1].getLabel().getHeight() + 3, References.buttonSize.width, References.buttonSize.height);
        }

        tempoLabel.setBounds(keyBinds[14].getLabel().getX(),keyBinds[14].getLabel().getY() + keyBinds[14].getLabel().getHeight() + 3, 100, 40);
        tempoField.setBounds(keyBinds[14].getButton().getX(),tempoLabel.getY(), 200, 40);
        tempoField.setText(Integer.toString(tempo));

        save.setBounds(keyBinds[7].getLabel().getX(), keyBinds[7].getLabel().getY() + keyBinds[7].getLabel().getHeight() + 7, (tempoField.getX() + tempoField.getWidth()) - keyBinds[0].getLabel().getX(), 40);
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saveToConfig();
            }
        });

        for (KeyBindComponent keyBind : keyBinds) {

            this.add(keyBind.getLabel());
            this.add(keyBind.getButton());
        }
        this.add(tempoLabel);
        this.add(tempoField);
        this.add(save);

        Thread thread = new Thread();
        thread.start();
        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setFromConfig() {
        References.config.load();
        keyBinds[0].setKeyCode(Integer.parseInt(References.config.noteC));
        keyBinds[1].setKeyCode(Integer.parseInt(References.config.noteCs));
        keyBinds[2].setKeyCode(Integer.parseInt(References.config.noteD));
        keyBinds[3].setKeyCode(Integer.parseInt(References.config.noteEb));
        keyBinds[4].setKeyCode(Integer.parseInt(References.config.noteE));
        keyBinds[5].setKeyCode(Integer.parseInt(References.config.noteF));
        keyBinds[6].setKeyCode(Integer.parseInt(References.config.noteFs));
        keyBinds[7].setKeyCode(Integer.parseInt(References.config.noteG));
        keyBinds[8].setKeyCode(Integer.parseInt(References.config.noteGs));
        keyBinds[9].setKeyCode(Integer.parseInt(References.config.noteA));
        keyBinds[10].setKeyCode(Integer.parseInt(References.config.noteB));
        keyBinds[11].setKeyCode(Integer.parseInt(References.config.noteBb));
        keyBinds[12].setKeyCode(Integer.parseInt(References.config.noteC1));
        keyBinds[13].setKeyCode(Integer.parseInt(References.config.decreaseOctave));
        keyBinds[14].setKeyCode(Integer.parseInt(References.config.increaseOctave));
        tempo = Integer.parseInt(References.config.tempo);

        for (int i = 0; i < keyBinds.length; i++)
            keyBinds[i].updateText();
        tempoField.setText(String.valueOf(tempo));
    }

    private void saveToConfig() {
        References.config.noteC = String.valueOf(keyBinds[0].getKeyCode());
        References.config.noteCs = String.valueOf(keyBinds[1].getKeyCode());
        References.config.noteD = String.valueOf(keyBinds[2].getKeyCode());
        References.config.noteEb = String.valueOf(keyBinds[3].getKeyCode());
        References.config.noteE = String.valueOf(keyBinds[4].getKeyCode());
        References.config.noteF = String.valueOf(keyBinds[5].getKeyCode());
        References.config.noteFs = String.valueOf(keyBinds[6].getKeyCode());
        References.config.noteG = String.valueOf(keyBinds[7].getKeyCode());
        References.config.noteGs = String.valueOf(keyBinds[8].getKeyCode());
        References.config.noteA = String.valueOf(keyBinds[9].getKeyCode());
        References.config.noteB = String.valueOf(keyBinds[10].getKeyCode());
        References.config.noteBb = String.valueOf(keyBinds[11].getKeyCode());
        References.config.noteC1 = String.valueOf(keyBinds[12].getKeyCode());
        References.config.decreaseOctave = String.valueOf(keyBinds[13].getKeyCode());
        References.config.increaseOctave = String.valueOf(keyBinds[14].getKeyCode());
        References.config.tempo = String.valueOf(tempo);
        References.config.saveConfig();
    }

    static class KeyBindComponent {
        Object keyCode;
        JLabel label;
        JButton button;


        public KeyBindComponent(String labelText, Object keyBind){
            this.keyCode = keyBind;
            this.label = new JLabel(labelText);
            this.button = new JButton();

            button.setText(KeyEvent.getKeyText((int) keyBind));
            //Disabled till proper key bind method discovered. Use default key binds on US style keyboard.
//            button.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mousePressed(MouseEvent e) {
//                    button.addKeyListener(new KeyAdapter() {
//                        @Override
//                        public void keyPressed(KeyEvent e) {
//                            keyCode = e.getKeyCode();
//                            button.setText(KeyEvent.getKeyText((int) keyCode));
//                        }
//                    });
//                    Scanner s = new Scanner(System.in);
//                    int key = s.nextInt();
//                    keyCode = key;
//                    button.setText(String.valueOf(key));
//                }
//
//                @Override
//                public void mouseReleased(MouseEvent e) {
//                    button.removeKeyListener(button.getKeyListeners()[0]);
//                }
//            });
        }

        public void setBounds(int x, int y, int width, int height) {
            label.setBounds(x, y, width / 2, height);
            button.setBounds(x +  width / 2 + 3, y, width, height);
        }

        public void setKeyCode(int code) {
            this.keyCode = code;
        }

        public void setLocation(int x, int y) {
            label.setLocation(x, y);
            button.setLocation(x + label.getWidth() + 3, y);
        }

        public void setSize(int width, int height) {
            label.setSize(width / 2, height);
            button.setBounds(label.getX() + 3, label.getY(), width, height);
        }

        public void setFont(Font font) {
            label.setFont(font);
            button.setFont(font);
        }

        public void updateText() {
            this.button.setText(KeyEvent.getKeyText((int) this.keyCode));
        }

        public JLabel getLabel() {
            return label;
        }

        public JButton getButton() {
            return button;
        }

        public Object getKeyCode() {
            return keyCode;
        }
    }

    class Thread extends java.lang.Thread {
        @Override
        public void run(){
            while (true) {
                String tempoText = tempoField.getText();
                if (tempoText.equals("") || tempoText.equals("0"))
                    tempo = 1;
                else
                    try {
                        tempo = Integer.parseInt(tempoText);
                    } catch (NumberFormatException e) {
                        tempo = 1;
                    }
            }
        }
    }

}
