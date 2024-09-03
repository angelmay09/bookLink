package bookLink;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import java.awt.Dimension;

public class homeAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBooks;
	private JTextField username;
	private JTextField txtHello;
	private JList<Book> bookList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeAdmin frame = new homeAdmin();
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
        String overview;

        Book(String title, String author, String genre, String publishedDate, boolean isAvailable, String imagePath, String overview) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.publishedDate = publishedDate;
            this.isAvailable = isAvailable;
            this.imagePath = imagePath;
            this.overview = overview;
        }
        
        public String getTitle() { return title;}
		public String getAuthor() {return author;}
		public String getGenre() {return genre;}
		public String getPublished() {return publishedDate;}
		public String getImage() {return imagePath;}
		public String getOverview() {return overview;}
		public Boolean getAvailability() {return isAvailable;}
		
		public void setTitle(String title) { this.title = title;}
		public void setAuthor(String author) { this.author = author;}
		public void setGenre(String genre) { this.genre = genre;}
		public void setPublished(String publishedDate) { this.publishedDate = publishedDate;}
		public void setImage(String image) { this.imagePath = image;}
		public void setOverview(String overview) { this.overview = overview;}
		public void setAvailability(boolean available) { this.isAvailable = available;}
    }
	
	 static class BookListCellRenderer extends JPanel implements ListCellRenderer<Book> {

	        private final JLabel titleLabel = new JLabel();
	        private final JLabel authorLabel = new JLabel();
	        private final JLabel genreLabel = new JLabel();
	        private final JLabel publishedDateLabel = new JLabel();
	        private final JLabel availabilityLabel = new JLabel();
	        private final JLabel imageLabel = new JLabel();
	        private final JButton editButton = new JButton("<html><center><img src='file:C:\\Users\\Angel\\eclipse-workspace\\bookLink\\assets\\edit.png' width='35' height='35'></center></html>");
	        private final JButton deleteButton = new JButton("<html><center><img src='file:C:\\Users\\Angel\\eclipse-workspace\\bookLink\\assets\\delete.png' width='35' height='35'></center></html>");

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
	            buttonPanel.setBackground(Color.WHITE);
	            buttonPanel.add(editButton);
	            buttonPanel.add(Box.createVerticalStrut(5)); 
	            deleteButton.setContentAreaFilled(false);
	            editButton.setContentAreaFilled(false);
	            deleteButton.setBorderPainted(false);
	            editButton.setBorderPainted(false);
	            buttonPanel.add(deleteButton);

	            // Container for button panel
	            JPanel buttonContainer = new JPanel(new BorderLayout());
	            buttonContainer.add(buttonPanel, BorderLayout.CENTER);

	            // Adding components to main panel
	            add(imagePanel, BorderLayout.WEST);
	            add(detailsPanel, BorderLayout.CENTER);
	            add(buttonContainer, BorderLayout.EAST);
	        }

	        @Override
	        public Component getListCellRendererComponent(JList<? extends Book> list, Book book, int index, boolean isSelected, boolean cellHasFocus) {
	            titleLabel.setText("     " + book.title);
	            authorLabel.setText("   Author: " + book.author);
	            genreLabel.setText("   Genre: " + book.genre);
	            publishedDateLabel.setText("   Published Date: " + book.publishedDate);
	            availabilityLabel.setText("   ● ");
	            availabilityLabel.setForeground(book.isAvailable ? Color.GREEN : Color.RED);
	            availabilityLabel.setText(availabilityLabel.getText() + (book.isAvailable ? "Available" : "Not Available"));
	            imageLabel.setText("<html><img src='file:" + book.imagePath + "' width='100' height='100'></html>");
	            titleLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
	           
	            editButton.addActionListener(e -> {
	                //new bookEdit(book).setVisible(true);
	            	JOptionPane.showMessageDialog(this, book.title + " edited.");
	            });

	            deleteButton.addActionListener(e -> {
	                int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + book.title + "?",
	                    "Confirm Deletion", JOptionPane.YES_NO_OPTION);
	                if (response == JOptionPane.YES_OPTION) {
	                	// ---- REMOVE --->>>
	                    JOptionPane.showMessageDialog(this, book.title + " deleted.");
	                }
	            });
	            
	            setBorder(isSelected? new MatteBorder(2, 2, 2, 2, (Color) new Color(239, 65, 54)): new EmptyBorder(7, 10, 7, 10));
	            return this;
	        }
	    }
	 
	public homeAdmin() {
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 784);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(232, 232, 232));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField lblNewLabel_1 = new JTextField("BOOKS");
		lblNewLabel_1.setEditable(false);
		lblNewLabel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		lblNewLabel_1.setBackground(new Color(232, 232, 232));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(211, 51, 51));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(159, 72, 147, 62);
		contentPane.add(lblNewLabel_1);
		
		JButton adminborrowed = new JButton("<html><center><img src='file:C:\\Users\\Angel\\eclipse-workspace\\bookLink\\assets\\borrow.png' width='35' height='35'><br>Borrowed Books</center></html>");
		adminborrowed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new borrowedAdmin().setVisible(true);
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
		
		JButton addBook = new JButton("<html><center><img src='file:C:\\Users\\Angel\\eclipse-workspace\\bookLink\\assets\\add.png' width='37' height='37'><br>Add Book</center></html>");
		addBook.setVerticalAlignment(SwingConstants.TOP);
		addBook.setForeground(new Color(255, 255, 255));
		addBook.setRequestFocusEnabled(false);
		addBook.setFont(new Font("Tahoma", Font.BOLD, 10));
		addBook.setBackground(new Color(239, 65, 54));
		addBook.setBorderPainted(false);
		addBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookEdit bookEditFrame = new bookEdit(null);
				bookEditFrame.setVisible(true);
				setVisible(false);
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
		
		username = new JTextField("");
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.setForeground(Color.BLACK);
		username.setFont(new Font("Tahoma", Font.BOLD, 25));
		username.setEditable(false);
		username.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		username.setBackground(new Color(232, 232, 232));
		username.setBounds(166, 20, 286, 52);
		
		username.setText("ADMIN ! ");
		contentPane.add(username);
		
		txtBooks = new JTextField("        Hello");
		txtBooks.setHorizontalAlignment(SwingConstants.LEFT);
		txtBooks.setForeground(new Color(0, 0, 0));
		txtBooks.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtBooks.setEditable(false);
		txtBooks.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtBooks.setBackground(new Color(232, 232, 232));
		txtBooks.setBounds(21, 20, 431, 52);
		setBookList(new JList<>(new DefaultListModel<Book>()));
		
		DefaultListModel<Book> model = (DefaultListModel<Book>) getBookList().getModel();
        model.addElement(new Book("Book Title 1", "Author 1", "Genre 1", "2022", true, "C:\\Users\\Angel\\eclipse-workspace\\bookLink\\assets\\book.png", "Lorem Ipsum!Lorem Ipsum!Lorem Ipsum!Lorem Ipsum!Lorem Ipsum!Lorem Ipsum!Lorem Ipsum! Lorem Ipsum!Lorem Ipsum!Lorem Ipsum!Lorem Ipsum! Lorem Ipsum!Lorem Ipsum!"));
        model.addElement(new Book("Book Title 2", "Author 2", "Genre 2", "2021", false, "C:\\Users\\Angel\\eclipse-workspace\\bookLink\\assets\\book1.png", "Lorem Ipsum!Lorem Ipsum!Lorem Ipsum!Lorem Ipsum!Lorem Ipsum!Lorem Ipsum!Lorem Ipsum! Lorem Ipsum!Lorem Ipsum!Lorem Ipsum!Lorem Ipsum! Lorem Ipsum!Lorem Ipsum!Lorem Ipsum"));
        model.addElement(new Book("Book Title 1", "Author 1", "Genre 1", "2022", true, "C:\\Users\\Angel\\eclipse-workspace\\bookLink\\assets\\book.png", "Lorem Ipsum!Lorem Ipsum!Lorem Ipsum!Lorem Ipsum!Lorem Ipsum!Lorem Ipsum!Lorem Ipsum! Lorem Ipsum!Lorem Ipsum!Lorem Ipsum!Lorem Ipsum! Lorem Ipsum!Lorem Ipsum!Lorem Ipsum"));
        model.addElement(new Book("Book Title 2", "Author 2", "Genre 2", "2021", false, "C:\\Users\\Angel\\eclipse-workspace\\bookLink\\assets\\book1.png", "Lorem Ipsum"));
        
        
        getBookList().setBorder(null);
        getBookList().setBackground(new Color(232, 232, 232));
        getBookList().setCellRenderer(new BookListCellRenderer());
        getBookList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getBookList().addListSelectionListener(new ListSelectionListener() {
        	public void valueChanged(ListSelectionEvent e) {
        		if(!e.getValueIsAdjusting()) {
        			Book selectedBook = getBookList().getSelectedValue();
        			if (selectedBook!=null) {
        				new bookInfo(selectedBook).setVisible(true);
        				dispose();
        			}
        		}
        	}
        });
        
        JScrollPane scrollPane = new JScrollPane(getBookList());
        scrollPane.setBounds(10, 145, 456, 530);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane.setBackground(new Color(232, 232, 232));
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setPreferredSize(new Dimension(8, Integer.MAX_VALUE)); 
        contentPane.add(scrollPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
		layeredPane.setBounds(0, 0, 476, 102);
		contentPane.add(layeredPane);
		
		txtHello = new JTextField("       Hello");
		txtHello.setHorizontalAlignment(SwingConstants.LEFT);
		txtHello.setForeground(Color.BLACK);
		txtHello.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtHello.setEditable(false);
		txtHello.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtHello.setBackground(new Color(232, 232, 232));
		txtHello.setBounds(20, 20, 432, 52);
		layeredPane.add(txtHello);
		
		
	}

	public JList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(JList<Book> bookList) {
		this.bookList = bookList;
	}
}
