package com.luka.game.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.luka.game.framework.GameObject;
import com.luka.game.framework.KeyInput;
import com.luka.game.framework.ObjectId;
import com.luka.game.objects.BasicEnemy;
import com.luka.game.objects.BasicEnemy2;
import com.luka.game.objects.Block;
import com.luka.game.objects.Checkpoint;
import com.luka.game.objects.FastEnemy;
import com.luka.game.objects.FastEnemy2;
import com.luka.game.objects.Player;
import com.luka.game.objects.eBlock;


public class Game extends Canvas implements Runnable {

	
	
	private static final long serialVersionUID = 3079691829185460400L;

	private boolean running =false;
	private Thread thread;
	GameObject object;
	public static int WIDTH,HEIGHT;
	
	public BufferedImage level = null;
	public BufferedImage background = null; 
	public BufferedImage background2 = null; 
	
	Handler handler;
	
	private HUD hud;
	private Menu menu;
	public static int LEVEL = 1;
	
	public enum STATE{
		Menu,
		Help,
		Game,
		End,
		Win
	};
	
	public STATE gameState = STATE.Menu;
	
	private void init(){
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/level1.png");
		background = loader.loadImage("/background.png");
		background2 = loader.loadImage("/backgroundGame.png");
		handler = new Handler();
		hud = new HUD();
		menu = new Menu(this,handler);
		if(gameState == STATE.Game){
		handler.LoadImageLevel(level);
		}
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
	}
	
	public synchronized void start(){
		if(running) 
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	private void tick(){
		handler.tick();
		if(gameState == STATE.Game){
			
		hud.tick();
		
		if(HUD.HEALTH <= 0){
			HUD.HEALTH = 100;
			handler.clearLevel();
			gameState = STATE.End;
			HUD.level =1;
			LEVEL = 1;
		}
		if(HUD.level == 11){
			HUD.HEALTH = 100;
			handler.clearLevel();
			gameState = STATE.Win;
			HUD.level =1;
			LEVEL = 1;	
		}
		}else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Win){
			menu.tick();
		}
		
		
		
		
		
	}
	
	private void render(){
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;		
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(background2, 0, 0, null);
		
		handler.render(g);
		if(gameState == STATE.Game){
			
			hud.render(g);
			
		}else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Win){
			g.drawImage(background, 0, 0, null);
			menu.render(g);	
		}
		g.dispose();
		bs.show();
	}
	
	
	
	public static int clamp(int var,int min,int max){
		if(var >= max)
			return var = max;
		if(var <= min)
			return var = min;
		else
			return var;
	}
	
	
	public static void main(String args[]){
		new Window(1366,825,"Dodge2live",new Game());
	}

}
