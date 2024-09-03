package bookLink;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField registerUser;
	private JTextField registerContact;
	private JTextField registerAddress;
	private JPasswordField registerPass;
	private JPasswordField registerRepeat;
	private JLabel backBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
		setTitle("BookLink");
		setBackground(new Color(232, 232, 232));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 784);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBackground(new Color(232, 232, 232));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(true);
		layeredPane.setForeground(new Color(232, 232, 232));
		layeredPane.setBackground(new Color(211, 51, 51));
		layeredPane.setBounds(1, 0, 475, 237);
		contentPane.add(layeredPane);
		
		JLabel lblNewLabel = new JLabel("CREATE YOUR");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(33, 55, 432, 99);
		layeredPane.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 55));
		lblNewLabel.setAutoscrolls(false);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		
		JLabel lblAccount = new JLabel("ACCOUNT");
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
		
		backBtn = new JLabel("<");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new login().setVisible(true);
				dispose();
			}
		});
		backBtn.setHorizontalAlignment(SwingConstants.CENTER);
		backBtn.setForeground(new Color(255, 255, 255));
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		backBtn.setBounds(428, 10, 37, 35);
		layeredPane.add(backBtn);
		
		
		JButton registerBtn = new JButton("Create Account");
		registerBtn.setRequestFocusEnabled(false);
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (registerUser.getText().trim().isEmpty() || String.valueOf(registerPass.getPassword()).trim().isEmpty() ||
	                    registerUser.getText().trim().equals("Username") || String.valueOf(registerPass.getPassword()).trim().equals("Password") || 
	                    registerContact.getText().trim().isEmpty() || String.valueOf(registerRepeat.getPassword()).trim().isEmpty() ||
	                    registerContact.getText().trim().equals("Contact Number") || String.valueOf(registerRepeat.getPassword()).trim().equals("Repeat Password") ||
	                    registerAddress.getText().trim().isEmpty() || registerAddress.getText().trim().equals("Address") ) {
	                    JOptionPane.showMessageDialog(register.this, "All fields must be filled!", "Register Error", JOptionPane.ERROR_MESSAGE);
	                } else if (!String.valueOf(registerPass.getPassword()).equals(String.valueOf(registerRepeat.getPassword()))) {
						JOptionPane.showMessageDialog(register.this, "Passwords do not match!.", "Login Error", JOptionPane.ERROR_MESSAGE);
					}else if (!registerContact.getText().matches("\\d{11}")){
						JOptionPane.showMessageDialog(register.this, "Invalid contact number format (must be 11 digits).", "Register Error", JOptionPane.ERROR_MESSAGE);
					} else {
	                    JOptionPane.showMessageDialog(register.this, "Register successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
	                    registerUser.setText("");
	                    registerPass.setText("");
	                    registerContact.setText("");
	                    registerAddress.setText("");
	                    registerRepeat.setText("");
	                    new login().setVisible(true);
	    				dispose();
	                }
			}
		});
		registerBtn.setBounds(77, 635, 303, 53);
		contentPane.add(registerBtn);
		registerBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		registerBtn.setBorderPainted(false);
		registerBtn.setForeground(new Color(255, 255, 255));
		registerBtn.setBackground(new Color(211, 51, 51));
		
		registerUser = new JTextField();
		registerUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (registerUser.getText().equals("Username")) {
					registerUser.setText("");
					registerUser.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (registerUser.getText().isEmpty()) {
					registerUser.setText("Username");
					registerUser.setForeground(Color.GRAY);
				}
			}
		});
		registerUser.setHorizontalAlignment(SwingConstants.LEFT);
		registerUser.setText("Username");
		registerUser.setForeground(Color.GRAY);
		registerUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		registerUser.setColumns(10);
		registerUser.setBackground(Color.WHITE);
		registerUser.setBounds(77, 302, 303, 39);
		contentPane.add(registerUser);
		
		registerContact = new JTextField();
		registerContact.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (registerContact.getText().equals("Contact Number")) {
					registerContact.setText("");
					registerContact.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (registerContact.getText().isEmpty()) {
					registerContact.setText("Contact Number");
					registerContact.setForeground(Color.GRAY);
				}
			}
		});
		registerContact.setBounds(new Rectangle(5, 0, 0, 0));
		registerContact.setText("Contact Number");
		registerContact.setHorizontalAlignment(SwingConstants.LEFT);
		registerContact.setForeground(Color.GRAY);
		registerContact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		registerContact.setColumns(10);
		registerContact.setBackground(Color.WHITE);
		registerContact.setBounds(77, 367, 303, 39);
		contentPane.add(registerContact);
		
		registerAddress = new JTextField();
		registerAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (registerAddress.getText().equals("Address")) {
					registerAddress.setText("");
					registerAddress.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (registerAddress.getText().isEmpty()) {
					registerAddress.setText("Address");
					registerAddress.setForeground(Color.GRAY);
				}
			}
		});
		registerAddress.setText("Address");
		registerAddress.setHorizontalAlignment(SwingConstants.LEFT);
		registerAddress.setForeground(Color.GRAY);
		registerAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		registerAddress.setColumns(10);
		registerAddress.setBounds(new Rectangle(5, 0, 0, 0));
		registerAddress.setBackground(Color.WHITE);
		registerAddress.setBounds(77, 421, 303, 39);
		contentPane.add(registerAddress);
		
		registerPass = new JPasswordField();
		registerPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(registerPass.getPassword()).isEmpty()) {
					registerPass.setEchoChar((char)0);
					registerPass.setText("Password");
					registerPass.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(registerPass.getPassword()).equals("Password")) {
					registerPass.setText("");
					registerPass.setForeground(Color.BLACK);
					registerPass.setEchoChar('●');
				}
			}
		});
		registerPass.setText("Password");
		registerPass.setHorizontalAlignment(SwingConstants.LEFT);
		registerPass.setForeground(Color.GRAY);
		registerPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		registerPass.setColumns(10);
		registerPass.setBounds(new Rectangle(5, 0, 0, 0));
		registerPass.setBackground(Color.WHITE);
		registerPass.setBounds(77, 481, 303, 39);
		registerPass.setEchoChar((char)0);
		contentPane.add(registerPass);
		
		registerRepeat = new JPasswordField();
		registerRepeat.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(registerRepeat.getPassword()).isEmpty()) {
					registerRepeat.setEchoChar((char)0);
					registerRepeat.setText("Repeat Password");
					registerRepeat.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(registerRepeat.getPassword()).equals("Repeat Password")) {
					registerRepeat.setText("");
					registerRepeat.setForeground(Color.BLACK);
					registerRepeat.setEchoChar('●');
				}
			}
		});
		registerRepeat.setText("Repeat Password");
		registerRepeat.setHorizontalAlignment(SwingConstants.LEFT);
		registerRepeat.setForeground(Color.GRAY);
		registerRepeat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		registerRepeat.setColumns(10);
		registerRepeat.setBounds(new Rectangle(5, 0, 0, 0));
		registerRepeat.setBackground(Color.WHITE);
		registerRepeat.setAlignmentX(15.0f);
		registerRepeat.setBounds(77, 541, 303, 39);
		registerRepeat.setEchoChar((char)0);
		contentPane.add(registerRepeat);
	}
}
