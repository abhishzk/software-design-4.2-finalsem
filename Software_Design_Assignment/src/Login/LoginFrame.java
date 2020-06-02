package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import MainMenu.MainFrame;
import Misc.DialogMessage;
import Product.HashTable;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class LoginFrame extends JFrame {
	private JTextField txt_uname;
	private JPasswordField txt_pwd;
	private static boolean created = false;
	private static LoginFrame single;

	/**
	 * Launch the application.
	 */
	
	 public static void main(String[] args) { EventQueue.invokeLater(new
	  Runnable() { public void run() { try { LoginFrame frame = new LoginFrame();
	  frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	  }
	 

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		getContentPane().setBackground(SystemColor.activeCaption);
		setBounds(100, 100, 430, 320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lbltitle = new JLabel("Inventory Management System");
		lbltitle.setFont(new Font("Calibri", Font.BOLD, 22));
		lbltitle.setForeground(SystemColor.desktop);
		lbltitle.setBounds(56, 11, 307, 50);
		getContentPane().add(lbltitle);

		created = true;
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 20));
		lblUsername.setForeground(SystemColor.desktop);
		lblUsername.setBounds(46, 84, 125, 23);
		getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setForeground(SystemColor.desktop);
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 20));
		lblPassword.setBounds(46, 148, 125, 23);
		getContentPane().add(lblPassword);

		txt_uname = new JTextField();
		txt_uname.setForeground(Color.BLACK);
		txt_uname.setFont(new Font("Arial", Font.BOLD, 15));
		txt_uname.setBounds(219, 86, 116, 22);
		getContentPane().add(txt_uname);
		txt_uname.setColumns(10);

		JButton btn_SignIn = new JButton("Sign In");
		btn_SignIn.setBackground(Color.DARK_GRAY);
		btn_SignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uname = txt_uname.getText();
				String pwd = new String(txt_pwd.getPassword());

				if (uname.equals("admin") && pwd.equals("admin")) {
					DialogMessage.showInfoDialog("Logged in");
					txt_uname.setText("");
					txt_pwd.setText("");

//					MainFrame m = new MainFrame();
//					m.setVisible(true);
//					setVisible(false);
					SelectionFrame f = new SelectionFrame();
					f.setVisible(true);
					setVisible(false);
					
				} else {
					DialogMessage.showWarningDialog("Wrong Credentials");
					txt_uname.setText("");
					txt_pwd.setText("");
				}
			}
		});
		btn_SignIn.setForeground(Color.LIGHT_GRAY);
		btn_SignIn.setFont(new Font("Calibri", Font.BOLD, 18));
		btn_SignIn.setBounds(135, 207, 131, 31);
		getContentPane().add(btn_SignIn);

		txt_pwd = new JPasswordField();
		txt_pwd.setForeground(Color.BLACK);
		txt_pwd.setFont(new Font("Arial", Font.BOLD, 15));
		txt_pwd.setBounds(219, 150, 116, 22);
		getContentPane().add(txt_pwd);
		
		JLabel lblNewLabel = new JLabel("admin/admin");
		lblNewLabel.setBounds(172, 249, 94, 21);
		getContentPane().add(lblNewLabel);

	}

	public static LoginFrame getInstance() {
		if (!created) {
			single = new LoginFrame();
		}
		return single;
	}
}
