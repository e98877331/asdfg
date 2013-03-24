package ytwhyc.wcm.entity;

import java.util.ArrayList;
import java.util.Iterator;

import ytwhyc.wcm.wcmengine.updater.Updater;
import android.graphics.Canvas;


public abstract class AEntitiy {

	ArrayList<Updater> mUpdaterList = new ArrayList<Updater>();
	
	public int mPositionX,mPositionY;
	
	public abstract void draw(Canvas pCanvas);

	public int getX()
	{
		return mPositionX;
	}
	
	public int getY()
	{
		return mPositionY;
	}
	
	public void addUpdater(Updater pUpdater)
	{
		mUpdaterList.add(pUpdater);
	}
	public void update(long timePassBy)
	{
		
		Iterator<Updater> it =  mUpdaterList.iterator();
		
		while(it.hasNext())
		{
			it.next().update(timePassBy);
		}
	}
	
}
