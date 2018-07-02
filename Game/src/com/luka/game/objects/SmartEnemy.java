package com.luka.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.luka.game.framework.GameObject;
import com.luka.game.framework.ObjectId;
import com.luka.game.window.Game;
import com.luka.game.window.Handler;

public class SmartEnemy extends GameObject {

	private Handler handler;
	private GameObject player;
	
	public SmartEnemy(float x, float y, ObjectId id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getId() == id.Player) 
				player = handler.object.get(i);
					
		}
	}

	
	public void tick(LinkedList<GameObject> object) {
		
		x += velX;
		y += velY;
		
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float distance = (float)Math.sqrt((x-player.getX()) *
				(x-player.getX()) + (y-player.getY())*
				(y-player.getY()));
		
		velX = (float) ((-1.0/distance)*diffX);
		velY = (float) ((-1.0/distance)*diffY);
		
		if(y <= 32 || y >= Game.HEIGHT -64) velY *= -1;
		if(x <= 32 || x >= Game.WIDTH -65) velX *= -1;
	}

	
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect((int)x, (int)y,32, 32);
		}

	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,  (int)y, 32, 32);
	}

}
