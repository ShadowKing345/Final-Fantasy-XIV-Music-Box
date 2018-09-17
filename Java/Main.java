package Java;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static Config config = new Config();
    private Dimension size = new Dimension(650, 600);
    static Font font = new Font("Bahnschrift", Font.PLAIN, 15);

    JPanel contentPanel = new JPanel();
    JLabel header = new JLabel("Welcome to Final Fantasy XIV Music Box");
    JLabel fileLocationLabel = new JLabel("File Location");
    JTextField fileLocation = new JTextField("File Location");
    JTabbedPane content = new JTabbedPane();

    JPanel display = new Display();
    JPanel setting = new Settings();

    private Main() {
        this.setTitle("Final Fantasy XIV Music Box");
        this.setBounds(screenSize.width / 2 - (size.width / 2), screenSize.height / 2 - (size.height/2), size.width, size.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPanel);
        this.setResizable(false);

        contentPanel.setBorder(null);
        contentPanel.setLayout(null);

        header.setBounds( 3,0, size.width, 40);
        header.setFont(font);
        contentPanel.add(header);

        fileLocationLabel.setBounds(header.getX(), header.getY() + header.getHeight(), 90, 30);
        fileLocationLabel.setFont(font);
        contentPanel.add(fileLocationLabel);

        fileLocation.setBounds(fileLocationLabel.getX() + fileLocationLabel.getWidth(), fileLocationLabel.getY(), size.width - (fileLocationLabel.getWidth() + fileLocationLabel.getX() + 13), 30);
        fileLocation.setFont(new Font(font.getName(), font.getStyle(), 12));
        fileLocation.setBorder(null);
        contentPanel.add(fileLocation);

        content.setBounds(0, fileLocationLabel.getY() + fileLocationLabel.getHeight() + 10, size.width - 6, 100);
        contentPanel.add(content);

        content.add(display);
        content.add(setting);
        content.setTitleAt(0, "Display");
        content.setTitleAt(1, "Settings");

    }






    public static void main(String[] arg) {
        config.load();
        Main frame = new Main();
        frame.setVisible(true);
        frame.content.setSize(frame.contentPanel.getWidth(), frame.contentPanel.getHeight());
    }
}
