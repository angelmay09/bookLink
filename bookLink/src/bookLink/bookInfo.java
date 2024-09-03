package bookLink;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import bookLink.homeAdmin.Book;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Insets;

public class bookInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField publishedField;
	private JTextField authorField;
	private JTextField titleField;
	private JTextField availabilityField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookInfo frame = new bookInfo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public bookInfo(Book selectedBook) {
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 784);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(232, 232, 232));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this book?", "Confirm Deletion",
		                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		        if (response == JOptionPane.YES_OPTION) {
		            DefaultListModel<Book> model = (DefaultListModel<Book>) new homeAdmin().getBookList().getModel();
		            model.removeElement(selectedBook);
		            
		            JOptionPane.showMessageDialog(null, "Book deleted successfully!");
		            new homeAdmin().setVisible(true);
		            dispose(); 
		        } else {
		            JOptionPane.showMessageDialog(null, "Deletion cancelled.");
		        }
			}
		});
		btnDelete.setRequestFocusEnabled(false);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(211, 51, 51));
		btnDelete.setBounds(245, 667, 223, 53);
		contentPane.add(btnDelete);
		
		JLabel imageField = new JLabel();
		imageField.setBounds(148, 32, 175, 175);
		contentPane.add(imageField);
		
		JButton btnE = new JButton("Edit");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new bookEdit(selectedBook).setVisible(true);
				dispose();
			}
		});
		btnE.setRequestFocusEnabled(false);
		btnE.setForeground(Color.WHITE);
		btnE.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnE.setBorderPainted(false);
		btnE.setBackground(new Color(211, 51, 51));
		btnE.setBounds(10, 667, 223, 53);
		contentPane.add(btnE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 226, 456, 125);
		contentPane.add(panel);
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();  
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(10, 350, 456, 275);
        getContentPane().add(scrollPane);
        
        JTextArea overviewField = new JTextArea();
        overviewField.setMargin(new Insets(5, 5, 5, 5));
        overviewField.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane.setViewportView(overviewField);
        overviewField.setLineWrap(true);
        overviewField.setEditable(false);
        overviewField.setText("   Book Overview");
        overviewField.setForeground(new Color(0, 0, 0));
        overviewField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        overviewField.setColumns(10);
        overviewField.setBackground(Color.WHITE);
        overviewField.setText(selectedBook.getOverview());
		
		publishedField = new JTextField();
		publishedField.setEditable(false);
		publishedField.setBorder(new EmptyBorder(0, 0, 0, 0));
		publishedField.setText("   Published Date");
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
		genreField.setText("Genre");
		genreField.setHorizontalAlignment(SwingConstants.CENTER);
		genreField.setName("   Genre");
		genreField.setForeground(new Color(0, 0, 0));
		genreField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		genreField.setBackground(Color.WHITE);
		genreField.setBounds(26, 75, 397, 22);
		panel.add(genreField);
		
		authorField = new JTextField();
		authorField.setEditable(false);
		authorField.setBorder(new EmptyBorder(0, 0, 0, 0));
		authorField.setText("   Author");
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
		titleField.setText("   Book Title");
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
		
		availabilityField = new JTextField();
		availabilityField.setBounds(10, 623, 456, 22);
		contentPane.add(availabilityField);
		availabilityField.setEditable(false);
		availabilityField.setText("Avaiaility");
		availabilityField.setHorizontalAlignment(SwingConstants.TRAILING);
		availabilityField.setForeground(Color.BLACK);
		availabilityField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		availabilityField.setColumns(10);
		availabilityField.setBorder(new EmptyBorder(0, 0, 0, 0));
		availabilityField.setBackground(Color.WHITE);
		availabilityField.setText(selectedBook.getAvailability()? "● Available" : "● Not Available");
		availabilityField.setForeground(selectedBook.getAvailability()? Color.GREEN : Color.RED);
	}
}
