package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public abstract class Interactable implements VisibleObject{
	public int currentHP;
	public int maxHP;
	abstract boolean dealsDamage();
	ShapeRenderer sr;
}

class Square extends Interactable implements VisibleObject{
	int xPos = 700;
	int yPos = 400;
	int width = 35;
	int height = 35;
	int rotationDGR = 0;
	
	public Square() {
		sr = new ShapeRenderer();
	}
	
	private int value = 20;
	
	@Override
	boolean dealsDamage() {
		return false;
	}
	
	public void _break(Player p) {
		p.addPoints(this.value);
	}
	
	public void draw() {
		
	}

	public void drawAtCoordinate(int relX,int relY,int rotationDGR) {
		sr.begin(ShapeType.Filled);
		sr.setColor(Color.GOLD);
		sr.rect(relX,relY,relX+(width/2),relY+(height/2),width,height,1,1,rotationDGR);
		sr.end();
	}

	@Override
	public boolean onScreen(Cameraman c) {
		return (!(xPos+width<c.getX()||xPos>c.getX()+c.getWidth()))&&(!(yPos+height<c.getY()||yPos>c.getY()+c.getHeight()));
	}

	@Override
	public int getX() {
		return xPos;
	}

	@Override
	public int getY() {
		return yPos;
	}

	@Override
	public int getRotationDGR() {
		return rotationDGR;
	}

}

class Star extends Interactable implements VisibleObject{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private int rotationDGR;
	
	public Star() {
		xPos = 500;
		yPos = 200;
		width = 20;
		height = 20;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScreen(Cameraman c) {
		return (!(xPos+width<c.getX()||xPos>c.getX()+c.getWidth()))&&(!(yPos+height<c.getY()||yPos>c.getY()+c.getHeight()));
	}

	@Override
	boolean dealsDamage() {
		return false;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return xPos;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return yPos;
	}

	@Override
	public void drawAtCoordinate(int scrRelX, int scrRelY, int RotationDGR) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getRotationDGR() {
		// TODO Auto-generated method stub
		return rotationDGR;
	}
	
}