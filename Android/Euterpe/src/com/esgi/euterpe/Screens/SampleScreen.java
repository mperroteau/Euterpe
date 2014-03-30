package com.esgi.euterpe.Screens;

import android.util.Log;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.esgi.euterpe.Classes.EGame;

/**
 * Created by Marine on 05/12/13.
 */
public class SampleScreen implements Screen {
    @Override
    public void render(float delta) {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl20.glClearColor(255.0F, 255.0F,255.0F, 1.0F);
        //Clear the screen to white.

        //batch.begin();
        //batch.draw(splash, 0, 0);
        //batch.end();

        if(Gdx.input.justTouched())
        {
            Log.v("Euterpe", "justTouched");
            EGame g = new EGame();
            //Log.v("Game generation", g.generateTest("musics/bj_sevensisters.mp3"));
            g.generate("musics/bj_sevensisters.mp3");
            /*
            * Afficher les informations sur une musique en particulier
            * Longueur de la musique
            * La fréquence
            * Les données
            * ...
            * */
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
