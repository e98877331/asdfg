package ytwhyc.wcm.engine;

import android.view.View.MeasureSpec;
import ytwhyc.wcm.surfaceview.WCMSurfaceView;

public class ScreenMeasureRatioPolicy {
	
	private final float widthRatio = 768;
	private final float heightRatio = 1024;
//	private final float widthRatio = 540;
	//private final float heightRatio = 850;
	
	public float originWidth,originHeight;
	
	
	private final float mRatio;
	
	
	
	public ScreenMeasureRatioPolicy(float screenRatio,boolean isVerticle) {
		// TODO Auto-generated constructor stub
		//setting target ratio
//		mRatio = widthRatio/heightRatio;
		
	
		if(isVerticle)
			mRatio = (float)1/screenRatio;
		else
			mRatio = screenRatio;
		
			
	}
	
	public void onMeasure(WCMSurfaceView pView,final int pWidthMeasureSpec, final int pHeightMeasureSpec)
	{
		final int specWidth = MeasureSpec.getSize(pWidthMeasureSpec);
		final int specHeight = MeasureSpec.getSize(pHeightMeasureSpec);

		final float desiredRatio = this.mRatio;
		final float realRatio = (float)specWidth / specHeight;

		int measuredWidth;
		int measuredHeight;
		if(realRatio < desiredRatio) {
			measuredWidth = specWidth;
			measuredHeight = Math.round(measuredWidth / desiredRatio);
		} else {
			measuredHeight = specHeight;
			measuredWidth = Math.round(measuredHeight * desiredRatio);
		}
		
		pView.setMeasuredDimensionProxy(measuredWidth, measuredHeight);
	}

}
