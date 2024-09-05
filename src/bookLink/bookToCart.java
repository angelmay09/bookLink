package bookLink;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import bookLink.homeAdmin.Book;

public class bookToCart extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField publishedField;
	private JTextField authorField;
	private JTextField titleField;
	private JTextField availabilityField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookToCart frame = new bookToCart(null,"USERNAME");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public bookToCart(Book selectedBook, String loginUser) {
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 20, 490, 784);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(232, 232, 232));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton cartBtn = new JButton("Add to Cart");
		cartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedBook.getAvailability()) {
			        DbConnect conn = new DbConnect();
					conn.connect();
			        if (conn.con != null ) {
			        	String sql = "INSERT INTO reservation (book_id, user_id) VALUES (?, ?)";
			        	try (PreparedStatement pst = conn.con.prepareStatement (sql)){
			        		// Set parameters for the SQL query
			                pst.setInt(1, selectedBook.getBookId());
			                pst.setInt(2, 7000001);
			                pst.executeUpdate();
			                JOptionPane.showMessageDialog(bookToCart.this, "Book Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			        	} catch (SQLException ex) {
			                ex.printStackTrace();
			                JOptionPane.showMessageDialog(bookToCart.this, "Error saving book: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			            }
			        	
			        }
				} else {
					JOptionPane.showMessageDialog(null, "Book Not Available");
				}
				new homeUser(loginUser).setVisible(true);
				dispose();
			}
		});
		cartBtn.setRequestFocusEnabled(false);
		cartBtn.setForeground(Color.WHITE);
		cartBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		cartBtn.setBorderPainted(false);
		cartBtn.setBackground(new Color(211, 51, 51));
		cartBtn.setBounds(10, 667, 458, 53);
		contentPane.add(cartBtn);
		
		JLabel imageField = new JLabel();
		imageField.setBounds(148, 32, 175, 175);
		contentPane.add(imageField);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 226, 456, 125);
		contentPane.add(panel);
		panel.setLayout(null);

        JTextArea overviewField = new JTextArea();
        overviewField.setMargin(new Insets(5, 5, 5, 5));
        overviewField.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 255, 255)));
        overviewField.setLineWrap(true);
        overviewField.setEditable(false);
        overviewField.setForeground(new Color(0, 0, 0));
        overviewField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        overviewField.setColumns(10);
        overviewField.setBackground(Color.WHITE);
        overviewField.setText(selectedBook.getOverview());
        JScrollPane overviewScroll = new JScrollPane(overviewField);  
        overviewScroll.setOpaque(false);
		overviewScroll.setBorder(new EmptyBorder(0, 0, 0, 0));
		overviewScroll.setBounds(10, 350, 456, 275);
        getContentPane().add(overviewScroll);
        overviewScroll.setViewportView(overviewField);
        
		publishedField = new JTextField();
		publishedField.setEditable(false);
		publishedField.setBorder(new EmptyBorder(0, 0, 0, 0));
		publishedField.setHorizontalAlignment(SwingConstants.CENTER);
		publishedField.setForeground(new Color(0, 0, 0));
		publishedField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		publishedField.setColumns(10);
		publishedField.setBackground(Color.WHITE);
		publishedField.setBounds(26, 96, 397, 22);
		panel.add(publishedField);
		
		JTextField genreField = new JTextField();
		genreField.setEditable(false);
		genreField.setBorder(new EmptyBorder(0, 0, 0, 0));
		genreField.setHorizontalAlignment(SwingConstants.CENTER);
		genreField.setForeground(new Color(0, 0, 0));
		genreField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		genreField.setBackground(Color.WHITE);
		genreField.setBounds(26, 75, 397, 22);
		panel.add(genreField);
		
		authorField = new JTextField();
		authorField.setEditable(false);
		authorField.setBorder(new EmptyBorder(0, 0, 0, 0));
		authorField.setHorizontalAlignment(SwingConstants.CENTER);
		authorField.setForeground(new Color(0, 0, 0));
		authorField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		authorField.setColumns(10);
		authorField.setBackground(Color.WHITE);
		authorField.setBounds(26, 54, 397, 22);
		panel.add(authorField);
		
		titleField = new JTextField();
		titleField.setEditable(false);
		titleField.setBorder(new EmptyBorder(0, 0, 0, 0));
		titleField.setHorizontalAlignment(SwingConstants.CENTER);
		titleField.setForeground(new Color(0, 0, 0));
		titleField.setFont(new Font("Tahoma", Font.BOLD, 25));
		titleField.setColumns(10);
		titleField.setBackground(Color.WHITE);
		titleField.setBounds(26, 10, 397, 39);
		panel.add(titleField);
		
		titleField.setText(selectedBook.getTitle());
		authorField.setText(selectedBook.getAuthor());
		genreField.setText(selectedBook.getGenre());
		publishedField.setText(selectedBook.getPublished());
		imageField.setText("<html><center><img src='file:" + selectedBook.getImage() + "' width='175' height='175'></center></html>");
		
		availabilityField = new JTextField();
		availabilityField.setBounds(10, 623, 456, 22);
		contentPane.add(availabilityField);
		availabilityField.setEditable(false);
		availabilityField.setHorizontalAlignment(SwingConstants.TRAILING);
		availabilityField.setForeground(Color.BLACK);
		availabilityField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		availabilityField.setColumns(10);
		availabilityField.setBorder(new MatteBorder(0, 0, 0, 3, (Color) new Color(255, 255, 255)));
		availabilityField.setBackground(Color.WHITE);
		availabilityField.setText(selectedBook.getAvailability()? "● Available" : "● Not Available");
		availabilityField.setForeground(selectedBook.getAvailability()? Color.green : Color.RED);
		
		JLabel backBtn = new JLabel("<");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new homeUser(loginUser).setVisible(true);
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
