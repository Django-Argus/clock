package net.argus.clock.ui;

import java.awt.Graphics2D;

import net.argus.clock.Timer;

public class Time {
	  private Center center = new Center();
	  
	  private NumberBlock h1 = new NumberBlock(82, 250);
	  
	  private NumberBlock h2 = new NumberBlock(184, 250);
	  
	  private NumberBlock m1 = new NumberBlock(316, 250);
	  
	  private NumberBlock m2 = new NumberBlock(418, 250);
	  
	  public void draw(Graphics2D g) {
	    this.center.draw(g);

	    int[] h = decompose(Timer.getTime().getHour());
	    int[] m = decompose(Timer.getTime().getMinute());

	    if (h.length > 1) {
	      this.h1.draw(h[0], g);
	      this.h2.draw(h[1], g);
	    } else if (h.length == 1) {
	      this.h1.draw(0, g);
	      this.h2.draw(h[0], g);
	    } else {
	      this.h1.draw(-1, g);
	      this.h2.draw(-1, g);
	    } 
	    if (m.length > 1) {
	      this.m1.draw(m[0], g);
	      this.m2.draw(m[1], g);
	    } else if (m.length == 1) {
	      this.m1.draw(0, g);
	      this.m2.draw(m[0], g);
	    } else {
	      this.m1.draw(-1, g);
	      this.m2.draw(-1, g);
	    } 
	  }
	  
	  public int[] decompose(int num) {
		  String str = Integer.toString(num);

		  int[] n = new int[str.length()];
		  for(int i = 0; i < str.length(); i++)
			  n[i] = Character.getNumericValue(str.charAt(i));
		  
		  return n;
	  }
}
