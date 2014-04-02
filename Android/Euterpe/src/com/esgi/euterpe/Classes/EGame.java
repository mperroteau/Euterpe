package com.esgi.euterpe.Classes;
import android.util.Log;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.analysis.KissFFT;
import com.badlogic.gdx.audio.io.Mpg123Decoder;
import com.badlogic.gdx.files.FileHandle;

import java.util.List;

/**
 * Created by Marine on 11/01/14.
 */
public class EGame {

    EMusic music;
    List<Item> itemList;
    Level level;

    public void Game(){
        level = new Level();
    };


    public String generateTest(String musicToGen){
        //Lancement de la partie et génération des items
        //On créer une nouvelle musique a partir d'un fichier
        Music mp3Music;
        mp3Music = Gdx.audio.newMusic(Gdx.files.internal(musicToGen));
        return mp3Music.toString();
    }

    public void generate(String musicToGen){
        Log.v("Debug", "Entrée dans la fonction generate");
        KissFFT fft = new KissFFT(2048);
        short[] samples = new short[2048];
        float[] spectrum = new float[2048];
        FileHandle externalFile = Gdx.files.external(musicToGen);
        Mpg123Decoder decoder = new Mpg123Decoder(externalFile);
        AudioDevice device = Gdx.audio.newAudioDevice(decoder.getRate(), decoder.getChannels()==1 ? true:false);

        float[] newSpectrum = new float[2048];
        System.arraycopy(spectrum, 0, newSpectrum, 0, spectrum.length);
        Log.v("Debug", "before newSpectrum");

        for (int i =0; i<newSpectrum.length; i++)
            Log.v("Sepctrum", Float.toString(newSpectrum[i]));

        //TODO Récupérer la bonne fréquence

        //TODO Remplacer ++ par la fréquence obtenue
        for (int f = 0; f<newSpectrum.length; f++){
            //TODO Affiner l'incrémentation en fonction du niveau
            itemList.add(new Item());//Ajouter des coordonnées

        }
    }

    public void pause(){
        //Met le jeu en pause
    }

    public void stop(){
        //Met fin a la partie
    }

    public void restart(){
        //relance le jeu et réinitialise tous les arguments
    }

    public void testfmod(){
        
    }

}
