package com.clients;

import com.panels.BasicPanel;

// Creator from the 'Factory Method' pattern. Defines abstract operation.
public abstract class FrameCreator {
	
	public abstract BasicFrame createFrame(String frameTitle, BasicPanel panel);
}
