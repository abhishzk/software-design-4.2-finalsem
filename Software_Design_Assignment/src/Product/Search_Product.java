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

public class Search_Product extends JPanel {
	private JTextField m_detail;

	/**
	 * Create the panel.
	 */
	public Search_Product() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JLabel lblProductDetails = new JLabel("Product Details");
		lblProductDetails.setForeground(SystemColor.desktop);
		lblProductDetails.setFont(new Font("Calibri", Font.BOLD, 20));
		lblProductDetails.setBounds(23, 92, 163, 23);
		add(lblProductDetails);
		
		m_detail = new JTextField();
		m_detail.setForeground(new Color(65, 105, 225));
		m_detail.setFont(new Font("Arial", Font.BOLD, 15));
		m_detail.setColumns(10);
		m_detail.setBounds(218, 94, 163, 22);
		add(m_detail);
		
		JButton btnSearchByName = new JButton("Search By Name");
		btnSearchByName.setBackground(Color.DARK_GRAY);
		
		btnSearchByName.setForeground(Color.LIGHT_GRAY);
		btnSearchByName.setFont(new Font("Calibri", Font.BOLD, 22));
		btnSearchByName.setBounds(218, 162, 192, 37);
		add(btnSearchByName);
		
		JLabel lblSearchProducts = new JLabel("Search Product");
		lblSearchProducts.setForeground(SystemColor.desktop);
		lblSearchProducts.setFont(new Font("Calibri", Font.BOLD, 24));
		lblSearchProducts.setBounds(113, 13, 218, 50);
		add(lblSearchProducts);
		
		JButton btnSearchById_1 = new JButton("Search By ID");
		btnSearchById_1.setBackground(Color.DARK_GRAY);
		btnSearchById_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(m_detail.getText());
				HashTable table1 = HashTable.getInstance();
				HNode temp = table1.searchbyIterator(id);
				if(temp!=null)
				{
					DialogMessage.showInfoDialog("FOUND: "+temp.readProductName());
					m_detail.setText("");
				}
				else
				{
					DialogMessage.showWarningDialog("NOT FOUND");
				}
			}
		});
		btnSearchById_1.setForeground(Color.LIGHT_GRAY);
		btnSearchById_1.setFont(new Font("Calibri", Font.BOLD, 22));
		btnSearchById_1.setBounds(10, 162, 168, 37);
		add(btnSearchById_1);
		
		JButton button = new JButton("BACK");
		button.setBackground(Color.DARK_GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.backHome();
				m_detail.setText("");
			}
		});
		button.setForeground(Color.LIGHT_GRAY);
		button.setFont(new Font("Calibri", Font.BOLD, 22));
		button.setBounds(151, 221, 131, 32);
		add(button);
		
		btnSearchByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = m_detail.getText();
				HashTable table1 = HashTable.getInstance();
				HNode temp = table1.searchbyName(name);
				if(temp!=null)
				{
					DialogMessage.showInfoDialog("FOUND: "+temp.readKey()+" "+temp.readProductName());
					m_detail.setText("");
				}
				else
				{
					DialogMessage.showWarningDialog("NOT FOUND");
				}
			}
			
		});

		
	}

}
