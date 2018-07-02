
package com.luka.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.luka.game.framework.GameObject;
import com.luka.game.framework.ObjectId;
import com.luka.game.window.Game;

public class StrongEnemy extends GameObject {

	public StrongEnemy(float x, float y, ObjectId id) {
		super(x, y, id);
		
		velX = 2;
		velY = 7;
	}

	
	public void tick(LinkedList<GameObject> object) {
		
		x += velX;
		y += velY;
		
		if(y <= 32 || y >= Game.HEIGHT -65) velY *= -1;
		if(x <= 35 || x >= Game.WIDTH -65) velX *= -1;
	}

	
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect((int)x, (int)y,32, 32);
		g.setColor(Color.black);
		g.drawRect((int)x, (int)y,32, 32);
		}

	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,  (int)y, 32, 32);
	}

}
