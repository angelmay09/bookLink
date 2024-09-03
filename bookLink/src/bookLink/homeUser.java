package bookLink;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import bookLink.homeAdmin.Book;
import bookLink.homeAdmin.BookListCellRenderer;

public class homeUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField textField_1;
	private JList<Book> bookList;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeUser frame = new homeUser(" USERNAME ");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	static class Book {
        String title;
        String author;
        String genre;
        String publishedDate;
        boolean isAvailable;
        String imagePath;

        Book(String title, String author, String genre, String publishedDate, boolean isAvailable, String imagePath) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.publishedDate = publishedDate;
            this.isAvailable = isAvailable;
            this.imagePath = imagePath;
        }
    }
	
	 static class BookListCellRenderer extends JPanel implements ListCellRenderer<Book> {

	        private final JLabel titleLabel = new JLabel();
	        private final JLabel authorLabel = new JLabel();
	        private final JLabel genreLabel = new JLabel();
	        private final JLabel publishedDateLabel = new JLabel();
	        private final JLabel availabilityLabel = new JLabel();
	        private final JLabel imageLabel = new JLabel();
	        private final JButton addButton = new JButton("<html><center><img src='file:C:\\Users\\Angel\\eclipse-workspace\\bookLink\\assets\\add1.png' width='65' height='65'></center></html>");

	        public BookListCellRenderer() {
	            setLayout(new BorderLayout(0, 0));
	            setBorder(new EmptyBorder(20, 10, 20, 10));
	            setBackground(new Color(232,232,232));

	            // Image on the right
	            JPanel imagePanel = new JPanel(new BorderLayout());
	            imagePanel.add(imageLabel, BorderLayout.CENTER);
	            imagePanel.setPreferredSize(new Dimension(100, 100)); 
	            imagePanel.setBackground(Color.WHITE);

	            // Book details
	            JPanel detailsPanel = new JPanel();
	            detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
	            detailsPanel.add(titleLabel);
	            detailsPanel.add(authorLabel);
	            detailsPanel.add(genreLabel);
	            detailsPanel.add(publishedDateLabel);
	            detailsPanel.add(availabilityLabel);
	            detailsPanel.setBackground(Color.WHITE);

	            // Buttons panel
	            JPanel buttonPanel = new JPanel();
	            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
	            buttonPanel.add(Box.createVerticalStrut(12)); 
	            buttonPanel.setBackground(Color.WHITE);
	            buttonPanel.add(addButton);
	            addButton.setContentAreaFilled(false);
	            addButton.setBorderPainted(false);

	            // Add components to the renderer
	            add(detailsPanel, BorderLayout.CENTER);
	            add(imagePanel, BorderLayout.WEST);
	            add(buttonPanel, BorderLayout.EAST);
	        }

	        @Override
	        public Component getListCellRendererComponent(JList<? extends Book> list, Book book, int index, boolean isSelected, boolean cellHasFocus) {
	            titleLabel.setText("     " + book.title);
	            authorLabel.setText("   Author: " + book.author);
	            genreLabel.setText("   Genre: " + book.genre);
	            publishedDateLabel.setText("   Published Date: " + book.publishedDate);
	            availabilityLabel.setText("   ●  ");
	            availabilityLabel.setForeground(book.isAvailable ? Color.GREEN : Color.RED);
	            availabilityLabel.setText(availabilityLabel.getText() + (book.isAvailable ? "Available" : "Not Available"));
	            
	            imageLabel.setText("<html><img src='file:" + book.imagePath + "' width='100' height='100'></html>");

	            titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	            addButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Add " + book.title));
	            setBorder(isSelected? new MatteBorder(2, 2, 2, 2, (Color) new Color(239, 65, 54)): new EmptyBorder(7, 10, 7, 10));
	            return this;
	        }
	    }
	 
	/**
	 * Create the frame.
	 * @param loginUser 
	 */
	public homeUser(String loginUser) {
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 784);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(232, 232, 232));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton adminborrowed = new JButton("<html><center><img src='file:C:\\Users\\Angel\\eclipse-workspace\\bookLink\\assets\\borrow.png' width='35' height='35'><br>Borrowed Books</center></html>");
		adminborrowed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new borrowedUser().setVisible(true);
				dispose();
			}
		});
		adminborrowed.setFont(new Font("Tahoma", Font.BOLD, 10));
		adminborrowed.setRequestFocusEnabled(false);
		adminborrowed.setForeground(new Color(255, 255, 255));
		adminborrowed.setBorderPainted(false);
		adminborrowed.setBackground(new Color(239, 65, 54));
		adminborrowed.setBounds(0, 685, 160, 62);
		contentPane.add(adminborrowed);
		
		JButton addBook = new JButton("<html><center><img src='file:C:\\Users\\Angel\\eclipse-workspace\\bookLink\\assets\\cart.png' width='35' height='35'><br>Cart</center></html>");
		addBook.setVerticalAlignment(SwingConstants.TOP);
		addBook.setForeground(new Color(255, 255, 255));
		addBook.setRequestFocusEnabled(false);
		addBook.setFont(new Font("Tahoma", Font.BOLD, 10));
		addBook.setBackground(new Color(239, 65, 54));
		addBook.setBorderPainted(false);
		addBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new cart().setVisible(true);
				dispose();
			}
		});
		addBook.setBounds(159, 685, 160, 62);
		contentPane.add(addBook);
		
		JButton logOut = new JButton("<html><center><img src='file:C:\\Users\\Angel\\eclipse-workspace\\bookLink\\assets\\out.png' width='40' height='40'><br>Log Out</center></html>");
		logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new login().setVisible(true);
				dispose();
			}
		});
		logOut.setVerticalTextPosition(SwingConstants.BOTTOM);
		logOut.setVerticalAlignment(SwingConstants.TOP);
		logOut.setFont(new Font("Tahoma", Font.BOLD, 10));
		logOut.setRequestFocusEnabled(false);
		logOut.setForeground(new Color(255, 255, 255));
		logOut.setBorderPainted(false);
		logOut.setBorder(new EmptyBorder(0, 0, 0, 0));
		logOut.setBackground(new Color(239, 65, 54));
		logOut.setBounds(316, 685, 160, 62);
		contentPane.add(logOut);
		
		DefaultListModel<Book> adminModel = homeAdmin.getBookList();

        bookList = new JList<>(adminModel);
        bookList.setBackground(new Color(232, 232, 232));
        bookList.setCellRenderer(new BookListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(bookList);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane.setBounds(10, 144, 456, 531);
        contentPane.add(scrollPane);
        
		JTextField lblNewLabel_1 = new JTextField("BOOKS");
		lblNewLabel_1.setEditable(false);
		lblNewLabel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		lblNewLabel_1.setBackground(new Color(232, 232, 232));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(211, 51, 51));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(159, 77, 147, 57);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField("");
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.setForeground(Color.BLACK);
		username.setFont(new Font("Tahoma", Font.BOLD, 25));
		username.setEditable(false);
		username.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		username.setBackground(new Color(232, 232, 232));
		username.setBounds(167, 23, 286, 52);
		username.setText(loginUser + " ! ");
		contentPane.add(username);
		
		JLayeredPane panel = new JLayeredPane();
		panel.setBackground(new Color(232, 232, 232));
		panel.setBorder(new CompoundBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)), new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0))));
		panel.setBounds(0, 0, 476, 107);
		contentPane.add(panel);
		
		textField_1 = new JTextField("        Hello");
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		textField_1.setEditable(false);
		textField_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textField_1.setBackground(new Color(232, 232, 232));
		textField_1.setBounds(22, 23, 431, 52);
		panel.add(textField_1);
	}

}
