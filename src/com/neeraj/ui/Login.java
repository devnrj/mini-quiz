package com.neeraj.ui;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.neeraj.entity.Users;
import com.neeraj.entity.UsersOperations;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -968534300784379736L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuizApp = new JLabel("Quiz App");
		lblQuizApp.setBounds(189, 45, 61, 16);
		contentPane.add(lblQuizApp);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(116, 110, 81, 16);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(220, 105, 130, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(116, 153, 61, 16);
		contentPane.add(lblPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		btnRegister.setBounds(93, 199, 117, 29);
		contentPane.add(btnRegister);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setBounds(233, 199, 117, 29);
		contentPane.add(btnLogin);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(220, 148, 130, 26);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
	}
	public void register() {
		UsersOperations uo = UsersOperations.getInstance();
		String uname = txtUsername.getText();
		String pass = txtPassword.getText();
		Users u = new Users(uname,pass);
		String result = uo.registerUser(u);
		JOptionPane.showMessageDialog(this, result);
		this.printList();
	}
	public void login() {
		UsersOperations uo = UsersOperations.getInstance();
		String uname = txtUsername.getText();
		String pass = txtPassword.getText();
		Users u = new Users(uname,pass);
		if(uo.loginUser(u)) {
			JOptionPane.showMessageDialog(this, "Login Successful");
			try {
				Quiz frame = new Quiz();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(this,"Invalid Password");
		}
			
		
	}
	public void printList() {
		System.out.println(UsersOperations.getInstance().getList());
	}
}
