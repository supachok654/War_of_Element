package com.mygdx.game;

import java.time.Year;

import com.badlogic.gdx.Gdx;

public class World {
	private Water water;
	private Fire fire;
    private WarGame warofelementsGame;
    public int waterscore;
    public int firescore;
 
    World(WarGame warofelementsGame) {
        this.warofelementsGame = warofelementsGame;
 
        water = new Water(10,70);
        fire = new Fire(1230, 70);
        waterscore = 0;
        firescore = 0;
    }
    public int getWaterScore() {
    	return waterscore;
    }
    
    public int getFireScore() {
    	return firescore; 
    }
 
    Water getWater() {
        return water;
    }
    Fire getFire() {
    	return fire;
    }
}
