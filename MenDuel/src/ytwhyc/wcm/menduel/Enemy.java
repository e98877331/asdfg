package ytwhyc.wcm.menduel;

import java.util.ArrayList;

import android.graphics.Bitmap;
import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.entity.Sprite;
import ytwhyc.wcm.wcmengine.bitmap.WCMBitmap;

public class Enemy extends Sprite {

	int tickCounter;
	
	boolean hitting;
	
WCMBitmap  mHurtBitmap;
WCMBitmap mNormalBitmap;
	
	public Enemy(Engine pEngine, WCMBitmap pWCMBitmap, int pX, int pY) {
		super(pEngine, pWCMBitmap, pX, pY);
		// TODO Auto-generated constructor stub
		tickCounter = 0;
		hitting = false;
		
		mNormalBitmap = pWCMBitmap;
	}
	
	public void setHurtBitmap(WCMBitmap pB)
	{
		mHurtBitmap = pB;
	}
	
    public void onHit()
    {
    	hitting = true;
    	mWCMBitmap = mHurtBitmap;
    }
	
    @Override
    public void update(long timePassBy) {
    	// TODO Auto-generated method stub
    	super.update(timePassBy);
    	
    	if(hitting)
    	{
           tickCounter++;
           if(tickCounter > 1)
           {
        	   mWCMBitmap =mNormalBitmap;
        	   hitting = false;
        	   tickCounter = 0;
           }
   
        	   
    	}
    }
    
    

}
