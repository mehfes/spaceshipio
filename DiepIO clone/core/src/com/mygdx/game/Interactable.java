package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Interactable {
	public int currentHP;
	public int maxHP;
	abstract boolean dealsDamage();
	ShapeRenderer sr;
}

class Square extends Interactable{
	private int value = 20;
	
	@Override
	boolean dealsDamage() {
		return false;
	}
	
	public void _break(Player p) {
		p.addPoints(this.value);
	}

}