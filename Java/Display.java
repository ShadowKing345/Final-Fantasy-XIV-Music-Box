package Java;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Display extends JPanel {

    JButton begin = new JButton("Begin");
    JButton stop = new JButton("Stop");
    JSlider slider = new JSlider();
    JLabel sliderValue = new JLabel();

    Display() {
        this.setLayout(null);

        begin.setBounds(2, 417, 313, 40);
        begin.setFont(References.font);
        begin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                References.DelayTime = slider.getValue();
                References.play.start();
            }
        });
        this.add(begin);

        stop.setBounds(begin.getX() + begin.getWidth() + 10, begin.getY(), 313, 40);
        stop.setFont(References.font);
        stop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Play.setStop(true);
            }
        });
        this.add(stop);

        slider.setBounds(begin.getX(), begin.getY() - 50, 200, 16);
        slider.setValue(50);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderValue.setText(String.valueOf(slider.getValue()/10) + " :Seconds before song plays");
            }
        });
        this.add(slider);

        sliderValue.setText("5 :Seconds before song plays");
        sliderValue.setBounds(slider.getX() + slider.getWidth() + 10, slider.getY(), 200, slider.getHeight());
        this.add(sliderValue);
    }

}
