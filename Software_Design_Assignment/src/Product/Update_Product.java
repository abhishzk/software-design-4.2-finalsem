package Product;


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

public class Update_Product extends JPanel {
	private JTextField m_Name;
	private JTextField m_id;
	private JTextField m_Quantity;
	private JTextField m_price;
	HashTable tree = HashTable.getInstance();
	
	/**
	 * Create the panel.
	 */
	public Update_Product() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JLabel lblSearchProducts = new JLabel("Update Products");
		lblSearchProducts.setForeground(SystemColor.desktop);
		lblSearchProducts.setFont(new Font("Calibri", Font.BOLD, 24));
		lblSearchProducts.setBounds(105, 13, 241, 50);
		add(lblSearchProducts);
		
		JLabel label_1 = new JLabel("Product ID:");
		label_1.setForeground(SystemColor.desktop);
		label_1.setFont(new Font("Calibri", Font.BOLD, 20));
		label_1.setBounds(39, 71, 163, 23);
		add(label_1);
		
		JLabel label_2 = new JLabel("Product Name:");
		label_2.setForeground(SystemColor.desktop);
		label_2.setFont(new Font("Calibri", Font.BOLD, 20));
		label_2.setBounds(39, 120, 191, 23);
		add(label_2);
		
		m_Name = new JTextField();
		m_Name.setEditable(false);
		m_Name.setForeground(SystemColor.desktop);
		m_Name.setFont(new Font("Arial", Font.BOLD, 15));
		m_Name.setColumns(10);
		m_Name.setBounds(272, 122, 116, 22);
		add(m_Name);
		
		m_id = new JTextField();
		m_id.setForeground(SystemColor.desktop);
		m_id.setFont(new Font("Arial", Font.BOLD, 15));
		m_id.setColumns(10);
		m_id.setBounds(272, 73, 116, 22);
		add(m_id);
		
		m_Quantity = new JTextField();
		m_Quantity.setEditable(false);
		m_Quantity.setForeground(SystemColor.desktop);
		m_Quantity.setFont(new Font("Arial", Font.BOLD, 15));
		m_Quantity.setColumns(10);
		m_Quantity.setBounds(272, 177, 116, 22);
		add(m_Quantity);
		
		JLabel label_3 = new JLabel("Product Quantity");
		label_3.setForeground(SystemColor.desktop);
		label_3.setFont(new Font("Calibri", Font.BOLD, 20));
		label_3.setBounds(39, 175, 175, 23);
		add(label_3);
		
		JLabel label_4 = new JLabel("Product Price:");
		label_4.setForeground(SystemColor.desktop);
		label_4.setFont(new Font("Calibri", Font.BOLD, 20));
		label_4.setBounds(39, 227, 175, 23);
		add(label_4);
		
		m_price = new JTextField();
		m_price.setEditable(false);
		m_price.setForeground(SystemColor.desktop);
		m_price.setFont(new Font("Arial", Font.BOLD, 15));
		m_price.setColumns(10);
		m_price.setBounds(272, 229, 116, 22);
		add(m_price);
		
		JButton btn_Update = new JButton("Update");
		btn_Update.setBackground(Color.DARK_GRAY);
		btn_Update.setForeground(Color.LIGHT_GRAY);
		btn_Update.setFont(new Font("Calibri", Font.BOLD, 18));
		btn_Update.setBounds(68, 290, 131, 25);
		add(btn_Update);
		
		JButton btn_Back = new JButton("BACK");
		btn_Back.setBackground(Color.DARK_GRAY);
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				m_id.setText("");
				m_Name.setText("");
				m_price.setText("");
				m_Quantity.setText("");
				MainFrame.backHome();
				m_id.setEditable(true);
				m_Name.setEditable(false);
				m_price.setEditable(false);
				m_Quantity.setEditable(false);
			}
		});
		btn_Back.setForeground(Color.LIGHT_GRAY);
		btn_Back.setFont(new Font("Calibri", Font.BOLD, 18));
		btn_Back.setBounds(246, 292, 131, 25);
		add(btn_Back);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setBackground(Color.DARK_GRAY);
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int product_id = Integer.parseInt(m_id.getText());				
				HNode temp = tree.searchbyIterator(product_id);
				if(temp!=null)
				{
					 m_Name.setText(""+temp.readProductName());
   	              m_price.setText(String.valueOf(temp.readPrice()));
   	             m_Quantity.setText(String.valueOf(temp.readQuantity()));
   	             m_Name.setEditable(true);
   	          m_price.setEditable(true);
   	       m_Quantity.setEditable(true);
   	       m_id.setEditable(false);
				}
				else
				{
					DialogMessage.showWarningDialog("Item Not Found");
				}
				
			}
		});
		btnCheck.setForeground(Color.LIGHT_GRAY);
		btnCheck.setFont(new Font("Calibri", Font.BOLD, 18));
		btnCheck.setBounds(400, 70, 131, 25);
		add(btnCheck);
		
		
		
		btn_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int product_id = Integer.parseInt(m_id.getText());
				String product_name = m_Name.getText();
				int product_quantity = Integer.parseInt(m_Quantity.getText());
				int product_price = Integer.parseInt(m_price.getText());
				tree.insert(product_id, product_name,  product_quantity,product_price);
				DialogMessage.showInfoDialog("Updated");
				m_id.setText("");
				m_Name.setText("");
				m_price.setText("");
				m_Quantity.setText("");
			     m_Name.setEditable(false);
	   	          m_price.setEditable(false);
	   	       m_Quantity.setEditable(false);
	   	       m_id.setEditable(true);
				
		
			}
		});

	}

}
