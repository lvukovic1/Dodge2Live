package com.luka.game.window;

import com.luka.game.framework.GameObject;

public class Camera {
	private float x,y;
	
	public Camera(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public void tickPlayer(GameObject player ){
		//x+= ((player.getX() - x) - 1000/2) * 0.05f;
		//y+= ((player.getY() - y) - 563/2) * 0.05f;
		//x= -player.getX() + Game.HEIGHT/2-200;
		//y= -player.getY() + Game.WIDTH/2-250;
		
		if(x <= 0) x = 0;
		if(x >= 610) x = 610;
		if(y <= 0) y = 0;
		if(y >= 500 + 32) y = 500+32;
		
		
	}
	public void tickHud(GameObject hud){
		
		y= -hud.getY() + Game.WIDTH/2-250;
		
		
	}
	
		
		
		


	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	

}
