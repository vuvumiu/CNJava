package yy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bai25 extends JFrame {
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private JLabel selectionLabel;

    public bai25() {
        setTitle("Gender Selection");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Tạo JRadioButtons
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");

        // Nhóm để chỉ cho chọn một
        ButtonGroup group = new ButtonGroup();
        group.add(maleButton);
        group.add(femaleButton);

        // JLabel hiển thị lựa chọn
        selectionLabel = new JLabel("Select gender", JLabel.CENTER);

        // Xử lý sự kiện khi chọn
        ActionListener listener = e -> {
            JRadioButton source = (JRadioButton) e.getSource();
            selectionLabel.setText("Selected: " + source.getText());
        };
        maleButton.addActionListener(listener);
        femaleButton.addActionListener(listener);

        // Thêm vào JFrame
        add(maleButton);
        add(femaleButton);
        add(selectionLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            bai25 frame = new bai25();
            frame.setVisible(true);
        });
    }
}
