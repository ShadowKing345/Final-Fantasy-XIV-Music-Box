package Java;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Deprecated
public class Display extends JPanel {

    JButton begin = new JButton("Begin");
    JButton stop = new JButton("Stop");
    JSlider slider = new JSlider();
    JLabel sliderValue = new JLabel();

    Display() {
        this.setLayout(null);

        begin.setBounds(5, 351, References.buttonSize.width, References.buttonSize.height);
        begin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                References.DelayTime = slider.getValue();
                References.play.start();
            }
        });
        this.add(begin);

        slider.setBounds(begin.getX(), begin.getY() - 50, 200, 20);
        slider.setValue(50);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderValue.setText(String.valueOf(slider.getValue()/10) + " :Seconds before song plays");
            }
        });
        slider.setBackground(References.innerPanelCol);
        this.add(slider);

        sliderValue.setText("5 :Seconds before song plays");
        sliderValue.setBounds(slider.getX() + slider.getWidth() + 10, slider.getY(), 200, slider.getHeight());
        this.add(sliderValue);

        stop.setBounds(begin.getX() + begin.getWidth() + 10, begin.getY(), References.buttonSize.width, References.buttonSize.height);
        stop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Play.setStop(true);
            }
        });
        this.add(stop);
    }

}
