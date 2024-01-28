package net.argus.clock.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import net.argus.system.UserSystem;

public class ClockFrame extends JFrame {
	  private static final long serialVersionUID = 1707774623688997751L;
	  
	  private ClockPanel panel = new ClockPanel();
	  
	  private Framing framing = new Framing();
	  
	  private Point clickPoint;
	  
	  public ClockFrame() {
	    super("Clock");
	    setResizable(false);
	    setUndecorated(true);
	    setDefaultCloseOperation(3);
	    //setIconImage((new ImageIcon(ClockFrame.class.getResource("/icon.png"))).getImage());
	    setBackground(new Color(0.0F, 0.0F, 0.0F, 0.0F));
	    addMouseListener(getMouseListener());
	    addMouseMotionListener(getMouseMotionListener());
	    this.panel.add(this.framing);
	    setContentPane(this.panel);
	    pack();
	    setLocationRelativeTo((Component)null);
	  }
	  
	  private MouseListener getMouseListener() {
	    return new MouseListener() {
	        public void mouseReleased(MouseEvent e) {
	          ClockFrame.this.clickPoint = null;
	        }
	        
	        public void mousePressed(MouseEvent e) {
	          ClockFrame.this.clickPoint = e.getPoint();
	        }
	        
	        public void mouseExited(MouseEvent e) {}
	        
	        public void mouseEntered(MouseEvent e) {}
	        
	        public void mouseClicked(MouseEvent e) {
	          if (e.getButton() == 2)
	            ClockFrame.this.setAlwaysOnTop(!ClockFrame.this.isAlwaysOnTop()); 
	          if (e.getClickCount() == 10)
	            UserSystem.exit(0); 
	        }
	      };
	  }
	  
	  private MouseMotionListener getMouseMotionListener() {
	    return new MouseMotionListener() {
	        public void mouseMoved(MouseEvent e) {}
	        
	        public void mouseDragged(MouseEvent e) {
	          if (ClockFrame.this.clickPoint != null) {
	            Point currCoords = e.getLocationOnScreen();
	            ClockFrame.this.setLocation(currCoords.x - ClockFrame.this.clickPoint.x, currCoords.y - ClockFrame.this.clickPoint.y);
	          } 
	        }
	      };
	  }
	  
	  public Framing getFraming() {
	    return this.framing;
	  }
	}
