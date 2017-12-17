package com.mygdx.game;

import java.time.Year;

import com.badlogic.gdx.Gdx;

public class World {
	private Water water;
	private Fire fire;
    private WarGame warofelementsGame;
    public int waterHP;
    public int fireHP;
 
    World(WarGame warofelementsGame) {
        this.warofelementsGame = warofelementsGame;
 
        water = new Water(10,70);
        fire = new Fire(1230, 70);
        waterHP = 15;
        fireHP = 15;
    }
    public int getWaterHp() {
    	return waterHP;
    }
    
    public int getFireHp() {
    	return fireHP; 
    }
 
    Water getWater() {
        return water;
    }
    Fire getFire() {
    	return fire;
    }
}