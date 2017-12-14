package com.mygdx.game;

import java.time.Year;

import com.badlogic.gdx.Gdx;

public class World {
	private Water water;
	private Fire fire;
    private WarGame warofelementsGame;
 
    World(WarGame warofelementsGame) {
        this.warofelementsGame = warofelementsGame;
 
        water = new Water(10,70);
        fire = new Fire(1230, 70);
    }
 
    Water getWater() {
        return water;
    }
    Fire getFire() {
    	return fire;
    }
}
