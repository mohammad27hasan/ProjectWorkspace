/*
* Project: Digital clock
* Version: 1.0.1
* Author: Mohammad Hasan
*/
package clock;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class DigitalClock extends JFrame {
    private Calendar calendar;
    private SimpleDateFormat timeFormat;
    private JLabel timeLabel;
    private String time;

    public DigitalClock() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clock");
        this.setLayout(new FlowLayout());
        this.setSize(350, 200);
        this.setResizable(false);
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);
        time = null;
        this.add(timeLabel);
    }

    private void runTime() {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public void start() {
        this.setVisible(true);
        runTime();
    }
}