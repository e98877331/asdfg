package ytwhyc.wcm.menduel;

import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.engine.LayoutParamsType;
import ytwhyc.wcm.engine.MeasureRatioScreenPolicy;
import ytwhyc.wcm.surfaceview.WCMSurfaceView;
import android.app.Activity;
import android.content.pm.ActivityInfo;
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
		mEngine.setScreenPolicy(new MeasureRatioScreenPolicy(720,480, true));
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
	}
	
	
}
