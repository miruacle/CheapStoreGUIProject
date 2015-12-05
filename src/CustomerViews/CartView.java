package CustomerViews;
/*
 * 445 Database
 * Ariel McNamara and Audrey
 * 
 */
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import DBClass.CheapStoreDB;
import model.Item;
import model.UserAccount;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JList;

public class CartView extends JPanel {

	private UserAccount currentUser;
	private CheapStoreDB db;
	private List<Item> itemsInOrderList;
	private JList itemsInCartList;
	private int currentOrderNumber;

	/**
	 * Create the panel.
	 */
	public CartView(UserAccount currentUser) {
		
		

		this.currentUser = currentUser;
		db = new CheapStoreDB();
		
		System.out.println(currentUser.getUsersEmail());
		
		try {
			// query 1                                     query 2  
			// get users latest order number 
			 currentOrderNumber = db.getLatestOrderNumber(currentUser.getUsersEmail());
			// get items connectd to that order
//			if(items connectd to that order != null)
//				populate itemsInOrderList with the returned items in the users order list 
			
			itemsInOrderList = db.getItemsInOrder(currentUser.getUsersEmail(), currentOrderNumber);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		

		// Size of layoutPane W: 788, H: 424
		setBounds(0, 0, 788, 424);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 0));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 102, 0));
		panel.add(panel_2, BorderLayout.CENTER);

		JPanel itemsOnCartPanel = new JPanel();
		itemsOnCartPanel.setBackground(new Color(153, 153, 51));
		itemsOnCartPanel.setBounds(0, 11, 580, 392);
		panel_2.add(itemsOnCartPanel);
		itemsOnCartPanel.setLayout(new BorderLayout(0, 0));


		itemsInCartList = new JList(itemsInOrderList.toArray());
		itemsInCartList.setCellRenderer(new ItemCellRendererCart());
		itemsInCartList.setVisibleRowCount(4);

		JScrollPane scrollPane_1 = new JScrollPane(itemsInCartList);
		itemsOnCartPanel.add(scrollPane_1);
		
		// Create IMage
				Image cartImage = new ImageIcon(this.getClass().getResource(
						"/pictures/cart.png")).getImage();
				

		JPanel shoppingCartPanel = new JPanel();
		shoppingCartPanel.setBackground(new Color(255, 153, 51));
		shoppingCartPanel.setBounds(590, 11, 198, 172);
		panel_2.add(shoppingCartPanel);
		shoppingCartPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Your Cart");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shoppingCartPanel.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JLabel ImageLabel = new JLabel("");
		ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageLabel.setIcon(new ImageIcon(cartImage) );
		shoppingCartPanel.add(ImageLabel, BorderLayout.CENTER);
		

		JPanel purchaseSummaryPanel = new JPanel();
		purchaseSummaryPanel.setBackground(new Color(255, 153, 51));
		purchaseSummaryPanel.setBounds(590, 194, 198, 209);
		panel_2.add(purchaseSummaryPanel);
		purchaseSummaryPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		purchaseSummaryPanel.add(scrollPane, BorderLayout.CENTER);

		JTextArea txtrFdfddfvvdfvdfv = new JTextArea();
		txtrFdfddfvvdfvdfv.setText("fdfddfvvdfvdfv\nfdfddfvvdfvdfv\r\nfdfddfvvdfvdfv\r\n\r\nfdfddfvvdfvdfv\r\nfdfddfvvdfvdfv\r\nfdfddfvvdfvdfv\r\nfdfddfvvdfvdfv\r\nfdfddfvvdfvdfv\r\nfdfddfvvdfvdfv\r\nfdfddfvvdfvdfv\r\nv\r\nfdfddfvvdfvdfv\r\nfdfddfvvdfvdfv\r\nfdfddfvvdfvdfv\r\nfdfddfvvdfvdfv\r\nfdfddfvvdfvdfv\r\nv\r\n\r\nv\r\n");
		scrollPane.setViewportView(txtrFdfddfvvdfvdfv);

		JLabel lblNewLabel = new JLabel("Your Estimated Total:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		purchaseSummaryPanel.add(lblNewLabel, BorderLayout.NORTH);

	}
}



////////////////////////////////////////////////////////////////////////////////////
class ItemCellRendererCart extends JLabel implements ListCellRenderer {
	private static final Color HIGHLIGHT_COLOR = new Color(100, 0, 128);

	public ItemCellRendererCart() {
		setOpaque(true);
		setIconTextGap(12);
	}

	public Component getListCellRendererComponent(
			JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {

		Item entry = (Item) value;
		
		System.out.println("Product Selected " + entry.getName());

		setText(entry.getName() + " $" + String.format("%.2f", entry.getPrice()));
		setFont(new Font("Tahoma", Font.PLAIN, 30));

		setIcon( (Icon) entry.getImage());
		if (isSelected) {
			setBackground(HIGHLIGHT_COLOR);
			setForeground(Color.white);
		} else {
			setBackground(Color.white);
			setForeground(Color.black);
		}
		return this;
	}

}

