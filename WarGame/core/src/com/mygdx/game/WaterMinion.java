package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class WaterMinion {
	private Vector2 pos;
	private int  check = 0;
	private Water water;
	public WaterMinion(Water water) {
		this.water = water;
		pos = new Vector2(water.getPosition().x,water.getPosition().y);
	}
	public Vector2 getPosition() {
		return pos;
	}
	public void  setCheck(int x){
		check = x;
	}
	public void update() {
		if(check == 1)
			pos.x+=10;
		else
			pos.y =  water.getPosition().y;
			
		/*if(Gdx.input.isKeyJustPressed(Keys.D)) {
			check =1;
		}*/
	}
}
