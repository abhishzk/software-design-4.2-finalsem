package com.clients;

import com.panels.BasicPanel;

// Concrete Creator from the 'Factory Method' pattern. Creates university frame.
public class UniversityFrameCreator extends FrameCreator {

	@Override
	public BasicFrame createFrame(String frameTitle, BasicPanel panel) {
		return new UniversityFrame(frameTitle, panel);
	}
}
