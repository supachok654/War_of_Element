package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class WorldRenderer {
    private World world;
    private WarGame warofelementsGame;
    private Texture waterImg;
    private Texture fireImg;
    private Texture waterminionImg;
    private Texture fireminionImg;
    private Texture Background;
    private Texture fireWin;
    private Texture waterWin;
    private BitmapFont font;
    private List<Texture> firelistImg;
    private List<Texture> waterlistImg;
    private int nextWaterMinion;
    private int nextFireMinion;
    private boolean gameOver;
    public WorldRenderer(WarGame warofelementsGame,World world){
        this.world = world;
        this.warofelementsGame = warofelementsGame;
        gameOver = false;
        waterImg = new Texture("Water.png");
        fireImg = new Texture("Fire.png");
        waterminionImg = new Texture("WaterMinion1.png");
        fireminionImg = new Texture("FireMinion1.png");
        Background = new Texture("background.jpg");
        fireWin = new Texture("FireWin.png");
        waterWin = new Texture("WaterWin.png");
        font = new BitmapFont();
        firelistImg = new ArrayList();
        waterlistImg = new ArrayList();
    }
    private void update(){
        waterlistImg.clear();
        firelistImg.clear();
        for (int i =0;i<world.waterList.size();i++){
            if (world.waterList.get(i).level <= 4)
                waterlistImg.add(new Texture("WaterMinion1.png"));
            else if (world.waterList.get(i).level <= 7)
                waterlistImg.add(new Texture("WaterMinion2.png"));
            else if (world.waterList.get(i).level == 8)
                waterlistImg.add(new Texture("WaterBall.png"));
        }
        for (int i =0;i<world.fireList.size();i++){
            if (world.fireList.get(i).level <= 4)
                firelistImg.add(new Texture("FireMinion1.png"));
            else if (world.fireList.get(i).level <= 7)
                firelistImg.add(new Texture("FireMinion2.png"));
            else if (world.fireList.get(i).level == 8)
                firelistImg.add(new Texture("FireBall.png"));
        }
        if(world.fireHP == 0) {
        	gameOver = true;
        }
        if(world.waterHP == 0) {
        	gameOver = true;
        }
    }
    public void render(float delta){
        update();
        SpriteBatch batch = warofelementsGame.batch;
        if(gameOver == false) {
        	batch.begin();
        	batch.draw(Background, 0, 0);
        	batch.draw(waterImg, world.getWater().getPosition().x, world.getWater().getPosition().y);
        	batch.draw(fireImg, world.getFire().getPosition().x, world.getFire().getPosition().y);
        	font.draw(batch,"WATER : " + world.getWaterHp(),300,770);
        	font.draw(batch,"FIRE : " + world.getFireHp(),960,770);
        	for(int i=0;i<world.waterList.size();i++) {
        		batch.draw(waterlistImg.get(i),world.waterList.get(i).getPosition().x,world.waterList.get(i).getPosition().y);
        		nextWaterMinion = i;
        	}
        	batch.draw(waterlistImg.get(nextWaterMinion),150,750);
        	for(int i=0;i<world.fireList.size();i++) {
        		batch.draw(firelistImg.get(i),world.fireList.get(i).getPosition().x,world.fireList.get(i).getPosition().y);
        		nextFireMinion = i;
        	}
        	batch.draw(firelistImg.get(nextFireMinion),1100,750);
        	batch.end();
        }
        if(gameOver == true && world.fireHP == 0) {
        	batch.begin();
        	batch.draw(waterWin,0,0);
        	
        	batch.end();
        }
        if(gameOver == true && world.waterHP == 0) {
        	batch.begin();
        	batch.draw(fireWin,0,0);
        	batch.end();
        }
    }
}