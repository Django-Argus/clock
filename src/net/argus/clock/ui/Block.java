package net.argus.clock.ui;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import net.argus.util.DoubleStock;

public class Block {
	  private List<DoubleStock<Circle, Point>> circles = new ArrayList<>();
	  
	  private int w;
	  
	  private int h;
	  
	  private int wOff;
	  
	  private int hOff;
	  
	  private int x;
	  
	  private int y;
	  
	  public Block(int w, int h, int wOff, int hOff, int x, int y) {
	    this.w = w;
	    this.h = h;
	    this.wOff = wOff;
	    this.hOff = hOff;
	    this.x = x;
	    this.y = y;
	    createCircle();
	  }
	  
	private void createCircle() {
	    for (int y = 0; y < this.h; y += this.hOff) {
	      for (int x = 0; x < this.w; x += this.wOff)
	        this.circles.add(new DoubleStock<Circle, Point>(new Circle(this.x - (this.w * 18 - 6) / 2 + x * 18 + 6, 
	                this.y - (this.h * 18 - 6) / 2 + y * 18 + 6), new Point(x, y))); 
	    } 
	  }
	  
	  public void draw(Graphics2D g) {
	    for (DoubleStock<Circle, Point> cir : this.circles)
	      ((Circle)cir.getFirst()).drawOff(g); 
	  }
	  
	  public List<Circle> getCircles() {
	    List<Circle> cirs = new ArrayList<>();
	    for (DoubleStock<Circle, Point> ds : this.circles)
	      cirs.add((Circle)ds.getFirst()); 
	    return cirs;
	  }
	  
	  public List<Point> getPoint() {
	    List<Point> points = new ArrayList<>();
	    for (DoubleStock<Circle, Point> ds : this.circles)
	      points.add((Point)ds.getSecond()); 
	    return points;
	  }
	  
	  public int size() {
	    return this.w * this.h;
	  }
	  
	  public int getWidth() {
	    return this.w;
	  }
	  
	  public int getHeight() {
	    return this.h;
	  }
	  
	  public int getWidthOff() {
	    return this.wOff;
	  }
	  
	  public int getHeightOff() {
	    return this.hOff;
	  }
	  
	  public int getX() {
	    return this.x;
	  }
	  
	  public int getY() {
	    return this.y;
	  }
	}
