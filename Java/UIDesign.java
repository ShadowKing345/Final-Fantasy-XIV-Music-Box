package Java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UIDesign {
    static Font font = new Font("Bahnschrift", Font.PLAIN, 15);

    static Color lightBackgroundCol = new Color(249, 249, 249);
    static Color lightInnerPanelCol = new Color(211, 211, 211);
    static Color lightComponentBGCol = new Color(253, 246, 136);
    static Color lightComponentChangeBGCol = new Color(255, 246, 0);
    static Color lightTextCol = new Color(0, 0, 0);

    static Color darkBackgroundCol = new Color(35, 35, 35);
    static Color darkInnerPanelCol = new Color(40,40,40);
    static Color darkComponentBGCol = new Color(55, 55, 55);
    static Color darkComponentChangeBGCol = new Color(0,0,255);
    static Color darkTextCol = new Color(228, 228, 228);

    public static void changeToLight(JFrame Class){
        JFrame jFrame = Class;
        setPanel((JPanel) jFrame.getContentPane(), lightBackgroundCol);
        List<JPanel> panel = new ArrayList<>();
        for(Component component: jFrame.getContentPane().getComponents()){
            if(component instanceof JTabbedPane) {
                for (int i = 0; i < ((JTabbedPane) component).getComponentCount(); i++)
                    panel.add((JPanel) ((JTabbedPane) component).getComponent(i));

                for (JPanel panel1 : panel) {
                    setPanel(panel1, lightInnerPanelCol);
                    for (Component component1 : panel1.getComponents()) {
                        if (component1 instanceof JButton)
                            setButton((JButton) component1, lightComponentBGCol, lightTextCol, font);

                        if (component1 instanceof JLabel)
                            setLabel((JLabel) component1, lightTextCol, font);

                        if (component1 instanceof JTextField)
                            setTextField((JTextField) component1, lightComponentBGCol, lightTextCol, font);
                    }
                }
            }

            if (component instanceof JLabel)
                setLabel((JLabel) component, lightTextCol, font);

            if (component instanceof JTextField)
                setTextField((JTextField) component, lightComponentBGCol, lightTextCol, font);
        }
    }

    public static void changeToDark(JFrame Class){
        JFrame jFrame = Class;
        setPanel((JPanel) jFrame.getContentPane(), darkBackgroundCol);
        List<JPanel> panel = new ArrayList<>();
        for(Component component: jFrame.getContentPane().getComponents()){
            if(component instanceof JTabbedPane) {
                for (int i = 0; i < ((JTabbedPane) component).getComponentCount(); i++)
                    panel.add((JPanel) ((JTabbedPane) component).getComponent(i));

                for (JPanel panel1 : panel) {
                    setPanel(panel1, darkInnerPanelCol);
                    for (Component component1 : panel1.getComponents()) {
                        if (component1 instanceof JButton)
                            setButton((JButton) component1, darkComponentBGCol, darkTextCol, font);

                        if (component1 instanceof JLabel)
                            setLabel((JLabel) component1, darkTextCol, font);

                        if (component1 instanceof JTextField)
                            setTextField((JTextField) component1, darkComponentBGCol, darkTextCol, font);
                    }
                }
            }

            if (component instanceof JLabel)
                setLabel((JLabel) component, darkTextCol, font);

            if (component instanceof JTextField)
                setTextField((JTextField) component, darkComponentBGCol, darkTextCol, font);
        }
    }

    static void setPanel(JPanel panel, Color bgColor) {
        panel.setBackground(bgColor);
        panel.setBorder(null);
    }

    static void setButton(JButton button, Color bgColor, Color fgColor, Font font) {
        button.setFont(font);
        button.setForeground(fgColor);
        button.setBackground(bgColor);
        button.setBorder(null);
    }

    static void setLabel(JLabel label, Color fgColor, Font font) {
        label.setFont(font);
        label.setForeground(fgColor);
        label.setBorder(null);
    }

    static void setTextField(JTextField textField, Color bgColor, Color fgColor, Font font) {
        textField.setFont(font);
        textField.setForeground(fgColor);
        textField.setBackground(bgColor);
        textField.setBorder(null);
    }
}
