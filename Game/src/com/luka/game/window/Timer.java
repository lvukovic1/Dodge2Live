package com.luka.game.window;

import java.awt.event.ActionListener;

public class Timer {
	
	private int hour,minute,second,milsecond;
	private Timer timer;
	
	public void time(){
		milsecond++;
		if(milsecond == 10){
			milsecond = 0;
			second++;
		}
		if(second == 60){
			second++;
			minute = 0;
			
		}
		if(minute == 60){
			hour++;
			minute = 0;
			
		}
String h = String.valueOf(hour);
String m = String.valueOf(minute);
String s = String.valueOf(second);
String ms = String.valueOf(milsecond);
		
	}
	
	
	

}
