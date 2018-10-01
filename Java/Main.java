package Java;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    JPanel contentPanel = new JPanel();
    JLabel header = new JLabel("Welcome to Final Fantasy XIV Music Box");
    JLabel fileLocationLabel = new JLabel("File Location");
    static JTextField fileLocation = new JTextField();
    JTabbedPane content = new JTabbedPane();

    JPanel display = new Display();
    JPanel setting = new Settings();

    private Main() {
        this.setTitle("Final Fantasy XIV Music Box");
        this.setBounds(References.screenSize.width / 2 - (References.size.width / 2), References.screenSize.height / 2 - (References.size.height/2), References.size.width, References.size.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPanel);
        this.setResizable(false);

        contentPanel.setBorder(null);
        contentPanel.setLayout(null);

        header.setBounds( 3,0, References.size.width, 40);
        header.setFont(References.font);
        header.setForeground(References.textCol);
        contentPanel.add(header);

        fileLocationLabel.setBounds(header.getX(), header.getY() + header.getHeight(), 90, 30);
        fileLocationLabel.setFont(References.font);
        fileLocationLabel.setForeground(References.textCol);
        contentPanel.add(fileLocationLabel);

        fileLocation.setBounds(fileLocationLabel.getX() + fileLocationLabel.getWidth(), fileLocationLabel.getY(), References.size.width - (fileLocationLabel.getWidth() + fileLocationLabel.getX() + 13), 30);
        fileLocation.setFont(new Font(References.font.getName(), References.font.getStyle(), 12));
        fileLocation.setBackground(References.componentsBGCol);
        fileLocation.setForeground(References.textCol);
        fileLocation.setBorder(null);
        contentPanel.add(fileLocation);

        content.setBounds(0, fileLocationLabel.getY() + fileLocationLabel.getHeight() + 10, References.size.width - 6, 100);
        contentPanel.add(content);

        content.setFont(new Font(References.font.getName(), References.font.getStyle(), 12));
        content.add(display);
        content.add(setting);
        content.setBackgroundAt(0, References.innerPannelCol);
        content.setForegroundAt(0, References.textCol);
        content.setBackgroundAt(1, References.innerPannelCol);
        content.setForegroundAt(1, References.textCol);
        content.setTitleAt(0, "Display");
        content.setTitleAt(1, "Settings");

        contentPanel.setBackground(References.backgroundCol);
    }






    public static void main(String[] arg) {
        References.config.load();
        Main frame = new Main();
        frame.setVisible(true);
        frame.content.setSize(frame.contentPanel.getWidth(), frame.contentPanel.getHeight());
    }
}
