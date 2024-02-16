package com.nl.nexusblast;

import com.nl.nexusblast.screen.GameScreen;
import com.nl.nexusblast.screen.MainMenu;
import com.nl.nexusblast.watermark.Skyline;

public class ScreenManager {
    private static ScreenManager instance;
    private final Main game;

    private ScreenManager() {
        game = Main.getInstance();
    }

    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }
        return instance;
    }

    public void renderScreen(String screenName) {
        System.out.println("ScreenManager: " + screenName + " is being rendered");
        switch (screenName) {
            case "MainMenu":
                game.setScreen(new MainMenu());
                break;
            case "Skyline":
                game.setScreen(new Skyline());
                break;
            case "GameScreen":
                game.setScreen(new GameScreen());
                break;
        }
    }
}
