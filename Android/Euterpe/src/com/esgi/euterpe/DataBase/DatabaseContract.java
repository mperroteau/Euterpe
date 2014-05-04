package com.esgi.euterpe.DataBase;

import android.provider.BaseColumns;

/**
 * Created by Marine on 01/05/14.
 */
public class DatabaseContract {

    public DatabaseContract(){}

    //TODO Peut attendre, lancer les parties à la volée à l'aide de listes d'items le temps de terminer les bases de données
    //Cependant : !! Bases de données indispensables pour les scores

    public static abstract class GameBase implements BaseColumns {
        public static final String TABLE_NAME = "score";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_MUSIC = "music";
    }
/*
    public static abstract class ItemBase implements BaseColumns {
        public static final String TABLE_NAME = "score";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_LEVEL = "level";
        public static final String COLUMN_NAME_TIMER = "timer";
        public static final String COLUMN_NAME_TIME = "time";
        public static final String COLUMN_NAME_MOVE = "move";
        public static final String COLUMN_NAME_WIN = "win";
        public static final String COLUMN_NAME_BONUS = "bonus";
        public static final String COLUMN_NAME_POINT = "point";
    }*/
}
