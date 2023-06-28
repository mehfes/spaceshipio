package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import java.util.ArrayList;

/*
 * Note: the 2d physics (box2d) has been selected in project creation.
 * Use that module when you are making collision detection, movement etc
 * */

public class Player extends Interactable implements VisibleObject{
	private int points = 0;
	private int level = 1;
	private int xCoord = 500; //the coordinate of the player relative to the camera in pixels.
	private int yCoord = 500;
	private int radius = 50;
	private int RotationDGR = 0;
	private boolean Right = false;
	private boolean Left = false;
	private boolean Up = false;
	private boolean Down = false;
	private int speed = 1;
	ArrayList<Barrel> Guns = new ArrayList<Barrel>();
	
	public int getX() {return xCoord;}
	public int getY() {return yCoord;}
	public int getRadius() {return radius;}
	
	public Player() {
		sr = new ShapeRenderer();
		Guns.add(new Barrel(this));
	}
	
	//Player controller start
	void moveUp(boolean b) {
		Up = b;
	}
	void moveLeft(boolean b) {
		Left = b;
		RotationDGR+=5;
	}
	void moveDown(boolean b) {
		Down = b;
	}
	void moveRight(boolean b) {
		Right = b;
		RotationDGR-=5;
	}
	//Player controller end
	
	
	public void addPoints(int value) { //add <value> points to the player's xp bar
		points += value;
		updateScore();
	}

	int levelXP = 50;
	
	public void updateScore() {
		if(points>levelXP) {
			if(level==45) {points = 0;levelXP = Integer.MAX_VALUE;}
			while(points>levelXP&&level<45) {
				points-=levelXP;
				levelXP++;
				level++;
			}
		}
		//TODO: make this method update the xp bar visually.
	}

	@Override
	public void draw() { //do not use this method for drawing the player. usee drawAtCoordinate() instead.
		sr.begin(ShapeType.Filled);
		sr.setColor(.25f,.7f,.9f,1);
		sr.circle(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,50);
		sr.end();
	}

	@Override
	public boolean onScreen(Cameraman c) { //returns whether this object is rendered on the screen
		return true;
	}

	@Override
	boolean dealsDamage() { //returns whether this object can deal damage when it collides with another "Interactable"
		return true;
	}
	
	public void PlayerUpdate() {
		//the base method for all updates for the player (render,movement,attack,etc...)
		if(Up&&!Down) {
			yCoord += speed;
		}
		if(Down&&!Up) {
			yCoord -= speed;
		}
		if(Left&&!Right) {
			xCoord -= speed;
		}
		if(Right&&!Left) {
			xCoord += speed;
		}
		
		for(Barrel theBarrel:Guns) {
			theBarrel.draw();
		}
		
	}
	
	@Override
	public void drawAtCoordinate(int scrRelX,int scrRelY,int RotationDGR) {
		sr.begin(ShapeType.Filled);
		sr.setColor(.25f,.7f,.9f,1);
		sr.circle(scrRelX,scrRelY,radius);
		sr.end();
	}
	@Override
	public int getRotationDGR() {
		return RotationDGR;
	}
	public float getCenterX() {
		return xCoord;
	}
	public int getCenterY() {
		return yCoord;
	}
	
}

class Barrel{ //aka GUN
	Cameraman myCamera;
	Player myPlayer;
	ShapeRenderer sr;
	private int width = 20;
	private int height = 60;
	
	
	public Barrel(Player p) {
		sr = new ShapeRenderer();
		myPlayer = p;
	}
	
	public void draw() {
		sr.begin(ShapeType.Filled);
		sr.setColor(.5f, .5f, .5f, 1);
		sr.rect(Gdx.graphics.getWidth()/2+myPlayer.getRadius()-2,(Gdx.graphics.getHeight()/2)-(width/2),-myPlayer.getRadius()+2,width/2,height,width,1,1,myPlayer.getRotationDGR());
		sr.end();
	}
	
	public void draw(Player p) {
		sr.begin(ShapeType.Filled);
		sr.setColor(.5f, .5f, .5f, 1);
		sr.rect(p.getX()+p.getRadius()-1,p.getY()+(p.getRadius()),p.getCenterX(),p.getCenterY(),height,width,1,1,p.getRotationDGR());
		sr.end();
	}
	
}










