package com.luka.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.luka.game.framework.GameObject;
import com.luka.game.framework.ObjectId;
import com.luka.game.window.BufferedImageLoader;
import com.luka.game.window.Game;

public class Health extends GameObject {
	//public BufferedImage cross = null; 
	
	public Health(float x, float y, ObjectId id) {
		super(x, y, id);
		
		velX = 0;
		velY = 0;
		
		
		
		//BufferedImageLoader loader = new BufferedImageLoader();
		//cross = loader.loadImage("/cross.png");
	}
	
	
	public void tick(LinkedList<GameObject> object) {
		
		x += velX;
		y += velY;
		
		if(y <= 32 || y >= Game.HEIGHT -64) velY *= -1;
		if(x <= 32 || x >= Game.WIDTH -65) velX *= -1;
	}

	
	public void render(Graphics g) {
		
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y,32, 32);
		g.setColor(Color.black);
		g.drawRect((int)x, (int)y,32, 32);


		//g.drawImage(cross, 224, 256, null);
		//g.drawRect(224, 256,32,32);
		}

	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,  (int)y, 32, 32);
		
		
	}

}
