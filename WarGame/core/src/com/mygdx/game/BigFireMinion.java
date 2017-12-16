package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BigFireMinion {
	private Vector2 pos;
	private int  check = 0;
	private Fire fire;
	public BigFireMinion(Fire fire) {
		this.fire = fire;
		pos = new Vector2(fire.getPosition().x,fire.getPosition().y);
	}
	public Vector2 getPosition() {
		return pos;
	}
	public void  setCheck(int x){
		check = x;
	}
	public void update() {
		if(check == 1)
			pos.x-=5;
		else
			pos.y =  fire.getPosition().y;
			
		/*if(Gdx.input.isKeyJustPressed(Keys.D)) {
			check =1;
		}*/
	}
}
