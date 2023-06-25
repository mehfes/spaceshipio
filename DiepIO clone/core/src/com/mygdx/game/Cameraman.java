package com.mygdx.game;

import java.util.ArrayList;

public class Cameraman {
	private ArrayList<VisibleObject> visibleObjects = new ArrayList<VisibleObject>();
	private Player PlayerToFollow;
	private int cameraXRange;
	private int cameraYRange;
	
	public Cameraman(Player p) {
		PlayerToFollow = p;
		cameraXRange = 50; 
		cameraYRange = 80; 
	}
	
	public void addVisibleObject(VisibleObject o) {
		visibleObjects.add(o);
	}
	
	public void updateVisibilityList() {
		ArrayList<VisibleObject> tempArr = new ArrayList<VisibleObject>();
		for(VisibleObject o:visibleObjects) {
			if(!o.onScreen(PlayerToFollow))
				tempArr.add(o);
		}
		for(VisibleObject v:tempArr) {visibleObjects.remove(v);}
		tempArr.clear();
	}
	
	public void render() {
		for(VisibleObject obj:visibleObjects) {
			if(obj.onScreen(PlayerToFollow)) {
				obj.draw();
			}
		}
	}
	public void setCameraRange(int x, int y) {
		cameraXRange = x;
		cameraYRange = y;
	}
}
