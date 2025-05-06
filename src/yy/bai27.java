package yy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bai27 extends JFrame {
    private JProgressBar progressBar;
    private JButton startButton;
    private Timer timer;

    public bai27() {
        // Thiết lập JFrame
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        // Tạo JProgressBar
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        add(progressBar);

        // Tạo JButton
        startButton = new JButton("Start");
        add(startButton);

        // Xử lý sự kiện khi nhấn nút Start
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false); // Vô hiệu hóa nút khi chạy
                progressBar.setValue(0); // Reset progress bar

                // Tạo Timer để tăng giá trị progress bar trong 5 giây
                timer = new Timer(50, new ActionListener() { // Cập nhật mỗi 50ms
                    int value = 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        value++;
                        progressBar.setValue(value);
                        if (value >= 100) {
                            timer.stop();
                            startButton.setEnabled(true); // Kích hoạt lại nút
                        }
                    }
                });
                timer.start();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new bai27().setVisible(true);
            }
        });
    }
}