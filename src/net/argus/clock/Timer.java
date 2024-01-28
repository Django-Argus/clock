package net.argus.clock;

import java.time.LocalTime;

import net.argus.util.ThreadManager;

public class Timer extends Thread {
	
	  private static LocalTime time = LocalTime.now();
	  
	  private static boolean on;
	  
	  public void run() {
	    while (true) {
	      time = LocalTime.now();
	      on = (time.getSecond() % 2 == 0);
	      MainClock.getFrameing().repaint();
	      ThreadManager.sleep(200L);
	    } 
	  }
	  
	  public static LocalTime getTime() {
	    return time;
	  }
	  
	  public static boolean isOn() {
	    return on;
	  }
	}
