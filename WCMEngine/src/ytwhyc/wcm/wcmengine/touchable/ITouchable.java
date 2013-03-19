package ytwhyc.wcm.wcmengine.touchable;

import android.view.MotionEvent;

public interface  ITouchable {
	
	public  void onTouch(MotionEvent event);
	public  boolean IsInRegion(float x,float y);
	public void touch(MotionEvent event);
    
	
	
}
