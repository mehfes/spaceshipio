package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Interactable implements VisibleObject{
	public int currentHP;
	public int maxHP;
	abstract boolean dealsDamage();
	ShapeRenderer sr;
}

class Square extends Interactable implements VisibleObject{
	private int value = 20;
	
	@Override
	boolean dealsDamage() {
		return false;
	}
	
	public void _break(Player p) {
		p.addPoints(this.value);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScreen(Player p) {
		return false;
	}

}

class Star extends Interactable implements VisibleObject{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScreen(Player p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean dealsDamage() {
		// TODO Auto-generated method stub
		return false;
	}
	
}