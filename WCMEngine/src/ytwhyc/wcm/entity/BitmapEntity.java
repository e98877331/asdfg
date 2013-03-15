package ytwhyc.wcm.entity;

import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.wcmengine.bitmap.WCMBitmap;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;


public class BitmapEntity implements IEntitiy {

	
	/*
	 * Fields
	 */
	protected Engine mEngine;
	
	protected WCMBitmap mWCMBitmap;
	
	protected int mPositionX,mPositionY;
	
	/*
	 * Constructor
	 */
	
	public BitmapEntity(Engine pEngine,WCMBitmap pBitmap,int pX, int pY)
	{
		mEngine = pEngine;
		mPositionX = pX;
		mPositionY = pY;
	   
		mWCMBitmap = pBitmap;
	   
	}
	
//    public BitmapEntity(Engine pEngine,Resources pResource,int pResID,int pX,int pY,int pVWidth,int pVHeight)
//    {
//    	mEngine = pEngine;
//    	initCoordinateData(pX,pY,pVWidth,pVHeight);
//
//    	mBitmap = BitmapFactory.decodeResource(pResource, pResID);
//    	mBitmap = getScaledBitmap(mBitmap,pVWidth, pVHeight);
//    	
//    }
    /*
     * Override methods
     */
    
	@Override
	public void draw(Canvas pCanvas) {
		// TODO Auto-generated method stub
		pCanvas.drawBitmap(mWCMBitmap.getBitmap(), mPositionX*mEngine.getScreenPolicy().wscale, mPositionY*mEngine.getScreenPolicy().hscale, null);   
		//pCanvas.drawbit

		
	}

	@Override
	public void update(long timePassBy) {
		// TODO Auto-generated method stub
		
	}
    
    
	
	/*
	 * Functions
	 */
    
    
    public int getWidth()
    {
    	return mWCMBitmap.getWidth();
    }
    
    public int getHeight()
    {

    	return mWCMBitmap.getHeight();
    }
	
    
    


}
