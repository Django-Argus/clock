package net.argus.clock.ui;

import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.UIManager;

public class Circle extends JComponent {
	  private static final long serialVersionUID = -3124825525699877038L;
	  
	  public static final int D = 12;
	  
	  public static final int R = 6;
	  
	  private int x;
	  
	  private int y;
	  
	  private int sec;
	  
	  public Circle(int x, int y, int sec) {
	    this.x = x;
	    this.y = y;
	    this.sec = sec;
	  }
	  
	  public Circle(int x, int y) {
	    this.x = x;
	    this.y = y;
	    this.sec = 0;
	  }
	  
	  public void drawOff(Graphics2D g) {
	    draw(-1, g);
	  }
	  
	  public void drawOn(Graphics2D g) {
	    draw(1, g);
	  }
	  
	  public void draw(int secTime, Graphics2D g) {
	    if (secTime >= this.sec) {
	      g.setColor(UIManager.getColor("Clock.on"));
	    } else {
	      g.setColor(UIManager.getColor("Clock.off"));
	    } 
	    g.fillOval(this.x, this.y, 12, 12);
	  }
	}