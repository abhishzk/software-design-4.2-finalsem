package MainMenu;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import Employee.binarySearch;
import Login.SelectionFrame;
import Product.HashTable;
import vendor.HashTableVendor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class MainMenu extends JPanel {


	
	public static HashTableVendor ctable = new HashTableVendor();
	
	/**
	 * Create the panel.
	 */
	public MainMenu() {
		setBackground(SystemColor.activeCaption);
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setLayout(null);
		
		JButton btnProductHashTable = new JButton("Products");
		btnProductHashTable.setBackground(Color.DARK_GRAY);
		btnProductHashTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HashTable table = HashTable.getInstance();
				table.insert(1,"Alcatel X50", 28,500);
				table.insert(2,"iPhone XR", 50,900);
				table.insert(3,"OnePlus 7T",35,500);
				table.insert(4,"Samsung Galaxy S20 ", 56,1000);
				table.insert(5,"Nokia N8",22,200);
				table.insert(6,"Honor Z10", 56,500);
				table.insert(7,"Huawei P30 Pro",39,800);
			}
		});
		btnProductHashTable.setForeground(Color.LIGHT_GRAY);
		btnProductHashTable.setFont(new Font("Calibri", Font.BOLD, 18));
		btnProductHashTable.setBounds(12, 177, 141, 31);
		add(btnProductHashTable);
		
		JLabel lblStoreManagementSystem = new JLabel("Inventory Management System");
		lblStoreManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreManagementSystem.setForeground(Color.BLACK);
		lblStoreManagementSystem.setFont(new Font("Calibri", Font.BOLD, 24));
		lblStoreManagementSystem.setBounds(12, 30, 412, 50);
		add(lblStoreManagementSystem);
		
		JLabel lblInitializeStructures = new JLabel("Initialize The Entries");
		lblInitializeStructures.setHorizontalAlignment(SwingConstants.CENTER);
		lblInitializeStructures.setForeground(SystemColor.desktop);
		lblInitializeStructures.setFont(new Font("Calibri", Font.BOLD, 18));
		lblInitializeStructures.setBounds(12, 111, 346, 23);
		add(lblInitializeStructures);
		
		JButton btnEmployees = new JButton("Employees");
		btnEmployees.setBackground(Color.DARK_GRAY);
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binarySearch btree = binarySearch.getInstance();
				btree.insert(1,"Alex",25, 2000);
				btree.insert(2,"Ryan",42, 6000);
				btree.insert(3,"Edward",26, 2500);
				btree.insert(4,"Cristiano",31, 4500);
				btree.insert(5,"Michael",69, 4250);
				btree.insert(6,"Lorraine",25, 7500);
				btree.insert(7,"Mortis",96, 3500);
			}
		});
		btnEmployees.setForeground(Color.LIGHT_GRAY);
		btnEmployees.setFont(new Font("Calibri", Font.BOLD, 18));
		btnEmployees.setBounds(354, 177, 141, 31);
		add(btnEmployees);
		
		JButton btnCustomers = new JButton("Vendors");
		btnCustomers.setBackground(Color.DARK_GRAY);
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctable.insertCustomer(1, "Emraan");
				ctable.insertCustomer(2, "Hashmi");
				ctable.insertCustomer(3, "Noah");
				ctable.insertCustomer(4, "Anderson");
				ctable.insertCustomer(5, "Kristen");
				ctable.insertCustomer(6, "Dexter");
				ctable.insertCustomer(7, "Kelly");
			}
		});
		btnCustomers.setForeground(Color.LIGHT_GRAY);
		btnCustomers.setFont(new Font("Calibri", Font.BOLD, 18));
		btnCustomers.setBounds(180, 177, 135, 31);
		add(btnCustomers);

		
	}
}
