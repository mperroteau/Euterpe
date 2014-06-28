package com.esgi.euterpe.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


public class OptionScreen implements Screen{

    private Game game;

    //private TextureRegion bkTexture;
    Texture bkTexture;
    private SpriteBatch batch;
    private Stage stage;
    private TextureAtlas atlas;
    private Skin skin;
    private Table table;
    private TextButton buttonClassic, buttonLocal;
    private Label heading;
    private BitmapFont title;

    public OptionScreen(Game game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        batch.begin();
        //		bckRenderer.render(-1);
        batch.draw(bkTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        stage.draw();
        //		Table.drawDebug(stage);
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        //bkTexture = new TextureRegion(new Texture(Gdx.files.internal("background/background.png")),0 , 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        bkTexture = new Texture(Gdx.files.internal("background/background.png"));
        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        atlas = new TextureAtlas("ui/blueButtons.pack");
        skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), atlas);

        table = new Table(skin);
        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //Button CLASSIC
        buttonClassic = new TextButton("Classic Game", skin);
        buttonClassic.pad(20);
        buttonClassic.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
               // game.setScreen(new MusicScreen(game, true));
                game.setScreen(new TestScreen(game, true));
            }
        });

        //Button LOCAL
        buttonLocal = new TextButton("Local Song", skin);
        buttonLocal.pad(20);
        buttonLocal.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new MusicScreen(game, false));
                game.setScreen(new TestScreen(game, false));
            }
        });

        title = new BitmapFont(Gdx.files.internal("fonts/title.fnt"));
        LabelStyle headingStyle = new LabelStyle(title, new Color(0, 0, 0, 1));
        heading = new Label("Euterpe", headingStyle);

        //putting all that into a table
        table.add(heading);
        table.getCell(heading).spaceBottom(200);
        table.row();
        table.add(buttonClassic);
        table.getCell(buttonClassic).spaceBottom(20);
        table.add(buttonLocal);
        table.getCell(buttonLocal).spaceBottom(20);
        table.debug();
        stage.addActor(table);

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
        atlas.dispose();
        batch.dispose();
    }

}