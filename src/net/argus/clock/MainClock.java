package net.argus.clock;

import java.awt.Color;

import javax.swing.UIManager;

import net.argus.clock.ui.ClockFrame;
import net.argus.clock.ui.Framing;
import net.argus.clock.ui.Numbers;

public class MainClock 	{
	
	private static ClockFrame frame;
	  
	  public static ClockFrame getFrame() {
	    return frame;
	  }
	  
	  public static Framing getFrameing() {
	    return frame.getFraming();
	  }
	  
	  public static void main(String[] args) {
	    UIManager.put("Clock.background", Color.decode("#000000"));
	    UIManager.put("Clock.off", Color.decode("#0b0000"));
	    UIManager.put("Clock.on", Color.decode("#cb0002"));
	    
	    frame = new ClockFrame();
	    Numbers.init();
	    (new Timer()).start();
	    frame.setVisible(true);
	  }

}
