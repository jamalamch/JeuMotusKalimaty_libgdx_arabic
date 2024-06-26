package com.mygdx.game.desktop;


import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Kalimaty";
        config.height = 720;
        config.width=640;
        config.addIcon("logo_desktop.png", FileType.Local);
        new LwjglApplication(new MyGdxGame(), config);
	}
}
