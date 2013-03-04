package ytwhyc.wcm.surfaceview;

import ytwhyc.wcm.engine.Engine;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
	
	
	float temptest = 0;
	
	private void draw()
	{
		temptest+=5;
		Canvas canvas = mHolder.lockCanvas();
		
		canvas.drawColor(Color.GRAY);
		
		//Paint paint = new Paint();
		paint.setColor(Color.GREEN);
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
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				
				WCMSurfaceView.this.draw();
				Log.e("hehehe","ddfd");
			}
		}

	}
	
}
