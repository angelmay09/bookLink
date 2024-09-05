package bookLink;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;

import bookLink.homeAdmin.Book;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bookEdit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField bookTitle;
	private JTextField author;
	private JComboBox<?> genre;
	private JTextField published;
	private JLayeredPane panel;
	private JLabel imageLabel = new JLabel();
	private JTextArea overview;
    private File selectedImageFile = null;
	private Book selectedBook;

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

	public bookEdit(Book selectedBook) {
		this.selectedBook = selectedBook;
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 20, 490, 784);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(232, 232, 232));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		panel = new JLayeredPane();
		panel.setOpaque(true);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 456, 225);
		contentPane.add(panel);
       
		JLabel cover = new JLabel("Book Cover");
		cover.setBounds(175, 195, 109, 20);
		panel.add(cover);
		cover.setHorizontalAlignment(SwingConstants.LEFT);
		cover.setForeground(Color.GRAY);
		cover.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel imagePanel = new JPanel( new BorderLayout() );
		imagePanel.setBounds(139, 10, 175, 175);
		imagePanel.setPreferredSize(new Dimension(100, 100)); 
		imagePanel.setBackground(Color.WHITE);	
		panel.add(imagePanel);
		imagePanel.add(imageLabel);
		
		overview = new JTextArea();
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
		edit.setFocusPainted(false);
		edit.setBorderPainted(false);
		edit.setRequestFocusEnabled(false);
		edit.setBorder(new EmptyBorder(0, 0, 0, 0));
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();

		        fileChooser.setFileFilter(new FileFilter() {
		            @Override
		            public boolean accept(File file) {
		                if (file.isDirectory()) {
		                    return true;
		                } else {
		                    String filename = file.getName().toLowerCase();
		                    return filename.endsWith(".jpg") || filename.endsWith(".jpeg") || filename.endsWith(".png");
		                }
		            }

		            @Override
		            public String getDescription() {
		                return "Image Files (*.jpg, *.jpeg, *.png)";
		            }
		        });

		        int result = fileChooser.showOpenDialog(null);
		        if (result == JFileChooser.APPROVE_OPTION) {
		        	selectedImageFile = fileChooser.getSelectedFile();
		            try {
		                BufferedImage image = ImageIO.read(selectedImageFile);
		                ImageIcon imageIcon = new ImageIcon(image);
		                Image resizedImage = imageIcon.getImage().getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(), Image.SCALE_SMOOTH);
		                imageLabel.setIcon(new ImageIcon(resizedImage));
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }
			}
		});
		edit.setBounds(399, 179, 57, 46);
		edit.setContentAreaFilled(false);
		panel.add(edit);

		
		
		JButton saveBtn = new JButton("Save");
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedBook != null) {
					updateBook();
				}else {
					addBook();
				}
			}
		});
		saveBtn.setRequestFocusEnabled(false);
		saveBtn.setForeground(Color.WHITE);
		saveBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		saveBtn.setBorderPainted(false);
		saveBtn.setBackground(new Color(211, 51, 51));
		saveBtn.setBounds(38, 667, 397, 53);
		contentPane.add(saveBtn);
		
		
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
		
		genre = new JComboBox<>(new String[] {"Fiction", "Non-Fiction", "Science Fiction", "Fantasy", "Mystery", "Biography"});
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
	
	private void addBook() {
        String title = bookTitle.getText().trim();
        String authorName = author.getText().trim();
        String bookGenre = (String) genre.getSelectedItem();
        String publishDate = published.getText().trim();
        String bookOverview = overview.getText().trim();
        String imagePath = (selectedImageFile != null) ? selectedImageFile.getAbsolutePath() : null;
        
        DbConnect conn = new DbConnect();
		conn.connect();
        if (conn.con != null ) {
        	String sql = "INSERT INTO books (title, author, genre, published, image_path, overview, isAvailable) VALUES (?, ?, ?, ?, ?, ?, ?)";
        	try (PreparedStatement pst = conn.con.prepareStatement (sql)){
        		// Set parameters for the SQL query
                pst.setString(1, title);
                pst.setString(2, authorName);
                pst.setString(3, bookGenre);
                pst.setString(4, publishDate);
                pst.setString(5, imagePath);
                pst.setString(6, bookOverview);
                pst.setInt(7, 1);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Book Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                new homeAdmin().setVisible(true);
                dispose();
        	} catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving book: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        	
        }
    }
	
	private void updateBook() {
        String title = bookTitle.getText().trim();
        String authorName = author.getText().trim();
        String bookGenre = (String) genre.getSelectedItem();
        String publishDate = published.getText().trim();
        String bookOverview = overview.getText().trim();
        String imagePath = (selectedImageFile != null) ? selectedImageFile.getAbsolutePath() : selectedBook.getImage();
        
        DbConnect conn = new DbConnect();
		conn.connect();
        if (conn.con != null ) {
        	String sql = "UPDATE books SET title = ?, author = ?, genre = ?, published = ?, image_path = ?, overview = ?, isAvailable = ? WHERE book_id = ?";
        	try (PreparedStatement pst = conn.con.prepareStatement (sql)){
                pst.setString(1, title);
                pst.setString(2, authorName);
                pst.setString(3, bookGenre);
                pst.setString(4, publishDate);
                pst.setString(5, imagePath);
                pst.setString(6, bookOverview);
                pst.setInt(7, selectedBook.getAvailability()? 1 : 0);
                pst.setInt(8, selectedBook.getBookId());
                System.out.println(selectedBook.getBookId());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Book Updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                new homeAdmin().setVisible(true);
                dispose();
        	} catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving book: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        	
        }
    }
}
