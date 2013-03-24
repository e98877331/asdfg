package ytwhyc.wcm.engine;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

import ytwhyc.wcm.entity.Scene;
import ytwhyc.wcm.surfaceview.WCMSurfaceView;
import ytwhyc.wcm.wcmengine.activity.WCMActivity;
import ytwhyc.wcm.wcmengine.touchable.ITouchable;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class Engine {
	
//	private static Engine mInstance;
	
	/*
	 * Fields
	 */
	Scene mScene;
	
	UpdateThread mUpdateThread;
	WeakReference<WCMActivity> wrContext;
	WCMSurfaceView mSurfaceView;
	
	ArrayList<ITouchable> touchableList = new ArrayList<ITouchable>();
	
	
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
	
	public Context getContext()
	{
		return wrContext.get();
	}
	
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
	
	public void registTouchable(ITouchable touchable)
	{
		touchableList.add(touchable);
	}
	public void unregistTouchable(ITouchable touchable)
	{
		touchableList.remove(touchable);
	}
	
	public void unregistAllTouchable()
	{
		touchableList = new ArrayList<ITouchable>();
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
	
	public void onTouch(MotionEvent event)
	{
	    Iterator<ITouchable> it = touchableList.iterator();
	    while(it.hasNext())
	    {
	    	it.next().onTouch(event);
	    }
	}
	
	public void onSurfaceReady()
	{
		wrContext.get().onResourceCreate();
		wrContext.get().onSurfaceReady();
		
		
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
