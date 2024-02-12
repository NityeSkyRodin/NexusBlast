package com.nl.nexusblast;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends Game {
	SpriteBatch batch;
	Texture img;

	@Override
	public void create () {
		batch = new SpriteBatch();
        MainMenu mainMenu = new MainMenu();
        setScreen(mainMenu);
	}

    @Override
    public void render () {
        ScreenUtils.clear(1, 0, 0, 1);
        super.render(); // Voeg deze regel toe
    }
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
