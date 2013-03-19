package ytwhyc.wcm.entity;

import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.wcmengine.bitmap.WCMBitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;


public class BitmapEntity extends AEntitiy {

	
	/*
	 * Fields
	 */
	protected Engine mEngine;
	
	protected WCMBitmap mWCMBitmap;
	
	
	
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
	    if(mWCMBitmap == null)
	    	return;
	    Matrix rotator = new Matrix();
	    rotator.postRotate(45);
	    rotator.postTranslate(mPositionX*mEngine.getScreenPolicy().wscale, mPositionY*mEngine.getScreenPolicy().hscale);
	    pCanvas.drawBitmap(mWCMBitmap.getBitmap(), rotator, null);
	    
	    
		//pCanvas.drawBitmap(mWCMBitmap.getBitmap(), mPositionX*mEngine.getScreenPolicy().wscale, mPositionY*mEngine.getScreenPolicy().hscale, null);   
		//pCanvas.drawbit

		
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
