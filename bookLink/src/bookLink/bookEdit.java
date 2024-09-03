package bookLink;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bookLink.homeAdmin.Book;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class bookEdit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField bookTitle;
	private JTextField author;
	private JComboBox<?> genre;
	private JTextField published;
	private JLayeredPane panel;
	private final JLabel imageLabel = new JLabel();
	private Book selectedBook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookEdit frame = new bookEdit(null);
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
	public bookEdit(Book selectedBook) {
		this.selectedBook = selectedBook;
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 784);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(232, 232, 232));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JLayeredPane();
		panel.setOpaque(true);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 456, 225);
		contentPane.add(panel);
       
		JLabel cover = new JLabel("New label");
		cover.setBounds(175, 195, 109, 20);
		panel.add(cover);
		cover.setText("Book Cover");
		cover.setHorizontalAlignment(SwingConstants.LEFT);
		cover.setForeground(Color.GRAY);
		cover.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JTextArea overview = new JTextArea();
		overview.setLineWrap(true);
		overview.setBounds(38, 441, 397, 214);
		contentPane.add(overview);
		overview.setText("   Book Overview");
		overview.setForeground(Color.GRAY);
		overview.setFont(new Font("Tahoma", Font.PLAIN, 20));
		overview.setColumns(10);
		overview.setBackground(Color.WHITE);
		overview.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (overview.getText().equals("   Book Overview")) {
					overview.setText("");
					overview.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (overview.getText().isEmpty()) {
					overview.setText("   Book Overview");
					overview.setForeground(Color.GRAY);
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane(overview);  
		scrollPane.setBounds(38, 441, 397, 216);
        getContentPane().add(scrollPane);
        
		JButton edit = new JButton("<html><center><img src='file:C:\\Users\\Angel\\eclipse-workspace\\bookLink\\assets\\edit.png' width='25' height='25'></center></html>");
		edit.setBounds(399, 179, 57, 46);
		edit.setBorderPainted(false);
		edit.setContentAreaFilled(false);
		panel.add(edit);

		
		JPanel imagePanel = new JPanel( new BorderLayout() );
		imagePanel.setBounds(139, 10, 175, 175);
		imagePanel.setPreferredSize(new Dimension(100, 100)); 
		imagePanel.setBackground(Color.WHITE);
			
		panel.add(imagePanel);
		
		JButton saveBtn = new JButton("Save");
		saveBtn.setRequestFocusEnabled(false);
		saveBtn.setForeground(Color.WHITE);
		saveBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		saveBtn.setBorderPainted(false);
		saveBtn.setBackground(new Color(211, 51, 51));
		saveBtn.setBounds(38, 667, 397, 53);
		contentPane.add(saveBtn);
		saveBtn.addActionListener (e -> {
			// UPDATE >>>
			
			
		    JOptionPane.showMessageDialog(bookEdit.this, "Book Saved successfully!", "Saving Success", JOptionPane.INFORMATION_MESSAGE);
		    new homeAdmin().setVisible(true);
		    dispose();
		});

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
		
		bookTitle = new JTextField();
		bookTitle.setBounds(38, 245, 397, 39);
		contentPane.add(bookTitle);
		bookTitle.setColumns(10);
		bookTitle.setText("   Book Title");
		bookTitle.setHorizontalAlignment(SwingConstants.LEFT);
		bookTitle.setForeground(Color.GRAY);
		bookTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bookTitle.setColumns(10);
		bookTitle.setBackground(Color.WHITE);
		bookTitle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (bookTitle.getText().equals("   Book Title")) {
					bookTitle.setText("");
					bookTitle.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (bookTitle.getText().isEmpty()) {
					bookTitle.setText("   Book Title");
					bookTitle.setForeground(Color.GRAY);
				}
			}
		});
		
		author = new JTextField();
		author.setColumns(10);
		author.setBounds(38, 294, 397, 39);
		contentPane.add(author);
		author.setText("   Author");
		author.setHorizontalAlignment(SwingConstants.LEFT);
		author.setForeground(Color.GRAY);
		author.setFont(new Font("Tahoma", Font.PLAIN, 20));
		author.setColumns(10);
		author.setBackground(Color.WHITE);
		author.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (author.getText().equals("   Author")) {
					author.setText("");
					author.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (author.getText().isEmpty()) {
					author.setText("   Author");
					author.setForeground(Color.GRAY);
				}
			}
		});
		
		genre = new JComboBox();
		genre.setModel(new DefaultComboBoxModel(new String[] {"Fiction", "Non-Fiction", "Science Fiction", "Fantasy", "Mystery", "Biography"}));
		genre.setName("   Genre");
		genre.setBounds(38, 343, 397, 39);
		contentPane.add(genre);
		genre.setForeground(Color.GRAY);
		genre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		genre.setBackground(Color.WHITE);
		
		published = new JTextField();
		published.setColumns(10);
		published.setBounds(38, 392, 397, 39);
		contentPane.add(published);
		published.setText("   Published Date");
		published.setHorizontalAlignment(SwingConstants.LEFT);
		published.setForeground(Color.GRAY);
		published.setFont(new Font("Tahoma", Font.PLAIN, 20));
		published.setColumns(10);
		published.setBackground(Color.WHITE);
		published.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (published.getText().equals("   Published Date")) {
					published.setText("");
					published.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (published.getText().isEmpty()) {
					published.setText("   Published Date");
				}
			}
		});
		
		if (selectedBook!=null) {
			bookTitle.setText(selectedBook.getTitle());
			bookTitle.setForeground(Color.BLACK);
			author.setForeground(Color.BLACK);
			genre.setForeground(Color.BLACK);
			published.setForeground(Color.BLACK);
			cover.setForeground(Color.BLACK);
			overview.setForeground(Color.BLACK);
	        author.setText(selectedBook.getAuthor());
	        genre.setToolTipText(selectedBook.getGenre());
	        published.setText(selectedBook.getPublished());
	        imageLabel.setBounds(139, 10, 175, 175);
	        imagePanel.add(imageLabel);
	        imageLabel.setText("<html><center><img src='file:" + selectedBook.getImage() + "' width='175' height='175'></center></html>");
	        overview.setText(selectedBook.getOverview());
	        if (selectedBook.getImage() == null) {
	            cover.setText("<html><center>No Image</center></html>");
	        }
		}
	}

	
}
