package ytwhyc.wcm.entity;

import ytwhyc.wcm.wcmengine.updater.Updater;
import android.graphics.Canvas;


public abstract class AEntitiy {

	Updater mUpdater;
	public int mPositionX,mPositionY;
	
	public abstract void draw(Canvas pCanvas);

	
	public void setUpdater(Updater pUpdater)
	{
		mUpdater = pUpdater;
	}
	public void update(long timePassBy)
	{
		if(mUpdater != null)
		{
			mUpdater.update(timePassBy);
		}
	}
	
}
