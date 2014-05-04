package com.esgi.euterpe.utils;

import java.io.InputStream;

/**
 * Created by Marine on 03/05/14.
 * Interface entre le code Java et le code C++
 * Permet de faire le pont entre la librairie personnalisée (ou plutot la classe) utilisant FMOD pour décoder un fichier
 */
public class MusicDecoder {

    //TODO Tester et adapter le code C++ pour réaliser une classe permettant de récupérer le spectre d'un fichier musical sans jouer la partie audio
    //Code déjà présent

    public native void getPCMFromMP3(InputStream is);

    static {
        System.loadLibrary("euterpe.soungdecoder"); //Changer le nom de la librairie
    }

    public void getPCM(InputStream ip){
        this.getPCMFromMP3(ip);
    }
}
