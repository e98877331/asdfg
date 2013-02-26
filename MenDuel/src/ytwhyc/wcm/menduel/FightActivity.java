package ytwhyc.wcm.menduel;

import ytwhyc.wcm.surfaceview.WCMSurfaceView;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;

public class FightActivity extends Activity {

	
	/*
	 * Field
	 */
	WCMSurfaceView mSurfaceView;	
	
	/*
	 * Override Methods
	 */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView();
	}
	
	/*
	 * Methods
	 */
	private void setContentView()
	{
		mSurfaceView = new WCMSurfaceView(this);
		final LayoutParams layoutParams = new LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		layoutParams.gravity = Gravity.CENTER;
		this.setContentView(mSurfaceView,layoutParams);
	}
	
	
}
