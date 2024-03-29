package net.argus.clock.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class ClockPanel extends JPanel {
	  private static final long serialVersionUID = -7168012936134823578L;
	  
	  public ClockPanel() {
	    setBackground(UIManager.getColor("Clock.background"));
	    setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	  }
	  
	  protected void paintComponent(Graphics g) {
	    Graphics2D g2 = (Graphics2D)g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setColor(getBackground());
	    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
	  }
	}
