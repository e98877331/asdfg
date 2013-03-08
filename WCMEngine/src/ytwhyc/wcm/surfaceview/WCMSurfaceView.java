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
	private SurfaceViewThread mSurfaceViewThread;
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
		
		
		mSurfaceViewThread = new SurfaceViewThread();
		mSurfaceViewThread.start();
		Log.e("hehehe","start");
		
		
		
		
		Bitmap bitmap;
	    bitmap=((BitmapDrawable)getResources().getDrawable(ytwhyc.wcm.wcmengine.R.drawable.bg_common_5_6_7)).getBitmap();
		//bitmap = BitmapFactory.decodeResource(getResources(), ytwhyc.wcm.wcmengine.R.drawable.bg_common_5_6_7);
		
		testObject = new BitmapEntity(mEngine,bitmap,12,12,480,720);

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
	
	private void draw()
	{
		temptest+=2;
		if(mHolder == null)
			return;
		Canvas canvas = mHolder.lockCanvas();
         
		
		canvas.drawColor(Color.GRAY);
		 long time = 0;

		 testObject.draw(canvas);
		time = System.currentTimeMillis() - time;
//		for(int i =0 ;i < 50;i++)
//		{
//			
//		//canvas.drawBitmap(bm2, 50, 50+2*i, paint);
//		//canvas.
//		
//		
//		}
		
	
	   

		//Paint paint = new Paint();
		paint.setColor(Color.GREEN);
		canvas.drawText(Float.toString(temptest) + " instances needs: " +Integer.toString((int)time),200, 400, paint);
		
		canvas.drawCircle(temptest, 20, 5, paint);
		
	    mHolder.unlockCanvasAndPost(canvas);
	}
	
	
	/*
	 * SurfaceView draw threak
	 */
	
	class SurfaceViewThread extends Thread {
		boolean loop = true;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			//Log.e("hehehe","ddfd");
			while (loop) {

				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				
				WCMSurfaceView.this.draw();
				//Log.e("hehehe","ddfd");
			}
		}

	}
	
}
