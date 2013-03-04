package ytwhyc.wcm.engine;

import ytwhyc.wcm.surfaceview.WCMSurfaceView;
import android.content.pm.ActivityInfo;
import android.view.View.MeasureSpec;

public class MeasureRatioScreenPolicy extends BaseScreenPolicy{
	
	//public static enum layoutParamsType {LAYOUT_CENTER};
	
    public final int virtualWidth, virtualHeight;
	public float originWidth,originHeight;
	public boolean isVerticle;
	
	
    public float mRatio;
	
	
	
	public MeasureRatioScreenPolicy(int pVH,int pVW,boolean pIsVerticle) {
		// TODO Auto-generated constructor stub
		//setting target ratio
//		mRatio = widthRatio/heightRatio;
		virtualWidth = pVW;
		virtualHeight =pVH;
		isVerticle = pIsVerticle;
	    
		mRatio = (float)virtualWidth/virtualHeight; 
		if(!isVerticle)
		{
			//setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			mRatio = 1/mRatio;
		}
			
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
