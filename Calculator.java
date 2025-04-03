import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

class Calculator extends JFrame implements ActionListener {
    private Font font;
    private JTextField textfield;
    private JButton[] numberButtons;
    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;
    private JButton decimalButton;
    private JButton equalButton;
    private JButton negativeButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JButton[] functionButtons;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private int i;
    private double num1;
    private double num2;
    private double result;
    private char operator;
    Calculator(String s) {
        super(s);
        font = new Font("Ink Free", Font.BOLD, 30);
        textfield = new JTextField();
        numberButtons = new JButton[10];
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        negativeButton = new JButton("(-)");
        deleteButton = new JButton("Del");
        clearButton = new JButton("Clr");
        functionButtons = new JButton[9];
        middlePanel = new JPanel();
        bottomPanel = new JPanel();
        JButton[] operatorButtons = {
            addButton, subButton, mulButton, divButton, decimalButton, equalButton, negativeButton, deleteButton, clearButton
        };
        for (i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }
        for (i = 0; i < 9; i++) {
            functionButtons[i] = operatorButtons[i];
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        for (i = 0; i < 10; i++) {
            if (source == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (source == decimalButton) {
            textfield.setText(textfield.getText().concat("."));
        } else if (source == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        } else if (source == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        } else if (source == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        } else if (source == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        } else if (source == equalButton) {
            num2 = Double.parseDouble(textfield.getText());
            switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        } else if (source == clearButton) {
            textfield.setText("");
        } else if (source == deleteButton) {
            String text = textfield.getText();
            textfield.setText("");
            int len = text.length() - 1;
            for (i = 0; i < len; i++) {
                textfield.setText(textfield.getText() + text.charAt(i));
            }
        } else if (source == negativeButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp = -1 * temp;
            textfield.setText(String.valueOf(temp));
        }
    }

    void setComponents() {
        textfield.setBounds(50, 20, 300, 50);
        textfield.setFont(font);
        textfield.setEditable(false);
        for (i = 0; i < 10; i++) {
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }
        for (i = 0; i < 8; i++) {
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }
        negativeButton.setFocusable(false);
        deleteButton.setFocusable(false);
        clearButton.setFocusable(false);
        middlePanel.setBounds(50, 100, 300, 300);
        middlePanel.setLayout(new GridLayout(4, 4, 10, 10));
        bottomPanel.setBounds(50, 420, 300, 50);
        bottomPanel.setLayout(new GridLayout(1, 3, 10, 10));
    }

    void addComponents() {
        add(textfield);
        for (i = 0; i < 10; i++) {
            numberButtons[i].addActionListener(this);
        }
        for (i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
        }
        for (i = 1; i < 10; i++) {
            middlePanel.add(numberButtons[i]);
            switch (i) {
            case 3:
                middlePanel.add(addButton);
                break;
            case 6:
                middlePanel.add(subButton);
                break;
            case 9:
                middlePanel.add(mulButton);
                middlePanel.add(decimalButton);
                middlePanel.add(numberButtons[0]);
                middlePanel.add(equalButton);
                middlePanel.add(divButton);
            }
        }
        add(middlePanel);
        bottomPanel.add(negativeButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(clearButton);
        add(bottomPanel);
    }
    
    public static void main(String[] args) {
        Calculator calc = new Calculator("Calculator");
        calc.setLayout(null);
        calc.setSize(420, 550);
        calc.setVisible(true);
        calc.setComponents();
        calc.addComponents();
        calc.setDefaultCloseOperation(Calculator.EXIT_ON_CLOSE);
    }
}