package ytwhyc.wcm.wcmengine.touchable;

import ytwhyc.wcm.entity.Sprite;
import android.view.MotionEvent;

public class TouchableSprite implements ITouchable {
Sprite mSprite;
	
	public TouchableSprite(Sprite pSprite)
	{
		mSprite = pSprite;
	}
	
	@Override
	public void onTouch(MotionEvent event) {
		// TODO Auto-generated method stub
		if(IsInRegion(event.getX(), event.getY()))
				{
			
				}
		
	}

	@Override
	public boolean IsInRegion(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void touch(MotionEvent event) {
		// TODO Auto-generated method stub
		
	}

}
