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
        import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
        import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle;
        import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
        import com.badlogic.gdx.scenes.scene2d.ui.List;
        import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle;
        import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
        import  com.esgi.euterpe.utils.ListView;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TestScreen implements Screen {

    private Game game;
    private boolean IsLocalGame;
    private GameLevel level;

    //private TextureRegion bkTexture;
    Texture bkTexture;
    private SpriteBatch batch;
    private Stage leftStage;
    private Stage rightStage;
    private TextureAtlas leftAtlas;
    private TextureAtlas rightAtlas;
    private Skin leftSkin;
    private Skin rightSkin;
    private Table leftTable;
    private Table rightTable;
    private TextButton buttonEasy, buttonMedium , buttonHard, buttonPlay, buttonTest, buttonTest2;
    private Label heading;
    private BitmapFont title;
    private List maListe;
    private ScrollPane myScrollPane;

    public TestScreen(Game game, boolean typeGame) {
        this.game = game;
        this.IsLocalGame = typeGame;
        level = GameLevel.medium;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        leftStage.act(delta);
        leftStage.draw();
 /*
        rightStage.act(delta);
        batch.begin();
        //		bckRenderer.render(-1);
        batch.draw(bkTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        rightStage.draw();
        //		Table.drawDebug(stage);*/

        /*Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        rightStage.act(delta);
        leftStage.act(delta);

        //set the openGl viewport to half the screenheight and starting y from the     middle of the screen
        Gdx.gl.glViewport(0,Gdx.graphics.getHeight(),Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight());
        rightStage.draw();

        //set the openGl viewport to half the screenheight and starting y from the     bottom of the screen
        Gdx.gl.glViewport(0,0,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight());
        leftStage.draw();*/

        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        //rightStage.act(delta);
        //leftStage.act(delta);

        //set the openGl viewport to half the screenheight and starting y from the     middle of the screen
        // Gdx.gl.glViewport(0,Gdx.graphics.getHeight()/2,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/2);
        //Gdx.gl.glViewport( 0,0,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight() );
        //leftStage.draw();

        //set the openGl viewport to half the screenheight and starting y from the     bottom of the screen
        //Gdx.gl.glViewport(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/2);
       // Gdx.gl.glViewport( Gdx.graphics.getWidth()/2,0,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight() );
        //rightStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    private void showLeft(){

        /*TextureAtlas atlas2 = new TextureAtlas("ui/blueButtons.pack");
        Skin skin2 = new Skin(Gdx.files.internal("ui/menuSkin.json"), atlas2);

        Label.LabelStyle headingStyle2 = new Label.LabelStyle(title, new Color(1, 1, 0, 1));
        Table table2 = new Table(skin2);
        Table container = new Table(skin2);
        ScrollPane scroll = new ScrollPane(table2);
        container.add(scroll).width(500f).height(500f);
        container.row();

        Label label = new Label(null, headingStyle2);
        table2.add(label);
        table2.row();
        label.setAlignment(1);

        for(int i =0; i <10 ; i++){

            table2.add("mybutton " + i);//.width(WIDTH/4f);
        }*/
       /* TextButton mybuttonPlay2;

        Table table2 = new Table(skin);
        table2.setBounds(0, 0, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight());

        for(int i = 0; i < 8; i++) {
            mybuttonPlay2 = new TextButton("my button" + i, skin);
            mybuttonPlay2.pad(20);
            mybuttonPlay2.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    //game.setScreen(new GameScreen(game));
                }
            });
            //leftStage.addActor(mybuttonPlay);

            table2.row();
            table2.add(mybuttonPlay2);
            table2.getCell(mybuttonPlay2).spaceBottom(20);
        }
        leftStage.addActor(table2);*/
        Gdx.input.setInputProcessor(leftStage);

        leftStage = new Stage(0, 0, false);

        leftTable = new Table(leftSkin);
        leftTable.debug();

        leftAtlas = new TextureAtlas("ui/blueButtons.pack");
        leftSkin= new Skin(Gdx.files.internal("ui/menuSkin.json"), leftAtlas);
        //Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));

        maListe = new List(new String[] {"un", "deux", "trois", "quatre", "cinq", "six", "sept","huit", "neuf"}, leftSkin);
        myScrollPane = new ScrollPane(maListe, leftSkin);

        buttonTest = new TextButton("test",leftSkin);
        buttonTest.pad(15);

        buttonTest2 = new TextButton("test2",leftSkin);
        buttonTest2.pad(15);

       /* Gdx.graphics.setVSync(false);

        Table container = new Table();
        leftStage.addActor(container);
        container.setFillParent(true);

        leftTable = new Table();
        // table.debug();

        final ScrollPane scroll = new ScrollPane(leftTable, leftSkin);

        InputListener stopTouchDown = new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                event.stop();
                return false;
            }
        };

        leftTable.pad(10).defaults().expandX().space(4);
        for (int i = 0; i < 100; i++) {
            leftTable.row();
            leftTable.add(new Label(i + "uno", leftSkin)).expandX().fillX();

            TextButton button = new TextButton(i + "dos", leftSkin);
            leftTable.add(button);
            button.addListener(new ClickListener() {
                public void clicked (InputEvent event, float x, float y) {
                    System.out.println("click " + x + ", " + y);
                }
            });

            Slider slider = new Slider(0, 100, 100, false, leftSkin);
            slider.addListener(stopTouchDown); // Stops touchDown events from propagating to the FlickScrollPane.
            leftTable.add(slider);

            leftTable.add(new Label(i + "tres long0 long1 long2 long3 long4 long5 long6 long7 long8 long9 long10 long11 long12", leftSkin));
        }

        final TextButton flickButton = new TextButton("Flick Scroll", leftSkin.get("toggle", TextButtonStyle.class));
        flickButton.setChecked(true);
        flickButton.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                scroll.setFlickScroll(flickButton.isChecked());
            }
        });

        final TextButton fadeButton = new TextButton("Fade Scrollbars", leftSkin.get("toggle", TextButtonStyle.class));
        fadeButton.setChecked(true);
        fadeButton.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                scroll.setFadeScrollBars(fadeButton.isChecked());
            }
        });

        container.debug();
        container.add(scroll).expand().fill().colspan(2);
        container.row().space(10).padBottom(10);
        container.add(flickButton).right();
        container.add(fadeButton).left();*/

    }

    private void showRight(){
        rightTable = new Table(rightSkin);
        rightTable.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //Button EASY
        buttonEasy = new TextButton("Easy", rightSkin);
        buttonEasy.pad(20);
        buttonEasy.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new GameScreen(game));
                ButtonToggle(GameLevel.easy);
            }
        });
        //Button MEDIUM
        buttonMedium = new TextButton("Medium", rightSkin);
        buttonMedium.pad(20);
        buttonMedium.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new GameScreen(game));
                ButtonToggle(GameLevel.medium);
            }
        });

        //Button HARD
        buttonHard = new TextButton("Hard", rightSkin);
        buttonHard.pad(20);
        buttonHard.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new GameScreen(game));
                ButtonToggle(GameLevel.hard);
            }
        });


        //Button PLAY
        buttonPlay = new TextButton("Play", rightSkin);
        buttonPlay.pad(20);
        buttonPlay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });

        title = new BitmapFont(Gdx.files.internal("fonts/title.fnt"));
        Label.LabelStyle headingStyle = new Label.LabelStyle(title, new Color(0, 0, 0, 1));
        heading = new Label("Euterpe", headingStyle);

        //putting all that into a table
        //table.add(heading);
        //table.getCell(heading).spaceBottom(200);
        rightTable.row();
        rightTable.add(buttonEasy);
        rightTable.getCell(buttonEasy).spaceBottom(20);
        //table.row();
        rightTable.add(buttonMedium);
        rightTable.getCell(buttonMedium).spaceBottom(20);
        //table.row();
        rightTable.add(buttonHard);
        rightTable.getCell(buttonHard).spaceBottom(20);
        rightTable.row();
        rightTable.add(buttonPlay);
        rightTable.getCell(buttonPlay).spaceBottom(20);
        rightTable.debug();
        rightStage.addActor(rightTable);
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(leftStage);
        leftStage = new Stage(0, 0, false);

        leftSkin = new Skin(Gdx.files.internal("uiskin.json"));

        leftTable = new Table(leftSkin);
        leftTable.debug();

        //leftAtlas = new TextureAtlas("ui/blueButtons.pack");
        //leftSkin= new Skin(Gdx.files.internal("ui/menuSkin.json"), leftAtlas);
        //Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));

        maListe = new List(new String[] {"un", "deux", "trois", "quatre", "cinq", "six", "sept","huit", "neuf"}, leftSkin);
        myScrollPane = new ScrollPane(maListe, leftSkin);

        buttonTest = new TextButton("test",leftSkin);
        buttonTest.pad(15);

        buttonTest2 = new TextButton("test2",leftSkin);
        buttonTest2.pad(15);
        /*batch = new SpriteBatch();
        //bkTexture = new TextureRegion(new Texture(Gdx.files.internal("background/background.png")),0 , 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        bkTexture = new Texture(Gdx.files.internal("background/background.png"));
        rightStage = new Stage();
        leftStage = new Stage();

        //Gdx.input.setInputProcessor(rightStage);
        Gdx.input.setInputProcessor(leftStage);
        rightAtlas = new TextureAtlas("ui/blueButtons.pack");
        rightSkin = new Skin(Gdx.files.internal("ui/menuSkin.json"), rightAtlas);

        //showRight();

        showLeft();
*/
       /* table = new Table(skin);
        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //Button EASY
        buttonEasy = new TextButton("Easy", skin);
        buttonEasy.pad(20);
        buttonEasy.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new GameScreen(game));
                ButtonToggle(GameLevel.easy);
            }
        });
        //Button MEDIUM
        buttonMedium = new TextButton("Medium", skin);
        buttonMedium.pad(20);
        buttonMedium.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new GameScreen(game));
                ButtonToggle(GameLevel.medium);
            }
        });

        //Button HARD
        buttonHard = new TextButton("Hard", skin);
        buttonHard.pad(20);
        buttonHard.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new GameScreen(game));
                ButtonToggle(GameLevel.hard);
            }
        });


        //Button PLAY
        buttonPlay = new TextButton("Play", skin);
        buttonPlay.pad(20);
        buttonPlay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });

        title = new BitmapFont(Gdx.files.internal("fonts/title.fnt"));
        Label.LabelStyle headingStyle = new Label.LabelStyle(title, new Color(0, 0, 0, 1));
        heading = new Label("Euterpe", headingStyle);

        //putting all that into a table
        //table.add(heading);
        //table.getCell(heading).spaceBottom(200);
        table.row();
        table.add(buttonEasy);
        table.getCell(buttonEasy).spaceBottom(20);
        //table.row();
        table.add(buttonMedium);
        table.getCell(buttonMedium).spaceBottom(20);
        //table.row();
        table.add(buttonHard);
        table.getCell(buttonHard).spaceBottom(20);
        table.row();
        table.add(buttonPlay);
        table.getCell(buttonPlay).spaceBottom(20);
        table.debug();
        rightStage.addActor(table);*/

        /*
        LEFT STAGE
         */

        /*Label.LabelStyle headingStyle2 = new Label.LabelStyle(title, new Color(1, 1, 0, 1));
        Table table2 = new Table(skin);
        Table container = new Table(skin);
        ScrollPane scroll = new ScrollPane(table2);
        container.add(scroll).width(500f).height(500f);
        container.row();

        //LabelStyle style = new LabelStyle(Color.WHITE);
        Label label = new Label(null, headingStyle2);
        table2.add(label);
        table2.row();
        label.setAlignment(1); // align center*/

        /*TextButton exchange = new TextButton("Exchange", skin);
        exchange.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.log("clicked", "--->");
            }
        });
        ListView list = new ListView(new String[] { "  data1  ", "  data2  ",
                "  data3  ", "  data4  ", "  data5  ", "  data6  ",
                "  data7  ", "  data8  ", "  data9  ", "  data10  ",
                "  data11  ", "  data12  ", "  data13  ", "  data14  ",
                "  data15  ", "  data16  ", "  data17  " },
                skin.get(ListStyle.class), exchange, Color.CYAN, 1);

        ScrollPane scrollPane = new ScrollPane(list);
        scrollPane.setWidth(Gdx.graphics.getWidth());
        scrollPane.setHeight(Gdx.graphics.getHeight());
        ListStyle style = list.getStyle();
        style.selection.setRightWidth(Gdx.graphics.getWidth()
                - list.getPrefWidth());
        list.setStyle(style);
        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ListView listView, int index, String item) {
                Gdx.app.log("item", item);
            }
        });
        leftStage = new Stage();
        leftStage.addActor(scrollPane);*/

        //Button
       /* TextButton mybuttonPlay2;

        Table table2 = new Table(skin);
        table2.setBounds(0, 0, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight());

        for(int i = 0; i < 8; i++) {
            mybuttonPlay2 = new TextButton("my button" + i, skin);
            mybuttonPlay2.pad(20);
            mybuttonPlay2.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    //game.setScreen(new GameScreen(game));
                }
            });
            //leftStage.addActor(mybuttonPlay);

            table2.row();
            table2.add(mybuttonPlay2);
            table2.getCell(mybuttonPlay2).spaceBottom(20);
        }
        leftStage.addActor(table2);*/
        //Liste des fichiers musicaux
        //FileHandle[] files = Gdx.files.local("mylocaldir/").list();

       /* this.stage = new Stage();
        Gdx.input.setInputProcessor(this.stage);
        final Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
*/
      /*  final Label text = new Label("jjjjdjjjjjjjjjjjjj", skin);
        //text.setAlignment(Align.center);
        text.setWrap(true);
        final Label text2 = new Label("This is a short string!", skin);
        //text2.setAlignment(Align.center);
        text2.setWrap(true);
        final Label text3 = new Label("dfdsfqfdsdsfbhjrtjytd  grg rrgregrg ", skin);
        //text3.setAlignment(Align.center);
        text3.setWrap(true);

        final Table scrollTable = new Table();
        scrollTable.add(text);
        scrollTable.row();
        scrollTable.add(text2);
        scrollTable.row();
        scrollTable.add(text3);

        final ScrollPane scroller = new ScrollPane(scrollTable);

        //final Table table = new Table();
        //table.setFillParent(true);
        table.setFillParent(true);
        table.add(scroller).fill().expand();

        stage.addActor(table);*/
    }
    private void ButtonToggle(GameLevel lvl){

        TextButton.TextButtonStyle buttonStyleChecked = new TextButton.TextButtonStyle();
        buttonStyleChecked.font = new BitmapFont();

        TextButton.TextButtonStyle buttonStyleUnChecked = new TextButton.TextButtonStyle();
        buttonStyleUnChecked.font = new BitmapFont();

        switch (lvl){
            case easy:
                buttonEasy.setStyle(buttonStyleChecked);
                buttonMedium.setStyle(buttonStyleUnChecked);
                buttonHard.setStyle(buttonStyleUnChecked);
                break;
            case hard:
                buttonEasy.setStyle(buttonStyleUnChecked);
                buttonMedium.setStyle(buttonStyleUnChecked);
                buttonHard.setStyle(buttonStyleChecked);
                break;
            case medium:
                buttonEasy.setStyle(buttonStyleUnChecked);
                buttonMedium.setStyle(buttonStyleChecked);
                buttonHard.setStyle(buttonStyleUnChecked);
                break;
        }
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
        rightStage.dispose();
        leftStage.dispose();
        leftSkin.dispose();
        rightSkin.dispose();
        leftAtlas.dispose();
        rightAtlas.dispose();
        batch.dispose();
    }

}