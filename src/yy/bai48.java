package yy;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.SwingUtilities;

public class bai48 extends JFrame {
    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JLabel lblNumber;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                bai48 frame = new bai48();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public bai48() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);                 // Kích thước 300x200
        setLocationRelativeTo(null);       // Đưa cửa sổ vào giữa màn hình

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setContentPane(contentPane);

        // JLabel hiển thị nhãn và giá trị
        lblNumber = new JLabel("Number: ");
        contentPane.add(lblNumber);

        // JTextField cho người dùng nhập
        textField = new JTextField(10);
        contentPane.add(textField);

        // Thêm DocumentListener để lọc chỉ số và cập nhật JLabel
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterAndUpdate();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                filterAndUpdate();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Không cần xử lý cho plain-text components
            }

            // Hàm lọc ký tự không phải số và cập nhật JLabel
            private void filterAndUpdate() {
                // Đảm bảo chạy trên EDT và tránh đúp sự kiện
                SwingUtilities.invokeLater(() -> {
                    String text = textField.getText();
                    // Loại mọi ký tự không phải chữ số
                    String digits = text.replaceAll("\\D+", "");
                    if (!text.equals(digits)) {
                        textField.setText(digits);
                    }
                    lblNumber.setText("Number: " + digits);
                });
            }
        });
    }
}
