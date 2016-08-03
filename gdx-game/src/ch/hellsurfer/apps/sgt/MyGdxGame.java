package ch.hellsurfer.apps.sgt;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import android.location.*;
import android.os.*;
import com.badlogic.gdx.math.*;

public class MyGdxGame implements ApplicationListener
{
	public MyGdxGame(LocationManager lm)
	{
		this.lm = lm;
	}
	LocationManager lm;
	Texture texture;
	SpriteBatch batch;
	BitmapFont fnt;
	SwissGridCoordinates c;
	public Location track()
	{
		return lm.getLastKnownLocation(lm.GPS_PROVIDER);
	}

	
	//Location loc = lm.getLastKnownLocation(lm.GPS_PROVIDER);
	@Override
	public void create()
	{
		texture = new Texture(Gdx.files.internal("android.jpg"));
		fnt = new BitmapFont(Gdx.files.internal("lcd.fnt"));
		batch = new SpriteBatch();
		
	}

	@Override
	public void render()
	{
		c=SwissGridCoordinates.fromGPS(track());
	    Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.draw(texture, Gdx.graphics.getWidth() / 4, 0, 
				   //Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() / 2);
		fnt.draw(batch, c.toString(), 10, 100);
		batch.end();
	}

	@Override
	public void dispose()
	{
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
}
