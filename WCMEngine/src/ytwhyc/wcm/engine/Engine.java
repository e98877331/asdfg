package ytwhyc.wcm.engine;

public class Engine {
	
	private static Engine mInstance;
	
	public ScreenMeasureRatioPolicy screenPolicy;
	
	private Engine()
	{
		screenPolicy = new ScreenMeasureRatioPolicy();
	}
	
	
	
	
	public static Engine getShareInstance()
	{
		if(mInstance == null)
		{
			mInstance = new Engine();
		}
		return mInstance;
	}
	

}
