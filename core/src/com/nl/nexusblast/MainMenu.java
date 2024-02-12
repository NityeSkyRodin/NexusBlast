package com.nl.nexusblast;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenu implements Screen {
    private Stage stage;
    TextButton startButton;
    TextButton optionsButton;
    TextButton exitButton;
    Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
    Texture texture = new Texture(Gdx.files.internal("NEXBLAST3.jpeg"));
    Drawable drawable = new TextureRegionDrawable(new TextureRegion(texture));
    public MainMenu() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        MusicPlayer music = new MusicPlayer("NEXBLASTMAIN.mp3");
        music.ManageMusic("play");

        // Voeg knoppen toe aan het hoofdmenu
        startButton = new TextButton("Start", skin);
        optionsButton = new TextButton("Options", skin);
        exitButton = new TextButton("Exit", skin);

        // Voeg functionaliteit toe aan de knoppen
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Navigeer naar het volgende scherm (bijv. het spelscherm)
                // game.setScreen(new GameScreen());
                music.ManageMusic("pause");
            }
        });
        optionsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Navigeer naar het optiescherm
                // game.setScreen(new OptionsScreen());
                music.ManageMusic("play");
            }
        });
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit(); // Sluit de applicatie
            }
        });
    }

    @Override
    public void show() {
        // Maak een nieuwe tabel
        Table table = createTable();
        table.setBackground(drawable);

        // Maak een nieuwe skin
        table.pad(20);
        startButton.pad(100);
        optionsButton.pad(100);
        exitButton.pad(100);
        table.align(Align.left | Align.top);
        // Voeg GUI-elementen toe aan de tabel
        table.add(startButton).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(optionsButton).fillX().uniformX();
        table.row();
        table.add(exitButton).fillX().uniformX();
        stage.addActor(table);

        Table table2 = createTable();
        table2.add(new Label("NEXUSBLAST CODENAME: POLYBIUS V0.0.0", skin));
        table2.align(Align.bottom | Align.right);
        stage.addActor(table2);
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

}
