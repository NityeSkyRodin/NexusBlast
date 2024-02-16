package com.nl.nexusblast.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.nl.nexusblast.MusicPlayer;
import com.nl.nexusblast.ScreenManager;
import com.nl.nexusblast.watermark.Watermark;

public class MainMenu implements Screen {
    private Stage stage;
    TextButton startButton;
    TextButton optionsButton;
    TextButton exitButton;
    Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
    Texture texture = new Texture(Gdx.files.internal("NEXBLAST3.jpeg"));
    Image image = new Image(texture);
    MusicPlayer music = new MusicPlayer("NEXBLASTMAIN.mp3");
    private static MainMenu instance;
    private final ScreenManager screenManager = ScreenManager.getInstance();
    public MainMenu() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        // Voeg knoppen toe aan het hoofdmenu
        startButton = new TextButton("Start", skin);
        optionsButton = new TextButton("Options", skin);
        exitButton = new TextButton("Exit", skin);

        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                music.manageMusic("stop");
                screenManager.renderScreen("GameScreen");
            }
        });
        optionsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit(); // Sluit de applicatie
            }
        });
        music.manageMusic("play");

        Table table = createTable();
        table.setBackground(image.getDrawable());
        // Maak een nieuwe skin
        table.pad(20);
        startButton.pad(75);
        optionsButton.pad(75);
        exitButton.pad(75);

        table.align(Align.left | Align.top);
        table.add(startButton).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(optionsButton).fillX().uniformX();
        table.row();
        table.add(exitButton).fillX().uniformX();
        stage.addActor(table);


        stage.addActor(new Watermark().getWatermark());
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
    }

    public Table createTable(){
        Table table = new Table();
        table.setFillParent(true);
        return table;
    }

    public static MainMenu getInstance() {
        if (instance == null) {
            instance = new MainMenu();
        }
        return instance;
    }


}
