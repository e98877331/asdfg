package ytwhyc.wcm.surfaceview;

import ytwhyc.wcm.engine.Engine;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class WCMSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

	/*
	 * Field
	 */
	private Engine mEngine = Engine.getShareInstance();
	private SurfaceHolder mHolder;
	private SurfaceViewThread mSurfaceViewThread;
	
	/*
	 * Constructor
	 */
	public WCMSurfaceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mHolder = this.getHolder();
		
	}
  
	/*
	 * Override functions
	 */
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		mEngine.screenPolicy.onMeasure(this, widthMeasureSpec, heightMeasureSpec);
		
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
		Canvas canvas = mHolder.lockCanvas(null);
		
		canvas.drawColor(Color.BLUE);
		
		Paint paint = new Paint();
		paint.setColor(Color.GRAY);
		canvas.drawCircle(temptest, 20, 5, paint);
		
	    mHolder.unlockCanvasAndPost(canvas);
	}
	
	
	/*
	 * SurfaceView draw threak
	 */
	
	class SurfaceViewThread extends Thread
	{
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			temptest++;
			WCMSurfaceView.this.draw();
		}
		
	}
	
}
