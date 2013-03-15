package ytwhyc.wcm.wcmengine.bitmap;

import ytwhyc.wcm.engine.Engine;
import android.graphics.Bitmap;

public class WCMBitmap{
    Bitmap mBitmap;
	
    int mVWidth,mVHeight;
    
    float mScaleX;
    float mScaleY;
    
    /*
     * Constructor
     */
	public WCMBitmap(Engine pEngine,Bitmap pBitmap,int pVWidth,int pVHeight)
	{
		mVWidth = pVWidth;
		mVHeight = pVHeight;
   	 
		mScaleX = pEngine.getScreenPolicy().getWScale();
   	 mScaleY = pEngine.getScreenPolicy().getHScale();
   	 
   	 
   	 mBitmap = getScaledBitmap(pBitmap, pVWidth, pVHeight);
	}
	
	
	
	/*
	 * Functions
	 */
	
	public Bitmap getBitmap()
	{
		return mBitmap;
	}
	
	public int getWidth()
	{
		return mVWidth;
	}
	public int getHeight()
	{
		return mVHeight;
	}
	
    private Bitmap getScaledBitmap(Bitmap pBitmap, int pVWeight,int pVHeight)
    {

    	
    	return Bitmap.createScaledBitmap(pBitmap, (int)(pVWeight*mScaleX), (int)(pVHeight*mScaleY), false);
    	
    }
}
