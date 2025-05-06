package yy;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class bai26 extends JFrame {
    private JSlider brightnessSlider;

    public bai26() {
        setTitle("Brightness Slider Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        // JSlider từ 0 đến 255
        brightnessSlider = new JSlider(0, 255, 128);
        brightnessSlider.setMajorTickSpacing(50);
        brightnessSlider.setPaintTicks(true);
        brightnessSlider.setPaintLabels(true);

        // Xử lý sự kiện thay đổi slider
        brightnessSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = brightnessSlider.getValue();
                Color bg = new Color(value, value, value);
                getContentPane().setBackground(bg);
            }
        });

        // Thêm slider vào dưới cùng
        getContentPane().add(brightnessSlider, BorderLayout.SOUTH);

        // Thiết lập màu nền ban đầu
        getContentPane().setBackground(new Color(128, 128, 128));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            bai26 frame = new bai26();
            frame.setVisible(true);
        });
    }
}