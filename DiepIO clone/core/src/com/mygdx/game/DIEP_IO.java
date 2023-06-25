package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class DIEP_IO extends ApplicationAdapter {
	ShapeRenderer sr;
	Cameraman cameraman;
	
	@Override
	public void create () {
		Player p1 = new Player();
		
		cameraman = new Cameraman(p1);
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(.25f,.25f,.25f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
	}
	
	@Override
	public void dispose () {
		sr.dispose();
	}
}
