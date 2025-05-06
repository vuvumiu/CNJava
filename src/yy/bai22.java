package yy;

import javax.swing.*;
import java.awt.*;

public class bai22 extends JFrame {
    private JComboBox<String> fruitComboBox;
    private JLabel selectionLabel;

    public bai22() {
        setTitle("JComboBox Trái cây");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Danh sách trái cây tiếng Việt
        String[] fruits = {"Táo", "Chuối", "Cam", "Xoài", "Nho"};
        fruitComboBox = new JComboBox<>(fruits);

        // JLabel hiển thị lựa chọn
        selectionLabel = new JLabel("Chọn một loại trái cây", JLabel.CENTER);

        // Xử lý sự kiện khi lựa chọn thay đổi
        fruitComboBox.addActionListener(e -> {
            String selected = (String) fruitComboBox.getSelectedItem();
            selectionLabel.setText("Bạn chọn: " + selected);
        });

        // Thêm vào JFrame
        add(fruitComboBox, BorderLayout.NORTH);
        add(selectionLabel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            bai22 frame = new bai22();
            frame.setVisible(true);
        });
    }
}
