package yy;

import java.awt.EventQueue;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bai29 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    bai29 frame = new bai29();
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
    public bai29() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        cardLayout = new CardLayout(0, 0);
        contentPane.setLayout(cardLayout);

        // Tạo Card 1: JPanel với JLabel
        JPanel card1 = new JPanel();
        JLabel label = new JLabel("Page 1");
        card1.add(label);
        contentPane.add(card1, "Card1");

        // Tạo Card 2: JPanel với JButton
        JPanel card2 = new JPanel();
        JButton button = new JButton("Click");
        card2.add(button);
        contentPane.add(card2, "Card2");

        // Tạo JButton Switch để chuyển đổi giữa các card
        JButton switchButton = new JButton("Switch");
        switchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(contentPane); // Chuyển sang card tiếp theo
            }
        });

        // Thêm nút Switch vào contentPane
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(switchButton);
        contentPane.add(buttonPanel, "ButtonPanel");

        // Hiển thị card đầu tiên
        cardLayout.show(contentPane, "Card1");
    }
}