package yy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class StudentInfoApp {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("Thông tin sinh viên");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Font dùng chung
        Font font = new Font("Tahoma", Font.PLAIN, 14);

        // Tạo các nhãn và trường nhập liệu
        JLabel labelHoTen = new JLabel("Họ và tên:");
        labelHoTen.setFont(font);
        JTextField textHoTen = new JTextField(20);
        textHoTen.setFont(font);

        JLabel labelMaSV = new JLabel("Mã sinh viên:");
        labelMaSV.setFont(font);
        JTextField textMaSV = new JTextField(20);
        textMaSV.setFont(font);

        JLabel labelNgaySinh = new JLabel("Ngày sinh (dd/MM/yyyy):");
        labelNgaySinh.setFont(font);
        JTextField textNgaySinh = new JTextField(20);
        textNgaySinh.setFont(font);

        JButton buttonHienThi = new JButton("Hiển thị");
        buttonHienThi.setFont(font);

        JTextArea textArea = new JTextArea(6, 25);
        textArea.setFont(font);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Thêm thành phần vào frame
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.LINE_END;
        frame.add(labelHoTen, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.LINE_START;
        frame.add(textHoTen, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.LINE_END;
        frame.add(labelMaSV, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.LINE_START;
        frame.add(textMaSV, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.LINE_END;
        frame.add(labelNgaySinh, gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.LINE_START;
        frame.add(textNgaySinh, gbc);

        gbc.gridx = 1; gbc.gridy = 3; gbc.anchor = GridBagConstraints.CENTER;
        frame.add(buttonHienThi, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.BOTH;
        frame.add(scrollPane, gbc);

        // Sự kiện nút
        buttonHienThi.addActionListener(e -> {
            String hoTen = textHoTen.getText().trim();
            String maSV = textMaSV.getText().trim();
            String ngaySinh = textNgaySinh.getText().trim();

            // Kiểm tra họ tên: cho phép chữ cái Unicode và khoảng trắng
            if (!hoTen.matches("[\\p{L} ]+")) {
                JOptionPane.showMessageDialog(frame, "Họ tên chỉ được chứa chữ cái và khoảng trắng!");
                return;
            }

            // Kiểm tra mã sinh viên: số
            if (!maSV.matches("\\d+")) {
                JOptionPane.showMessageDialog(frame, "Mã sinh viên phải là số!");
                return;
            }

            // Kiểm tra ngày sinh
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            try {
                sdf.parse(ngaySinh);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(frame, "Ngày sinh phải đúng định dạng dd/MM/yyyy!");
                return;
            }

            // Hiển thị kết quả
            String message = "Họ tên: " + hoTen + "\n"
                    + "Mã sinh viên: " + maSV + "\n"
                    + "Ngày sinh: " + ngaySinh + "\n\n";
            textArea.append(message);

            // Xoá sau khi thêm
            textHoTen.setText("");
            textMaSV.setText("");
            textNgaySinh.setText("");
        });

        frame.setVisible(true);
    }
}
