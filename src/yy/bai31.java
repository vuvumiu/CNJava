package yy;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class bai31 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    bai31 frame = new bai31();
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
    public bai31() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new java.awt.BorderLayout());

        // Tạo JSplitPane chia đôi ngang
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        contentPane.add(splitPane, java.awt.BorderLayout.CENTER);

        // Tạo JList bên trái
        JList<String> list = new JList<>();
        JScrollPane listScrollPane = new JScrollPane(list);
        splitPane.setLeftComponent(listScrollPane);

        // Tạo JTextArea bên phải
        JTextArea textArea = new JTextArea();
        JScrollPane textScrollPane = new JScrollPane(textArea);
        splitPane.setRightComponent(textScrollPane);

        // Đặt vị trí chia mặc định là 200 pixel
        splitPane.setDividerLocation(200);
    }
}