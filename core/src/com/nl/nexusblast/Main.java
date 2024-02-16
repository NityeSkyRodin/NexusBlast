package com.nl.nexusblast;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class Main extends Game {
	SpriteBatch batch;
    private static Main instance = Main.getInstance();
	@Override
	public void create () {
		batch = new SpriteBatch();
        ScreenManager screenManager = ScreenManager.getInstance();
        screenManager.renderScreen("GameScreen");
	}

    @Override
    public void render () {
        ScreenUtils.clear(1, 0, 0, 1);
        super.render();
    }
	
	@Override
	public void dispose () {
		batch.dispose();
	}

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }
}
