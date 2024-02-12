package com.nl.nexusblast;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;

public class MusicPlayer {
    Music music;
    MusicPlayer(String path){
        AssetManager assetManager = new AssetManager();
        assetManager.load(path, Music.class);
        assetManager.finishLoading(); // Wacht tot de muziek geladen is voordat je verdergaat
        music = assetManager.get(path, Music.class);
    }

    public void ManageMusic(String action){
        switch (action) {
            case "play":
                music.play();
                music.setLooping(true);
                break;
            case "pause":
                music.pause();
                break;
            case "stop":
                music.stop();
                break;
        }
    }
}
