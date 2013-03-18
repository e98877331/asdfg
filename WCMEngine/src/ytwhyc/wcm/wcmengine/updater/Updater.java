package ytwhyc.wcm.wcmengine.updater;

public abstract class Updater {
final long MILLIS_PER_SECOND = 1000;
    float mUpdateRateInMillis;
    long totalPassedTime;
	long lastTime;
	public Updater(float rateInSecond)
	{
		
		mUpdateRateInMillis = rateInSecond * MILLIS_PER_SECOND;
		totalPassedTime = 0;
	}
	
	public void update(long timePassBy)
	{
		
		totalPassedTime  += timePassBy;
		
		while(totalPassedTime > mUpdateRateInMillis)
		{
			doUpdate();
			totalPassedTime -= mUpdateRateInMillis;
		}
		
		
	}
	
	public abstract void doUpdate();
	
}
