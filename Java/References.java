package Java;

import java.awt.*;

public class References {

    //General Variables
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static Config config = new Config();
    static Dimension size = new Dimension(592, 402);
    static Dimension actualSize = new Dimension(574,332);
    static Dimension sizeDifference = new Dimension(size.width - actualSize.width, size.height - actualSize.height);
    static Play play = new Play();
    static int DelayTime = 50;

    //Design attributes
    static Color panelColor = new Color(233, 233, 233);
    static Color buttonBackgroundColor = new Color(200, 200, 200);

    @Deprecated
    static Dimension buttonSize = new Dimension(200, 40);
    @Deprecated
    static Color backgroundCol = new Color(35, 35, 35);
    @Deprecated
    static Color innerPanelCol = new Color(40, 40, 40);
    @Deprecated
    static Color componentBGCol = new Color(55, 55, 55);
    @Deprecated
    static Color componentChangeBGCol = new Color(0, 0, 255);
    @Deprecated
    static Font font = new Font("Bahnschrift", Font.PLAIN, 15);
    @Deprecated
    static Color textCol = new Color(228, 228, 228);
}
