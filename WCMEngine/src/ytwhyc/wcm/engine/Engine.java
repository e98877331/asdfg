package ytwhyc.wcm.engine;

import java.lang.ref.WeakReference;

import ytwhyc.wcm.entity.Scene;
import ytwhyc.wcm.surfaceview.WCMSurfaceView;
import ytwhyc.wcm.wcmengine.activity.WCMActivity;
import android.graphics.Canvas;
import android.util.Log;

public class Engine {
	
//	private static Engine mInstance;
	
	/*
	 * Fields
	 */
	Scene mScene;
	
	UpdateThread mUpdateThread;
	WeakReference<WCMActivity> wrContext;
	WCMSurfaceView mSurfaceView;
	
	
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
	public void setDrawingView(WCMSurfaceView pView)
	{
       mSurfaceView = pView;
	}
	
	public void setScreenPolicy(BaseScreenPolicy pBSP)
	{
		mScreenPolicy = pBSP;
	}
	
	public BaseScreenPolicy getScreenPolicy()
	{
		return mScreenPolicy;
	}
	
	public void onPause()
	{
		mUpdateThread.pause();
	}
	
    public void setScene(Scene pScene)
    {
    	mScene = pScene;
    }
	
	public void draw(Canvas pCanvas)
	{
		if(mScene != null)
		{
			mScene.drawAll(pCanvas);
		}
	}
	
	public void onSurfaceReady()
	{
		
		wrContext.get().onSurfaceReady();
		wrContext.get().onResourceCreate();
		
		mUpdateThread = new UpdateThread();
		mUpdateThread.start();
		//Log.e("thread","Thread Start!!");
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
        long timePassBy = 0;
        
        public UpdateThread()
        {
        	super();
        }
        
        public void pause()
        {
        	loop = false;
        }
        
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			//Log.e("hehehe","ddfd");
			
			lastTick = java.lang.System.currentTimeMillis();
			while (loop) {

				try {
					long currentTime = java.lang.System.currentTimeMillis();
					timePassBy = (currentTime - lastTick);
					lastTick = currentTime;
				
	
						mScene.updateAll(timePassBy);

					
		
					mSurfaceView.draw();
					

					//sleep(0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Log.e("hehehe","ddfd");
			}
		}

	}
	

}//end of engine
