package com.nl.nexusblast.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bullet extends Sprite {

    private float x, y;
    private float speed = 20f;

    private float rotation = 0;

    private Texture texture = new Texture("Bullet.png");

    public Bullet(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Texture getTexture() {
        return texture;
    }

}
