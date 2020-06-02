package Employee;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import MainMenu.MainFrame;
import MainMenu.MainMenu;
import Misc.DialogMessage;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_Employee extends JPanel {
	private JTextField e_salary;
	private JTextField E_age;
	private JTextField E_name;
	private JTextField E_id;

	/**
	 * Create the panel.
	 */
	public Add_Employee() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);

		e_salary = new JTextField();
		e_salary.setForeground(SystemColor.desktop);
		e_salary.setFont(new Font("Arial", Font.BOLD, 15));
		e_salary.setColumns(10);
		e_salary.setBounds(283, 239, 116, 22);
		add(e_salary);

		JLabel lblEmployeeSalary = new JLabel("Employee Salary");
		lblEmployeeSalary.setForeground(SystemColor.desktop);
		lblEmployeeSalary.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEmployeeSalary.setBounds(50, 237, 175, 23);
		add(lblEmployeeSalary);

		JLabel lblEmployeeAge = new JLabel("Employee Age:");
		lblEmployeeAge.setForeground(SystemColor.desktop);
		lblEmployeeAge.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEmployeeAge.setBounds(50, 185, 175, 23);
		add(lblEmployeeAge);

		E_age = new JTextField();
		E_age.setForeground(SystemColor.desktop);
		E_age.setFont(new Font("Arial", Font.BOLD, 15));
		E_age.setColumns(10);
		E_age.setBounds(283, 187, 116, 22);
		add(E_age);

		E_name = new JTextField();
		E_name.setForeground(SystemColor.desktop);
		E_name.setFont(new Font("Arial", Font.BOLD, 15));
		E_name.setColumns(10);
		E_name.setBounds(283, 132, 116, 22);
		add(E_name);

		JLabel lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setForeground(SystemColor.desktop);
		lblEmployeeName.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEmployeeName.setBounds(50, 130, 191, 23);
		add(lblEmployeeName);

		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setForeground(SystemColor.desktop);
		lblEmployeeId.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEmployeeId.setBounds(50, 81, 163, 23);
		add(lblEmployeeId);

		E_id = new JTextField();
		E_id.setForeground(SystemColor.desktop);
		E_id.setFont(new Font("Arial", Font.BOLD, 15));
		E_id.setColumns(10);
		E_id.setBounds(283, 83, 116, 22);
		add(E_id);

		JLabel lblAddEmployee = new JLabel("Add Employee");
		lblAddEmployee.setForeground(SystemColor.desktop);
		lblAddEmployee.setFont(new Font("Calibri", Font.BOLD, 18));
		lblAddEmployee.setBounds(117, 13, 218, 50);
		add(lblAddEmployee);

		JButton btnEmployee_Ins = new JButton("INSERT");
		btnEmployee_Ins.setBackground(Color.DARK_GRAY);

		btnEmployee_Ins.setForeground(Color.LIGHT_GRAY);
		btnEmployee_Ins.setFont(new Font("Calibri", Font.BOLD, 18));
		btnEmployee_Ins.setBounds(75, 291, 131, 25);
		add(btnEmployee_Ins);

		JButton btn_Employee_Back = new JButton("BACK");
		btn_Employee_Back.setBackground(Color.DARK_GRAY);
		btn_Employee_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.backHome();
			}
		});
		btn_Employee_Back.setForeground(Color.LIGHT_GRAY);
		btn_Employee_Back.setFont(new Font("Calibri", Font.BOLD, 18));
		btn_Employee_Back.setBounds(253, 293, 131, 25);
		add(btn_Employee_Back);

		btnEmployee_Ins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(E_id.getText());
				String name = E_name.getText();
				int age = Integer.parseInt(E_age.getText());
				int salary = Integer.parseInt(e_salary.getText());
				binarySearch btree = binarySearch.getInstance();
				btree.insert(id, name, age, salary);
				DialogMessage.showInfoDialog("Inserted");

				E_id.setText("");
				E_name.setText("");
				E_age.setText("");
				e_salary.setText("");
			}
		});

	}
}
