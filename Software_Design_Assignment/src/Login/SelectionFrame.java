package Login;
import java.awt.EventQueue;

import javax.swing.JFrame;

import MainMenu.MainFrame;
import hashtable.DirectoryHash;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class SelectionFrame extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectionFrame window = new SelectionFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectionFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnbst = new JButton("Binary Search Tree");
		btnbst.setForeground(Color.LIGHT_GRAY);
		btnbst.setBackground(Color.DARK_GRAY);
		btnbst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame m = new MainFrame();
				m.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnbst.setBounds(138, 47, 144, 62);
		frame.getContentPane().add(btnbst);
		
		JButton btnht = new JButton("Hash Table");
		btnht.setForeground(Color.LIGHT_GRAY);
		btnht.setBackground(Color.DARK_GRAY);
		btnht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DirectoryHash h= new DirectoryHash();
				h.setVisible(true);
				setVisible(false);
			}
		});
		btnht.setBounds(138, 145, 144, 56);
		frame.getContentPane().add(btnht);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}
}
