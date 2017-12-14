package com.mygdx.game;

import java.util.LinkedList;

import com.badlogic.gdx.Graphics;

public class LinkWaterMinion {

	private LinkedList<WaterMinion> water = new LinkedList<WaterMinion>();
	
	WaterMinion  tempWaterMinion;
	
	public void tick() {
		for(int i=0;i<water.size();i++) {
			tempWaterMinion = water.get(i);
			
			tempWaterMinion.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i=0;i<water.size();i++) {
			tempWaterMinion = water.get(i);
			
			tempWaterMinion.render(g);
		}
	}
}
