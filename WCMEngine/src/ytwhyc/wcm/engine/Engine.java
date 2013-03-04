package ytwhyc.wcm.engine;

public class Engine {
	
//	private static Engine mInstance;
	
	public BaseScreenPolicy mScreenPolicy;
	
	public Engine()
	{
		//Todo: should settle outside engine
		//screenPolicy = new MeasureRatioScreenPolicy(1.6f,true);
	}
	
	public void setScreenPolicy(BaseScreenPolicy pBSP)
	{
		mScreenPolicy = pBSP;
	}
	
	public BaseScreenPolicy getScreenPolicy()
	{
		return mScreenPolicy;
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
