package yy;

import javax.swing.*;
import java.awt.*;

public class bai20 extends JFrame {   // Đổi từ MyTabbedFrame thành bai20
    public bai20() {
        setTitle("Bài 20");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel homePanel = new JPanel(new BorderLayout());
        homePanel.add(new JLabel("Meomeomeo", JLabel.CENTER), BorderLayout.CENTER);
        tabbedPane.addTab("Home", homePanel);

        JPanel profilePanel = new JPanel(new BorderLayout());
        profilePanel.add(new JLabel("Vuvumiu", JLabel.CENTER), BorderLayout.CENTER);
        tabbedPane.addTab("Profile", profilePanel);

        JPanel settingsPanel = new JPanel(new BorderLayout());
        settingsPanel.add(new JLabel("Hehehe", JLabel.CENTER), BorderLayout.CENTER);
        tabbedPane.addTab("Settings", settingsPanel);

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            bai20 frame = new bai20();
            frame.setVisible(true);
        });
    }
}
