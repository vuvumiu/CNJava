package yy;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class kiemtra extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtHoTen;
    private JFormattedTextField txtNgaySinh;
    private JTextField txtQueQuan;
    private JTable table;
    private DefaultTableModel tableModel;

    public static void main(String[] args) {
        // Thiết lập Look & Feel hiện đại
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            kiemtra frame = new kiemtra();
            frame.setVisible(true);
        });
    }

    public kiemtra() {
        setTitle("Kiểm tra thông tin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);

        // Content pane với padding và BorderLayout
        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        // Panel chứa form nhập
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Nhập thông tin cá nhân"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        Font labelFont = new Font("Tahoma", Font.BOLD, 14);
        Font fieldFont = new Font("Tahoma", Font.PLAIN, 14);

        // Họ và tên
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel lblHoTen = new JLabel("Họ và tên:");
        lblHoTen.setFont(labelFont);
        formPanel.add(lblHoTen, gbc);

        gbc.gridx = 1;
        txtHoTen = new JTextField(20);
        txtHoTen.setFont(fieldFont);
        formPanel.add(txtHoTen, gbc);

        // Ngày sinh
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel lblNgaySinh = new JLabel("Ngày sinh:");
        lblNgaySinh.setFont(labelFont);
        formPanel.add(lblNgaySinh, gbc);

        gbc.gridx = 1;
        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('_');
            txtNgaySinh = new JFormattedTextField(dateMask);
        } catch (ParseException e) {
            txtNgaySinh = new JFormattedTextField();
        }
        txtNgaySinh.setColumns(20);
        txtNgaySinh.setFont(fieldFont);
        formPanel.add(txtNgaySinh, gbc);

        // Quê quán
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel lblQueQuan = new JLabel("Quê quán:");
        lblQueQuan.setFont(labelFont);
        formPanel.add(lblQueQuan, gbc);

        gbc.gridx = 1;
        txtQueQuan = new JTextField(20);
        txtQueQuan.setFont(fieldFont);
        formPanel.add(txtQueQuan, gbc);

        // Nút Thêm
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        JButton btnThem = new JButton("Thêm");
        btnThem.setFont(labelFont);
        formPanel.add(btnThem, gbc);

        contentPane.add(formPanel, BorderLayout.NORTH);

        // Bảng hiển thị
        String[] columns = { "Họ và tên", "Ngày sinh", "Quê quán" };
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        table.setFont(fieldFont);
        table.setRowHeight(24);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createTitledBorder("Danh sách nhập"));
        contentPane.add(scroll, BorderLayout.CENTER);

        // Xử lý sự kiện nút
        btnThem.addActionListener(e -> {
            String hoTen = txtHoTen.getText().trim();
            String ngaySinhStr = txtNgaySinh.getText().trim();
            String queQuan = txtQueQuan.getText().trim();

            if (!hoTen.matches("[\\p{L} ]+")) {
                JOptionPane.showMessageDialog(
                    this, "Họ và tên chỉ được chứa chữ cái và khoảng trắng", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            try {
                Date d = sdf.parse(ngaySinhStr);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(
                    this, "Ngày sinh phải nhập đúng định dạng dd/MM/yyyy", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            tableModel.addRow(new Object[]{hoTen, ngaySinhStr, queQuan});

            txtHoTen.setText("");
            txtNgaySinh.setValue(null);
            txtQueQuan.setText("");
        });
    }
}