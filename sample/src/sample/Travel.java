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
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Travel {

	private JFrame frmTrawell;
	private JTextField tf1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Travel window = new Travel();
					window.frmTrawell.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Travel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTrawell = new JFrame();
		frmTrawell.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\online lab\\Downloads\\train.png"));
		frmTrawell.setTitle("Trawell");
		frmTrawell.setBounds(100, 100, 450, 300);
		frmTrawell.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrawell.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trawell");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(175, 11, 64, 19);
		frmTrawell.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(89, 59, 46, 14);
		frmTrawell.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Source : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(81, 91, 54, 14);
		frmTrawell.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Destination : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(52, 122, 83, 14);
		frmTrawell.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("No of Tickets :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(42, 156, 93, 14);
		frmTrawell.getContentPane().add(lblNewLabel_5);
		
		tf1 = new JTextField();
		tf1.setBounds(145, 57, 147, 20);
		frmTrawell.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		JComboBox cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "HYDERABAD", "SECUNDERABAD", "MIYAPUR", "PATENCHERU", "AMEERPET", "HOUSING BOARD", "PARADE GROUND", "KOMPALLY"}));
		cb1.setBounds(145, 88, 147, 22);
		frmTrawell.getContentPane().add(cb1);
		
		JComboBox cb2 = new JComboBox();
		cb2.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "HYDERABAD", "SECUNDERABAD", "MIYAPUR", "PATENCHERU", "AMEERPET", "HOUSING BOARD", "PARADE GROUND", "KOMPALLY"}));
		cb2.setBounds(145, 119, 147, 22);
		frmTrawell.getContentPane().add(cb2);
		
		JComboBox cb3 = new JComboBox();
		cb3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		cb3.setBounds(145, 153, 147, 22);
		frmTrawell.getContentPane().add(cb3);
		
		JButton btnNewButton = new JButton("Book Now");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tf1.getText();
				String source = (String) cb1.getSelectedItem();
				String destination = (String) cb2.getSelectedItem();
				String NoOfTickets = (String) cb3.getSelectedItem();
				int tickets = Integer.parseInt(NoOfTickets);
				int bill = 0;
				if(source == destination || source == "SELECT" || destination == "SELECT" || tickets == 0) {
					JOptionPane.showMessageDialog(btnNewButton, "Check your status");
				} else {
					bill = bill+50*tickets;
					int result = JOptionPane.showConfirmDialog(btnNewButton, "Name : " + name + "\nSource : " + source + "\nDestination : " + destination + "\nNo of Tickets : " + NoOfTickets + "\nBill : " + bill);
					if(result == 0) {
						JOptionPane.showMessageDialog(btnNewButton, "Booking Confirmed");
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Booking Cancelled");
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(145, 205, 147, 23);
		frmTrawell.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\online lab\\Downloads\\weathered-blue-page.jpg"));
		lblNewLabel_1.setBounds(0, 0, 434, 261);
		frmTrawell.getContentPane().add(lblNewLabel_1);
	}
}
