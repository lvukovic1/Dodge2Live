package com.luka.game.window;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	public static int hour = 0;
	public static int minute= 0;
	public static int second = 0;
	public static int milsecond= 0;
	
	public static int HEALTH = 100;
	private int greenValue = 255;
	public static int level = 1;
	
	
	
	public void tick(){
		HEALTH = Game.clamp(HEALTH,0,100);

		greenValue = Game.clamp(greenValue,0,255);
		greenValue = HEALTH*2;
		
		
		
			milsecond++;
			if(milsecond == 60){
				
				milsecond = 0;
				second ++;
				
			}
			if(second == 60){
				second = 0;
				minute++;
				
				
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
	
		public void timeStop(){
			
		}
	
	
	public void render (Graphics g){
		g.setColor(Color.gray);
		g.fillRect(20, 20, 200, 32);
		g.setColor(new Color(75,greenValue,0));
		g.fillRect(20, 20, HEALTH*2, 32);
		g.setColor(Color.black);
		g.drawRect(20, 20, 200, 32);
		
		g.setColor(Color.black);
		//g.drawString("Score:  " +hour+":"+minute+":"+second+":"+milsecond, 45, 70);
		g.drawString("Level: " +level, 45, 90);
	}





	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}

	public static int getHour() {
		return hour;
	}

	public static void setHour(int hour) {
		HUD.hour = hour;
	}

	public static int getMinute() {
		return minute;
	}

	public static void setMinute(int minute) {
		HUD.minute = minute;
	}

	public static int getSecond() {
		return second;
	}

	public static void setSecond(int second) {
		HUD.second = second;
	}

	public static int getMilsecond() {
		return milsecond;
	}

	public static void setMilsecond(int milsecond) {
		HUD.milsecond = milsecond;
	}
	
	
	
	
}
