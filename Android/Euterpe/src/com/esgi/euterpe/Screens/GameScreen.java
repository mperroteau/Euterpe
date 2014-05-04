package com.esgi.euterpe.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.esgi.euterpe.Classes.EGame;
import com.esgi.euterpe.Classes.Item;

/**
 * Created by Marine on 02/05/14.
 */
public class GameScreen implements Screen {

    private EGame game;
    Stage stage;

    Button buttonSettings, buttonPlay;


    @Override
    public void render(float delta) {
        //Pour les updates et les éléments de dessin
        //Ajoutedes fonctions en fonction des événement. Exemple if justTouched


        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl20.glClearColor(255.0F, 255.0F,255.0F, 1.0F); // Couleur du fond

        //Gdx.gl20.glDrawElements(); : Ajouter ces éléments à la volée
        //TODO pour chaque item dans le jeu lancer en fonction de la liste d'items dans les éléments

        for(Item item : game.getItemList()){
            //TODO afficher les éléments sur la fiche
            //Voir comment faire pour déterminer une durée limitée dans le temps pour chaqure item
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
