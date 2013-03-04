package ytwhyc.wcm.engine;

import ytwhyc.wcm.surfaceview.WCMSurfaceView;
import android.view.Gravity;
import android.widget.FrameLayout.LayoutParams;


public abstract class BaseScreenPolicy {
//public int ddf;
	public enum layoutParamsType {LAYOUT_CENTER};
	public abstract void onMeasure(WCMSurfaceView pView,final int pWidthMeasureSpec, final int pHeightMeasureSpec);
	
	public LayoutParams getLayoutParams(LayoutParamsType type)
	{
		LayoutParams layoutParams = new LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		if(type == LayoutParamsType.LAYOUT_CENTER)
		{
			layoutParams = new LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT);
			layoutParams.gravity = Gravity.CENTER;
			
		}
		return layoutParams;
	}
	
}
