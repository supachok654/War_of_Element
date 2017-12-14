package com.mygdx.game;

import com.badlogic.gdx.Graphics;

public class WaterMinion {
	
	private double x;
	private double y;
	private World world;
	Water image;
	
	public WaterMinion(double x, double y,GameScreen game,World world) {
		this.x = x;
		this.y = y;
		this.world = world;
		image = world.getWater();
	}
	
	public void tick() {
		x += 10;
	}
	
/*
	public void render(Graphics g) {
		//g.drawImage(image,(int)x,(int)y,null);
	}*/
}
