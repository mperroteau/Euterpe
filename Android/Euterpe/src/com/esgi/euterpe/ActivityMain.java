package com.esgi.euterpe;

import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

/**
 * Created by Marine on 05/12/13.
 */
public class ActivityMain extends AndroidApplication {
    //AndroidApplication est une Activity qui implemente intilialize (gdx)

    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        //Log.v("TEST", "ActivityMain");
        AndroidApplicationConfiguration appConfig = new AndroidApplicationConfiguration();
        appConfig.useGL20 = true;
        appConfig.useWakelock = true;

        initialize(new GameCore(), appConfig);


    }
}
