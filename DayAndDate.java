/*
* Project: DayAndDate
* Version: 1.0.1
* Author: Mohammad Hasan
*/

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class DayAndDate extends JFrame {
    private SimpleDateFormat dayFormat;
    private SimpleDateFormat dateFormat;
    private JLabel dayLabel;
    private JLabel dateLabel;
    private String day;
    private String date;

    public DayAndDate() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("DayAndDate");
        this.setLayout(new FlowLayout());
        this.setSize(450, 200);
        this.setResizable(false);
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        dayLabel.setForeground(new Color(0x00FF00));
        dayLabel.setBackground(Color.BLACK);
        dayLabel.setOpaque(true);
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Verdana", Font.PLAIN, 40));
        dateLabel.setForeground(new Color(0x00FF00));
        dateLabel.setBackground(Color.BLACK);
        dateLabel.setOpaque(true);
        day = null;
        date = null;
        this.add(dayLabel);
        this.add(dateLabel);
    }

    private void runStatus() {
        while (true) {
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public void status() {
        this.setVisible(true);
        runStatus();
    }

    public static void main(String[] args) {
        new DayAndDate().status();
    }
}