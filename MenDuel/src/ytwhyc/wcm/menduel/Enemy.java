package ytwhyc.wcm.menduel;

import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.entity.Sprite;
import ytwhyc.wcm.wcmengine.bitmap.WCMBitmap;
import ytwhyc.wcm.wcmengine.touchable.TouchableSprite;
import ytwhyc.wcm.wcmengine.updater.Updater;
import android.util.Log;
import android.view.MotionEvent;

public class Enemy extends TouchableSprite {

	int tickCounter;
	
	boolean hitting;
	PowerBar mPowerbar;
	
WCMBitmap  mHurtBitmap;
WCMBitmap mNormalBitmap;
	
	public Enemy(Engine pEngine, WCMBitmap pWCMBitmap, int pX, int pY) {
		super(pEngine, pWCMBitmap, pX, pY);
		// TODO Auto-generated constructor stub
		tickCounter = 0;
		hitting = false;
		
		mNormalBitmap = pWCMBitmap;
		

		this.addUpdater(new Updater(0.00001f) {
			int diff = -1;
			float rotate = 0;
			@Override
			public void doUpdate() {
				// TODO Auto-generated method stub
				
				setPosition(mPositionX += diff, mPositionY);
				setRotate(rotate+= 0.2, getWidth()/2, getHeight()/2);

				if( mPositionX < 0 || mPositionX > 400)
				{
					diff = -diff;
				}
	//Log.e("hddd",Integer.toString(mPositionX) + "  " + Integer.toString(diff));
				
				if(hitting)
				{
					tickCounter++;
				    if(tickCounter  == 1000)
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
	
    @Override
    public void touch(MotionEvent event) {
    	// TODO Auto-generated method stub
    	
		if(event.getAction() == MotionEvent.ACTION_DOWN)
		{
			//mEnemy.onHit();
    	onHit();
    	mPowerbar.addPower();
		}
    }
    

}
