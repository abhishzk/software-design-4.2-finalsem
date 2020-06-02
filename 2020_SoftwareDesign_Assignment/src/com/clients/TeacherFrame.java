package com.clients;

import com.panels.BasicPanel;

// Concrete Product
public class TeacherFrame extends BasicFrame {
	private static final long serialVersionUID = 1L;
	private static final int FRAME_X = 10;
	private static final int FRAME_Y = 10;
	private static final int FRAME_WIDHT = 550;
	private static final int FRAME_HEIGHT = 520;
	
	public TeacherFrame(String frameTitle, BasicPanel panel) {
		super(frameTitle, panel);
		
		this.setVisible(true);
		this.setResizable(true);
		this.setBounds(FRAME_X, FRAME_Y, FRAME_WIDHT, FRAME_HEIGHT);
		
		this.getFramePanel().setBackgroundColor();
		this.getFramePanel().setLayoutManager();
	}
}
