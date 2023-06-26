package com.mygdx.game;

import java.util.ArrayList;

public class Cameraman {
	private ArrayList<VisibleObject> visibleObjects = new ArrayList<VisibleObject>();
	private Player PlayerToFollow;
	
	
	//the position of this Cameraman relative to the map in gameUnits (bottom left corner coords)
	private int xPos;
	private int yPos;
	
	//1 gameUnit == 5px (subject to change)
	private int cameraXRange; //the horizontal range of the camera in gameUnits
	private int cameraYRange; //the vertical range of the camera in gameUnits
	
	public Cameraman(Player p) {
		PlayerToFollow = p;
		cameraXRange = 50;
		cameraYRange = 80;
	}
	
	public void addVisibleObject(VisibleObject o) { //call this method whenever an object enters the range of this cameraman.
		visibleObjects.add(o);
	}
	
	private void updateVisibilityList() { //this method is called to remove objects that are no longer in range of this cameraman.
		ArrayList<VisibleObject> tempArr = new ArrayList<VisibleObject>();
		for(VisibleObject o:visibleObjects) {
			if(!o.onScreen(PlayerToFollow))
				tempArr.add(o);
		}
		for(VisibleObject v:tempArr) {visibleObjects.remove(v);}
		tempArr.clear();
	}
	
	private void render() { //calls the draw() method of each object tagged as visible.
		PlayerToFollow.draw();
		for(VisibleObject obj:visibleObjects) {
			if(obj.onScreen(PlayerToFollow)) {
				obj.draw();
			}
		}
	}
	
	public void CameraUpdate() { //use this method externally for updating the camera
		updateVisibilityList();
		render();
	}
	
	public void CameraUpdate(ArrayList<VisibleObject> arr) { //overload method for whenever there are new objects to render
		for(VisibleObject o:arr) {addVisibleObject(o);}
		this.CameraUpdate();
	}
	
	public void setCameraRange(int x, int y) {
		// TODO: remove this method (or make it private) unless the camera is meant to be resizable
		// and if it is resizable, write a comment here to explain
		cameraXRange = x;
		cameraYRange = y;
	}

	public Player getPlayer() { //returns the Player object this Cameraman is following.
		return PlayerToFollow;
	}
}
