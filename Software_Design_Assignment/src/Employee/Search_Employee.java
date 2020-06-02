package Employee;

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

public class Search_Employee extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	binarySearch btree = binarySearch.getInstance();

	public Search_Employee() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);

		JLabel lblEmployeeDetails = new JLabel("Employee Details");
		lblEmployeeDetails.setForeground(SystemColor.desktop);
		lblEmployeeDetails.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEmployeeDetails.setBounds(35, 107, 190, 23);
		add(lblEmployeeDetails);

		textField = new JTextField();
		textField.setForeground(SystemColor.desktop);
		textField.setFont(new Font("Arial", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(268, 109, 116, 22);
		add(textField);

		JLabel lblSearchEmployee = new JLabel("Search Employee");
		lblSearchEmployee.setForeground(SystemColor.desktop);
		lblSearchEmployee.setFont(new Font("Calibri", Font.BOLD, 18));
		lblSearchEmployee.setBounds(125, 28, 218, 50);
		add(lblSearchEmployee);

		JButton button = new JButton("Search By ID");
		button.setBackground(Color.DARK_GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node a = btree.search(Integer.parseInt(textField.getText()));
				if (a != null) {
					DialogMessage.showInfoDialog("Value Found " + a.key + " Name: " + a.name);
					textField.setText("");
				} else {
					DialogMessage.showWarningDialog("Value Not Found");
				}

			}
		});
		button.setForeground(Color.LIGHT_GRAY);
		button.setFont(new Font("Calibri", Font.BOLD, 18));
		button.setBounds(135, 162, 171, 31);
		add(button);

		JButton button_1 = new JButton("BACK");
		button_1.setBackground(Color.DARK_GRAY);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.backHome();
				textField.setText("");
			}
		});
		button_1.setForeground(Color.LIGHT_GRAY);
		button_1.setFont(new Font("Calibri", Font.BOLD, 18));
		button_1.setBounds(157, 223, 131, 25);
		add(button_1);

	}

}
