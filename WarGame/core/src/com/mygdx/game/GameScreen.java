package com.mygdx.game;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {

	private WarGame warofelementsGame;
	public Texture Background;
	public Texture waterImg;
	public Texture fireImg;
	public Texture waterminionImg;
	public Texture fireminionImg;
	private Random rand;
	private Water water;
	private Fire fire;
	public World world;
	private WaterMinion waterMinion;
	private FireMinion fireMinion;
	private List<WaterMinion> waterList;
	private List<FireMinion> fireList;

	private List<Texture> waterlistImg;
	private List<Texture> firelistImg;
	//private List<Texture> rectangleList;
	private int nextWaterMinion;
	private int nextFireMinion;
	private int delay1;
	private int delay2;

	//private LinkWaterMinion<> linkWaterMinion;
	private BitmapFont font;
	public GameScreen(WarGame warofelementsGame) {
		this.warofelementsGame = warofelementsGame;
		waterImg = new Texture("Water.png");
		fireImg = new Texture("Fire.png");
		waterminionImg = new Texture("WaterMinion1.png");
		fireminionImg = new Texture("FireMinion1.png");
		world = new World(warofelementsGame);
		water = world.getWater();
		fire = world.getFire();
		Background = new Texture("background.jpg");
		waterMinion = new WaterMinion(water,1);
		fireMinion = new FireMinion(fire,1);
		waterList = new ArrayList();
		waterList.add(waterMinion);
		fireList = new ArrayList();
		fireList.add(fireMinion);
		font = new BitmapFont();
		firelistImg = new ArrayList();
		waterlistImg = new ArrayList();
		//rectangleList = new ArrayList();
		waterlistImg.add(new Texture("WaterMinion1.png"));
		firelistImg.add(new Texture("FireMinion1.png"));
		rand = new Random();
		//w = new LinkWaterMinion(this);
		//Background = new Texture(Gdx.files.internal("background.jpg"));
	}
	/*public static Rectangle getBounds(float x,float y,int width, int heigth) {
		return new Rectangle(x,y,width,heigth);
	}
	private boolean collision(float x,float y,int width,int heigth) {
		return GameScreen.getBounds(x,y,width,heigth).intersects(getBounds());
	}*/
	@Override
    public void render(float delta) {
        SpriteBatch batch = warofelementsGame.batch;
        batch.begin();
        batch.draw(Background, 0, 0);
        update(delta);
        Vector2 pos_water = water.getPosition();
        Vector2 pos_fire = fire.getPosition();
        batch.draw(waterImg, pos_water.x, pos_water.y);
        batch.draw(fireImg, pos_fire.x, pos_fire.y);
        font.draw(batch,"WATER : " + world.getWaterHp(),300,770);
        font.draw(batch,"FIRE : " + world.getFireHp(),960,770);
        for(int i=0;i<waterlistImg.size();i++) {
        	batch.draw(waterlistImg.get(i),waterList.get(i).getPosition().x,waterList.get(i).getPosition().y);
        	//getBounds(waterList.get(i).getPosition().x,waterList.get(i).getPosition().y,waterlistImg.get(i).getWidth(),waterlistImg.get(i).getHeight());
        	//new Rectangle(waterList.get(i).getPosition().x,waterList.get(i).getPosition().y,waterlistImg.get(i).getWidth(),waterlistImg.get(i).getHeight());
        	nextWaterMinion = i;
        }
        batch.draw(waterlistImg.get(nextWaterMinion),150,750);
        for(int i=0;i<firelistImg.size();i++) {
        	batch.draw(firelistImg.get(i),fireList.get(i).getPosition().x,fireList.get(i).getPosition().y);
        	
        	//getBounds(fireList.get(i).getPosition().x,fireList.get(i).getPosition().y,firelistImg.get(i).getWidth(),firelistImg.get(i).getHeight());
        	// new Rectangle(fireList.get(i).getPosition().x,fireList.get(i).getPosition().y,firelistImg.get(i).getWidth(),firelistImg.get(i).getHeight());
        	nextFireMinion = i;
        }
        batch.draw(firelistImg.get(nextFireMinion),1100,750);
        batch.end();
    }
	private void update(float delta) {
		
		
		if(Gdx.input.isKeyJustPressed(Keys.W)){
			
			water.moveUp();
			
		}
		if(Gdx.input.isKeyJustPressed(Keys.S)) {
			
			water.moveDown();
		}
		if(Gdx.input.isKeyJustPressed(Keys.UP)){
			
			fire.moveUp();
			
		}
		if(Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			
			fire.moveDown();
		}
		delay1++;
		delay2++;
		if(Gdx.input.isKeyJustPressed(Keys.D)) {

			int tmp = rand.nextInt(8)+1;
			//System.out.println(delay1);
			//System.out.println(tmp);
			if(delay1 > 50) {
				delay1 = 0;
				waterList.get(waterList.size()-1).setCheck(1);
				waterList.add(new WaterMinion(water,tmp));
				if(tmp <= 4)
					waterlistImg.add(new Texture("WaterMinion1.png"));
				else if(tmp <= 7)
					waterlistImg.add(new Texture("WaterMinion2.png"));
				else if(tmp == 8)
					waterlistImg.add(new Texture("WaterBall.png"));
			}
			//int randomNum_1 = ThreadLocalRandom.current().nextInt(1,8);
			//System.out.println(randomNum_1);
			/*if(randomNum_1 < 4) {
				waterList.add(new WaterMinion(water));
				waterList.get(waterList.size()-1).setCheck(1);
				
			}
			else if(randomNum_1 < 7) {
				bigwaterList.add(new BigWaterMinion(water));
				bigwaterList.get(bigwaterList.size()-1).setCheck(1);
				
			}
			else {
				ultrawaterList.add(new UltraWaterMinion(water));
				ultrawaterList.get(ultrawaterList.size()-1).setCheck(1);
				
			}*/
			
		}
		if(Gdx.input.isKeyJustPressed(Keys.LEFT)) {

			int tmp = rand.nextInt(8)+1;
			//System.out.println(tmp);
			if(delay2 > 50) {
				delay2 = 0;
				fireList.get(fireList.size()-1).setCheck(1);
				fireList.add(new FireMinion(fire,tmp));
				if(tmp <= 4)
					firelistImg.add(new Texture("FireMinion1.png"));
				else if(tmp <= 7)
					firelistImg.add(new Texture("FireMinion2.png"));
				else if(tmp == 8)
					firelistImg.add(new Texture("FireBall.png"));
			}
			//int randomNum_2 = ThreadLocalRandom.current().nextInt(1,8);
			/*if(randomNum_2 < 4) {
				fireList.add(new FireMinion(fire));
				fireList.get(fireList.size()-1).setCheck(1);
				
			}
			else if(randomNum_2 < 7) {
				bigfireList.add(new BigFireMinion(fire));
				bigfireList.get(bigfireList.size()-1).setCheck(1);
				
			}
			else {
				ultrafireList.add(new UltraFireMinion(fire));
				ultrafireList.get(ultrafireList.size()-1).setCheck(1);
				
			}*/
		}
		for(int i=0;i<waterList.size();i++) {
        	if(waterList.get(i).getPosition().x == fire.getPosition().x && waterList.get(i).getPosition().y == fire.getPosition().y) {
        			world.fireHP--;
        	}
		}
		for(int i=0;i<fireList.size();i++) {
        	if(fireList.get(i).getPosition().x == water.getPosition().x && fireList.get(i).getPosition().y == water.getPosition().y) {
        			world.waterHP--;
        	}
		}
		for(int i=0;i<waterList.size();i++) {
			waterList.get(i).update();
			if(waterList.get(i).getPosition().x>1280) {
				waterList.remove(i);
				waterlistImg.remove(i);
			}
			/*if(waterList.get(i).getPosition().x<0) {
				waterList.remove(i);
				waterlistImg.remove(i);
				world.firescore++;
			}*/
		}
		for(int i=0;i<fireList.size();i++) {
			fireList.get(i).update();
			if(fireList.get(i).getPosition().x<0) {
				fireList.remove(i);
				firelistImg.remove(i);
				
			}
			/*if(fireList.get(i).getPosition().x>1280) {
				fireList.remove(i);
				firelistImg.remove(i);
				world.waterscore++;
			}*/
		}
		//System.out.println(waterList.size());
		/*for(int i=1;i<waterList.size();i++) {
			for(int j=1;j<fireList.size();j++) {
				if(waterList.get(i).getPosition().x == fireList.get(j).getPosition().x && waterList.get(i).getPosition().y == fireList.get(j).getPosition().y);
				{
					System.out.println("Hit");
				}
			}
		}*/
		//fireMinion.update();
		//System.out.println(waterList.size());
		//System.out.println(waterScore);
		//System.out.println(fireScore);
		/*if(Gdx.input.isKeyJustPressed(Keys.D)) {
			check =1;
		}*/
	}
}