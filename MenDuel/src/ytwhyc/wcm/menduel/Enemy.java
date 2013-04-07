package ytwhyc.wcm.menduel;

import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.wcmengine.bitmap.WCMBitmap;
import ytwhyc.wcm.wcmengine.touchable.TouchableSprite;
import ytwhyc.wcm.wcmengine.updater.Updater;
import android.view.MotionEvent;
import android.widget.TextView;

public class Enemy extends TouchableSprite {
    TextView clickCounterView;
    int clickCounter =0;
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
		

		this.addUpdater(new Updater(0.000001f) {
			int diff = -1;
			
			float rotateDiff = 1;
			float rotate = 0;
			@Override
			public void doUpdate() {
				// TODO Auto-generated method stub
				
				//setPosition(mPositionX += diff, mPositionY);
				
				if(rotate <= -30)
					rotateDiff = 0.07f;
				else if( rotate >= 30)
					rotateDiff = -0.07f;
				setRotate(rotate+= rotateDiff, getWidth()/2, getHeight());

				if( mPositionX < 0 || mPositionX > 400)
				{
					diff = -diff;
				}
	//Log.e("hddd",Integer.toString(mPositionX) + "  " + Integer.toString(diff));
				
				if(hitting)
				{
					tickCounter++;
				    if(tickCounter  == 200)
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
	public void setClickCounterView(TextView pTv)
	{
		clickCounterView = pTv;
	}
	
	public void setPowerBar(PowerBar pP)
	{
		mPowerbar = pP;
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
    	clickCounter++;
    	
    	
    	
    	clickCounterView.setText("Cambo:" + Integer.toString(clickCounter));
    	
		}
    }
    

}
