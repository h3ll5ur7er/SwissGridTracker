package ch.hellsurfer.apps.sgt;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import android.location.*;
import android.content.*;

public class MainActivity extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		LocationManager lm =(LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        
        initialize(new MyGdxGame(lm), cfg);
    }
}
