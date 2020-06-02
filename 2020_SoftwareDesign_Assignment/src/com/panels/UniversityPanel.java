package com.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.clients.BasicFrame;
import com.clients.FrameCreator;
import com.clients.TeacherFrameCreator;
import com.contracts.IOperations;
import com.data.AdapterLocalDB;
import com.data.DataValidationProxy;
import com.data.TeacherSortProxy;
import com.models.Teacher;

// The 'ConcreteComponent' class from Decorator Pattern
public class UniversityPanel extends BasicPanel {
	private static final long serialVersionUID = 1L;

	private static final int PANEL_PADDING = 10;
	private static final int DELETE_FRAME_WIDTH = 350;
	private static final int DELETE_FRAME_HEIGHT = 100;
	private static final int SCROLL_PANE_WIDHT = 500;
	private static final int SCROLL_PANE_HEIGHT = 420;
	private static final String[] COLUMN_NAMES = { "ID", "First name", "Last name", "Phone Number", "Gender", "Department" };

	private final JButton addNewTeacherButton = new JButton("Add");
	private final JButton showAllTeachersButton = new JButton("Show");
	private final JButton updateTeacherButton = new JButton("Update");
	private final JButton deleteTeacherButton = new JButton("Delete");
	private final JButton sortTeacherButton = new JButton("Sort");

	private final JTable table = new JTable();
	private final DefaultTableModel defaultTableModel = new DefaultTableModel(0, 0);
	private final JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	private FrameCreator teacherFrameCreator;
	private IOperations validationProxy;
	private IOperations sortProxy;
	private BasicPanel updatablePanelDecorator;
	private final JButton btnNewButton = new JButton("Export");

	public UniversityPanel() {
		this.defaultTableModel.setColumnIdentifiers(COLUMN_NAMES);
		this.table.setModel(this.defaultTableModel);
		this.scrollPane.setPreferredSize(new Dimension(SCROLL_PANE_WIDHT, SCROLL_PANE_HEIGHT));
		this.add(this.addNewTeacherButton);
		this.add(this.showAllTeachersButton);
		this.add(this.updateTeacherButton);
		this.add(this.deleteTeacherButton);
		this.add(this.sortTeacherButton);
		this.add(this.btnNewButton);
		this.btnNewButton.addActionListener(new ActionListener() {
		 
			public void actionPerformed(ActionEvent e) {
				try {
				File file = new File("C:\\eclipse-workspace\\2020_SoftwareDesign_Assignment\\Details.txt");
				if(!file.exists()) {
					
						file.createNewFile();
					}
				
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw); 
				
				for(int i = 0; i<table.getRowCount(); i++) {
					for(int j = 0; j< table.getColumnCount(); j++) {
						bw.write(table.getModel().getValueAt(i, j)+ " ");
					}
					bw.write("\n____________\n");
				}
				bw.close();
				fw.close();
				JOptionPane.showMessageDialog(null, "Data Exported");
				}
					
					
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
		});

	add(btnNewButton);
		this.add(this.scrollPane);
		this.setBorder(new EmptyBorder(PANEL_PADDING, PANEL_PADDING, PANEL_PADDING, PANEL_PADDING));
		
		this.addNewTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherFrameCreator = new TeacherFrameCreator();
				teacherFrameCreator.createFrame("New Teacher Frame", new TeacherPanel());
			}
		});
		
		this.showAllTeachersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validationProxy = new DataValidationProxy(new AdapterLocalDB());
				showAllTeachers(validationProxy.getAllTeachers());
			}
		});
		
		this.updateTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherPanel teacherPanel = new TeacherPanel();
				teacherFrameCreator = new TeacherFrameCreator();
				teacherFrameCreator.createFrame("Update Teacher Frame", teacherPanel);
				
				updatablePanelDecorator = new UpdatableTeacherPanel(teacherPanel);
				updatablePanelDecorator.setBackgroundColor();
				updatablePanelDecorator.setLayoutManager();				
			}
		});
		
		this.deleteTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherFrameCreator = new TeacherFrameCreator();
				TeacherPanel teacherPanel = new TeacherPanel();
				
				BasicFrame deletableTeacherFrame = teacherFrameCreator.createFrame("Delete Teacher Frame", teacherPanel);
				deletableTeacherFrame.setFrameSize(DELETE_FRAME_WIDTH, DELETE_FRAME_HEIGHT);
				
				DeletableTeacherPanel deletablePanelDecorator = new DeletableTeacherPanel(teacherPanel);
				deletablePanelDecorator.setBackgroundColor();
				deletablePanelDecorator.setLayoutManager();
			}
		});
		
		this.sortTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortProxy = new TeacherSortProxy(new AdapterLocalDB());
				showAllTeachers(sortProxy.getAllTeachers());
			}
		});
	}

	@Override
	public void setBackgroundColor() {
		this.setBackground(Color.LIGHT_GRAY);
	}

	@Override
	public void setLayoutManager() {
		this.setLayout(new FlowLayout());
	}

	/**
	 * Returns the all data (teachers) from the JTable.
	 */
	@Override
	public List<Teacher> getTeachers() {
		return this.validationProxy.getAllTeachers();
	}

	/**
	 * Clears JTable from data by removing all the table rows.
	 */
	@Override
	public void clearFields() {
		this.defaultTableModel.setRowCount(0);
	}

	/**
	 * Fills JTable with teachers.
	 * 
	 * @param teachers - all the teachers from the table in LocalDB class.
	 */
	private void showAllTeachers(List<Teacher> teachers) {
		this.clearFields();

		for (Teacher teacher : teachers) {
			this.defaultTableModel.addRow(new Object[] { teacher.getID(), teacher.getFirstName(), teacher.getLastName(),
					teacher.getPersonalID(), teacher.getGender(), teacher.getCity() });
		}
	}

	private void writeToFile(ResultSet rs) {
		try {
			System.out.println("In writeToFile");
			FileWriter outputFile = new FileWriter("Details.csv");
			PrintWriter printWriter = new PrintWriter(outputFile);

			ResultSetMetaData rsmd = rs.getMetaData();
			int numColumns = rsmd.getColumnCount();

			for (int i = 0; i < numColumns; i++) {
				printWriter.print(rsmd.getColumnLabel(i + 1) + ",");
			}
			printWriter.print("\n");
			while (rs.next()) {
				for (int i = 0; i < numColumns; i++) {
					printWriter.print(rs.getString(i + 1) + ",");
				}
				printWriter.print("\n");
				printWriter.flush();
			}
			printWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
