package com.mygdx.game;

import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;

public class Fire {
	private Vector2 position;
	
	public Fire(int x, int y) {
        position = new Vector2(x, y);
        
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    
    public void moveUp() {
    	if(position.y < 710) {
    		position.y+=160;
    	}
	}
    public void moveDown() {
    	if(position.y > 70) {
    		position.y-=160;
    	}
    }
}