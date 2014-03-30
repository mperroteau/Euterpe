package com.esgi.euterpe.Classes;

import android.text.format.Time;

/**
 * Created by Marine on 30/03/14.
 */
public class EMusic {
    int id;
    String nom;
    String artiste;
    Time duree;

    /*
    * Variables utiles dans la génération de la partie
    * */
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
}
