package ytwhyc.wcm.menduel;

import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.entity.Sprite;
import ytwhyc.wcm.wcmengine.bitmap.WCMBitmap;
import ytwhyc.wcm.wcmengine.updater.Updater;
import android.util.Log;

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
		
		this.setUpdater(new Updater(0.01f) {
			int diff = -4;
			@Override
			public void doUpdate() {
				// TODO Auto-generated method stub

				mPositionX += diff;
				mPositionY += diff;
				if( mPositionX < 0 || mPositionX > 400)
				{
					diff = -diff;
				}
	//Log.e("hddd",Integer.toString(mPositionX) + "  " + Integer.toString(diff));
				
				if(hitting)
				{
					tickCounter++;
				    if(tickCounter  == 10)
				    {
				    	hitting = false;
				    	mWCMBitmap = mNormalBitmap;
				    	tickCounter = 0;
				    }
					
				}
				
				
			}
		});
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
	
    
    

}
