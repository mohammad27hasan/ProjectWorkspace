/*
* Project: Temperature converter
* Version: 1.0
* Author: Mohammad Hasan
*/

public class TemperatureConverter extends javax.swing.JFrame implements java.awt.event.ActionListener {
    private String[] units;
    private javax.swing.JTextField input;
    private javax.swing.JComboBox<String> inputUnit;
    private javax.swing.JLabel convertTo;
    private javax.swing.JComboBox<String> outputUnit;
    private javax.swing.JButton convert;
    private javax.swing.JLabel output;

    public TemperatureConverter() {
        super("Temperature Converter");
        units = new String[] {"Celsius", "Kelvin", "Fahrenheit"};
        input = new javax.swing.JTextField();
        inputUnit = new javax.swing.JComboBox<String>(units);
        convertTo = new javax.swing.JLabel("Convert To:");
        outputUnit = new javax.swing.JComboBox<String>(units);
        convert = new javax.swing.JButton("Convert");
        output = new javax.swing.JLabel();
        addComponents();
        setComponents();
    }

    private void addComponents() {
        add(input);
        add(inputUnit);
        add(convertTo);
        add(outputUnit);
        convert.addActionListener(this);
        add(convert);
        add(output);
    }

    private void setComponents() {
        setSize(350, 300);
        setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        java.awt.Dimension dimension = new java.awt.Dimension(100, 20);
        input.setSize(dimension);
        input.setLocation(50, 50);
        inputUnit.setSize(dimension);
        inputUnit.setLocation(160, 50);
        convertTo.setSize(dimension);
        convertTo.setLocation(50, 80);
        outputUnit.setSize(dimension);
        outputUnit.setLocation(160, 80);
        convert.setSize(dimension);
        convert.setLocation(50, 110);
        output.setSize(dimension);
        output.setLocation(190, 110);
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        Object selectedInputUnit = inputUnit.getSelectedItem();
        Object selectedOutputUnit = outputUnit.getSelectedItem();
        try {    /* throws NumberFormatException */
            if (selectedInputUnit.equals(units[0])) {
                double celsius = Double.parseDouble(input.getText());
                if (selectedOutputUnit.equals(units[1])) {
                    long kelvin = Math.round(celsius + 273.15);
                    output.setText(kelvin + " K");
                } else if (selectedOutputUnit.equals(units[2])) {
                    long fahrenheit = Math.round(celsius * 1.8 + 32);
                    output.setText(fahrenheit + " \u00b0F");
                } else {
                    output.setText(celsius + " \u00b0C");
                }
            } else if (selectedInputUnit.equals(units[1])) {
                double kelvin = Double.parseDouble(input.getText());
                if (selectedOutputUnit.equals(units[0])) {
                    long celsius = Math.round(kelvin - 273.15);
                    output.setText(celsius + " \u00b0C");
                } else if (selectedOutputUnit.equals(units[2])) {
                    long fahrenheit = Math.round(kelvin * 1.8 - 459.67);
                    output.setText(fahrenheit + " \u00b0F");
                } else {
                    output.setText(kelvin + " K");
                }
            } else {
                double fahrenheit = Double.parseDouble(input.getText());
                if (selectedOutputUnit.equals(units[0])) {
                    long celsius = Math.round((fahrenheit - 32) / 1.8);
                    output.setText(celsius + " \u00b0C");
                } else if (selectedOutputUnit.equals(units[1])) {
                    long kelvin = Math.round((fahrenheit + 459.67) / 1.8);
                    output.setText(kelvin + " K");
                } else {
                    output.setText(fahrenheit + " \u00b0F");
                }
            }
        } catch (NumberFormatException nfe) {
            output.setText("Non Numeric");    
        }
    }

    public static void main(String[] args) {
        new TemperatureConverter().setVisible(true);
    }
}