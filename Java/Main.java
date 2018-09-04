package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

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

    JPanel display = new JPanel();
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

    public void StartSequence(int delay) {
        Robot robot;
        Delay(delay);
        {
            try {
                robot = new Robot();
                List<MusicalNote> notes = Load.ReadFile("C:\\Users\\alexa\\Desktop\\FF14 Musical instrument robot\\src\\music.txt");

                for (MusicalNote n : notes) {
                    if (n.getOctave().equals("1"))
                        robot.keyPress(KeyEvent.VK_SHIFT);

                    if (n.getOctave().equals("-1"))
                        robot.keyPress(KeyEvent.VK_CONTROL);

                    switch (n.getNote()) {
                        case "q":
                            robot.keyPress(KeyEvent.VK_Q);
                            robot.delay(n.getTime());
                            robot.keyRelease(KeyEvent.VK_Q);
                            break;
                        case "2":
                            robot.keyPress(KeyEvent.VK_2);
                            robot.delay(n.getTime());
                            robot.keyRelease(KeyEvent.VK_2);
                            break;
                        case "w":
                            robot.keyPress(KeyEvent.VK_W);
                            robot.delay(n.getTime());
                            robot.keyRelease(KeyEvent.VK_W);
                            break;
                        case "3":
                            robot.keyPress(KeyEvent.VK_3);
                            robot.delay(n.getTime());
                            robot.keyRelease(KeyEvent.VK_3);
                            break;
                        case "e":
                            robot.keyPress(KeyEvent.VK_E);
                            robot.delay(n.getTime());
                            robot.keyRelease(KeyEvent.VK_E);
                            break;
                        case "r":
                            robot.keyPress(KeyEvent.VK_R);
                            robot.delay(n.getTime());
                            robot.keyRelease(KeyEvent.VK_R);
                            break;
                        case "5":
                            robot.keyPress(KeyEvent.VK_5);
                            robot.delay(n.getTime());
                            robot.keyRelease(KeyEvent.VK_5);
                            break;
                        case "t":
                            robot.keyPress(KeyEvent.VK_T);
                            robot.delay(n.getTime());
                            robot.keyRelease(KeyEvent.VK_T);
                            break;
                        case "6":
                            robot.keyPress(KeyEvent.VK_6);
                            robot.delay(n.getTime());
                            robot.keyRelease(KeyEvent.VK_6);
                            break;
                        case "y":
                            robot.keyPress(KeyEvent.VK_Y);
                            robot.delay(n.getTime());
                            robot.keyRelease(KeyEvent.VK_Y);
                            break;
                        case "7":
                            robot.keyPress(KeyEvent.VK_7);
                            robot.delay(n.getTime());
                            robot.keyRelease(KeyEvent.VK_7);
                            break;
                        case "u":
                            robot.keyPress(KeyEvent.VK_U);
                            robot.delay(n.getTime());
                            robot.keyRelease(KeyEvent.VK_U);
                            break;
                        case "i":
                            robot.keyPress(KeyEvent.VK_I);
                            robot.delay(n.getTime());
                            robot.keyRelease(KeyEvent.VK_I);
                        default:
                            break;
                    }

                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_CONTROL);

                }
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }


    private static void Delay(int milliseconds) {
        try {
            System.out.println("You have " + milliseconds + " to open ffIV.");
            Thread.sleep(milliseconds);
            System.out.println("Begin.");
        } catch (InterruptedException iex) {
            System.out.println(iex);
        }
    }


    public static void main(String[] arg) {
        config.load();
        Main frame = new Main();
        frame.setVisible(true);
        frame.content.setSize(frame.contentPanel.getWidth(), frame.contentPanel.getHeight());
    }
}
