package bookLink;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class borrowedAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					borrowedAdmin frame = new borrowedAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public borrowedAdmin() {
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 20, 490, 784);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(232, 232, 232));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 144, 456, 108);
		contentPane.add(list);
		
		JTextField lblNewLabel_1 = new JTextField("BORROWED");
		lblNewLabel_1.setEditable(false);
		lblNewLabel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		lblNewLabel_1.setBackground(new Color(232, 232, 232));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(211, 51, 51));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(134, 0, 210, 57);
		contentPane.add(lblNewLabel_1);
		
		JLabel backBtn = new JLabel("<");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new homeAdmin().setVisible(true);
				dispose();
				
			}
		});
		backBtn.setHorizontalAlignment(SwingConstants.CENTER);
		backBtn.setForeground(new Color(239, 65, 54));
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		backBtn.setBounds(429, 10, 37, 35);
		contentPane.add(backBtn);
	}

}
