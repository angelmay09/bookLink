package bookLink;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cart extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cart frame = new cart();
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
	public cart() {
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 784);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(232, 232, 232));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"asd", "asd"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 144, 456, 108);
		contentPane.add(list);
		
		JTextField lblNewLabel_1 = new JTextField("CART");
		lblNewLabel_1.setEditable(false);
		lblNewLabel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		lblNewLabel_1.setBackground(new Color(232, 232, 232));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(211, 51, 51));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(156, 10, 147, 57);
		contentPane.add(lblNewLabel_1);
		
		JLayeredPane panel = new JLayeredPane();
		panel.setBackground(new Color(232, 232, 232));
		panel.setBorder(new CompoundBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)), new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0))));
		panel.setBounds(0, 0, 476, 39);
		contentPane.add(panel);
		
		JButton btnDelete = new JButton("BACK");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new homeUser("from cart").setVisible(true);
				dispose();
			}
		});
		btnDelete.setRequestFocusEnabled(false);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(211, 51, 51));
		btnDelete.setBounds(10, 671, 456, 53);
		contentPane.add(btnDelete);
		
		
		JButton btnBorrow = new JButton("BORROW");
		btnBorrow.setRequestFocusEnabled(false);
		btnBorrow.setForeground(Color.WHITE);
		btnBorrow.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBorrow.setBorderPainted(false);
		btnBorrow.setBackground(new Color(211, 51, 51));
		btnBorrow.setBounds(10, 608, 456, 53);
		contentPane.add(btnBorrow);
	}

}
