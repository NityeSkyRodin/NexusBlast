package com.nl.nexusblast.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.nl.nexusblast.MusicPlayer;
import com.nl.nexusblast.player.Bullet;
import com.nl.nexusblast.player.Player;
import com.nl.nexusblast.watermark.Watermark;

public class GameScreen implements Screen, InputProcessor {
    MusicPlayer music = new MusicPlayer("NEXBLASTMAIN.mp3");
    private Stage stage;

    private SpriteBatch batch;
    private boolean[] keysPressed = new boolean[4];
    private Player player = new Player(700, 200);

    private Bullet bullet = new Bullet(player.getX(), player.getY());
    private Sprite sprite = new Sprite(player.getTexture());

    private Sprite sprite2 = new Sprite(bullet.getTexture());

    public GameScreen() {
        stage = new Stage(new ScreenViewport());
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);
        sprite.setScale(0.2f);
    }
    @Override
    public void show() {
        music.manageMusic("play");
        stage.addActor(new Watermark().getWatermark());
    }

    @Override
    public void render(float v) {
        update();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.setPosition(player.getX(), player.getY());
        sprite.setRotation(player.getRotation());
        sprite.draw(batch);
        batch.end();
        stage.draw();
    }
    private void update() {
        if (keysPressed[0]) player.moveUp();
        if (keysPressed[1]) player.moveLeft();
        if (keysPressed[2]) player.moveDown();
        if (keysPressed[3]) player.moveRight();
    }
    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean keyDown(int keycode) {
        // Wanneer een toets wordt ingedrukt, stel de juiste vlag in op true
        switch (keycode) {
            case Input.Keys.W:
                keysPressed[0] = true;
                break;
            case Input.Keys.A:
                keysPressed[1] = true;
                break;
            case Input.Keys.S:
                keysPressed[2] = true;
                break;
            case Input.Keys.D:
                keysPressed[3] = true;
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                keysPressed[0] = false;
                break;
            case Input.Keys.A:
                keysPressed[1] = false;
                break;
            case Input.Keys.S:
                keysPressed[2] = false;
                break;
            case Input.Keys.D:
                keysPressed[3] = false;
                break;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        System.out.println(i + " " + i1 + " " + i2 + " " + i3);
        batch.begin();
        sprite2.setPosition(player.getX(), player.getY());
        sprite2.draw(batch);
        batch.end();
        return true;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        System.out.println(i + " " + i1);
        player.turnPlayer(i, i1);
        return true;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        if (v1 > 0) {
            player.turnPlayer(true);
        }
        else if (v1 < 0) {
            player.turnPlayer(false);
        }
        return true;
    }
}
