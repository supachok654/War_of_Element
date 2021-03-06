package com.mygdx.game;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class World {
	private Water water;
	private Fire fire;
    private WarGame warofelementsGame;
    public int waterHP;
    public int fireHP;
    private WaterMinion waterMinion;
    private FireMinion fireMinion;
    public List<WaterMinion> waterList;
    public List<FireMinion> fireList;
    private Random rand;
    private int delay1;
    private int delay2;
 
    World(WarGame warofelementsGame) {
        this.warofelementsGame = warofelementsGame;
 
        water = new Water(10,70);
        fire = new Fire(1230, 70);
        waterHP = 5;
        fireHP = 5;
        waterMinion = new WaterMinion(water,1);
        fireMinion = new FireMinion(fire,1);
        waterList = new ArrayList();
        waterList.add(waterMinion);
        fireList = new ArrayList();
        fireList.add(fireMinion);
        rand = new Random();
        delay1=0;
        delay2=0;
    }
    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {

            water.moveUp();

        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {

            water.moveDown();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {

            fire.moveUp();

        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {

            fire.moveDown();
        }
        delay1++;
        delay2++;
        if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {

            int tmp = rand.nextInt(8) + 1;
            if (delay1 > 25) {
                delay1 = 0;
                waterList.get(waterList.size() - 1).setCheck(1);
                waterList.add(new WaterMinion(water, tmp));
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {

            int tmp = rand.nextInt(8) + 1;
            if (delay2 > 25) {
                delay2 = 0;
                fireList.get(fireList.size() - 1).setCheck(1);
                fireList.add(new FireMinion(fire, tmp));
            }
        }
        for (int i = 0; i < waterList.size(); i++) {
            if (waterList.get(i).getPosition().x == fire.getPosition().x && waterList.get(i).getPosition().y == fire.getPosition().y) {
                fireHP--;
            }
        }
        for (int i = 0; i < fireList.size(); i++) {
            if (fireList.get(i).getPosition().x == water.getPosition().x && fireList.get(i).getPosition().y == water.getPosition().y) {
                waterHP--;
            }
        }
        for (int i = 0; i < waterList.size(); i++) {
            waterList.get(i).update();
            if (waterList.get(i).getPosition().x > 1280) {
                waterList.remove(i);
            }
        }
        for (int i = 0; i < fireList.size(); i++) {
            fireList.get(i).update();
            if (fireList.get(i).getPosition().x < 0) {
                fireList.remove(i);

            }

        }
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
