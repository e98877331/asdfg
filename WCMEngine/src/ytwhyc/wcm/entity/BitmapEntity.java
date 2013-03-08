package ytwhyc.wcm.entity;

import ytwhyc.wcm.engine.Engine;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;


public class BitmapEntity implements IEntitiy {

	protected Engine mEngine;
	
	protected Bitmap mBitmap;
	
	public int mPositionX,mPositionY;
	
	public BitmapEntity(Engine pEngine,Bitmap pBitmap,int pX, int pY,int pVHeight,int pVWeight )
	{
		mEngine = pEngine;
	   mBitmap = getScaledBitmap(pBitmap, pVHeight, pVWeight);
	   init(pX,pY);
	   
	}
	
    public BitmapEntity(Engine pEngine,Resources pResource,int pResID,int pX,int pY,int pVHeight,int pVWeight)
    {
    	mEngine = pEngine;
    	mBitmap = BitmapFactory.decodeResource(pResource, pResID);
    	mBitmap = getScaledBitmap(mBitmap, pVHeight, pVWeight);
    	init(pX,pY);
    	
    }
    
    public void init(int pPositionX,int pPositionY)
    {
    	mPositionX = pPositionX;
    	mPositionY =pPositionY;
    }
    
	
    
    private Bitmap getScaledBitmap(Bitmap pBitmap, int pVHeight, int pVWeight)
    {
    	float hScale = mEngine.getScreenPolicy().getHScale();
    	float wScale = mEngine.getScreenPolicy().getWScale();
    	
    	return Bitmap.createScaledBitmap(pBitmap, (int)(pVHeight*hScale), (int)(pVWeight*wScale), false);
    	
//	    Matrix matrix = new Matrix();
//	    // resize the bit map
//	    matrix.postScale(wScale, hScale);
//	    // recreate the new Bitmap
//	    return Bitmap.createBitmap(pBitmap, 0, 0, pBitmap.getWidth(), pBitmap.getHeight(), matrix, false);
    }
    
    
	
	@Override
	public void draw(Canvas pCanvas) {
		// TODO Auto-generated method stub
		pCanvas.drawBitmap(mBitmap, mPositionX, mPositionY, null);                                                                                                                                       
		
		
	}

	@Override
	public void update(int timePassBy) {
		// TODO Auto-generated method stub
		
	}

}
