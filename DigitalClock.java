/*
* Project: Digital clock
* Version: 1.0.4
* Author: Mohammad Hasan
*/

public class DigitalClock extends javax.swing.JFrame {
    private java.time.LocalTime localTime;
    private java.time.format.DateTimeFormatter timeFormatter;
    private String time;
    private javax.swing.JLabel timeLabel;

    public DigitalClock() {
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setTitle("Digital Clock");
        setLayout(new java.awt.FlowLayout());
        setSize(350, 200);
        setResizable(false);
        localTime = null;
        timeFormatter = java.time.format.DateTimeFormatter.ofPattern("hh:mm:ss a");
        time = null;
        timeLabel = new javax.swing.JLabel();
        timeLabel.setFont(new java.awt.Font("Verdana", java.awt.Font.PLAIN, 50));
        timeLabel.setForeground(new java.awt.Color(0x00FF00));
        timeLabel.setBackground(java.awt.Color.BLACK);
        timeLabel.setOpaque(true);
        add(timeLabel);
    }

    public void startClock() {
        setVisible(true);
        while (true) {
            localTime = java.time.LocalTime.now();
            time = timeFormatter.format(localTime);
            timeLabel.setText(time);
        }
    }

    public static void main(String[] args) {
        new DigitalClock().startClock();
    }
}