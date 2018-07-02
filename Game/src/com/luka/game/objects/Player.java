package com.luka.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.math.*;

import com.luka.game.framework.GameObject;
import com.luka.game.framework.ObjectId;

import com.luka.game.window.HUD;
import com.luka.game.window.Handler;



public class Player extends GameObject{
	private float width = 32, height = 32;
	private final float MAX_SPEED = 10;
	
	private Handler handler;
	public HUD hud;
	
	
	public Player(float x, float y,Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object) {
		x += velX;
		y += velY;
		
		Collision(object);
	}

	private void Collision(LinkedList<GameObject>object){
		for(int i = 0; i < handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Block ){
				
				if(getBounds().intersects(tempObject.getBounds())){
					x += (velX * -1);
					y += (velY * -1);
				}
			}
			else if(tempObject.getId() == ObjectId.Checkpoint ){
				if(getBounds().intersects(tempObject.getBounds())){
					handler.switchLevel();
				}	
			}
			
			else if(tempObject.getId() == id.Health){
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH = 100;
					handler.removeObject(tempObject);
				}
				
			}else if(tempObject.getId() == id.StrongEnemy){
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 100;	
				}	
			}else if(tempObject.getId() == id.BasicEnemy ||
					tempObject.getId() == id.FastEnemy ||
					tempObject.getId() == id.FastEnemy2 ||
					tempObject.getId() == id.BasicEnemy2 || 
					tempObject.getId() == id.SmartEnemy){
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 2;
				}
			}	
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.green);
		g2d.draw(getBounds());
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,  (int)y, (int)width, (int)height);
	}
}	
	
		
	

