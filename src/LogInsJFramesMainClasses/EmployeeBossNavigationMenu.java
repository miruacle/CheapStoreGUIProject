package LogInsJFramesMainClasses;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import BossViews.InventoryView;
import BossViews.StatisticsView;
import CustomerViews.CartView;
import CustomerViews.StoreView;
import EmployeeViews.OrdersView;

public class EmployeeBossNavigationMenu extends JPanel {

	
	private JPanel secondPane;	
	private JPanel panel;
	
	private JPanel panel_2;
	

	
	/**
	 * Create the panel.
	 */
	public EmployeeBossNavigationMenu() {
		
		setBounds(100, 100, 848, 471);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 102, 0));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		

		Component horizontalStrut = Box.createHorizontalStrut(30);
		panel.add(horizontalStrut, BorderLayout.WEST);
		
		//Panel 2 - Contains all stuff about store View
		createStoreView();
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(204, 102, 0));
		panel.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_6.add(panel_1);
		panel_1.setBackground(new Color(204, 102, 0));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		panel_1.add(btnLogout, BorderLayout.EAST);
		
		JButton button_1 = new JButton("Navigation Button");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.removeAll();
				createStoreView();
				panel_2.revalidate();
				panel_2.repaint();

			}
		});
		panel_1.add(button_1, BorderLayout.WEST);
		
		Component verticalStrut_1 = Box.createVerticalStrut(12);
		verticalStrut_1.setBackground(new Color(204, 102, 0));
		panel_1.add(verticalStrut_1, BorderLayout.NORTH);
		
		Component verticalStrut = Box.createVerticalStrut(12);
		panel_1.add(verticalStrut, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 102, 0));
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.EAST);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JButton btnNewButton_3 = new JButton("Cart");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				secondPane = new CartView();
				
				panel_2.removeAll();
				panel_2.add(secondPane);
				panel_2.revalidate();
				panel_2.repaint();
			}
		});
		panel_4.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Store");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				secondPane = new StoreView();
				
				panel_2.removeAll();
				panel_2.add(secondPane);
				panel_2.revalidate();
				panel_2.repaint();
				
			}
		});
		panel_4.add(btnNewButton_4);
		
		JLabel lblWelcomeEmployee = new JLabel("Welcome Employee");
		lblWelcomeEmployee.setBackground(new Color(204, 102, 0));
		lblWelcomeEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblWelcomeEmployee, BorderLayout.CENTER);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(30);
		panel_6.add(horizontalStrut_2, BorderLayout.WEST);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(30);
		panel_6.add(horizontalStrut_3, BorderLayout.EAST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(30);
		panel.add(horizontalStrut_1, BorderLayout.EAST);

	}


	private void createStoreView() {
	    panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 102, 0));
		panel.add(panel_2, BorderLayout.CENTER);
		
		// Buttons start on y-coordinates: 15,109,203,297 when y length of pane is 392
		JPanel itemsOnDisplayPanel = new JPanel();
		itemsOnDisplayPanel.setBackground(new Color(153, 153, 51));
		itemsOnDisplayPanel.setBounds(0, 11, 336, 392);
		panel_2.add(itemsOnDisplayPanel);
		
		JButton btnNewButton = new JButton("Orders");
		btnNewButton.setBounds(10, 15, 316, 80);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondPane = new OrdersView();
				
				panel_2.removeAll();
				panel_2.add(secondPane);
				panel_2.revalidate();
				panel_2.repaint();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Statistics");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(10, 297, 316, 80);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				secondPane = new StatisticsView();
				
				panel_2.removeAll();
				panel_2.add(secondPane);
				panel_2.revalidate();
				panel_2.repaint();
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("Inventory");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                secondPane = new InventoryView();
				
				panel_2.removeAll();
				panel_2.add(secondPane);
				panel_2.revalidate();
				panel_2.repaint();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(10, 203, 316, 80);
		itemsOnDisplayPanel.setLayout(null);
		itemsOnDisplayPanel.add(btnNewButton);
		itemsOnDisplayPanel.add(btnNewButton_1);
		itemsOnDisplayPanel.add(btnNewButton_2);
		
		JButton btnStore = new JButton("Store");
		btnStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				secondPane = new StoreView();
				
				panel_2.removeAll();
				panel_2.add(secondPane);
				panel_2.revalidate();
				panel_2.repaint();
			}
		});
		btnStore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnStore.setBounds(10, 109, 316, 80);
		itemsOnDisplayPanel.add(btnStore);
		
		JPanel itemImagePanel = new JPanel();
		itemImagePanel.setBackground(new Color(255, 153, 51));
		itemImagePanel.setBounds(346, 11, 442, 247);
		panel_2.add(itemImagePanel);
		
		JPanel descriptionAndPricePanel = new JPanel();
		descriptionAndPricePanel.setBackground(new Color(255, 153, 51));
		descriptionAndPricePanel.setBounds(346, 269, 442, 134);
		panel_2.add(descriptionAndPricePanel);
	}
}
