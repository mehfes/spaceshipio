package com.mygdx.game;

public interface VisibleObject {
	public abstract void draw();
	public abstract boolean onScreen(Player p);
}