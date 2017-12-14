package com.mygdx.game;

import com.badlogic.gdx.Graphics;

public class WaterMinion {
	
	private double x;
	private double y;
	
	Water image;
	
	public WaterMinion(double x, double y,WarGame game) {
		this.x = x;
		this.y = y;
		
		image = World.Water(10,70);
	}
	
	public void tick() {
		x += 10;
	}

	public void render(Graphics g) {
		g.drawImage(image,(int)x,(int)y,null);
	}
}
