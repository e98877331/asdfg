package ytwhyc.wcm.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ytwhyc.wcm.wcmengine.updater.Updater;
import android.graphics.Canvas;

public class Entity extends AEntitiy{

	public int mPositionX,mPositionY;
	
	List<Entity> childs = new ArrayList<Entity>();
	
	/*
	 * override methods
	 * 
	 */
	
	@Override
	public void draw(Canvas pCanvas) {
		// TODO Auto-generated method stub
		
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
	
	
	public void drawAll(Canvas pCanvas)
	{

		for(int i = 0 ; i< childs.size(); i++)
		{
			childs.get(i).drawAll(pCanvas);
		}
		
	}
	
	public void updateAll(long timePassBy)
	{
		update(timePassBy);
		for(int i= 0;i < childs.size();i++)
		{
			childs.get(i).updateAll(timePassBy);
		}
		
	}
	
	
/*
 * functions
 */
	public int getX()
	{
		return mPositionX;
	}
	
	public int getY()
	{
		return mPositionY;
	}
	
	
	public void addChild(Entity pChild)
	{
		childs.add(pChild);
	}
	
	public void removeChild(Entity pChild)
	{
		childs.remove(pChild);
	}
	
	
	public void removeAllChilds()
	{
		childs = new ArrayList<Entity>();
	}
	
	
	
}
