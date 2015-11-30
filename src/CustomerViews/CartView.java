package CustomerViews;
/*
 * 445 Database
 * Ariel McNamara and Audrey
 * 
 */
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Color;

public class CartView extends JPanel {

	/**
	 * Create the panel.
	 */
	public CartView() {

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
		
		JPanel itemOnCartPanel = new JPanel();
		itemOnCartPanel.setBackground(new Color(153, 153, 51));
		itemOnCartPanel.setBounds(0, 11, 580, 392);
		panel_2.add(itemOnCartPanel);
		
		JPanel shoppingCartPanel = new JPanel();
		shoppingCartPanel.setBackground(new Color(255, 153, 51));
		shoppingCartPanel.setBounds(590, 11, 198, 172);
		panel_2.add(shoppingCartPanel);
		
		JPanel purchaseSummaryPanel = new JPanel();
		purchaseSummaryPanel.setBackground(new Color(255, 153, 51));
		purchaseSummaryPanel.setBounds(590, 194, 198, 209);
		panel_2.add(purchaseSummaryPanel);

	}
}
