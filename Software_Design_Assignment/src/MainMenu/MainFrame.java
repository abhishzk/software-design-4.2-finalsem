package MainMenu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Employee.Add_Employee;
import Employee.Search_Employee;

import Login.LoginFrame;
import Login.SelectionFrame;
import Product.Add_Product;
import Product.Report_Product;
import Product.Update_Product;
import vendor.Add_Vendors;
import vendor.Report_Vendor;
import vendor.Search_Vendors;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import java.awt.SystemColor;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	static CardLayout cardLayout;
	static JPanel panel;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setBackground(SystemColor.activeCaption);
		init();
	}
	
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.LIGHT_GRAY);
		menuBar.setBackground(Color.DARK_GRAY);
		menuBar.setBounds(0, 0, 740, 26);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("Options");
		mnFile.setBackground(Color.DARK_GRAY);
		mnFile.setForeground(Color.LIGHT_GRAY);
		mnFile.setFont(new Font("Calibri", Font.BOLD, 16));
		menuBar.add(mnFile);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.setForeground(SystemColor.desktop);
		mntmLogout.setFont(new Font("Calibri", Font.BOLD, 18));
		mntmLogout.setBackground(SystemColor.activeCaption);
		mnFile.add(mntmLogout);
		
		JMenu mnEmployees = new JMenu("Employees");
		mnEmployees.setForeground(Color.LIGHT_GRAY);
		mnEmployees.setFont(new Font("Calibri", Font.BOLD, 16));
		mnEmployees.setBackground(Color.DARK_GRAY);
		menuBar.add(mnEmployees);
		JMenuItem menu_Add_Employee = new JMenuItem("Add Employee");
		menu_Add_Employee.setBackground(SystemColor.activeCaption);
		menu_Add_Employee.setForeground(SystemColor.desktop);
		menu_Add_Employee.setFont(new Font("Calibri", Font.BOLD, 18));
	
		mnEmployees.add(menu_Add_Employee);
		
		JMenuItem mntmSearchEmployee = new JMenuItem("Search Employee");
		mntmSearchEmployee.setForeground(SystemColor.desktop);
		mntmSearchEmployee.setFont(new Font("Calibri", Font.BOLD, 18));
		mntmSearchEmployee.setBackground(SystemColor.activeCaption);
		mnEmployees.add(mntmSearchEmployee);
		
		JMenu mnProducts = new JMenu("Products");
		mnProducts.setForeground(Color.LIGHT_GRAY);
		mnProducts.setFont(new Font("Calibri", Font.BOLD, 16));
		mnProducts.setBackground(Color.DARK_GRAY);
		menuBar.add(mnProducts);
		
		JMenuItem menu_Add_Products = new JMenuItem("Add Product\r\n");
		menu_Add_Products.setForeground(SystemColor.desktop);
		menu_Add_Products.setFont(new Font("Calibri", Font.BOLD, 18));
		menu_Add_Products.setBackground(SystemColor.activeCaption);
		mnProducts.add(menu_Add_Products);
		
		JMenuItem mntmSearchProducts = new JMenuItem("Search Product");
		mntmSearchProducts.setForeground(SystemColor.desktop);
		mntmSearchProducts.setFont(new Font("Calibri", Font.BOLD, 18));
		mntmSearchProducts.setBackground(SystemColor.activeCaption);
		mnProducts.add(mntmSearchProducts);
		
		JMenu mnCustomers = new JMenu("Vendor");
		mnCustomers.setForeground(Color.LIGHT_GRAY);
		mnCustomers.setFont(new Font("Calibri", Font.BOLD, 16));
		mnCustomers.setBackground(Color.DARK_GRAY);
		menuBar.add(mnCustomers);
		
		JMenuItem mntmAddCustomer = new JMenuItem("Add Vendor");
		mntmAddCustomer.setForeground(SystemColor.activeCaptionText);
		mntmAddCustomer.setFont(new Font("Calibri", Font.BOLD, 18));
		mntmAddCustomer.setBackground(SystemColor.activeCaption);
		mnCustomers.add(mntmAddCustomer);
		
		JMenuItem mntmSearchCustomer = new JMenuItem("Search Vendor");
		mntmSearchCustomer.setForeground(SystemColor.desktop);
		mntmSearchCustomer.setFont(new Font("Calibri", Font.BOLD, 18));
		mntmSearchCustomer.setBackground(SystemColor.activeCaption);
		mnCustomers.add(mntmSearchCustomer);
		
		JMenu mnReports = new JMenu("Reports");
		mnReports.setForeground(Color.LIGHT_GRAY);
		mnReports.setFont(new Font("Calibri", Font.BOLD, 16));
		mnReports.setBackground(Color.DARK_GRAY);
		menuBar.add(mnReports);
		
		JMenuItem mntmProductsReport = new JMenuItem("Products Report");
		mntmProductsReport.setForeground(SystemColor.desktop);
		mntmProductsReport.setFont(new Font("Calibri", Font.BOLD, 18));
		mntmProductsReport.setBackground(SystemColor.activeCaption);
		mnReports.add(mntmProductsReport);
		
		JMenuItem mntmCustomerReport = new JMenuItem("Vendor Report");
		mntmCustomerReport.setForeground(SystemColor.desktop);
		mntmCustomerReport.setFont(new Font("Calibri", Font.BOLD, 18));
		mntmCustomerReport.setBackground(SystemColor.activeCaption);
		mnReports.add(mntmCustomerReport);
		
		JMenuItem mntmEmployeereport = new JMenuItem("Employee Report");
		mntmEmployeereport.setForeground(SystemColor.desktop);
		mntmEmployeereport.setFont(new Font("Calibri", Font.BOLD, 18));
		mntmEmployeereport.setBackground(SystemColor.activeCaption);
		mnReports.add(mntmEmployeereport);
		
		
		
		 cardLayout = new CardLayout(); 
		 panel = new JPanel(cardLayout);
		panel.setBounds(0, 27, 740, 383);
		contentPane.add(panel);
		
		JPanel MainMenu = new MainMenu();
		panel.add(MainMenu,"Main");
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectionFrame x = new SelectionFrame();
				x.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(521, 177, 133, 31);
		MainMenu.add(btnNewButton);
		
		
		JPanel Report_Employee = new Employee.Report_Employee();
		panel.add(Report_Employee,"Rep_Emp");
		
		JPanel Search_Employee = new Search_Employee();
		panel.add(Search_Employee,"Search_Emp");
		
		JPanel Report_Customer = new Report_Vendor();
		panel.add(Report_Customer,"Rep_Cust");
		
		JPanel Search_Products = new Product.Search_Product();
		panel.add(Search_Products,"Search_Prod");
		
		
		JPanel Search_Customer = new Search_Vendors();
		panel.add(Search_Customer,"Search_Cust");
		
		JPanel Add_Customers = new Add_Vendors();
		panel.add(Add_Customers,"Add_Cust");
		
		JPanel Add_Employee = new Add_Employee();
		panel.add(Add_Employee,"Add_Emp");
		JPanel Add_Products = new Add_Product();
		panel.add(Add_Products,"Add_Product");
		JPanel Update_Products = new Update_Product();
		panel.add(Update_Products,"Update_Products");
		
		JPanel Report_Products = new Report_Product();
		panel.add(Report_Products,"Rep_Prod");
		
	
		
		
	menu_Add_Employee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				cardLayout.show(panel, "Add_Emp");
			}	
		});
	
	menu_Add_Products.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cardLayout.show(panel, "Add_Product");
		}
	});
		
	mntmAddCustomer.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cardLayout.show(panel,"Add_Cust");
		}
	});
		
	
	mntmSearchCustomer.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cardLayout.show(panel,"Search_Cust");
		}
	});
	
	mntmProductsReport.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cardLayout.show(panel,"Rep_Prod");
		}
	});
	
	mntmSearchProducts.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cardLayout.show(panel,"Search_Prod");
		}
	});
	
	mntmCustomerReport.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cardLayout.show(panel,"Rep_Cust");
		}
	});
	
	mntmLogout.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			LoginFrame l = new LoginFrame();
			l.setVisible(true);
			setVisible(false);
		}
	});
	
	mntmEmployeereport.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cardLayout.show(panel,"Rep_Emp");
		}
	});
	
	mntmSearchEmployee.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cardLayout.show(panel,"Search_Emp");
		}
	});
	}
	
	
	public static void backHome()
	{
		//JPanel MainMenu = new MainMenu();
		cardLayout.show(panel,"Main");
	}
}
