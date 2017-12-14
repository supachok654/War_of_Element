package com.mygdx.game;

import java.util.LinkedList;

import com.badlogic.gdx.Graphics;

public class LinkWaterMinion {

	private LinkedList<WaterMinion> water = new LinkedList<WaterMinion>();
	
	WaterMinion  tempWaterMinion;
	
	GameScreen game;
	
	public LinkWaterMinion(GameScreen gameScreen){
		this.game = gameScreen;
		
		addMinion(new WaterMinion(100,300,game,game.world));
	}
	
	public void tick() {
		for(int i=0;i<water.size();i++) {
			tempWaterMinion = water.get(i);
			
			tempWaterMinion.tick();
		}
	}
	
	/*public void render(Graphics g) {
		for(int i=0;i<water.size();i++) {
			tempWaterMinion = water.get(i);
			
			tempWaterMinion.render(g);
		}
	}*/
	public void addMinion(WaterMinion minion) {
		water.add(minion);
	}
	public void removeMinion(WaterMinion minion) {
		water.remove(minion);
	}
}
