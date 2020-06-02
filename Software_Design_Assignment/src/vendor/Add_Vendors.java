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

public class Add_Vendors extends JPanel {
	private JTextField vendor_id;
	private JTextField vend_name;
	HashTableVendor ctable = MainMenu.ctable;

	/**
	 * Create the panel.
	 */
	public Add_Vendors() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);

		JLabel lblAddCustomer = new JLabel("Add Vendor");
		lblAddCustomer.setForeground(SystemColor.desktop);
		lblAddCustomer.setFont(new Font("Calibri", Font.BOLD, 24));
		lblAddCustomer.setBounds(111, 29, 218, 50);
		add(lblAddCustomer);

		JLabel lblCustomerId = new JLabel("Vendor ID:");
		lblCustomerId.setForeground(SystemColor.desktop);
		lblCustomerId.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCustomerId.setBounds(44, 97, 163, 23);
		add(lblCustomerId);

		vendor_id = new JTextField();
		vendor_id.setForeground(new Color(65, 105, 225));
		vendor_id.setFont(new Font("Arial", Font.BOLD, 15));
		vendor_id.setColumns(10);
		vendor_id.setBounds(277, 99, 116, 22);
		add(vendor_id);

		vend_name = new JTextField();
		vend_name.setForeground(new Color(65, 105, 225));
		vend_name.setFont(new Font("Arial", Font.BOLD, 15));
		vend_name.setColumns(10);
		vend_name.setBounds(277, 148, 116, 22);
		add(vend_name);

		JLabel lblCustomerName = new JLabel("Vendor Name");
		lblCustomerName.setForeground(SystemColor.desktop);
		lblCustomerName.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCustomerName.setBounds(44, 146, 191, 23);
		add(lblCustomerName);

		JButton btn_cust_Insert = new JButton("INSERT");
		btn_cust_Insert.setBackground(Color.DARK_GRAY);
		btn_cust_Insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int key = Integer.parseInt(vendor_id.getText());
				String value = vend_name.getText();
				ctable.insertCustomer(key, value);
				DialogMessage.showInfoDialog("INSERTED");
				vendor_id.setText("");
				vend_name.setText("");
			}
		});
		btn_cust_Insert.setForeground(Color.LIGHT_GRAY);
		btn_cust_Insert.setFont(new Font("Calibri", Font.BOLD, 22));
		btn_cust_Insert.setBounds(76, 225, 131, 37);
		add(btn_cust_Insert);

		JButton btn_back = new JButton("BACK");
		btn_back.setBackground(Color.DARK_GRAY);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vendor_id.setText("");
				vend_name.setText("");
				MainFrame.backHome();

			}
		});
		btn_back.setForeground(Color.LIGHT_GRAY);
		btn_back.setFont(new Font("Calibri", Font.BOLD, 22));
		btn_back.setBounds(251, 225, 131, 37);
		add(btn_back);

	}
}
