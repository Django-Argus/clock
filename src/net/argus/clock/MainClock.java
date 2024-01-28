package net.argus.clock;

import java.awt.Color;

import javax.swing.UIManager;

import net.argus.clock.ui.ClockFrame;
import net.argus.clock.ui.Framing;
import net.argus.clock.ui.Numbers;
import net.argus.exception.InstanceException;
import net.argus.instance.CardinalProgram;
import net.argus.instance.Program;

@Program(instanceName = "clock")
public class MainClock extends CardinalProgram {
	private static ClockFrame frame;
	  
	  public static ClockFrame getFrame() {
	    return frame;
	  }
	  
	  public static Framing getFrameing() {
	    return frame.getFraming();
	  }
	  
	  @Override
	  public void main(String[] args) throws InstanceException {
	    UIManager.put("Clock.background", Color.decode("#000000"));
	    UIManager.put("Clock.off", Color.decode("#2b0000"));
	    UIManager.put("Clock.on", Color.decode("#cb0002"));
	    
	    frame = new ClockFrame();
	    Numbers.init();
	    (new Timer()).start();
	    frame.setVisible(true);
	  }

}
