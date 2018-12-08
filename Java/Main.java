package Java;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class Main {
    public static ContentFrame frame = new ContentFrame();

    public static void main(String[] arg) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){}
        frame.setVisible(true);
        System.out.println(frame.getContentPane().getSize());
    }

    public static void closingArguments() {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
