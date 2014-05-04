package com.esgi.euterpe.Screens;

import android.graphics.Color;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.esgi.euterpe.GameCore;


public class MenuScreen implements Screen {

    Skin skin;
    Stage stage;
    SpriteBatch batch;
    Game game;

    public MenuScreen(GameCore gameCore) {
        create();
        this.game = gameCore;
    }

    private void create() {
        this.batch = new SpriteBatch();
        this.stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        //Un skin peut être chargé via JSON ou défini en ligne de code, le skin est optionnel mais fortement recommandé

        skin = new Skin();
        //Génération d'une texture au format 1x1 et l'enregistrer dans un objet skin nommé "white"

        Pixmap pixmap = new Pixmap(100, 100, Pixmap.Format.RGB888);
        pixmap.setColor(Color.GREEN);
        pixmap.fill();

        skin.add("white", new Texture(pixmap));

        //Créer un font par défaut
        BitmapFont bfont = new BitmapFont();
        bfont.scale(1);
        skin.add("default", bfont);

        //Configure un type de boutton

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("white", com.badlogic.gdx.graphics.Color.DARK_GRAY);
        textButtonStyle.down = skin.newDrawable("white", com.badlogic.gdx.graphics.Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable("white", com.badlogic.gdx.graphics.Color.BLUE);
        textButtonStyle.over = skin.newDrawable("white", com.badlogic.gdx.graphics.Color.LIGHT_GRAY);

        textButtonStyle.font = skin.getFont("default");

        //Créer le bouton avec le style default

        final TextButton playButton = new TextButton("PLAY", textButtonStyle);
        playButton.setPosition(200, 200);
        stage.addActor(playButton);



    }

    @Override
    public void render(float delta) {

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
