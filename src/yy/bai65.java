package yy;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class bai65 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel timeLabel;
    private JButton btnStart;
    private JButton btnStop;
    private JButton btnReset;
    private Timer timer;
    private int elapsedSeconds = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    bai65 frame = new bai65();
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
    public bai65() {
        setTitle("Đồng hồ bấm giờ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        setContentPane(contentPane);

        // Label hiển thị thời gian
        timeLabel = new JLabel(formatTime(elapsedSeconds));
        contentPane.add(timeLabel);

        // Nút Start
        btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!timer.isRunning()) {
                    timer.start();
                }
            }
        });
        contentPane.add(btnStart);

        // Nút Stop
        btnStop = new JButton("Stop");
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer.isRunning()) {
                    timer.stop();
                }
            }
        });
        contentPane.add(btnStop);

        // Nút Reset
        btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                elapsedSeconds = 0;
                timeLabel.setText(formatTime(elapsedSeconds));
            }
        });
        contentPane.add(btnReset);

        // Thiết lập Timer để tăng thời gian mỗi giây
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedSeconds++;
                timeLabel.setText(formatTime(elapsedSeconds));
            }
        });
    }

    /**
     * Format thời gian từ giây sang MM:SS
     */
    private String formatTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("Time: %02d:%02d", minutes, seconds);
    }
}
