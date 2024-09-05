package bookLink;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bookLink.homeAdmin.Book;
import bookLink.homeAdmin.BookListCellRenderer;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class cart extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<Reserved> reservedBook;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cart frame = new cart(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	static class Reserved {
		int bookId;
		int userId;
		boolean status;

        Reserved(int bookId, int userId, boolean status) {
            this.bookId = bookId;
            this.userId = userId;
            this.status = status;
        }
        
        public int getBookId() { return bookId;}
        public int getUserId() { return userId;}
		public Boolean getStatus() {return status;}
		
		public void setBookId(int bookId) { this.bookId = bookId;}
		public void setUserId(int userId) { this.userId = userId;}
		public void setStatus(boolean status) { this.status = status;}
    }
	
	static class ReservedBookCellRenderer extends JPanel implements ListCellRenderer<Reserved> {

        private final JLabel titleLabel = new JLabel();
        private final JLabel imageLabel = new JLabel();
        private JButton deleteButton = new JButton("<html><center><img src='file:C:\\Users\\Angel\\eclipse-workspace\\bookLink\\assets\\delete.png' width='45' height='45'></center></html>");
        private JCheckBox checked = new JCheckBox();

        public ReservedBookCellRenderer() {
            setLayout(new BorderLayout(0, 0));
            setBorder(new EmptyBorder(20, 10, 20, 10));
            setBackground(new Color(232,232,232));

            // Details on the center
            JPanel imagePanel = new JPanel(new BorderLayout());
            imagePanel.add(imageLabel, BorderLayout.WEST);
            imagePanel.add(titleLabel, BorderLayout.CENTER);
            imagePanel.setPreferredSize(new Dimension(100, 100));      
            imagePanel.setBackground(Color.WHITE);

            //checkbox 
            JPanel checkBoxPanel = new JPanel(new BorderLayout());
            checkBoxPanel.setBackground(Color.WHITE);
            checkBoxPanel.setSize(100, 100);
            checkBoxPanel.add(checked, BorderLayout.CENTER);
            checked.setSize(30,30);
            checked.setBorder(new LineBorder(new Color(211, 51, 51), 2)); 
            checked.setBackground(Color.white);
       
            // Buttons panel
            JPanel buttonPanel = new JPanel(new BorderLayout());
            buttonPanel.setBackground(Color.WHITE);
            buttonPanel.add(deleteButton, BorderLayout.CENTER);
            deleteButton.setContentAreaFilled(false);
            deleteButton.setBorderPainted(false);
            buttonPanel.add(deleteButton);

            // Adding components to main panel
            add(imagePanel, BorderLayout.CENTER);
            add(checkBoxPanel, BorderLayout.WEST);
            add(buttonPanel, BorderLayout.EAST);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Reserved> list, Reserved reserved, int index, boolean isSelected, boolean cellHasFocus) {
        	Book book = getBookDetailsById(reserved.bookId);
        	if (book != null) {
                titleLabel.setText("    " + book.title);
                imageLabel.setText("<html><img src='file:" + book.imagePath + "' width='100' height='100'></html>");
                checked.setEnabled(true);
                checked.setSelected(reserved.getStatus());
                titleLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
                deleteButton.addActionListener(e -> {
                    int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + book.title + "?",
                        "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {
                        // ---- REMOVE --->>>
                        JOptionPane.showMessageDialog(this, book.title + " deleted.");
                    }
                });
            } else {
                titleLabel.setText("Book not found");
                imageLabel.setText(""); // Or set a placeholder image
            }
            
            setBorder(isSelected? new MatteBorder(2, 2, 2, 2, (Color) new Color(239, 65, 54)): new EmptyBorder(7, 10, 7, 10));
            return this;
        }
        
        private Book getBookDetailsById(int bookId) {
            DbConnect conn = new DbConnect();
            conn.connect();

            if (conn.con != null) {
                String sql = "SELECT title, image_path FROM books WHERE book_id = ?";
                try (PreparedStatement pst = conn.con.prepareStatement(sql)) {
                    pst.setInt(1, bookId);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        String title = rs.getString("title");
                        String imagePath = rs.getString("image_path");
                        return new Book(bookId, title, null, null, null, false, imagePath, null);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

	public cart(Book selectedBook) {
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 20, 490, 784);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(232, 232, 232));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField lblNewLabel_1 = new JTextField("CART");
		lblNewLabel_1.setEditable(false);
		lblNewLabel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		lblNewLabel_1.setBackground(new Color(232, 232, 232));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(211, 51, 51));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(156, 10, 147, 57);
		contentPane.add(lblNewLabel_1);
		
		DefaultListModel<Reserved> reservedModel = getReservedBook();
        reservedBook = new JList<>(reservedModel);
        reservedBook.setBorder(new EmptyBorder(20, 0, 0, 0));
        reservedBook.setCellRenderer(new ReservedBookCellRenderer());
        reservedBook.setBackground(new Color(232, 232, 232));

        JScrollPane scrollPane = new JScrollPane(reservedBook);
        scrollPane.setBounds(10, 38, 456, 562);
        scrollPane.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(0, 0, 0)));
        scrollPane.setBackground(new Color(232, 232, 232));
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setPreferredSize(new Dimension(8, Integer.MAX_VALUE)); 
        contentPane.add(scrollPane);
		
		JButton btnDelete = new JButton("BACK");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new homeUser("from cart").setVisible(true);
				dispose();
			}
		});
		btnDelete.setRequestFocusEnabled(false);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(211, 51, 51));
		btnDelete.setBounds(10, 671, 456, 53);
		contentPane.add(btnDelete);
		
		
		JButton btnBorrow = new JButton("BORROW");
		btnBorrow.setRequestFocusEnabled(false);
		btnBorrow.setForeground(Color.WHITE);
		btnBorrow.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBorrow.setBorderPainted(false);
		btnBorrow.setBackground(new Color(211, 51, 51));
		btnBorrow.setBounds(10, 608, 456, 53);
		contentPane.add(btnBorrow);	
	}
	
	public static DefaultListModel<Reserved> getReservedBook() {
        DefaultListModel<Reserved> reservedListModel = new DefaultListModel<>();
        DbConnect conn = new DbConnect();
        conn.connect();

        if (conn.con != null) {
            String sql = "SELECT book_id FROM reservation WHERE reservation_status = 0";
            try (PreparedStatement pst = conn.con.prepareStatement(sql)) {
                ResultSet rs = pst.executeQuery();

                if (!rs.isBeforeFirst()) {
                    System.out.println("No records found.");
                }
                while (rs.next()) {
                    int bookId = rs.getInt("book_id");
                    System.out.println("Book ID: " + bookId);
                    Reserved reserved = new Reserved(bookId, 700001, false); // Initially unchecked
                    reservedListModel.addElement(reserved);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return reservedListModel;
    }
}
