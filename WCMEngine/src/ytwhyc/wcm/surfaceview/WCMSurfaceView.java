package ytwhyc.wcm.surfaceview;

import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.entity.BitmapEntity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class WCMSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

	/*
	 * Field
	 */
	//private Engine mEngine = Engine.getShareInstance();
	private SurfaceHolder mHolder;
	private Engine mEngine;
	Paint paint = new Paint();
	
	
	BitmapEntity testObject;
	/*
	 * Constructor
	 */
	public WCMSurfaceView(Context context, Engine pEngine) {
		super(context);
		// TODO Auto-generated constructor stub
		mHolder = this.getHolder();
		mHolder.addCallback(this);
		mEngine = pEngine;
	
		mEngine.setDrawingView(this);
		
	}
  
	/*
	 * Override functions
	 */
	
	@SuppressLint("WrongCall")
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			
		mEngine.getScreenPolicy().onMeasure(this, widthMeasureSpec, heightMeasureSpec);	

	}
	
	/*
	 *  SurfaceHolder.Callback override function
	 */
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		mEngine.onSurfaceReady();

//		Bitmap bitmap;
//	    bitmap=((BitmapDrawable)getResources().getDrawable(ytwhyc.wcm.wcmengine.R.drawable.bg_common_5_6_7)).getBitmap();
//		//bitmap = BitmapFactory.decodeResource(getResources(), ytwhyc.wcm.wcmengine.R.drawable.bg_common_5_6_7);
//		
//		testObject = new BitmapEntity(mEngine,bitmap,0,0,480,720);

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Methods
	 */
	public void setMeasuredDimensionProxy(final int pMeasuredWidth,final int pMeasuredHeight)
	{
		this.setMeasuredDimension(pMeasuredWidth, pMeasuredHeight);
		
		
		
	}
	
//	public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth)
//	{
//	    int width = bm.getWidth();
//	    int height = bm.getHeight();
//	    float scaleWidth = ((float) newWidth) / width;
//	    float scaleHeight = ((float) newHeight) / height;
//	    // create a matrix for the manipulation
//	    Matrix matrix = new Matrix();
//	    // resize the bit map
//	    matrix.postScale(scaleWidth, scaleHeight);
//	    // recreate the new Bitmap
//	    Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
//	    return resizedBitmap;
//	}
//	
	float temptest = 0;
	
	public void draw()
	{
		long time = System.currentTimeMillis();
		
		temptest+=2;
		if(mHolder == null)
			return;
		Canvas canvas = mHolder.lockCanvas();
        if(canvas == null)
        	return;
		
		
		canvas.drawColor(Color.GRAY);
		 

		 if(canvas!= null && mEngine != null)
		 mEngine.draw(canvas);
		 
		
//		for(int i =0 ;i < 50;i++)
//		{
//			
//		//canvas.drawBitmap(bm2, 50, 50+2*i, paint);
//		//canvas.
//		
//		
//		}
		
	
	   
		 time = System.currentTimeMillis() - time;
		//Paint paint = new Paint();
		paint.setColor(Color.GREEN);
		canvas.drawText("FPS:" +Integer.toString((int)((float)1000/time)),200, 400, paint);
		
		canvas.drawCircle(temptest, 20, 5, paint);
		if(temptest > 500)
			temptest = 0;
		
	    mHolder.unlockCanvasAndPost(canvas);
	}
	
	
	
}
