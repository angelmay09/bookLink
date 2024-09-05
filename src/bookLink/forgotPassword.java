package bookLink;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextArea;

public class forgotPassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField forgotUser;
	private JPasswordField forgotPass;
	private JPasswordField forgotRepeat;
	private JButton returnBtn;
	private JLabel error;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgotPassword frame = new forgotPassword();
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
	public forgotPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 20, 490, 784);
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
		
		JLabel lblNewLabel = new JLabel("FORGOT");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 55));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setAutoscrolls(false);
		lblNewLabel.setAlignmentY(0.0f);
		lblNewLabel.setAlignmentX(0.5f);
		lblNewLabel.setBounds(33, 55, 432, 99);
		layeredPane.add(lblNewLabel);
		
		JLabel lblAccount = new JLabel("PASSWORD");
		lblAccount.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAccount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAccount.setForeground(Color.WHITE);
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 55));
		lblAccount.setBackground(Color.WHITE);
		lblAccount.setAutoscrolls(false);
		lblAccount.setAlignmentY(0.0f);
		lblAccount.setAlignmentX(0.5f);
		lblAccount.setBounds(33, 128, 432, 99);
		layeredPane.add(lblAccount);
		
		forgotUser = new JTextField();
		forgotUser.setText("Username");
		forgotUser.setHorizontalAlignment(SwingConstants.LEFT);
		forgotUser.setForeground(Color.GRAY);
		forgotUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		forgotUser.setColumns(10);
		forgotUser.setBackground(Color.WHITE);
		forgotUser.setAlignmentX(15.0f);
		forgotUser.setBounds(94, 405, 303, 39);
		contentPane.add(forgotUser);
		forgotUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (forgotUser.getText().equals("Username")) {
					forgotUser.setText("");
					forgotUser.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (forgotUser.getText().isEmpty()) {
					forgotUser.setText("Username");
					forgotUser.setForeground(Color.GRAY);
				}
			}
		});
		
		forgotPass = new JPasswordField();
		forgotPass.setText("New Password");
		forgotPass.setHorizontalAlignment(SwingConstants.LEFT);
		forgotPass.setForeground(Color.GRAY);
		forgotPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		forgotPass.setColumns(10);
		forgotPass.setBounds(new Rectangle(5, 0, 0, 0));
		forgotPass.setBackground(Color.WHITE);
		forgotPass.setBounds(94, 459, 303, 39);
		forgotPass.setEchoChar((char) 0); 
		contentPane.add(forgotPass);
		forgotPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(forgotPass.getPassword()).equals("New Password")) {
					forgotPass.setText("");
					forgotPass.setForeground(Color.BLACK);
					forgotPass.setEchoChar('●');
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(forgotPass.getPassword()).isEmpty()) {
					forgotPass.setEchoChar((char) 0); 
					forgotPass.setText("New Password");
					forgotPass.setForeground(Color.GRAY);
				}
			}
		});
		
		forgotRepeat = new JPasswordField();
		forgotRepeat.setText("Repeat Password");
		forgotRepeat.setHorizontalAlignment(SwingConstants.LEFT);
		forgotRepeat.setForeground(Color.GRAY);
		forgotRepeat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		forgotRepeat.setColumns(10);
		forgotRepeat.setBounds(new Rectangle(5, 0, 0, 0));
		forgotRepeat.setBackground(Color.WHITE);
		forgotRepeat.setBounds(94, 516, 303, 39);
		forgotRepeat.setEchoChar((char) 0); 
		contentPane.add(forgotRepeat);
		forgotRepeat.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(forgotRepeat.getPassword()).equals("Repeat Password")) {
					forgotRepeat.setText("");
					forgotRepeat.setForeground(Color.BLACK);
					forgotRepeat.setEchoChar('●');
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(forgotRepeat.getPassword()).isEmpty()) {
					forgotRepeat.setEchoChar((char) 0); 
					forgotRepeat.setText("Repeat Password");
					forgotRepeat.setForeground(Color.GRAY);
				}
			}
		});
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setHorizontalAlignment(SwingConstants.CENTER);
		error.setFont(new Font("Tahoma", Font.PLAIN, 14));
		error.setBounds(94, 565, 303, 20);
		contentPane.add(error);
		
		JButton resetBtn = new JButton("Reset Password");
		resetBtn.setRequestFocusEnabled(false); 
		resetBtn.setFocusPainted(false);
		resetBtn.setBorderPainted(false);
		resetBtn.setBorder(BorderFactory.createEmptyBorder());
		resetBtn.setForeground(Color.WHITE);
		resetBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		resetBtn.setBackground(new Color(211, 51, 51));
		resetBtn.setBounds(94, 588, 303, 53);
		contentPane.add(resetBtn);
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				 boolean fieldsEmpty = forgotUser.getText().isEmpty() ||
                         String.valueOf(forgotPass.getPassword()).isEmpty() ||
                         String.valueOf(forgotRepeat.getPassword()).isEmpty() ||
                         forgotUser.getText().equals("Username") ||
                         String.valueOf(forgotPass.getPassword()).equals("New Password") ||
                         String.valueOf(forgotRepeat.getPassword()).equals("Repeat Password");

				if(fieldsEmpty) {
					error.setForeground(Color.RED);
					error.setText("All fields must be filled!");
				} else if (!String.valueOf(forgotPass.getPassword()).equals(String.valueOf(forgotRepeat.getPassword()))) {
					error.setForeground(Color.RED);
					error.setText("Passwords do not match!");
				} else {
					error.setForeground(new Color(0, 128, 64));
					error.setText("Password Reset Successful!");
					forgotUser.setText("");
					forgotPass.setText("");
					forgotRepeat.setText("");
				}
			}
		});
		
		returnBtn = new JButton("Return to Login Page");
		returnBtn.setRequestFocusEnabled(false);
		returnBtn.setForeground(Color.WHITE);
		returnBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		returnBtn.setBorder(BorderFactory.createEmptyBorder());
		returnBtn.setBorderPainted(false);
		returnBtn.setBackground(new Color(211, 51, 51));
		returnBtn.setBounds(0, 694, 475, 53);
		contentPane.add(returnBtn);
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e ) {
				login  loginFrame = new login();
				loginFrame.setVisible(true);
				dispose();
			}
		});
		
		lblNewLabel_1 = new JLabel("Trouble Loggin in?");
		lblNewLabel_1.setBackground(new Color(232, 232, 232));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(130, 287, 213, 39);
		contentPane.add(lblNewLabel_1);
		
		JTextArea txtrEnterYourUsername = new JTextArea();
		txtrEnterYourUsername.setEditable(false);
		txtrEnterYourUsername.setColumns(3);
		txtrEnterYourUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtrEnterYourUsername.setBackground(new Color(242, 242, 242));
		txtrEnterYourUsername.setText("     Enter your username and new \r\npassword. We'll reset your password.");
		txtrEnterYourUsername.setBounds(94, 324, 296, 82);
		contentPane.add(txtrEnterYourUsername);
	}
}
