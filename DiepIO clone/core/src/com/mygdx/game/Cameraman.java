package com.mygdx.game;

import java.util.ArrayList;

public class Cameraman {
	private ArrayList<VisibleObject> visibleObjects = new ArrayList<VisibleObject>();
	private Player PlayerToFollow;
	
	public Cameraman(Player p) {
		PlayerToFollow = p;
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
}
