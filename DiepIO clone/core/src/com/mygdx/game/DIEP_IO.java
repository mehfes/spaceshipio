package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import java.util.ArrayList;

public class DIEP_IO extends ApplicationAdapter {
	ArrayList<Cameraman> CamArray;
	ArrayList<Player> PlayerArray;
	Square sq;
	PolarCoordinates mousePosAngle;
	
	//Input controls start
	void moveUp(boolean b) {
		PlayerArray.get(0).moveUp(b);
	}
	void moveLeft(boolean b) {
		PlayerArray.get(0).moveLeft(b);
	}
	void moveDown(boolean b) {
		PlayerArray.get(0).moveDown(b);
	}
	void moveRight(boolean b) {
		PlayerArray.get(0).moveRight(b);
	}
	
	
	//Input controls end
	
	
	@Override
	public void create () {
		mousePosAngle = new PolarCoordinates();
		
		CamArray = new ArrayList<Cameraman>();
		PlayerArray = new ArrayList<Player>();
		AddPlayer(new Player());
		sq = new Square();
		CamArray.get(0).addVisibleObject(sq);
		
		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
			public boolean keyDown(int keyCode){
				switch(keyCode) {
				case Keys.W:
					moveUp(true);
					break;
				case Keys.A:
					moveLeft(true);
					break;
				case Keys.S:
					moveDown(true);
					break;
				case Keys.D:
					moveRight(true);
					break;
				}
				return true;
			}
			@Override
			public boolean keyUp(int keyCode){
				switch(keyCode) {
				case Keys.W:
					moveUp(false);
					break;
				case Keys.A:
					moveLeft(false);
					break;
				case Keys.S:
					moveDown(false);
					break;
				case Keys.D:
					moveRight(false);
					break;
				}
				return true;
			}
			
			@Override
			public boolean mouseMoved(int screenX,int screenY) {
				mousePosAngle.setCartesian(screenX-CamArray.get(0).getWidth()/2,CamArray.get(0).getHeight()/2-(screenY));
				PlayerArray.get(0).setRotation((float)mousePosAngle.getPolar()[0]);
				return true;
			}
		});
		
		
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(.25f,.25f,.25f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		GameUpdate(); 
	}
	
	private void GameUpdate() {//GameUpdate is the main method, the parent method for all updates in the game, this is called every render cycle
		for(Cameraman c:CamArray) {
			c.CameraUpdate();
			c.getPlayer().PlayerUpdate();
		}
		
		//TODO: add more update events to this method to make it more useful
	}
	
	private void AddPlayer(Player p) {
		Cameraman temp = new Cameraman(p);
		CamArray.add(temp);
		p.setCamera(temp);
		PlayerArray.add(p);
	}
	
	private void AddObject(VisibleObject o,Cameraman c) {
		c.addVisibleObject(o);
	}
	
}
