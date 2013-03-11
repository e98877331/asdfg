package ytwhyc.wcm.engine;

import java.lang.ref.WeakReference;

import ytwhyc.wcm.entity.Scene;
import ytwhyc.wcm.surfaceview.WCMSurfaceView;
import ytwhyc.wcm.wcmengine.activity.WCMActivity;
import android.graphics.Canvas;
import android.provider.Settings.System;

public class Engine {
	
//	private static Engine mInstance;
	
	/*
	 * Fields
	 */
	Scene mScene;
	
	WeakReference<WCMActivity> wrContext;
	
	
	public BaseScreenPolicy mScreenPolicy;
	
	/*
	 * Constructors
	 */
	
	public Engine(WCMActivity mContext)
	{
      wrContext = new WeakReference<WCMActivity>(mContext);
	}
	
	/*
	 * Functions
	 */
	
	public void setScreenPolicy(BaseScreenPolicy pBSP)
	{
		mScreenPolicy = pBSP;
	}
	
	public BaseScreenPolicy getScreenPolicy()
	{
		return mScreenPolicy;
	}
	
    public void setScene(Scene pScene)
    {
    	mScene = pScene;
    }
	
	public void draw(Canvas pCanvas)
	{
		if(mScene != null)
		{
			mScene.draw(pCanvas);
		}
	}
	
	public void onSurfaceReady()
	{
		wrContext.get().onSurfaceReady();
	}
	
	
	
//	public static Engine getShareInstance()
//	{
//		if(mInstance == null)
//		{
//			mInstance = new Engine();
//		}
//		return mInstance;
//	}
	
	class UpdateThread extends Thread {
		boolean loop = true;
long lastTick;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			//Log.e("hehehe","ddfd");
			
			lastTick = java.lang.System.currentTimeMillis();
			while (loop) {

				lastTick = java.lang.System.currentTimeMillis() - lastTick;
//				try {
//					sleep(20);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				mScene.updateAll(timePassBy);
				//Log.e("hehehe","ddfd");
			}
		}

	}
	

}//end of engine
