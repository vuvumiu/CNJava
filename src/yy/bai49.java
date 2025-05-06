package yy;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class bai49 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel sampleLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    bai49 frame = new bai49();
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
    public bai49() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new java.awt.FlowLayout());

        // Tạo ButtonGroup để nhóm các JRadioButton
        ButtonGroup colorGroup = new ButtonGroup();

        // Tạo JRadioButton "Red"
        JRadioButton redRadio = new JRadioButton("Red", true);
        colorGroup.add(redRadio);
        contentPane.add(redRadio);

        // Tạo JRadioButton "Blue"
        JRadioButton blueRadio = new JRadioButton("Blue");
        colorGroup.add(blueRadio);
        contentPane.add(blueRadio);

        // Tạo JRadioButton "Green"
        JRadioButton greenRadio = new JRadioButton("Green");
        colorGroup.add(greenRadio);
        contentPane.add(greenRadio);

        // Tạo JLabel "Sample"
        sampleLabel = new JLabel("Sample");
        sampleLabel.setForeground(Color.RED); // Màu mặc định
        contentPane.add(sampleLabel);

        // Thêm ItemListener cho các JRadioButton
        redRadio.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    sampleLabel.setForeground(Color.RED);
                }
            }
        });

        blueRadio.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    sampleLabel.setForeground(Color.BLUE);
                }
            }
        });

        greenRadio.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    sampleLabel.setForeground(Color.GREEN);
                }
            }
        });
    }
}