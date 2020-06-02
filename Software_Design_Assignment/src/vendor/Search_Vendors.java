package vendor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import MainMenu.MainFrame;
import MainMenu.MainMenu;
import Misc.DialogMessage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Search_Vendors extends JPanel {
	private JTextField txt_cust_name;

	/**
	 * Create the panel.
	 */
	public Search_Vendors() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);

		JLabel lblSearchByName = new JLabel("Search By Name");
		lblSearchByName.setForeground(SystemColor.desktop);
		lblSearchByName.setFont(new Font("Calibri", Font.BOLD, 20));
		lblSearchByName.setBounds(50, 99, 163, 23);
		add(lblSearchByName);

		txt_cust_name = new JTextField();
		txt_cust_name.setForeground(new Color(65, 105, 225));
		txt_cust_name.setFont(new Font("Arial", Font.BOLD, 15));
		txt_cust_name.setColumns(10);
		txt_cust_name.setBounds(272, 101, 116, 22);
		add(txt_cust_name);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(Color.DARK_GRAY);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt_cust_name.getText();
				HashTableVendor ctree = MainMenu.ctable;
				if (ctree.searchVendorbyName(name) == true) {
					DialogMessage.showInfoDialog("FOUND");
					txt_cust_name.setText("");
				} else {
					DialogMessage.showWarningDialog("NoT FOUND");
					txt_cust_name.setText("");
				}
			}
		});
		btnSearch.setForeground(Color.LIGHT_GRAY);
		btnSearch.setFont(new Font("Calibri", Font.BOLD, 23));
		btnSearch.setBounds(50, 170, 131, 31);
		add(btnSearch);

		JButton btn_back = new JButton("BACK");
		btn_back.setBackground(Color.DARK_GRAY);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.backHome();
				txt_cust_name.setText("");
			}
		});
		btn_back.setForeground(Color.LIGHT_GRAY);
		btn_back.setFont(new Font("Calibri", Font.BOLD, 23));
		btn_back.setBounds(247, 170, 131, 31);
		add(btn_back);

		JLabel lblSearchCustomer = new JLabel("Search Vendor");
		lblSearchCustomer.setForeground(SystemColor.desktop);
		lblSearchCustomer.setFont(new Font("Calibri", Font.BOLD, 24));
		lblSearchCustomer.setBounds(113, 24, 218, 50);
		add(lblSearchCustomer);

	}

}
