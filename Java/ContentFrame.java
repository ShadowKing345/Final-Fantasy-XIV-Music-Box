package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ContentFrame extends JFrame {

    //Object declaration
    public GeneralActionHandler generalActionHandler;
    public PlayActionHandler playActionHandler;

    //Menu Bar
    public JMenuBar menuBar;
    public JMenu fileMenu;
    public JMenuItemDesign settingMenuItem;
    public JMenuItemDesign loadMenuItem;
    public JMenuItem exitMenuItem;
    public JMenu playMenu;
    public JMenuItemDesign beginMenuItem;
    public JMenuItemDesign stopMenuItem;
    public JSeparator separator;

    //Panels
    public JPanel contentPanel;
    public DisplayPanel displayPanel;
    public DisplayButtonPanel displayButtonPanel;
    public GeneralButtonPanel generalButtonPanel;

    public ContentFrame() {
        Initialization();
    }

    private void Initialization() {
        generalActionHandler = new GeneralActionHandler();
        playActionHandler = new PlayActionHandler();
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        settingMenuItem = new JMenuItemDesign(generalActionHandler,"Setting");
        loadMenuItem = new JMenuItemDesign(generalActionHandler,"Load");
        exitMenuItem = new JMenuItemDesign(generalActionHandler,"Exit");
        playMenu = new JMenu("play");
        beginMenuItem = new JMenuItemDesign(playActionHandler,"Begin");
        stopMenuItem = new JMenuItemDesign(playActionHandler,"Stop");
        separator = new JSeparator();
        contentPanel = new JPanel();
        displayPanel = new DisplayPanel();
        displayButtonPanel = new DisplayButtonPanel();
        generalButtonPanel = new GeneralButtonPanel();

        //this properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(References.size);
        this.setLocation((References.screenSize.width / 2) - (this.getWidth() / 2), (References.screenSize.height / 2) - (this.getHeight() / 2));
        this.setTitle("Final Fantasy XIV Music Box");
        //this.setResizable(false);

        //MenuBar properties
        this.setJMenuBar(menuBar);
        //File
        menuBar.add(fileMenu);

        fileMenu.add(settingMenuItem);
        fileMenu.add(loadMenuItem);
        fileMenu.add(separator);
        fileMenu.add(exitMenuItem);

        //play
        menuBar.add(playMenu);
        playMenu.add(beginMenuItem);
        playMenu.add(stopMenuItem);

        //ContentPanel properties
        this.setContentPane(contentPanel);
        contentPanel.setLayout(null);
        contentPanel.add(displayPanel);
        contentPanel.add(displayButtonPanel);
        contentPanel.add(generalButtonPanel);
    }

    class DisplayPanel extends JPanel {
        JLabel fileLocationLabel;
        JTextField fileLocationTextField;
        JButton loadFileButton;

        public DisplayPanel() {
            Initialization();
        }

        void Initialization() {
            fileLocationLabel = new JLabel("File Directory: ");
            fileLocationTextField = new JTextField();
            loadFileButton = new JButtonDesign(generalActionHandler, References.buttonBackgroundColor, "", new Dimension(25,25));

            //This properties
            this.setLocation(3,3);
            this.setSize(409, 268);
            this.setBackground(References.panelColor);
            this.setLayout(null);

            //File_Location_Label properties
            fileLocationLabel.setLocation(3,3);
            fileLocationLabel.setSize(83, 25);
            this.add(fileLocationLabel);

            //File_Location_TextField properties
            fileLocationTextField.setLocation(85,3);
            fileLocationTextField.setSize(295,25);
            this.add(fileLocationTextField);

            //Load_File_Button properties
            loadFileButton.setLocation(381,3);
            this.add(loadFileButton);

            //todo: Create "play" area
        }
    }

    class DisplayButtonPanel extends JPanel {
        //Object declarations
        JButton beginButton;
        JButton stopButton;

        public DisplayButtonPanel() {
            Initialization();
        }

        void Initialization(){
            beginButton = new JButtonDesign(playActionHandler,References.buttonBackgroundColor,"Begin",new Dimension(200,50));
            stopButton = new JButtonDesign(playActionHandler,References.buttonBackgroundColor,"Stop",new Dimension(200,50));

            //This properties
            this.setLayout(null);
            this.setLocation(3,276);
            this.setSize(409, References.actualSize.height - this.getY() - this.getX());
            this.setBackground(References.panelColor);

            //Begin_Button Properties
            beginButton.setLocation(3,3);
            this.add(beginButton);

            //Stop_Button Properties
            stopButton.setLocation(206,3);
            this.add(stopButton);
        }
    }

    class GeneralButtonPanel extends JPanel {
        //Object declarations
        JButton settingsButton;
        JButton loadButton;
        JButton exitButton;

        public GeneralButtonPanel() {
            Initialization();
        }

        void Initialization() {
            settingsButton = new JButtonDesign(generalActionHandler,References.buttonBackgroundColor,"Setting", new Dimension(150,50));
            loadButton = new JButtonDesign(generalActionHandler,References.buttonBackgroundColor,"Load", new Dimension(150,50));
            exitButton = new JButtonDesign(generalActionHandler,References.buttonBackgroundColor,"Exit", new Dimension(150,50));

            //This properties
            this.setLocation(415, 3);
            this.setSize(References.actualSize.width - this.getX() - 3,268);
            this.setLayout(null);
            this.setBackground(References.panelColor);

            //todo: Create metronome

            //Settings properties
            settingsButton.setLocation(3, 103);
            this.add(settingsButton);

            //Load_Button properties
            loadButton.setLocation(3,159);
            this.add(loadButton);

            //Exit_Button properties
            exitButton.setLocation(3,this.getHeight() - exitButton.getHeight() -3);
            this.add(exitButton);
        }
    }

    class GeneralActionHandler implements ActionListener {

        JFileChooser fileChooser = new JFileChooser();

        //@Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Main.frame.exitMenuItem || e.getSource() == Main.frame.generalButtonPanel.exitButton) {
                Main.closingArguments();
            }else if (e.getSource() == Main.frame.generalButtonPanel.loadButton || e.getSource() == Main.frame.loadMenuItem || e.getSource() == Main.frame.displayPanel.loadFileButton) {
                fileChooser.setCurrentDirectory(new File("Sheets"));
                if(fileChooser.showOpenDialog(Main.frame) == 0){
                    Main.frame.displayPanel.fileLocationTextField.setText(fileChooser.getSelectedFile().toString());
                }
            }else if (e.getSource() == Main.frame.generalButtonPanel.settingsButton || e.getSource() == Main.frame.settingMenuItem) {
                //todo: Create settings form
            }

        }
    }

    class PlayActionHandler implements ActionListener {

        Thread testThread = new Thread(){
            public void run() {
                Play.play(5000, Main.frame.displayPanel.fileLocationTextField.getText());
            }
        };

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Main.frame.beginMenuItem || e.getSource() == Main.frame.displayButtonPanel.beginButton) {
                if (Main.frame.displayPanel.fileLocationTextField.getText().equals(""))
                    return;
                //Todo:Find a better location for this thread;
                testThread.run();
            } else if (e.getSource() == Main.frame.stopMenuItem || e.getSource() == Main.frame.displayButtonPanel.stopButton) {
                try {
                    //Todo: Add a way to stop the thread.
                }catch (Exception ignored){}
            }
        }
    }

    class JButtonDesign extends JButton {
        JButtonDesign(ActionListener listener, Color color, String text, Dimension size) {
            super(text);
            this.setSize(size);
            this.setBorder(null);
            this.setBackground(color);
            this.addActionListener(listener);
        }
    }
    class JMenuItemDesign extends JMenuItem {
        JMenuItemDesign(ActionListener handler, String text) {
            super(text);
            this.addActionListener(handler);
        }
    }
}
