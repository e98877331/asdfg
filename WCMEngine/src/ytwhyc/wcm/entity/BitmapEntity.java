package ytwhyc.wcm.entity;

import ytwhyc.wcm.engine.Engine;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;


public class BitmapEntity implements IEntitiy {

	
	/*
	 * Fields
	 */
	protected Engine mEngine;
	
	protected Bitmap mBitmap;
	
	protected int mPositionX,mPositionY;
	protected int mVirtualWidth,mVirtualHeight;
	
	protected float mScaleX,mScaleY;
	
	/*
	 * Constructor
	 */
	
	public BitmapEntity(Engine pEngine,Bitmap pBitmap,int pX, int pY,int pVWidth,int pVHeight )
	{
		mEngine = pEngine;
		initCoordinateData(pX,pY,pVWidth,pVHeight);
	   
		mBitmap = getScaledBitmap(pBitmap,pVWidth, pVHeight);
	   
	}
	
    public BitmapEntity(Engine pEngine,Resources pResource,int pResID,int pX,int pY,int pVWidth,int pVHeight)
    {
    	mEngine = pEngine;
    	initCoordinateData(pX,pY,pVWidth,pVHeight);

    	mBitmap = BitmapFactory.decodeResource(pResource, pResID);
    	mBitmap = getScaledBitmap(mBitmap,pVWidth, pVHeight);
    	
    }
    /*
     * Override methods
     */
    
	@Override
	public void draw(Canvas pCanvas) {
		// TODO Auto-generated method stub
		pCanvas.drawBitmap(mBitmap, mPositionX*mScaleX, mPositionY*mScaleY, null);                                                                                                                                       
		
		
	}

	@Override
	public void update(long timePassBy) {
		// TODO Auto-generated method stub
		
	}
    
    
	
	/*
	 * Functions
	 */
    public void initCoordinateData(int pPositionX,int pPositionY,int pW, int pH)
    {
    	mPositionX = pPositionX;
    	mPositionY =pPositionY;
    	mVirtualWidth = pW;
    	mVirtualHeight = pH;
    	
    	 mScaleX = mEngine.getScreenPolicy().getWScale();
    	 mScaleY = mEngine.getScreenPolicy().getHScale();
    }
    
	
    
    private Bitmap getScaledBitmap(Bitmap pBitmap, int pVWeight,int pVHeight)
    {

    	
    	return Bitmap.createScaledBitmap(pBitmap, (int)(pVWeight*mScaleX), (int)(pVHeight*mScaleY), false);
    	
    }
    
    
    public int getWidth()
    {
    	return mVirtualWidth;
    }
    
    public int getHeight()
    {

    	return mVirtualHeight;
    }
	
    
    


}
