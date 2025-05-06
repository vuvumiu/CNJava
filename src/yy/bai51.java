package yy;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.SwingWorker;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bai51 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JProgressBar progressBar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    bai51 frame = new bai51();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public bai51() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200); // Kích thước JFrame: 300x200
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Tạo JProgressBar
        progressBar = new JProgressBar(0, 100); // Giá trị từ 0 đến 100
        progressBar.setBounds(50, 50, 200, 30); // Vị trí và kích thước
        progressBar.setValue(0); // Giá trị ban đầu là 0
        progressBar.setStringPainted(true); // Hiển thị giá trị % trên thanh tiến trình
        contentPane.add(progressBar);

        // Tạo JButton "Start"
        JButton btnStart = new JButton("Start");
        btnStart.setBounds(100, 100, 100, 30); // Vị trí và kích thước
        contentPane.add(btnStart);

        // Xử lý sự kiện khi nhấn nút "Start"
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Tạo và chạy SwingWorker để cập nhật JProgressBar
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        for (int i = 0; i <= 100; i++) {
                            final int progress = i;
                            // Cập nhật giá trị JProgressBar trên EDT
                            EventQueue.invokeLater(() -> progressBar.setValue(progress));
                            // Tạm dừng 100ms để tổng thời gian là 10 giây (100 bước x 100ms = 10.000ms)
                            Thread.sleep(100);
                        }
                        return null;
                    }
                };
                worker.execute(); // Chạy SwingWorker
            }
        });
    }
}