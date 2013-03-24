package ytwhyc.wcm.wcmengine.touchable;

import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.entity.Sprite;
import ytwhyc.wcm.wcmengine.bitmap.WCMBitmap;
import android.view.MotionEvent;

public abstract class TouchableSprite extends Sprite implements ITouchable {
	
	float scaleX;
	float scaleY;
	
	
public TouchableSprite(Engine pEngine, WCMBitmap pBitmap, int pX, int pY) {
		super(pEngine, pBitmap, pX, pY);
		// TODO Auto-generated constructor stub
		
		
		scaleX = pEngine.getScreenPolicy().wscale;
		
		
		scaleY = pEngine.getScreenPolicy().hscale;
		
	}
	@Override
	public void onTouch(MotionEvent event) {
		// TODO Auto-generated method stub
		if (!IsInRegion(event.getX()* scaleX , event.getY()*scaleY)) 
			return;
		
		touch(event);

	}

	@Override
	public boolean IsInRegion(float vx, float vy) {
		// TODO Auto-generated method stub

		
		if(vx > getX() && vx < getX() + getWidth())
			if(vy> getY() && vy < getY() + getHeight())
			{
				return true;
			}
		
		return false;
		
		
	}

	@Override
	public abstract void touch(MotionEvent event);

	

}
