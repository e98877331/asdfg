package ytwhyc.wcm.entity;

import java.util.ArrayList;
import java.util.Iterator;

import ytwhyc.wcm.wcmengine.updater.Updater;
import android.graphics.Canvas;


public abstract class AEntitiy {

	ArrayList<Updater> mUpdaterList = new ArrayList<Updater>();
	
	
	public abstract void draw(Canvas pCanvas);


	
	public abstract void addUpdater(Updater pUpdater);
	public abstract void update(long timePassBy);
	
}
