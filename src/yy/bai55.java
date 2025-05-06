package yy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class bai55 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Timer timer;
    private JButton btnStop;
    private Random rand = new Random();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                bai55 frame = new bai55();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public bai55() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);              // Kích thước 400x400
        setLocationRelativeTo(null);    // Căn giữa màn hình

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        // Nút dừng Timer
        btnStop = new JButton("Stop");
        contentPane.add(btnStop, BorderLayout.SOUTH);

        // Timer thay đổi màu nền mỗi 1000ms (1s)
        timer = new Timer(1000, (ActionEvent e) -> {
            // Tạo màu ngẫu nhiên
            Color randomColor = new Color(
                rand.nextInt(256),
                rand.nextInt(256),
                rand.nextInt(256)
            );
            contentPane.setBackground(randomColor);
        });
        timer.start();

        // Khi nhấn Stop, dừng Timer và vô hiệu hóa nút
        btnStop.addActionListener((ActionEvent e) -> {
            timer.stop();
            btnStop.setEnabled(false);
        });
    }
}
