package sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.Toolkit;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame frmRegistrationForm;
	private JTextField tb1;
	private JTextField tb2;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrationForm = new JFrame();
		frmRegistrationForm.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\online lab\\Downloads\\registration.png"));
		frmRegistrationForm.setTitle("Registration Form");
		frmRegistrationForm.setBounds(100, 100, 450, 300);
		frmRegistrationForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistrationForm.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Registration Form");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(144, 11, 143, 19);
		frmRegistrationForm.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(57, 56, 61, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Roll No :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(47, 81, 76, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Branch :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(47, 107, 76, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_4);
		
		tb1 = new JTextField();
		tb1.setBounds(133, 54, 117, 20);
		frmRegistrationForm.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		tb2 = new JTextField();
		tb2.setBounds(133, 79, 117, 20);
		frmRegistrationForm.getContentPane().add(tb2);
		tb2.setColumns(10);
		
		JComboBox cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "CSE", "IT", "ECE", "EEE", "CIVIL", "MECH"}));
		cb1.setBounds(133, 103, 117, 22);
		frmRegistrationForm.getContentPane().add(cb1);
		
		JLabel lblNewLabel_5 = new JLabel("Gender :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(47, 151, 76, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Prog Lang :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(27, 184, 90, 14);
		frmRegistrationForm.getContentPane().add(lblNewLabel_6);
		
		JRadioButton rb1 = new JRadioButton("Male");
		buttonGroup.add(rb1);
		rb1.setBackground(new Color(240, 240, 240));
		rb1.setBounds(133, 147, 117, 23);
		frmRegistrationForm.getContentPane().add(rb1);
		
		JRadioButton rb2 = new JRadioButton("Female");
		buttonGroup.add(rb2);
		rb2.setBounds(264, 147, 122, 23);
		frmRegistrationForm.getContentPane().add(rb2);
		
		JCheckBox check1 = new JCheckBox("Python");
		check1.setBounds(133, 181, 117, 23);
		frmRegistrationForm.getContentPane().add(check1);
		
		JCheckBox check2 = new JCheckBox("Java");
		check2.setBounds(264, 181, 122, 23);
		frmRegistrationForm.getContentPane().add(check2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name = tb1.getText();
			String roll = tb2.getText();
			String branch = (String) cb1.getSelectedItem();
			String Gender = rb1.isSelected() ? rb1.getText() : rb2.isSelected() ? rb2.getText() : "Null";
			String Lang = "";
			if(check1.isSelected()) {
				Lang= Lang+" Python";
			}
			if(check2.isSelected()) {
				Lang= Lang+" Java";
			}
			JOptionPane.showMessageDialog(btnNewButton, "Name :" + name + "\nRoll No :" + roll + "\nBranch :" + branch + "\nGender :" + Gender + "\nLanguages : " + Lang);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(161, 227, 89, 23);
		frmRegistrationForm.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\online lab\\Downloads\\weathered-blue-page.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		frmRegistrationForm.getContentPane().add(lblNewLabel);
		frmRegistrationForm.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmRegistrationForm.getContentPane(), lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, tb1, tb2, cb1, lblNewLabel_5, lblNewLabel_6, rb1, rb2, check1, check2, btnNewButton, lblNewLabel}));
	}
}
