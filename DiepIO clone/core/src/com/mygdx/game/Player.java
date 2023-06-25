package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Player extends Interactable implements VisibleObject{
	int points = 0;
	int level = 1;
	int xCoordinate = 500;
	int yCoordinate = 500;
	
	
	public Player() {
		sr = new ShapeRenderer();
	}
	
	public void addPoints(int value) {
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
	}

	@Override
	public void draw() {
		sr.begin(ShapeType.Filled);
		sr.setColor(new Color(.25f,.7f,.9f,1));
		sr.circle(Gdx.graphics.getWidth()/2+25,Gdx.graphics.getHeight()/2-25,50);
		sr.end();
	}

	@Override
	public boolean onScreen(Player p) {
		return p==this;
	}

	@Override
	boolean dealsDamage() {
		return true;
	}
	
}
