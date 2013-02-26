package ytwhyc.wcm.engine;

public class Engine {
	
	private static Engine mInstance;
	
	public ScreenMeasureRatioPolicy screenPolicy;
	
	private Engine()
	{
		//Todo: should settle outside engine
		screenPolicy = new ScreenMeasureRatioPolicy(1.6f,true);
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
