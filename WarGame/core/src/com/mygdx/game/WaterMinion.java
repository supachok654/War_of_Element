package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class WaterMinion {
	private Vector2 pos;
	private int  check = 0;
	private int speed;
	private Water water;
	public WaterMinion(Water water,int level) {
		this.water = water;
		pos = new Vector2(water.getPosition().x,water.getPosition().y);
		if(level == 1) speed = 10;
		else if(level == 2) speed = 15;
		else if(level == 3) speed = 20;
	}
	public Vector2 getPosition() {
		return pos;
	}
	public void  setCheck(int x){
		check = x;
	}
	public void update() {
		if(check == 1) {
			pos.x+=speed;
		}
		else
			pos.y =  water.getPosition().y;
			
		/*if(Gdx.input.isKeyJustPressed(Keys.D)) {
			check =1;
		}*/
	}
}
