package CustomerViews;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.Icon;

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
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;

public class StoreView extends JPanel {
	

	private CheapStoreDB db;
	private List<Item> itemsList;
	
	

	/**
	 * Create the panel.
	 */
	public StoreView() {
		
		
		
		db = new CheapStoreDB();
		
		try {
			itemsList = db.getItems();
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 153, 51));
		panel_1.setBounds(0, 11, 336, 392);
		panel_2.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JList itemList = new JList(itemsList.toArray());
		itemList.setCellRenderer(new ItemCellRenderer());
		itemList.setVisibleRowCount(4);
	   		
		JScrollPane pane = new JScrollPane(itemList);
		panel_1.add(pane, BorderLayout.CENTER);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 153, 51));
		panel_3.setBounds(346, 11, 442, 247);
		panel_2.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 153, 51));
		panel_4.setBounds(346, 269, 442, 134);
		panel_2.add(panel_4);

	}
}


////////////////////////////////////////////////////////////////////////////////////
class ItemCellRenderer extends JLabel implements ListCellRenderer {
	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

	public ItemCellRenderer() {
		setOpaque(true);
		setIconTextGap(12);
	}

	public Component getListCellRendererComponent(
			JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		
		Item entry = (Item) value;
		setText(entry.getName());
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
