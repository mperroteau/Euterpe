package com.esgi.euterpe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.libgdx.fighter.Config;
import com.libgdx.fighter.LittleFighter;

public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Euterpe";
        cfg.useGL20 = false;
        cfg.width = Config.VIRTAUL_MAP_WIDTH;
        cfg.height = Config.VIRTUAL_MAP_HEIGHT;
        cfg.fullscreen = false;
//		cfg.resizable = false;

        int MAX_MULTIPLIER = 7;

        for(int i = 1; i < MAX_MULTIPLIER; i++){
            if(cfg.width * i > LwjglApplicationConfiguration.getDesktopDisplayMode().width
                    || cfg.height * i > LwjglApplicationConfiguration.getDesktopDisplayMode().height){
                break;
            }
            cfg.width = cfg.width * i;
            cfg.height = cfg.height * i;

//			cfg.width = 1368;
//			cfg.height = 768;
        }

        new LwjglApplication(new Euterpe(), cfg);
    }
}

