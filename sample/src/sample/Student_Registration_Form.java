package sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Student_Registration_Form {

	private JFrame frmRegistrationForm;
	private JTextField tf1;
	private JTextField tf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Registration_Form window = new Student_Registration_Form();
					window.frmRegistrationForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Student_Registration_Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrationForm = new JFrame();
		frmRegistrationForm.setTitle("Registration Form");
		frmRegistrationForm.setBounds(100, 100, 453, 300);
		frmRegistrationForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistrationForm.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student registration Form");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(123, 11, 198, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(81, 56, 26, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(61, 92, 46, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Branch : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(51, 134, 60, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_4);
		
		tf1 = new JTextField();
		tf1.setBounds(138, 54, 142, 20);
		frmRegistrationForm.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(138, 90, 142, 20);
		frmRegistrationForm.getContentPane().add(tf2);
		tf2.setColumns(10);
		
		JComboBox cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "CSE", "ECE", "EEE", "CIVIL", "MECH"}));
		cb1.setBounds(138, 131, 142, 22);
		frmRegistrationForm.getContentPane().add(cb1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roll = tf1.getText();
				int id = Integer.parseInt(roll);
				String name = tf2.getText();
				String branch = (String) cb1.getSelectedItem();
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrec","root","mrec");
					String q = "insert into stdents values('"+id+"','"+name+"','"+branch+"')";
					Statement stn = con.createStatement();
					stn.executeUpdate(q);
					JOptionPane.showMessageDialog(btnNewButton, "Record Inserted Successfully");
					con.close();
				} catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(138, 193, 142, 23);
		frmRegistrationForm.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\online lab\\Downloads\\weathered-blue-page.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		frmRegistrationForm.getContentPane().add(lblNewLabel);
	}
}
