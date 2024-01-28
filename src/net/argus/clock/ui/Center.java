package net.argus.clock.ui;

import java.awt.Graphics2D;

import net.argus.clock.Timer;

public class Center extends Block {
	  public Center() {
		    super(1, 3, 1, 2, 250, 250);
		  }
		  
		  public void draw(Graphics2D g) {
		    for (Circle cir : getCircles()) {
		      if (Timer.isOn()) {
		        cir.drawOn(g);
		        continue;
		      } 
		      cir.drawOff(g);
		    } 
		  }
		}
