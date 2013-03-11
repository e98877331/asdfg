package ytwhyc.wcm.entity;

import java.util.ArrayList;
import java.util.List;

import ytwhyc.wcm.engine.Engine;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ArrayAdapter;

public class Scene extends BitmapEntity {

	
	/*
	 * Fields
	 */
	
	
	List<BitmapEntity> childs;
	
	/*
	 * Constructor
	 */
	public Scene(Engine pEngine, Bitmap pBitmap, int pX, int pY, int pVWeight,int pVHeight
			) {
		super(pEngine, pBitmap, pX, pY, pVWeight,pVHeight );
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
		pCanvas.drawBitmap(mBitmap, mPositionX, mPositionY, null);
		
		//draw childs
		for(int i = 0 ; i< childs.size(); i++)
		{
			childs.get(i).draw(pCanvas);
		}
		
		
	}
	
	public void updateAll(int timePassBy)
	{
		update(timePassBy);
		for(int i= 0;i < childs.size();i++)
		{
			childs.get(i).update(timePassBy);
		}
		
	}

	@Override
	public void update(int timePassBy) {
		// TODO Auto-generated method stub
		super.update(timePassBy);
	}

	/*
     *  Functions
     */

	public void addChild(BitmapEntity pChild)
	{
		childs.add(pChild);
	}
	

}
