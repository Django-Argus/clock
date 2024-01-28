package net.argus.clock.ui;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

public class NumberBlock extends Block {
	  public NumberBlock(int x, int y) {
		    super(5, 7, 1, 1, x, y);
		  }
		  
		  public void draw(int num, Graphics2D g) {
		    List<Circle> circs = getCircles();
		    List<Point> points = getPoint();

		    Number number = Number.getNumber(num);
		    if (number == null) {
		      draw(g);
		      return;
		    } 
		    for (int i = 0; i < size(); i++) {
		      if (number.isDraw(points.get(i))) {
		        ((Circle)circs.get(i)).drawOn(g);
		      } else {
		        ((Circle)circs.get(i)).drawOff(g);
		      } 
		    } 
		  }
		}
