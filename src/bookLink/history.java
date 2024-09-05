package bookLink;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class history extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					history frame = new history();
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
	public history() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 784);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 7));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(true);
		layeredPane.setForeground(new Color(232, 232, 232));
		layeredPane.setBackground(new Color(211, 51, 51));
		layeredPane.setBounds(0, 0, 475, 237);
		contentPane.add(layeredPane);
		
		JLabel lblNewLabel = new JLabel("BOOK");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setAutoscrolls(false);
		lblNewLabel.setAlignmentY(0.0f);
		lblNewLabel.setAlignmentX(0.5f);
		lblNewLabel.setBounds(33, 73, 432, 99);
		layeredPane.add(lblNewLabel);
		
		JLabel lblAccount = new JLabel("HISTORY");
		lblAccount.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAccount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAccount.setForeground(Color.WHITE);
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblAccount.setBackground(Color.WHITE);
		lblAccount.setAutoscrolls(false);
		lblAccount.setAlignmentY(0.0f);
		lblAccount.setAlignmentX(0.5f);
		lblAccount.setBounds(33, 128, 432, 99);
		layeredPane.add(lblAccount);
		
		JLabel backBtn = new JLabel("<");
		backBtn.setHorizontalAlignment(SwingConstants.CENTER);
		backBtn.setForeground(Color.WHITE);
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		backBtn.setBounds(428, 10, 37, 35);
		layeredPane.add(backBtn);
		
		
		JLabel lblNewLabel_1 = new JLabel("bOOK tITLE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBackground(new Color(232, 232, 232));
		lblNewLabel_1.setBounds(125, 263, 213, 39);
		contentPane.add(lblNewLabel_1);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRequestFocusEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ST", null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"USERNAME", "Borrowed", "Return"
			}
		));
		table.setFillsViewportHeight(true);
		table.setBounds(10, 302, 456, 435);
		contentPane.add(table);
	}
}
