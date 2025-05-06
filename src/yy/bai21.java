package yy;

import javax.swing.*;
import java.awt.*;

// Đổi tên lớp cho khớp với tên file bai21.java
public class bai21 extends JFrame {
    public bai21() {
        setTitle("Bài 21");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Danh sách 10 thành phố
        String[] cities = {
            "Hanoi", "Ho Chi Minh", "Da Nang", "Hai Phong", "Can Tho",
            "Nha Trang", "Hue", "Vung Tau", "Bien Hoa", "My Tho"
        };
        JList<String> cityList = new JList<>(cities);
        JScrollPane scrollPane = new JScrollPane(cityList);

        // JLabel hiển thị số lượng mục
        JLabel countLabel = new JLabel("Number of cities: " + cities.length, JLabel.CENTER);

        // Bố cục BorderLayout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(countLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            bai21 frame = new bai21();
            frame.setVisible(true);
        });
    }
}
