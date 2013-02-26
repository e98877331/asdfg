package ytwhyc.wcm.menduel;

import ytwhyc.wcm.surfaceview.WCMSurfaceView;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

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
		
		this.setContentView(mSurfaceView);
	}
	
	
}
