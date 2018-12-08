package Java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ContentFrame extends JFrame {

    //Object declaration
    GeneralActionHandler generalActionHandler = new GeneralActionHandler();

    //Menu Bar
    public JMenuBar menuBar = new JMenuBar();
    public JMenu fileMenu = new JMenu("File");
    public JMenuItem settingMenuItem = new JMenuItem("Setting");
    public JMenuItem loadMenuItem = new JMenuItem("Load");
    public JMenuItem exitMenuItem = new JMenuItem("Exit");

    public JMenu playMenu = new JMenu("Play");
    public JMenuItem beginMenuItem = new JMenuItem("Begin");
    public JMenuItem stopMenuItem = new JMenuItem("Stop");

    public JSeparator separator = new JSeparator();

    //Panels
    public JPanel contentPanel = new JPanel();
    public DisplayPanel displayPanel = new DisplayPanel();
    public DisplayButtonPanel displayButtonPanel = new DisplayButtonPanel();
    public GeneralButtonPanel generalButtonPanel = new GeneralButtonPanel();

    public ContentFrame() {
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
        settingMenuItem.addActionListener(generalActionHandler);
        fileMenu.add(loadMenuItem);
        loadMenuItem.addActionListener(generalActionHandler);
        fileMenu.add(separator);
        fileMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(generalActionHandler);

        //Play
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
        JLabel fileLocationLabel = new JLabel("File Directory: ");
        JTextField fileLocationTextField = new JTextField();
        JButton loadFileButton = new JButton();

        public DisplayPanel() {
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
            loadFileButton.setSize(25,25);
            loadFileButton.setBorder(null);
            loadFileButton.addActionListener(generalActionHandler);
            this.add(loadFileButton);
        }
    }

    class DisplayButtonPanel extends JPanel {
        //Object declarations
        JButton beginButton = new JButton("Begin");
        JButton stopButton = new JButton("Stop");

        public DisplayButtonPanel() {
            //This properties
            this.setLayout(null);
            this.setLocation(3,276);
            this.setSize(409, References.actualSize.height - this.getY() - this.getX());
            this.setBackground(References.panelColor);

            //Begin_Button Properties
            beginButton.setSize(200, 50);
            beginButton.setLocation(3,3);
            beginButton.setBorder(null);
            beginButton.setBackground(References.buttonBackgroundColor);
            this.add(beginButton);

            //Stop_Button Properties
            stopButton.setSize(200,50);
            stopButton.setLocation(206,3);
            stopButton.setBorder(null);
            stopButton.setBackground(References.buttonBackgroundColor);
            this.add(stopButton);
        }
    }

    class GeneralButtonPanel extends JPanel{
        //Object declarations
        JButton settingsButton = new JButton("Settings");
        JButton loadButton = new JButton("Load");
        JButton exitButton  = new JButton("Exit");

        public GeneralButtonPanel() {
            //This properties
            this.setLocation(415, 3);
            this.setSize(References.actualSize.width - this.getX() - 3,268);
            this.setLayout(null);
            this.setBackground(References.panelColor);

            //Settings properties
            settingsButton.setSize(150, 50);
            settingsButton.setLocation(3, 103);
            settingsButton.setBorder(null);
            settingsButton.setBackground(References.buttonBackgroundColor);
            settingsButton.addActionListener(generalActionHandler);
            this.add(settingsButton);

            //Load_Button properties
            loadButton.setSize(150,50);
            loadButton.setLocation(3,159);
            loadButton.setBorder(null);
            loadButton.setBackground(References.buttonBackgroundColor);
            loadButton.addActionListener(generalActionHandler);
            this.add(loadButton);

            //Exit_Button properties
            exitButton.setSize(150,50);
            exitButton.setLocation(3,this.getHeight() - exitButton.getHeight() -3);
            exitButton.setBorder(null);
            exitButton.setBackground(References.buttonBackgroundColor);
            exitButton.addActionListener(generalActionHandler);
            this.add(exitButton);
        }
    }

    class GeneralActionHandler implements ActionListener {

        JFileChooser fileChooser = new JFileChooser();

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Main.frame.exitMenuItem || e.getSource() == Main.frame.generalButtonPanel.exitButton) {
                Main.closingArguments();
            }else if (e.getSource() == Main.frame.generalButtonPanel.loadButton || e.getSource() == Main.frame.loadMenuItem || e.getSource() == Main.frame.displayPanel.loadFileButton) {
                fileChooser.setCurrentDirectory(new File("Sheets"));
                if(fileChooser.showOpenDialog(Main.frame) == 0){
                    Main.frame.displayPanel.fileLocationTextField.setText(fileChooser.getSelectedFile().toString());
                }
            }

        }
    }

    class PlayActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Todo: add functions
        }
    }


}
