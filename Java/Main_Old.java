package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

@Deprecated
public class Main_Old extends JFrame{

    JPanel contentPanel = new JPanel();
    JLabel header = new JLabel("Welcome to Final Fantasy XIV Music Box");
    JLabel fileLocationLabel = new JLabel("File Location");
    static JTextField fileLocation = new JTextField();
    JTabbedPane content = new JTabbedPane();

    JPanel display = new Display();
    JPanel setting = new Settings();

    JMenuBar menuBar = new JMenuBar();
    JMenu system = new JMenu("File");
    ButtonGroup group = new ButtonGroup();
    JRadioButtonMenuItem displayRadio = new JRadioButtonMenuItem("DisplayPanel");
    JRadioButtonMenuItem settingsRadio = new JRadioButtonMenuItem("Setting");
    JMenu view = new JMenu("View");

    public Main_Old() {
        this.setTitle("Final Fantasy XIV Music Box");
        this.setBounds(References.screenSize.width / 2 - (References.size.width / 2), References.screenSize.height / 2 - (References.size.height/2), References.size.width, References.size.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPanel);
        this.setResizable(false);

        displayRadio.setSelected(true);
        displayRadio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                content.setSelectedIndex(0);
            }
        });

        settingsRadio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                content.setSelectedIndex(1);
            }
        });

        group.add(displayRadio);
        system.add(displayRadio);
        system.addSeparator();
        group.add(settingsRadio);
        system.add(settingsRadio);

        system.setFont(UIDesign.font);
        system.setForeground(UIDesign.darkTextCol);
        system.setBorder(null);

        view.setFont(UIDesign.font);
        view.setForeground(UIDesign.darkTextCol);
        view.setBorder(null);

        menuBar.setBorderPainted(false);
        menuBar.setBackground(References.innerPanelCol);
        menuBar.add(system);
        menuBar.add(view);
        this.setJMenuBar(menuBar);

        contentPanel.setBorder(null);
        contentPanel.setLayout(null);

        header.setBounds( 3,0, References.size.width, 40);
        contentPanel.add(header);

        fileLocationLabel.setBounds(header.getX(), header.getY() + header.getHeight(), 90, 30);
        contentPanel.add(fileLocationLabel);

        fileLocation.setBounds(fileLocationLabel.getX() + fileLocationLabel.getWidth(), fileLocationLabel.getY(), References.size.width - (fileLocationLabel.getWidth() + fileLocationLabel.getX() + 13), 30);
        fileLocation.setFont(new Font(References.font.getName(), References.font.getStyle(), 12));
        contentPanel.add(fileLocation);

        contentPanel.add(content);

        Insets insets = UIManager.getInsets("TabbedPane.contentBorderInsets");
        insets.top = -1;
        insets.bottom = -1;
        insets.left = -1;
        insets.right = -1;
        UIManager.put("TabbedPane.contentBorderInsets", insets);


        content.setLocation(0, fileLocationLabel.getY() + fileLocationLabel.getHeight() + 10);
        content.setFont(new Font(References.font.getName(), References.font.getStyle(), 12));
        content.add(display);
        content.add(setting);

        content.setTitleAt(0, "DisplayPanel");
        content.setTitleAt(1, "Settings");
        content.setBackgroundAt(0, References.componentBGCol);
        content.setBackgroundAt(1, References.componentBGCol);
        content.setForegroundAt(0, References.textCol);
        content.setForegroundAt(1, References.textCol);
        contentPanel.setBackground(References.backgroundCol);
        setFinalSize();

        UIDesign.changeToDark(this);
    }






//    public static void main(String[] arg) {
//
//        References.config.load();
//        Main_Old frame = new Main_Old();
//        frame.setVisible(true);
//
//        frame.setFinalSize();
//        frame.content.setSize(frame.setting.getWidth(), References.size.height - frame.content.getY());
//        frame.setSize(References.size.width + (frame.getContentPane().getWidth() - References.size.width) / 2, (int) (References.size.height  + (frame.getContentPane().getHeight() - References.size.height) * 1.12));
//        System.out.println(frame.getSize());
//    }

    public void setFinalSize(){
        JComponent finalComponent = (JComponent) setting.getComponent(setting.getComponentCount() - 1);
        Dimension dimension = new Dimension(finalComponent.getWidth() + finalComponent.getX() + 1,finalComponent.getHeight() + finalComponent.getY() + 3);
        setting.setSize(dimension);
        display.setSize(dimension);
        References.size = new Dimension (dimension.width, dimension.height + system.getHeight() + content.getY());
    }
}
