package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import java.util.ArrayList;

public class DIEP_IO extends ApplicationAdapter {
	ArrayList<Cameraman> CamArray;
	ArrayList<Player> PlayerArray;
	
	@Override
	public void create () {
		CamArray = new ArrayList<Cameraman>();
		PlayerArray = new ArrayList<Player>();
		AddPlayer(new Player());
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
		PlayerArray.add(p);
	}
	
}
