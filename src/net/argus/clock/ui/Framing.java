package net.argus.clock.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.swing.JComponent;

import net.argus.clock.Timer;

public class Framing extends JComponent {
	  private static final long serialVersionUID = -8661740924585288372L;
	  
	  private List<Circle> circles = new ArrayList<>();
	  
	  private List<Circle> insideCircles = new ArrayList<>();
	  
	  private Time time = new Time();
	  
	  public static final int NB_POINT = 60;
	  
	  public static final int R = 250;
	  
	  private Point2D.Double center;
	  
	  public Framing() {
	    this.center = new Point2D.Double(250.0D, 250.0D);
	    createCircle();
	    createInsideCircle();
	    setPreferredSize(new Dimension(512, 512));
	  }
	  
	  private static final int[] compute(double coord0, double rayon, int nbCotes, double rotation, Function<Double, Double> trigo) {
	    int[] coord = new int[nbCotes];
	    for (int i = 0; i < nbCotes; i++)
	      coord[i] = (int)(coord0 + rayon * ((Double)trigo.apply(Double.valueOf((2 * i) * Math.PI / nbCotes + rotation))).doubleValue()); 
	    return coord;
	  }
	  
	  private void createCircle() {
	    int[] x = compute(this.center.getX(), 250.0D, 60, 0.0D, Math::cos);
	    int[] y = compute(this.center.getY(), 250.0D, 60, 0.0D, Math::sin);
	    int ind = indexOf(y);
	    int i;
	    for (i = ind; i < 60; i++)
	      this.circles.add(new Circle(x[i], y[i], i - ind)); 
	    for (i = 0; i < ind; i++)
	      this.circles.add(new Circle(x[i], y[i], i + 60 - ind)); 
	  }
	  
	  private void createInsideCircle() {
	    int[] x = compute(this.center.getX(), 230.0D, 12, 0.0D, Math::cos);
	    int[] y = compute(this.center.getY(), 230.0D, 12, 0.0D, Math::sin);
	    for (int i = 0; i < 12; i++)
	      this.insideCircles.add(new Circle(x[i], y[i], -1)); 
	  }
	  
	  private int indexOf(int[] y) {
	    int ind = 0;
	    int max = y[0];
	    for (int i = 1; i < y.length; i++) {
	      if (y[i] < max) {
	        max = y[i];
	        ind = i;
	      } 
	    } 
	    return ind;
	  }
	  
	  protected void paintComponent(Graphics g) {
	    Graphics2D g2 = (Graphics2D)g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    for (Circle cir : this.circles)
	      cir.draw(Timer.getTime().getSecond(), g2); 
	    for (Circle cir : this.insideCircles)
	      cir.draw(0, g2); 
	    this.time.draw(g2);
	    super.paintComponent(g);
	  }
	}
