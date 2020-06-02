package hashtable;

import java.awt.EventQueue;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

import Login.SelectionFrame;

import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class DirectoryHash extends JFrame implements Serializable {

	private JFrame teleFrame;
	private JTextField txtNum;
	private JTextField txtName;
	private JTextArea textArea1;
	Hashtable<String, String> htable = new Hashtable<String, String>();

	String str;

	public void iterate() {
		Set<String> keys = htable.keySet();
		Iterator<String> itr = keys.iterator();
		while (itr.hasNext()) {
			str = itr.next();

			textArea1.append("Product Number: " + str + " & Product Name: " + htable.get(str) + "\n");
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DirectoryHash window = new DirectoryHash();
					window.teleFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DirectoryHash() {
		initialize();
		teleFrame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		teleFrame = new JFrame();
		teleFrame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 15));
		teleFrame.getContentPane().setBackground(SystemColor.activeCaption);
		teleFrame.setForeground(Color.WHITE);
		teleFrame.setBackground(Color.WHITE);
		teleFrame.setTitle("HashTable");
		teleFrame.setBounds(100, 100, 941, 528);
		teleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		teleFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Product Inventory List");
		lblNewLabel.setForeground(UIManager.getColor("Button.foreground"));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 22));
		lblNewLabel.setBounds(12, 31, 311, 41);
		teleFrame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Product Number");
		lblNewLabel_2.setForeground(UIManager.getColor("Button.foreground"));
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel_2.setBounds(23, 102, 147, 17);
		teleFrame.getContentPane().add(lblNewLabel_2);

		textArea1 = new JTextArea();
		textArea1.setBackground(Color.WHITE);
		textArea1.setBounds(501, 97, 398, 377);
		teleFrame.getContentPane().add(textArea1);

		txtNum = new JTextField();
		txtNum.setBounds(229, 99, 227, 20);
		teleFrame.getContentPane().add(txtNum);
		txtNum.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Product Name");
		lblNewLabel_3.setForeground(UIManager.getColor("Button.foreground"));
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel_3.setBounds(23, 152, 124, 18);
		teleFrame.getContentPane().add(lblNewLabel_3);

		txtName = new JTextField();
		txtName.setBounds(229, 150, 227, 20);
		teleFrame.getContentPane().add(txtName);
		txtName.setColumns(10);

		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClear.setForeground(Color.LIGHT_GRAY);
		btnClear.setBackground(Color.DARK_GRAY);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				txtNum.setText("");
				txtName.setText("");
			}
		});
		btnClear.setBounds(280, 206, 179, 41);
		teleFrame.getContentPane().add(btnClear);

		JButton btnSearch = new JButton("Search Number");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.setForeground(Color.LIGHT_GRAY);
		btnSearch.setBackground(Color.DARK_GRAY);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = txtNum.getText().toString().trim();
				if (htable.containsKey(search) == true) {
					// DialogMessage.showInfoDialog("Telephone Number of:" +search+" is
					// "+hashtable.get(search));
					DialogMessage.showInfoDialog("Product Number of : " + htable.get(search) + " is " + search);

				} else {

					DialogMessage.showInfoDialog("Doesn't Exist In the Directory");
				}

			}
		});
		btnSearch.setBounds(280, 284, 179, 41);
		teleFrame.getContentPane().add(btnSearch);

		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInsert.setForeground(Color.LIGHT_GRAY);
		btnInsert.setBackground(Color.DARK_GRAY);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = txtNum.getText().toString().trim();
				String value = txtName.getText().toString().trim();
				htable.put(key, value);
				DialogMessage.showInfoDialog("Successfully Inserted Into Directory:" + key);

			}
		});
		btnInsert.setBounds(12, 374, 179, 41);
		teleFrame.getContentPane().add(btnInsert);

		JButton btnIterate = new JButton("Iterate");
		btnIterate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIterate.setForeground(Color.LIGHT_GRAY);
		btnIterate.setBackground(Color.DARK_GRAY);
		btnIterate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iterate();

			}
		});
		btnIterate.setBounds(12, 284, 179, 41);
		teleFrame.getContentPane().add(btnIterate);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectionFrame f=new SelectionFrame();
				f.setVisible(true);
//				setVisible(false);
				
				teleFrame.dispose();


			}
		});
		btnNewButton.setBounds(280, 372, 179, 44);
		teleFrame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Initialize");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				htable.put("11", "OnePlus 7T");
				htable.put("111", "Samsung Galaxy S20");
				htable.put("22", "Nokia N8");
				htable.put("222", "Samsung Galaxy A51");
				htable.put("33", "iPhone XR");
				htable.put("333", "Honor Xz90");
				htable.put("44", "Huawei P30 Pro");
				htable.put("444", "Alcatel XP50");
				htable.put("55", "Xioami Mi9");
				htable.put("555", "Asus Zenfone 6x");
				DialogMessage.showInfoDialog("List Initialized !");

			}
		});
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(12, 206, 178, 41);
		teleFrame.getContentPane().add(btnNewButton_1);

	}
}
