package ytwhyc.wcm.engine;

import ytwhyc.wcm.entity.Scene;
import android.graphics.Canvas;

public class Engine {
	
//	private static Engine mInstance;
	
	/*
	 * Fields
	 */
	Scene mScene;
	
	
	public BaseScreenPolicy mScreenPolicy;
	
	/*
	 * Constructors
	 */
	
	public Engine()
	{
		//Todo: should settle outside engine
		//screenPolicy = new MeasureRatioScreenPolicy(1.6f,true);
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
	
//	public static Engine getShareInstance()
//	{
//		if(mInstance == null)
//		{
//			mInstance = new Engine();
//		}
//		return mInstance;
//	}
	

}
