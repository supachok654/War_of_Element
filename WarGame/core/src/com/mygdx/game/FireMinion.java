package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class FireMinion {
	private Vector2 pos;
	private int  check = 0;
	private int  speed;
	private Fire fire;
	public int level;
	public FireMinion(Fire fire,int level) {
		this.fire = fire;
		this.level = level;
		if(level <= 4) {
			pos = new Vector2(fire.getPosition().x+50,fire.getPosition().y);
			speed = 5;
		}
		else if(level <= 7) {
			pos = new Vector2(fire.getPosition().x+75,fire.getPosition().y);
			speed = 8;
		}
		else if(level == 8) {
			pos = new Vector2(fire.getPosition().x+100,fire.getPosition().y);
			speed = 15;
		}
	}
	public Vector2 getPosition() {
		return pos;
	}
	public void  setCheck(int x){
		check = x;
	}
	public void update() {
		if(check == 1)
			pos.x-=speed;
		else
			pos.y =  fire.getPosition().y;
			
		/*if(Gdx.input.isKeyJustPressed(Keys.D)) {
			check =1;
		}*/
	}
}



