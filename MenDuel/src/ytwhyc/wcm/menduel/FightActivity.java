package ytwhyc.wcm.menduel;

import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.engine.LayoutParamsType;
import ytwhyc.wcm.engine.MeasureRatioScreenPolicy;
import ytwhyc.wcm.entity.BitmapEntity;
import ytwhyc.wcm.entity.Scene;
import ytwhyc.wcm.surfaceview.WCMSurfaceView;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Window;

public class FightActivity extends Activity {

	
	/*
	 * Field
	 */
	Engine mEngine;
	WCMSurfaceView mSurfaceView;	
	
	/*
	 * Override Methods
	 */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	
		mEngine = new Engine();
		mEngine.setScreenPolicy(new MeasureRatioScreenPolicy(480,720, true));
		//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView();
		

		

	}
	
	/*
	 * Methods
	 */
	private void setContentView()
	{
	 
		mSurfaceView = new WCMSurfaceView(this,mEngine);
		this.setContentView(mSurfaceView,mEngine.getScreenPolicy().getLayoutParams(LayoutParamsType.LAYOUT_CENTER));
		
		
		
		
		
		Bitmap bitmap;
	    bitmap=((BitmapDrawable)getResources().getDrawable(R.drawable.bg_common_5_6_7)).getBitmap();
//		//bitmap = BitmapFactory.decodeResource(getResources(), ytwhyc.wcm.wcmengine.R.drawable.bg_common_5_6_7);
//		Scene bg = new Scene(mEngine, bitmap, 0, 0, 480, 720);
//	    
//		bitmap=((BitmapDrawable)getResources().getDrawable(R.drawable.ic_launcher)).getBitmap();
//		BitmapEntity testObject = new BitmapEntity(mEngine,bitmap,50,50,50,50);
//		
//		bg.addChild(testObject);
//		
//		mEngine.setScene(bg);
		
	}
	
	
}
