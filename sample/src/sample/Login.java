package sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Login {

	private JFrame frame;
	private JTextField tb1;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(40, 69, 49, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(38, 104, 64, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		tb1 = new JTextField();
		tb1.setBounds(111, 67, 127, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		p1 = new JPasswordField();
		p1.setBounds(112, 102, 127, 20);
		frame.getContentPane().add(p1);
		
		JButton btnNewButton = 	new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tb1.getText();
				String password = p1.getText();
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mrec","root","mrec");
					PreparedStatement stn = con.prepareStatement("select name, password from users where name = ? and password = ?");
					stn.setString(1, name);
					stn.setString(2, password);
					ResultSet rs = stn.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(btnNewButton, "Valid User");
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Invalid User");
					}
				} catch(SQLException e1) {
					e1.printStackTrace();
				}
//				if (name.equals("Sai") && password.equals("sai")) {
//					JOptionPane.showMessageDialog(btnNewButton, "Welcome "+ name + "\n Your Password :" +password);
//				} else {
//					JOptionPane.showMessageDialog(btnNewButton, "Invalid Login");
//				}
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setBounds(112, 147, 127, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Login Page");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(156, 11, 93, 36);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
