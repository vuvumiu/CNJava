package yy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bai24 extends JFrame {
    private JCheckBox enableBackground;
    private Color defaultColor;

    public bai24() {
        setTitle("Background Toggle Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Lưu màu nền mặc định
        defaultColor = getContentPane().getBackground();

        // Tạo JCheckBox
        enableBackground = new JCheckBox("Enable Background");
        enableBackground.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                getContentPane().setBackground(Color.GREEN);
            } else {
                getContentPane().setBackground(defaultColor);
            }
        });

        add(enableBackground);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            bai24 frame = new bai24();
            frame.setVisible(true);
        });
    }
}