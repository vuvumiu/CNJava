package yy;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bai30 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    bai30 frame = new bai30();
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
    public bai30() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new java.awt.BorderLayout());

        // Tạo JToolBar
        JToolBar toolBar = new JToolBar();
        contentPane.add(toolBar, java.awt.BorderLayout.NORTH);

        // Tạo JButton "New"
        JButton btnNew = new JButton("New");
        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(bai30.this, "New button clicked!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        toolBar.add(btnNew);

        // Tạo JButton "Save"
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(bai30.this, "Save button clicked!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        toolBar.add(btnSave);

        // Tạo JButton "Open"
        JButton btnOpen = new JButton("Open");
        btnOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(bai30.this, "Open button clicked!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        toolBar.add(btnOpen);
    }
}