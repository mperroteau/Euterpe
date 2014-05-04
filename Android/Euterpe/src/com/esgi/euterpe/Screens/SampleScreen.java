package com.esgi.euterpe.Screens;

import android.content.Context;
import android.util.Log;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.esgi.euterpe.Classes.EGame;

/**
 * Created by Marine on 05/12/13.
 */
public class SampleScreen implements Screen {

    private Context context;

    public SampleScreen(Context _context){
        this.context = context;
    }

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
            //Music mp3Music;
            //mp3Music = Gdx.audio.newMusic(Gdx.files.internal("musics/bj_sevensisters.mp3"));

            //TODO test de l'audio sans librairies : impossible d'accéder aux musiques hors d'un activité (problème)
            context.getApplicationContext();
            Log.v("Euterpe", "Context : "+context.getApplicationContext().getAssets().getLocales().toString());
            /*
            try {

                //FileInputStream fis = new FileInputStream("musics/bj_sevensisters.mp3");
                URL url = getClass().getResource("/musics/bj_sevensisters.mp3");
                File f = new File(url.toURI());
                FileInputStream fis = new FileInputStream(f);

                Log.v("Euterpe", "A lu ou a pu lire le fichier dans le dossier assets");

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum);
                    Log.v("Euterpe", "read " + readNum + "bytes");
                }
                byte[] bytes = bos.toByteArray();

                Log.v("Euterpe", "A pu passer l'analyse du tableau de bytes");

            } catch (FileNotFoundException e) {
                Log.v("Euterpe", "Erreur : Fichier non trouvé");
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            */






            /*
            try {
                Log.v("Euterpe", g.getSpectrum("musics/bj_sevensisters.mp3"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            */
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
