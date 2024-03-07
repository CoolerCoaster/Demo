package sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MovieApp {

	private JFrame frame;
	private JTextField tf_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieApp window = new MovieApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MovieApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("MoviePix");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(176, 11, 75, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(90, 56, 50, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Movie Name :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(48, 88, 89, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Num Of Tickets :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(30, 122, 109, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		tf_1 = new JTextField();
		tf_1.setBounds(147, 54, 122, 20);
		frame.getContentPane().add(tf_1);
		tf_1.setColumns(10);
		
		JComboBox cb_1 = new JComboBox();
		cb_1.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "RRR", "FAMILY STAR", "KALKI", "GAME CHANGER", "SALAAR", "MIRCHI", "BAHUBALI"}));
		cb_1.setBounds(147, 85, 122, 22);
		frame.getContentPane().add(cb_1);
		
		JComboBox cb_2 = new JComboBox();
		cb_2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		cb_2.setBounds(146, 119, 123, 22);
		frame.getContentPane().add(cb_2);
		
		JButton btnNewButton = new JButton("Book Now");
//		btnNewButton.setEnabled(false);
//		String movieName1 = (String) cb_1.getSelectedItem();
//		String noOfTickets = (String) cb_2.getSelectedItem();
//		int tickets1 = Integer.parseInt(noOfTickets);
//		if(movieName1 != "SELECT" || tickets1 != 0) {
//			btnNewButton.setEnabled(true);
//		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(cb_1.getSelectedItem() == "SELECT" || cb_2.getSelectedItem() == "0")) {
				String nameO = tf_1.getText();
				String movieName = (String) cb_1.getSelectedItem();
				String noOfTickets = (String) cb_2.getSelectedItem();
				int tickets = Integer.parseInt(noOfTickets);
				int bill = 0;
				switch(movieName) {
				case "RRR" :
					bill = bill + tickets*450;
					break;
				case "FAMILY STAR" :
					bill = bill + tickets*250;
					break;
				case "KALKI" :
					bill = bill + tickets*750;
					break;
				case "GAME CHANGER" :
					bill = bill + tickets*200;
					break;
				case "SALAAR" :
					bill = bill + tickets*150;
					break;
				case "MIRCHI" :
					bill = bill + tickets*50;
					break;
				case "BAHUBALI" :
					bill = bill + tickets*300;
					break;
				default :
					break;
				
				}
				int result = JOptionPane.showConfirmDialog(btnNewButton, "Name : " + nameO + "\nMovie Name : " + movieName + "\nNo of Tickets : " + noOfTickets + "\nTotal Bill :" + bill);
				if(result == 0) {
					JOptionPane.showMessageDialog(btnNewButton, "Booking Confirmed");
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "Booking Cancelled");
				}
			}
			}
		});
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setBounds(147, 182, 122, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\online lab\\Downloads\\weathered-blue-page.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel);
	}
}
