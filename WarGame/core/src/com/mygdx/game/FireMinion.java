package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class FireMinion {
	private Vector2 pos;
	private int  check = 0;
	public FireMinion(float x,float y) {
		pos = new Vector2(x,y);
	}
	public Vector2 getPosition() {
		return pos;
	}
	public void update() {
		if(check == 1) {
			pos.x-=10;
		}
			
		if(Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			check =1;
		}
	}
}

