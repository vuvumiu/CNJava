package yy;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class bai61 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLable;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai61 frame = new bai61();
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
	public bai61() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Follow Me");
		lblNewLabel.setBounds(0, 0, 100, 20);
		contentPane.add(lblNewLabel);
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				lblNewLabel.setLocation(e.getX(), e.getY());
			}
			
		});
	}

}
