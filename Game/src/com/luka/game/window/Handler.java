package com.luka.game.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.luka.game.framework.GameObject;
import com.luka.game.framework.ObjectId;
import com.luka.game.objects.BasicEnemy;
import com.luka.game.objects.BasicEnemy2;
import com.luka.game.objects.Block;
import com.luka.game.objects.Checkpoint;
import com.luka.game.objects.FastEnemy;
import com.luka.game.objects.FastEnemy2;
import com.luka.game.objects.Health;

import com.luka.game.objects.Player;
import com.luka.game.objects.SmartEnemy;
import com.luka.game.objects.StrongEnemy;

import com.luka.game.objects.eBlock;

public class Handler {
	HUD hud;
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	public static int LEVEL = 1;
	private GameObject tempObject;
	private BufferedImage level = null,level2 = null, level3 = null,
			level4 = null, level5 = null,level6 = null,level7 = null,
			level8, level9 = null,level10 = null;
			
	public Handler(){
		BufferedImageLoader loader = new BufferedImageLoader();
	
	level = loader.loadImage("/level1.png");
	level2 = loader.loadImage("/level2.png");
	level3 = loader.loadImage("/level3.png");
	level4 = loader.loadImage("/level4.png");
	level5 = loader.loadImage("/level5.png");
	level6 = loader.loadImage("/level6.png");
	level7 = loader.loadImage("/level7.png");
	level8 = loader.loadImage("/level8.png");
	level9 = loader.loadImage("/level9.png");
	level10 = loader.loadImage("/level10.png");
	
	}
	
	
	public void tick(){
		for(int i = 0; i < object.size(); i++){
			tempObject = object.get(i);
			tempObject.tick(object);
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			
			tempObject = object.get(i);
			
			tempObject.render(g);
			
		}
	}
	
	
	public void LoadImageLevel(BufferedImage image){
		int w = image.getWidth();
		int h = image.getHeight();
		
		for(int xx = 0; xx < h; xx++){
			for(int yy = 0; yy < w; yy++){
				int pixel= image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff; 
				
				if(red == 255 && green == 255 && blue == 255) 
					addObject(new Block(xx*32,yy*32,ObjectId.Block));
				
				
				if(red == 0 && green == 0 && blue == 255) 
					addObject(new BasicEnemy(xx*32,yy*32,ObjectId.BasicEnemy));
				
				if(red == 255 && green == 0 && blue == 0) 
					addObject(new Player(xx*32,yy*32,this,ObjectId.Player));
				
				if(red == 100 && green == 0 && blue == 0) addObject(new FastEnemy(xx*32,yy*32,ObjectId.FastEnemy));
				if(red == 200 && green == 0 && blue == 0) addObject(new FastEnemy2(xx*32,yy*32,ObjectId.FastEnemy2));
				if(red == 0 && green == 0 && blue == 200) addObject(new BasicEnemy2(xx*32,yy*32,ObjectId.BasicEnemy2));
				if(red == 100 && green == 100 && blue == 100) addObject(new Checkpoint(xx*32,yy*32,ObjectId.Checkpoint));
				if(red == 0 && green == 100 && blue == 100) addObject(new SmartEnemy(xx*32,yy*32,ObjectId.SmartEnemy,this));
				if(red == 255 && green == 100 && blue == 0) addObject(new Health(xx*32,yy*32,ObjectId.Health));
				if(red == 255 && green == 0 && blue == 100) addObject(new StrongEnemy(xx*32,yy*32,ObjectId.StrongEnemy));
				if(red == 0 && green == 255 && blue == 0) addObject(new eBlock(xx*32,yy*32,ObjectId.eBlock));
			}
		}
	}
	
	public void switchLevel(){
		clearLevel();
		
		switch(Game.LEVEL){
		case 1:
			LoadImageLevel(level2);
		
			break;
		case 2:
			LoadImageLevel(level2);
			HUD.level = 2;
			break;
		case 3:
			LoadImageLevel(level3);
			
			break;
		case 4:
			LoadImageLevel(level3);
			HUD.level = 3;
			break;
		case 5:
			LoadImageLevel(level4);
		
			break;
		case 6:
			LoadImageLevel(level4);
			HUD.level = 4;
			break;
		case 7:
			LoadImageLevel(level5);
			HUD.level = 5;
			break;
		case 8:
			LoadImageLevel(level6);
			HUD.level = 6;
			break;
		case 9:
			LoadImageLevel(level7);
			
			break;
		case 10:
			LoadImageLevel(level7);
			HUD.level = 7;
			break;
		case 11:
			LoadImageLevel(level8);
		
			break;
		case 12:
			LoadImageLevel(level8);
			HUD.level = 8;
			break;
		case 13:
			LoadImageLevel(level9);
		
			break;
		case 14:
			LoadImageLevel(level9);
			HUD.level = 9;
			break;
		case 15:
			LoadImageLevel(level10);
			HUD.level = 10;
			break;
		case 16:
			LoadImageLevel(level10);
			HUD.level = 10;
			break;
		case 17:
			LoadImageLevel(level2);
			HUD.level = 11;
			break;
		
		
		
		
			
		}
		Game.LEVEL++;
		
	
	}
	
	
	
	
	
	public void clearLevel(){
		object.clear();
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
	
	

}
