package com.luka.game.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import com.luka.game.window.Game.STATE;

public class Menu extends MouseAdapter {
	Game game;
	Handler handler;
	
	
	public Menu(Game game,Handler handler){
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		if(game.gameState == STATE.Menu){
		//play gumb
		if(mouseOver(mx,my,620,300,250,100)){
			game.gameState = STATE.Game;
			handler.LoadImageLevel(game.level);
		}
		//Help gumb
		if(mouseOver(mx,my,620,450,250,100)){
			game.gameState = STATE.Help;
		}
		//quit gumb
		if(mouseOver(mx,my,620,600,250,100)){
			System.exit(1);
		}
		}
		//Help -back gumb
				if(game.gameState == STATE.Help){	
				if(mouseOver(mx,my,620,650,250,100)){
							game.gameState = STATE.Menu;
							return;
						}}
				if(game.gameState == STATE.End){	
					if(mouseOver(mx,my,620,400,250,100)){
								game.gameState = STATE.Game;
								handler.LoadImageLevel(game.level);
							}}
				if(game.gameState == STATE.Win){	
					if(mouseOver(mx,my,620,400,250,100)){
								game.gameState = STATE.Game;
								handler.LoadImageLevel(game.level);
								
							}}
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx,int my,int x,int y,int width,int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}else return false;
		}else return false;
	}
	
	
	public void tick(){
		
	}
	public void render(Graphics g){
		if(game.gameState == STATE.Menu){
			
		
		Font fnt = new Font("arial",1,70);
		Font fnt2 = new Font("arial",1,45);
		
		g.setFont(fnt);
		g.setColor(Color.BLACK);
		g.drawString("Menu", 650, 150);
		
		g.setFont(fnt2);
		g.setColor(Color.black);
		g.drawRect(620, 300, 250, 100);
		g.drawString("Play", 700, 365);
		
		g.setColor(Color.black);
		g.drawRect(620, 450, 250, 100);
		g.drawString("Help", 700, 515);
		
		g.setColor(Color.black);
		g.drawRect(620, 600, 250, 100);
		g.drawString("Quit", 700, 665);
		
	}else if(game.gameState == STATE.Help){
		Font fnt = new Font("arial",1,70);
		Font fnt2 = new Font("arial",1,45);
		Font fnt3 = new Font("arial",1,30);
		
		g.setFont(fnt);
		g.setColor(Color.BLACK);
		g.drawString("Help", 650, 150);
		
		g.setFont(fnt3);
		g.setColor(Color.BLACK);
		g.drawString("Use arrow keys to move player and dodge enemies", 150, 300);
		
		g.setFont(fnt3);
		g.setColor(Color.BLACK);
		g.drawString("These are enemies in game:", 150, 400);
		
		g.setColor(Color.RED);
		g.fillRect(580, 420, 32, 32);
		g.setColor(Color.BLACK);
		g.drawRect(580, 420, 32, 32);
		g.drawString("- This is basic enemy", 620, 445);
		
		g.setColor(Color.orange);
		g.fillRect(580, 460, 32, 32);
		g.setColor(Color.BLACK);
		g.drawRect(580, 460, 32, 32);
		g.drawString("- This is fast enemy", 620, 485);
		
		g.setColor(Color.cyan);
		g.fillRect(580, 500, 32, 32);
		g.setColor(Color.BLACK);
		g.drawRect(580, 500, 32, 32);
		g.drawString("- This is tracking enemy", 620, 525);
		
		g.setColor(Color.black);
		g.fillRect(580, 540, 32, 32);
		g.setColor(Color.BLACK);
		g.drawRect(580, 540, 32, 32);
		g.drawString("- This is instant death enemy", 620, 565);
		
		g.setFont(fnt2);
		g.setColor(Color.black);
		g.drawRect(620, 650, 250, 100);
		g.drawString("Back", 700, 715);
	}
	else if(game.gameState == STATE.End){
		Font fnt = new Font("arial",1,70);
		Font fnt2 = new Font("arial",1,30);
		
		
		g.setFont(fnt);
		g.setColor(Color.BLACK);
		g.drawString("Game over", 580, 150);
		
		g.setFont(fnt2);
		//g.drawString("it took you : "+HUD.hour+":"+HUD.minute+":"+HUD.second, 580, 350);
		
		
		
		g.setFont(fnt2);
		g.setColor(Color.black);
		g.drawRect(620, 400, 250, 100);
		g.drawString("Try again", 680, 465);
	}
	else if(game.gameState == STATE.Win){
		Font fnt = new Font("arial",1,70);
		Font fnt2 = new Font("arial",1,30);
		
		
		g.setFont(fnt);
		g.setColor(Color.BLACK);
		g.drawString("Congratulations", 580, 150);
		
		g.setFont(fnt2);
		//g.drawString("it took you : "+HUD.hour+":"+HUD.minute+":"+HUD.second, 580, 350);
		
		
		g.setFont(fnt2);
		g.setColor(Color.black);
		g.drawRect(620, 400, 250, 100);
		g.drawString("Try again", 680, 465);
	}
		
		}

}
