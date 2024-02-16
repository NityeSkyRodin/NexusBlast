package com.nl.nexusblast.watermark;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.nl.nexusblast.ScreenManager;

public class Skyline extends ScreenAdapter {
    Image image = new Image(new Texture("Skyline.jpeg"));
    private final Stage stage;
    private static Skyline instance;
    private final ScreenManager screenManager = ScreenManager.getInstance();
    public Skyline(){
        stage = new Stage(new ScreenViewport());

    }

    @Override
    public void show() {
        image.setPosition(700, 200);
        image.setColor(1, 1, 1, 0);
        image.addAction(Actions.fadeIn(2f));
        image.addAction(Actions.sequence(
                Actions.delay(4f),
                Actions.fadeOut(2f)
        ));
        stage.addActor(image);
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                screenManager.renderScreen("MainMenu");
            }
        }, 6);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(192 / 255f, 236 / 255f, 247 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void dispose() {
        ScreenUtils.clear(1, 0, 0, 1, true);

        stage.dispose();
    }

    public static Skyline getInstance() {
        if (instance == null) {
            instance = new Skyline();
        }
        return instance;
    }
}
