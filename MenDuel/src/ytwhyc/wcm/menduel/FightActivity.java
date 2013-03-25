package ytwhyc.wcm.menduel;

import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.engine.LayoutParamsType;
import ytwhyc.wcm.engine.MeasureRatioScreenPolicy;
import ytwhyc.wcm.entity.Scene;
import ytwhyc.wcm.surfaceview.WCMSurfaceView;
import ytwhyc.wcm.wcmengine.activity.WCMActivity;
import ytwhyc.wcm.wcmengine.bitmap.WCMBitmap;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;

public class FightActivity extends WCMActivity{

	final int virtualWidth = 540;
	final int virtualHeight = 888;
	/*
	 * Field
	 */
	Engine mEngine;
	WCMSurfaceView mSurfaceView;	
	
	WCMBitmap wbg,wenemy,wenemyOnHit,wenemyLife;
	
	Enemy mEnemy;
	PowerBar mPowerbar;
	/*
	 * Override Methods
	 */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	
		
//		Display display = getWindowManager().getDefaultDisplay();
//		Point size = new Point();
//		display.getSize(size);
//		int width = size.x;
//		int height = size.y;
		
		//asus padfone 1 width: 540, height:888
		
		mEngine = new Engine(this);
		mEngine.setScreenPolicy(new MeasureRatioScreenPolicy(virtualWidth,virtualHeight, true));
		//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView();
//		

		

	}
	
	@Override
	public void onResourceCreate() {
		// TODO Auto-generated method stub
		super.onResourceCreate();
		
		Bitmap bitmap;
		bitmap=((BitmapDrawable)getResources().getDrawable(R.drawable.bg_common_5_6_7)).getBitmap();
		wbg =new WCMBitmap(mEngine, bitmap, virtualWidth, virtualHeight);
		
		wenemyOnHit = new WCMBitmap(mEngine, bitmap, 300, 600);
		
		bitmap=((BitmapDrawable)getResources().getDrawable(R.drawable.ic_launcher)).getBitmap();
		wenemy = new WCMBitmap(mEngine, bitmap, 300, 600);
		wenemyLife = new WCMBitmap(mEngine, bitmap, virtualWidth, virtualHeight);
		
		
		
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		mEngine.onResume();
	}
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		mEngine.onPause();
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		mEngine.onPause();
	}
	
	@Override
	public void onSurfaceReady() {
		// TODO Auto-generated method stub

		Scene bg = new Scene(mEngine, wbg, 0,0);
	    
		mEnemy = new Enemy(mEngine, wenemy, 0, 0);
		mEnemy.setPosition(virtualWidth/2 - mEnemy.getWidth()/2, virtualHeight - mEnemy.getHeight());
		
		
		mPowerbar = new PowerBar(mEngine, null, 0, 0);
		
		mEnemy.mPowerbar = mPowerbar;
		mEnemy.setHurtBitmap(wenemyOnHit);
		//mEnemy.setHurtBitmap(pB);
		mEngine.registTouchable(mEnemy);
		bg.addChild(mEnemy);
		bg.addChild(mPowerbar);
		mEngine.setScene(bg);
		
	}
	
	/*
	 * Methods
	 */
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub

			mEngine.onTouch(event);
		
		return super.onTouchEvent(event);
	}
	
	private void setContentView()
	{
	 
		mSurfaceView = new WCMSurfaceView(this,mEngine);
		this.setContentView(mSurfaceView,mEngine.getScreenPolicy().getLayoutParams(LayoutParamsType.LAYOUT_CENTER));

		
	}
	
	
}
