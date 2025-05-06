package yy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bai23 extends JFrame {
    private JTextField displayField;
    private double result = 0;
    private String lastCommand = "=";
    private boolean start = true;

    public bai23() {
        // Thiết lập JFrame
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Tạo JTextField để hiển thị kết quả
        displayField = new JTextField("0");
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 0.2;
        add(displayField, gbc);

        // Tạo các nút cho máy tính
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        // Thêm các nút vào GridBagLayout
        int index = 0;
        for (int row = 1; row <= 4; row++) {
            for (int col = 0; col < 4; col++) {
                JButton button = new JButton(buttonLabels[index]);
                gbc.gridx = col;
                gbc.gridy = row;
                gbc.gridwidth = 1;
                gbc.weightx = 0.25;
                gbc.weighty = 0.2;
                add(button, gbc);
                button.addActionListener(new ButtonListener());
                index++;
            }
        }

        // Hiển thị JFrame
        setVisible(true);
    }

    // Xử lý sự kiện cho các nút
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();

            if (input.equals("C")) {
                displayField.setText("0");
                start = true;
                result = 0;
                lastCommand = "=";
            } else if (input.matches("[0-9]")) {
                if (start) {
                    displayField.setText(input);
                    start = false;
                } else {
                    displayField.setText(displayField.getText() + input);
                }
            } else if (input.equals("=")) {
                calculate(Double.parseDouble(displayField.getText()));
                lastCommand = "=";
                start = true;
            } else {
                if (!start) {
                    calculate(Double.parseDouble(displayField.getText()));
                    start = true;
                }
                lastCommand = input;
            }
        }

        private void calculate(double x) {
            switch (lastCommand) {
                case "+":
                    result += x;
                    break;
                case "-":
                    result -= x;
                    break;
                case "*":
                    result *= x;
                    break;
                case "/":
                    if (x != 0) {
                        result /= x;
                    } else {
                        displayField.setText("Error");
                        return;
                    }
                    break;
                case "=":
                    result = x;
                    break;
            }
            displayField.setText("" + result);
        }
    }

    public static void main(String[] args) {
        new bai23();
    }
}