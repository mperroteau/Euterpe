package com.esgi.euterpe.gen;

import android.os.Message;
import org.fmod.FMODAudioDevice;

import java.util.Timer;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by Marine on 30/03/14.
 */
public class EMusic {


    int id;
    String nom;
    String artiste;
    Timer duree;

    /**
     * Elements nécessaire au bon fonctionnement du decodage de la musique
     */

    private FMODAudioDevice fmodAudioDevice = new FMODAudioDevice();



    /*
    * Variables utiles dans la génération de la partie
    * */

    //TODO GetWaveDate sous FMOD permet de récupérer le spectre d'un fichier sans jouer la musique cf : http://web.media.mit.edu/~assaf/main.cpp

    private int[] audioData = null;
    int sampleRate = 44100;

    //En fonction du tempo et de la liste de fréquence générer la partie
    public void generateGame(int[] audioData, int frequency){


        int numSamples = audioData.length;
        int numCrossing = 0;

        //Initialiser une liste d'items


        for (int p = 0; p < numSamples-1; p++)
        {
            if ((audioData[p] > 0 && audioData[p + 1] <= 0) || (audioData[p] < 0 && audioData[p + 1] >= 0))
            {
                //En fonction des numéros suivants, définir quel item ajouter

            }
        }
    }

    // Fonction utilisée pour analyser la fréquence de la musique courante
    public int calculate(){

        int numSamples = this.audioData.length;
        int numCrossing = 0;
        for (int p = 0; p < numSamples-1; p++)
        {
            if ((this.audioData[p] > 0 && this.audioData[p + 1] <= 0) || (this.audioData[p] < 0 && this.audioData[p + 1] >= 0))
            {
                numCrossing++;
            }
        }

        float numSecondsRecorded = (float)numSamples/(float)this.sampleRate;
        float numCycles = numCrossing/2;
        float frequency = numCycles/numSecondsRecorded;

        return (int)frequency;
    }

    //Retourne une table de fréquence à analyser
    public int[] getSpectrum(){

        int numSamples = this.audioData.length;
        int[] tabFrequency = null;
        for (int p = 0; p < numSamples-1; p++)
        {
            if ((this.audioData[p] > 0 && this.audioData[p + 1] <= 0) || (this.audioData[p] < 0 && this.audioData[p + 1] >= 0)){
                tabFrequency[p] = this.audioData[p];
            }

        }

        return tabFrequency;
    }

    public void _getSpectrum(){

        fmodAudioDevice.start();
        cBegin(); //TODO Ajouter dans ce fichier et dans le fichier c++ un lien afin d'accéder au fichier : pour l'instant fichier en dur dans le code c++
        cDecode(); //TODO Faire si possible un return d'un tableau afin d'afficher les éléments

    }


    static
    {
        System.loadLibrary("fmodex");
        System.loadLibrary("main");
    }

    public native void cBegin();
    public native void cUpdate();
    public native void cEnd();
    public native void cDecode();
}
