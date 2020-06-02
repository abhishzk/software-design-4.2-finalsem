package com.clients;

import com.panels.UniversityPanel;

public class Program {
	
	public static void main(String[] args) {
		
		FrameCreator universityFrameCreator = new UniversityFrameCreator();
		universityFrameCreator.createFrame("University Frame", new UniversityPanel());
	}
}
