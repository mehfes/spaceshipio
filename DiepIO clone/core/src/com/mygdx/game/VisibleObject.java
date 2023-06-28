package com.mygdx.game;

public interface VisibleObject {
	public abstract void draw();
	public void drawAtCoordinate(int scrRelX,int scrRelY,int RotationDGR);
	public abstract boolean onScreen(Cameraman c);
	public int getX();
	public int getY();
	public abstract int getRotationDGR();
}