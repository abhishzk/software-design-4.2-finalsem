package com.panels;

import java.util.List;

import com.models.Teacher;
import java.awt.Color;

// The 'Decorator' abstract class
public abstract class PanelDecorator extends BasicPanel {
	private static final long serialVersionUID = 1L;
	
	private BasicPanel panel;
	
	protected PanelDecorator(BasicPanel panel) {
		setBackground(Color.BLACK);
		this.setPanel(panel);
	}
	
	protected BasicPanel getPanel() {
		return this.panel;
	}
	
	protected void setPanel(BasicPanel panel) {
		if (panel == null) {
			throw new NullPointerException("Panel cannot be null!");
		}
		
		this.panel = panel;
	}
	
	@Override
	public void setBackgroundColor() {
		this.panel.setBackgroundColor();
	}
	
	@Override
	public void setLayoutManager() {
		this.panel.setLayoutManager();
	}
	
	@Override
	public List<Teacher> getTeachers() {
		return this.panel.getTeachers();
	}
	
	@Override
	public void clearFields() {
		this.panel.clearFields();
	}
}
