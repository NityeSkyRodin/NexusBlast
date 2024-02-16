package com.nl.nexusblast.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class Player {
    private float x, y;
    private float speed = 10f; // Snelheid van de speler

    private float rotation = 0;

    private Texture texture = new Texture("Player.png");

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void turnPlayer(boolean up) {
        if (up) {
            rotation += 5;
        } else {
            rotation -= 5;
        }
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
