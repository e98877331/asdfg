package ytwhyc.wcm.wcmengine.touchable;

import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.entity.Sprite;
import android.view.MotionEvent;

public class TouchableSprite implements ITouchable {
Sprite mSprite;
Engine mEngine;
	
	public TouchableSprite(Sprite pSprite,Engine pEngine)
	{
		mSprite = pSprite;
		mEngine = pEngine;
	}

	@Override
	public void onTouch(MotionEvent event) {
		// TODO Auto-generated method stub
		if (!IsInRegion(event.getX(), event.getY())) 
			return;
		
		touch(event);

	}

	@Override
	public boolean IsInRegion(float x, float y) {
		// TODO Auto-generated method stub
		return false;
		
		
	}

	@Override
	public void touch(MotionEvent event) {
		// TODO Auto-generated method stub
		
	}

}
