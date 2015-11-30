package LogInsJFramesMainClasses;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CustomerViews.CustomerMenu;

import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.ComponentOrientation;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EmployeeBossLogIn extends JFrame{


	private JPanel containerPanel;
	private JLabel labelPicture;
	private JPanel loginFieldsPanel;
	private JPanel panel_2;
	private JTextField passwordTextField;
	private JTextField emailTextField;
	private JLabel lblEmail;
	private JPanel loginPanel;
	
	
	private boolean logoutFlag = false;
	
	
	private JButton btnLogout;

	private JPanel secondPane;
	private JButton employeeMenuLogout;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeBossLogIn frame = new EmployeeBossLogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void createLoginPanel(){
		containerPanel = new JPanel();
		containerPanel.setBackground(new Color(255, 102, 0));
		containerPanel.setBounds(100, 100, 848, 510);
		containerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Create IMage
				Image audreyP = new ImageIcon(this.getClass().getResource(
						"/pictures/Azul.png")).getImage();
				containerPanel.setLayout(new BorderLayout(0, 0));
				
				loginPanel = new JPanel();
				loginPanel.setBackground(new Color(255, 102, 0));
				containerPanel.add(loginPanel);
				loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
				
				JPanel welcomeImagePanel = new JPanel();
				loginPanel.add(welcomeImagePanel);
				welcomeImagePanel.setLayout(new BoxLayout(welcomeImagePanel, BoxLayout.X_AXIS));
				
				labelPicture = new JLabel("");
				labelPicture.setAlignmentX(Component.CENTER_ALIGNMENT);
				welcomeImagePanel.add(labelPicture);
				labelPicture.setHorizontalAlignment(SwingConstants.CENTER);
				labelPicture.setIcon(new ImageIcon(audreyP));
				
				loginFieldsPanel = new JPanel();
				loginPanel.add(loginFieldsPanel);
				loginFieldsPanel.setLayout(null);
				
				panel_2 = new JPanel();
				panel_2.setBackground(new Color(255, 102, 0));
				panel_2.setBounds(0, 0, 864, 315);
				loginFieldsPanel.add(panel_2);
				panel_2.setLayout(null);
				
				passwordTextField = new JTextField();
				passwordTextField.setColumns(10);
				passwordTextField.setBounds(176, 113, 473, 29);
				panel_2.add(passwordTextField);
				
				JLabel lblPassword = new JLabel("Password");
				lblPassword.setBounds(10, 113, 127, 28);
				panel_2.add(lblPassword);
				
				emailTextField = new JTextField();
				emailTextField.setColumns(10);
				emailTextField.setBounds(176, 35, 473, 29);
				panel_2.add(emailTextField);
				
				lblEmail = new JLabel("Email");
				lblEmail.setBounds(10, 35, 127, 28);
				panel_2.add(lblEmail);
				
				JButton signinButton = new JButton("Sign In");
				
				
				
				signinButton.addActionListener(new ActionListener() {
					

					public void actionPerformed(ActionEvent e) {
						
						//	Verify that account exists on DB 
						if(emailTextField.getText().equals("true")){
						
							
					    // Check if account is customer
						if(passwordTextField.getText().equals("c")){
							
							
							
							
							secondPane = new CustomerMenu(btnLogout);
							containerPanel.removeAll();
							containerPanel.add(secondPane);
							containerPanel.revalidate();
							containerPanel.repaint();
							
						// Check if account is Boss or Employee
						}else{
							
							secondPane = new EmployeeBossNavigationMenu(employeeMenuLogout);
							containerPanel.removeAll();
							containerPanel.add(secondPane);
							containerPanel.revalidate();
							containerPanel.repaint();
						}
							
						}
						
						
					}
				});
				signinButton.setBounds(347, 186, 127, 37);
				panel_2.add(signinButton);
				

				
				Component verticalStrut = Box.createVerticalStrut(49);
				containerPanel.add(verticalStrut, BorderLayout.NORTH);
		
		
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public EmployeeBossLogIn() {
		setResizable(false);
		setBackground(new Color(255, 102, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 510);
		
		btnLogout = new JButton("Logout");
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if Logout button gets clicked, logout and rebuild Login Screen
				containerPanel.removeAll();
				createLoginPanel();
				setContentPane(containerPanel);
				containerPanel.revalidate();
				containerPanel.repaint();
			}
			
		});
		
		
		
		employeeMenuLogout = new JButton("LogOut");
		
		employeeMenuLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// if Logout button gets clicked, logout and rebuild Login Screen
				containerPanel.removeAll();
				createLoginPanel();
				setContentPane(containerPanel);
				containerPanel.revalidate();
				containerPanel.repaint();
				
				
			}
		});
		
		
		
		// call on mathod that build Login Panel
		createLoginPanel();

		setContentPane(containerPanel);
		

		
	}

	
	
	
	
	
	
	
	
}
