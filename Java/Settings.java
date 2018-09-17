package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Settings extends JPanel{

    static Config config = new Config();
    static int[] keyCodes = {KeyEvent.VK_Q, KeyEvent.VK_2, KeyEvent.VK_W, KeyEvent.VK_3, KeyEvent.VK_E, KeyEvent.VK_R, KeyEvent.VK_5, KeyEvent.VK_T, KeyEvent.VK_6, KeyEvent.VK_Y, KeyEvent.VK_7, KeyEvent.VK_U, KeyEvent.VK_I, KeyEvent.VK_CONTROL, KeyEvent.VK_SHIFT};
    static KeyBindComponent[] keyBinds = {new KeyBindComponent("Note C", keyCodes[0]), new KeyBindComponent("Note Cs", keyCodes[1]), new KeyBindComponent("Note D", keyCodes[2]), new KeyBindComponent("Note Eb", keyCodes[3]),
            new KeyBindComponent("Note E", keyCodes[4]), new KeyBindComponent("Note F", keyCodes[5]), new KeyBindComponent("Note Fs", keyCodes[6]), new KeyBindComponent("Note G", keyCodes[7]),
            new KeyBindComponent("Note Gs", keyCodes[8]), new KeyBindComponent("Note A", keyCodes[9]), new KeyBindComponent("Note Bb", keyCodes[10]), new KeyBindComponent("Note B", keyCodes[11]),
            new KeyBindComponent("Note C+1", keyCodes[12]), new KeyBindComponent("-1 Octave", keyCodes[13]), new KeyBindComponent("+1 Octave", keyCodes[14])};
    JLabel tempoLabel = new JLabel("Tempo");
    JTextField tempoField = new JTextField();
    int tempo = 2500;
    JButton save = new JButton("Save");

    Settings() {
        this.setConfig();
        this.setLayout(null);
        keyBinds[0].setBounds(3,3, 200, 40);
        keyBinds[1].setBounds(keyBinds[0].getLabel().getX(),keyBinds[0].getLabel().getY() + keyBinds[0].getLabel().getHeight() + 3, 200, 40);
        keyBinds[2].setBounds(keyBinds[1].getLabel().getX(),keyBinds[1].getLabel().getY() + keyBinds[1].getLabel().getHeight() + 3, 200, 40);
        keyBinds[3].setBounds(keyBinds[2].getLabel().getX(),keyBinds[2].getLabel().getY() + keyBinds[2].getLabel().getHeight() + 3, 200, 40);
        keyBinds[4].setBounds(keyBinds[3].getLabel().getX(),keyBinds[3].getLabel().getY() + keyBinds[3].getLabel().getHeight() + 3, 200, 40);
        keyBinds[5].setBounds(keyBinds[4].getLabel().getX(),keyBinds[4].getLabel().getY() + keyBinds[4].getLabel().getHeight() + 3, 200, 40);
        keyBinds[6].setBounds(keyBinds[5].getLabel().getX(),keyBinds[5].getLabel().getY() + keyBinds[5].getLabel().getHeight() + 3, 200, 40);
        keyBinds[7].setBounds(keyBinds[6].getLabel().getX(),keyBinds[6].getLabel().getY() + keyBinds[6].getLabel().getHeight() + 3, 200, 40);

        keyBinds[8].setBounds(keyBinds[0].getButton().getX() + keyBinds[0].getButton().getWidth() + 20,keyBinds[0].getButton().getY(), 200, 40);
        keyBinds[9].setBounds(keyBinds[8].getLabel().getX(),keyBinds[8].getLabel().getY() + keyBinds[8].getLabel().getHeight() + 3, 200, 40);
        keyBinds[10].setBounds(keyBinds[9].getLabel().getX(),keyBinds[9].getLabel().getY() + keyBinds[9].getLabel().getHeight() + 3, 200, 40);
        keyBinds[11].setBounds(keyBinds[10].getLabel().getX(),keyBinds[10].getLabel().getY() + keyBinds[10].getLabel().getHeight() + 3, 200, 40);
        keyBinds[12].setBounds(keyBinds[11].getLabel().getX(),keyBinds[11].getLabel().getY() + keyBinds[11].getLabel().getHeight() + 3, 200, 40);
        keyBinds[13].setBounds(keyBinds[12].getLabel().getX(),keyBinds[12].getLabel().getY() + keyBinds[12].getLabel().getHeight() + 3, 200, 40);
        keyBinds[14].setBounds(keyBinds[13].getLabel().getX(),keyBinds[13].getLabel().getY() + keyBinds[13].getLabel().getHeight() + 3, 200, 40);
        tempoLabel.setBounds(keyBinds[14].getLabel().getX(),keyBinds[14].getLabel().getY() + keyBinds[14].getLabel().getHeight() + 3, 100, 40);
        tempoField.setBounds(keyBinds[14].getButton().getX(),tempoLabel.getY(), 200, 40);
        tempoField.setText(Integer.toString(tempo));

        save.setBounds(keyBinds[7].getLabel().getX(), keyBinds[7].getLabel().getY() + keyBinds[7].getLabel().getHeight() + 7, (tempoField.getX() + tempoField.getWidth()) - keyBinds[0].getLabel().getX(), 40);
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        this.add(keyBinds[0].getLabel());
        this.add(keyBinds[0].getButton());
        this.add(keyBinds[1].getLabel());
        this.add(keyBinds[1].getButton());
        this.add(keyBinds[2].getLabel());
        this.add(keyBinds[2].getButton());
        this.add(keyBinds[3].getLabel());
        this.add(keyBinds[3].getButton());
        this.add(keyBinds[4].getLabel());
        this.add(keyBinds[4].getButton());
        this.add(keyBinds[5].getLabel());
        this.add(keyBinds[5].getButton());
        this.add(keyBinds[6].getLabel());
        this.add(keyBinds[6].getButton());
        this.add(keyBinds[7].getLabel());
        this.add(keyBinds[7].getButton());
        this.add(keyBinds[8].getLabel());
        this.add(keyBinds[8].getButton());
        this.add(keyBinds[9].getLabel());
        this.add(keyBinds[9].getButton());
        this.add(keyBinds[10].getLabel());
        this.add(keyBinds[10].getButton());
        this.add(keyBinds[11].getLabel());
        this.add(keyBinds[11].getButton());
        this.add(keyBinds[12].getLabel());
        this.add(keyBinds[12].getButton());
        this.add(keyBinds[13].getLabel());
        this.add(keyBinds[13].getButton());
        this.add(keyBinds[14].getLabel());
        this.add(keyBinds[14].getButton());
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

    private void setConfig() {
        config.load();
        keyCodes[0] = Integer.parseInt(config.noteC);
        keyCodes[1] = Integer.parseInt(config.noteCs);
        keyCodes[2] = Integer.parseInt(config.noteD);
        keyCodes[3] = Integer.parseInt(config.noteEb);
        keyCodes[4] = Integer.parseInt(config.noteE);
        keyCodes[5] = Integer.parseInt(config.noteF);
        keyCodes[6] = Integer.parseInt(config.noteFs);
        keyCodes[7] = Integer.parseInt(config.noteG);
        keyCodes[8] = Integer.parseInt(config.noteGs);
        keyCodes[9] = Integer.parseInt(config.noteA);
        keyCodes[10] = Integer.parseInt(config.noteBb);
        keyCodes[11] = Integer.parseInt(config.noteB);
        keyCodes[12] = Integer.parseInt(config.noteC1);
        keyCodes[13] = Integer.parseInt(config.decreseOctave);
        keyCodes[14] = Integer.parseInt(config.increaseOctave);
        tempo = Integer.parseInt(config.tempo);
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

        public JLabel getLabel() {
            return label;
        }

        public JButton getButton() {
            return button;
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
