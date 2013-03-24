package ytwhyc.wcm.entity;

import java.util.ArrayList;
import java.util.List;

import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.wcmengine.bitmap.WCMBitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.ViewGroup.MarginLayoutParams;


public class BitmapEntity extends AEntitiy {

	
	/*
	 * Fields
	 */
	protected Engine mEngine;
	
	protected WCMBitmap mWCMBitmap;
	
	
	List<BitmapEntity> childs = new ArrayList<BitmapEntity>();
	
	//for drawing translation
	protected Matrix matrix = new Matrix();
	float mRotateDegree =0;
	float mRotateCenterX,mRotateCenterY;
	float mScaleX =1,mScaleY =1;
	
	/*
	 * Constructor
	 */
	
	public BitmapEntity(Engine pEngine,WCMBitmap pBitmap,int pX, int pY)
	{
		mEngine = pEngine;
		mPositionX = pX;
		mPositionY = pY;
	//    setPosition(pX, pY);
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
	    
	  //  Matrix rotator = new Matrix();
	   // rotator.postRotate(45);
	   // rotator.postTranslate(mPositionX*mEngine.getScreenPolicy().wscale, mPositionY*mEngine.getScreenPolicy().hscale);
	    preDraw();
	    pCanvas.drawBitmap(mWCMBitmap.getBitmap(), matrix, null);
	    
	    
		//pCanvas.drawBitmap(mWCMBitmap.getBitmap(), mPositionX*mEngine.getScreenPolicy().wscale, mPositionY*mEngine.getScreenPolicy().hscale, null);   
		//pCanvas.drawbit

		
	}


    
    
	
	/*
	 * Functions
	 */
    //handling draw matrix
	public void preDraw()
	{
		matrix.reset();
		matrix.postScale(mScaleX, mScaleY);
		
	   matrix.postRotate(mRotateDegree,mRotateCenterX,mRotateCenterY);
	   matrix.postTranslate(mPositionX*mEngine.getScreenPolicy().wscale, mPositionY*mEngine.getScreenPolicy().hscale);
	   
	   
	}
	
	public void setPosition(int x ,int y)
	{
		mPositionX = x;
		mPositionY = y;
		//matrix.postTranslate(x*mEngine.getScreenPolicy().wscale, y*mEngine.getScreenPolicy().hscale);
	}
	
    public void setRotate(float degree,float centerX,float centerY)
    {
    	//matrix.postRotate(degree, centerX,centerY);
    	
    	mRotateCenterX = centerX;
    	mRotateCenterY = centerY;
    	mRotateDegree = degree;
    }
    
    public void setScale(float scaleX,float scaleY)
    {
    	mScaleX = scaleX;
    	mScaleY = scaleY;
    	//matrix.postScale(scaleX, scaleY);
    }
    
    public void setMatrixIdentity()
    {
    	matrix.reset();
    }
	
    public int getWidth()
    {
    	return mWCMBitmap.getWidth();
    }
    
    public int getHeight()
    {

    	return mWCMBitmap.getHeight();
    }
	
    
    
	public void drawAll(Canvas pCanvas)
	{
		//super.draw(pCanvas);
		
		//draw self
		draw(pCanvas);
		
		//draw childs
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
     *  Functions
     */

	public void addChild(BitmapEntity pChild)
	{
		childs.add(pChild);
	}
	
    


}
