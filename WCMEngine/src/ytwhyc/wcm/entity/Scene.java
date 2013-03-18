package ytwhyc.wcm.entity;

import java.util.ArrayList;
import java.util.List;

import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.wcmengine.bitmap.WCMBitmap;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Scene extends BitmapEntity {

	
	/*
	 * Fields
	 */
	
	
	List<BitmapEntity> childs;
	
	/*
	 * Constructor
	 */
	public Scene(Engine pEngine, WCMBitmap pWCMBitmap, int pX, int pY
			) {
		super(pEngine, pWCMBitmap, pX, pY);
		// TODO Auto-generated constructor stub
		
		childs = new ArrayList<BitmapEntity>();
		
	}

	/*
	 * overridefieldes
	 */

	@Override
	public void draw(Canvas pCanvas) {
		// TODO Auto-generated method stub
		//super.draw(pCanvas);
		
		//draw self
		pCanvas.drawBitmap(mWCMBitmap.getBitmap(), mPositionX, mPositionY, null);
		
		//draw childs
		for(int i = 0 ; i< childs.size(); i++)
		{
			childs.get(i).draw(pCanvas);
		}
		
		
	}
	
	public void updateAll(long timePassBy)
	{
		update(timePassBy);
		for(int i= 0;i < childs.size();i++)
		{
			childs.get(i).update(timePassBy);
		}
		
	}


	/*
     *  Functions
     */

	public void addChild(BitmapEntity pChild)
	{
		childs.add(pChild);
	}
	

}
