package bookLink;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loginUser;
	private JPasswordField loginPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 20, 490, 784);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrEnterYourUsername = new JTextArea();
		txtrEnterYourUsername.setEditable(false);
		txtrEnterYourUsername.setForeground(new Color(211, 51, 51));
		txtrEnterYourUsername.setText("LINKING YOU WITH\r\n    YOUR BOOKS.");
		txtrEnterYourUsername.setFont(new Font("Tahoma", Font.ITALIC, 25));
		txtrEnterYourUsername.setColumns(3);
		txtrEnterYourUsername.setBackground(new Color(240, 240, 240));
		txtrEnterYourUsername.setBounds(128, 208, 236, 78);
		contentPane.add(txtrEnterYourUsername);
		
		JLabel lblAccount = new JLabel("BOOKLINK");
		lblAccount.setBounds(34, 107, 415, 99);
		contentPane.add(lblAccount);
		lblAccount.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setForeground(new Color(211, 51, 51));
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblAccount.setBackground(new Color(211, 51, 51));
		lblAccount.setAutoscrolls(false);
		lblAccount.setAlignmentY(0.0f);
		lblAccount.setAlignmentX(0.5f);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(true);
		layeredPane.setForeground(new Color(232, 232, 232));
		layeredPane.setBackground(new Color(255, 255, 255));
		layeredPane.setBounds(44, 346, 391, 352);
		contentPane.add(layeredPane);
		
		loginUser = new JTextField();
		loginUser.setBounds(44, 55, 303, 39);
		layeredPane.add(loginUser);
		loginUser.setText("Username");
		loginUser.setHorizontalAlignment(SwingConstants.CENTER);
		loginUser.setForeground(Color.GRAY);
		loginUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginUser.setColumns(10);
		loginUser.setBackground(new Color(232, 232, 232));
		loginUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (loginUser.getText().equals("Username")) {
					loginUser.setText("");
					loginUser.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (loginUser.getText().isEmpty()) {
					loginUser.setText("Username");
					loginUser.setForeground(Color.GRAY);
				}
			}
		});
		
		
		loginPass = new JPasswordField();
		loginPass.setBounds(44, 124, 303, 39);
		layeredPane.add(loginPass);
		loginPass.setText("Password");
		loginPass.setHorizontalAlignment(SwingConstants.CENTER);
		loginPass.setForeground(Color.GRAY);
		loginPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginPass.setColumns(10);
		loginPass.setBackground(new Color(232, 232, 232));
		loginPass.setEchoChar((char) 0); 
		loginPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(loginPass.getPassword()).equals("Password")) {
					loginPass.setText("");
					loginPass.setForeground(Color.BLACK);
					loginPass.setEchoChar('●');
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(loginPass.getPassword()).isEmpty()) {
					loginPass.setEchoChar((char) 0); 
					loginPass.setText("Password");
					loginPass.setForeground(Color.GRAY);
				}
			}
		});
		
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setRequestFocusEnabled(false);
		loginBtn.setVerifyInputWhenFocusTarget(false);
		loginBtn.setBounds(44, 227, 303, 53);
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		loginBtn.setBorderPainted(false);
		loginBtn.setBackground(new Color(211, 51, 51));
		layeredPane.add(loginBtn);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (loginUser.getText().trim().isEmpty() || String.valueOf(loginPass.getPassword()).trim().isEmpty() ||
	                    loginUser.getText().trim().equals("Username") || String.valueOf(loginPass.getPassword()).trim().equals("Password")) {
                    JOptionPane.showMessageDialog(login.this, "Please enter your username and password.", "Login Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(login.this, "Login successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    if (loginUser.getText().equals("admin") && String.valueOf(loginPass.getPassword()).equals("asd")) {
                    	new homeAdmin().setVisible(true);
                    	dispose();
                    } else {new homeUser(loginUser.getText().toUpperCase()).setVisible(true); dispose();}
                    //loginUser.setText(String.valueOf(loginPass.getPassword()));
                    //loginPass.setText("");
                }
//				boolean success = authenticate(username, password);
//		        if (success) {
//		            JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
//		            --insert visible true
//		        } else {
//		            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
//		        }
			}
		});
		
		JLabel forgotBtn = new JLabel("Forgot Password?");
		forgotBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new forgotPassword().setVisible(true);
				dispose();
			}
		});
		forgotBtn.setForeground(new Color(0, 128, 255));
		forgotBtn.setBounds(209, 165, 137, 30);
		layeredPane.add(forgotBtn);
		forgotBtn.setHorizontalAlignment(SwingConstants.TRAILING);
		forgotBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		forgotBtn.setBackground(new Color(255, 255, 255));
		
		
		JLabel registerBtn = new JLabel("Create an account");
		registerBtn.setForeground(new Color(0, 128, 255));
		registerBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		registerBtn.setBackground(Color.WHITE);
		registerBtn.setBounds(219, 301, 128, 30);
		layeredPane.add(registerBtn);
		registerBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent e ) {
				new register().setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Don't have an account?");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setBounds(44, 301, 170, 30);
		layeredPane.add(lblNewLabel_1_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(239, 65, 54));
		panel.setBounds(0, 490, 475, 237);
		contentPane.add(panel);
	}
}
