package com.nl.nexusblast.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class Player extends Sprite {
    private float x, y;
    private float speed = 7.5f;

    private float rotation = 0;

    private Texture texture = new Texture("Player.png");

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void turnPlayer(boolean up) {
        if (up) {
            rotation += 15;
        } else {
            rotation -= 15;
        }
    }

    public void turnPlayer(float i, float i1) {
        float angle = (float)Math.toDegrees(Math.atan2(i1 - y, i - x));
        rotation = angle;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public void moveUp() {
        y += speed;
    }

    public void moveDown() {
        y -= speed;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Texture getTexture() {
        return texture;
    }

    public float getRotation() {
        return rotation;
    }
}
