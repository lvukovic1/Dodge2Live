package com.luka.game.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.*;

import com.luka.game.window.Handler;

public class KeyInput extends KeyAdapter {
	
	Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	
	public void keyPressed(KeyEvent e){
		int key= e.getKeyCode();
		
		for(int i=0;i<handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Player ){
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
				if(key == KeyEvent.VK_UP) tempObject.setVelY(-5);
			}
	}
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(1);
		}
	}
	
   public void keyReleased(KeyEvent e){
	   int key= e.getKeyCode();	
	   for(int i=0;i<handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Player){
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
				if(key == KeyEvent.VK_UP) tempObject.setVelY(0);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(0);			
			}
		}
	}
	
	

}
