package Product;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import MainMenu.MainMenu;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Report_Product extends JPanel {

	
	public Report_Product() {
		setBackground(SystemColor.activeCaption);
        initializeUI();    
    }

    private void initializeUI() {
        setPreferredSize(new Dimension(539, 330));
        setLayout(null);

        JTable table = new JTable(25,15);

        // Turn off JTable's auto resize so that JScrollPane will show a
        // horizontal scroll bar.
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(69, 62, 372, 187);
        add(pane);
        
        JButton btn_Generate = new JButton("GENERATE");
        btn_Generate.setBackground(Color.DARK_GRAY);
        btn_Generate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		HashTable table1 = HashTable.getInstance();
        		
        		DefaultTableModel model = table1.printReport();
        		table.setModel(model);
        	}
        });
        btn_Generate.setForeground(Color.LIGHT_GRAY);
        btn_Generate.setFont(new Font("Calibri", Font.BOLD, 22));
        btn_Generate.setBounds(175, 273, 168, 40);
        add(btn_Generate);
        
        JLabel lblProductReport = new JLabel("Product Report");
        lblProductReport.setHorizontalAlignment(SwingConstants.CENTER);
        lblProductReport.setForeground(SystemColor.desktop);
        lblProductReport.setFont(new Font("Calibri", Font.BOLD, 24));
        lblProductReport.setBounds(0, 11, 196, 40);
        add(lblProductReport);
        
     
    }

    public static void showFrame() {
        JPanel panel = new Report_Product();
        panel.setOpaque(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Employees Report");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Report_Products.showFrame();
            }
        });
    }*/
}