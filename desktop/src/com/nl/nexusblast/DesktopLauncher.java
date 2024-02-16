package com.nl.nexusblast;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.nl.nexusblast.Main;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {

	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("NexusBlast");
        config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
        Main mainInstance = Main.getInstance(); // Hier wordt de enige instantie van Main opgehaald
        new Lwjgl3Application(mainInstance, config);
	}
}
