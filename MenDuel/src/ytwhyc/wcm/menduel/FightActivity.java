package ytwhyc.wcm.menduel;

import java.util.ArrayList;

import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.engine.LayoutParamsType;
import ytwhyc.wcm.engine.MeasureRatioScreenPolicy;
import ytwhyc.wcm.entity.BitmapEntity;
import ytwhyc.wcm.entity.Scene;
import ytwhyc.wcm.surfaceview.WCMSurfaceView;
import ytwhyc.wcm.wcmengine.activity.WCMActivity;
import ytwhyc.wcm.wcmengine.bitmap.WCMBitmap;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Window;

public class FightActivity extends WCMActivity{

	
	/*
	 * Field
	 */
	Engine mEngine;
	WCMSurfaceView mSurfaceView;	
	
	
	Enemy mEnemy;
	/*
	 * Override Methods
	 */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	
		mEngine = new Engine(this);
		mEngine.setScreenPolicy(new MeasureRatioScreenPolicy(480,720, true));
		//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView();
//		

		

	}
	
	@Override
	public void onResourceCreate() {
		// TODO Auto-generated method stub
		super.onResourceCreate();
		
		
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
		
		Bitmap bitmap;
	    bitmap=((BitmapDrawable)getResources().getDrawable(R.drawable.bg_common_5_6_7)).getBitmap();
	    
	    WCMBitmap wb = new WCMBitmap(mEngine, bitmap, 480, 720);
		//bitmap = BitmapFactory.decodeResource(getResources(), ytwhyc.wcm.wcmengine.R.drawable.bg_common_5_6_7);
		Scene bg = new Scene(mEngine, wb, 0,0);
	    
		bitmap=((BitmapDrawable)getResources().getDrawable(R.drawable.ic_launcher)).getBitmap();
		WCMBitmap oBitmap = new WCMBitmap(mEngine, bitmap, 200, 300);
		
		//BitmapEntity testObject = new BitmapEntity(mEngine,bitmap,50,50,50,50);
		
//		ArrayList<BitmapEntity> tests = new ArrayList<BitmapEntity>();
//		
//		for(int i  = 0 ;i < 10000 ;i ++)
//		{
//			tests.add(new BitmapEntity(mEngine, oBitmap, 480, 20*i));
//			tests.add(new BitmapEntity(mEngine, oBitmap, 10*i,680-(20*i)));
//			bg.addChild(tests.get(i));	
//		}
	
		
		
		
		mEnemy = new Enemy(mEngine, oBitmap, 240, 360);
		
		 bitmap=((BitmapDrawable)getResources().getDrawable(R.drawable.bg_common_5_6_7)).getBitmap();
			WCMBitmap ohit = new WCMBitmap(mEngine, bitmap, 200, 300);
		mEnemy.setHurtBitmap(ohit);
		//mEnemy.setHurtBitmap(pB);
		
	bg.addChild(mEnemy);
		mEngine.setScene(bg);
		
	}
	
	/*
	 * Methods
	 */
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if(event.getAction() == MotionEvent.ACTION_DOWN)
		{
			mEnemy.onHit();
			//mEngine.onPause();
		}
		
		return super.onTouchEvent(event);
	}
	
	private void setContentView()
	{
	 
		mSurfaceView = new WCMSurfaceView(this,mEngine);
		this.setContentView(mSurfaceView,mEngine.getScreenPolicy().getLayoutParams(LayoutParamsType.LAYOUT_CENTER));

		
	}
	
	
}
