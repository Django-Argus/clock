package net.argus.clock.ui;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public abstract class Number {
	
	  private static List<Number> numbers = new ArrayList<>();
	  
	  private int num;
	  
	  public Number(int num) {
	    this.num = num;
	    numbers.add(this);
	  }
	  
	  public static Number getNumber(int num) {
	    for (Number n : numbers) {
	      if (n.num == num)
	        return n; 
	    } 
	    return null;
	  }
	  
	  public boolean isDraw(Point p) {
	    return getPoint().contains(p);
	  }
	  
	  public abstract List<Point> getPoint();
	  
	  public int getNumber() {
	    return this.num;
	  }
	}