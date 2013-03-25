package ytwhyc.wcm.menduel;

import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.entity.BitmapEntity;
import ytwhyc.wcm.entity.Sprite;
import ytwhyc.wcm.wcmengine.bitmap.WCMBitmap;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public class PowerBar extends Sprite{

	int power = 0;
	public PowerBar(Engine pEngine, WCMBitmap pBitmap, int pX, int pY) {
		super(pEngine, pBitmap, pX, pY);
		// TODO Auto-generated constructor stub
		
	
	}

	public void addPower()
	{
		power++;
		
		if(power > 10)
		{
			removeAllChilds();
			power = 0;
            return;
		}
		
		Bitmap bitmap =((BitmapDrawable)mEngine.getContext().getResources().getDrawable(R.drawable.ic_launcher)).getBitmap();
		WCMBitmap wpower = new WCMBitmap(mEngine, bitmap, 20, 20);
		BitmapEntity p = new BitmapEntity(mEngine, wpower, power * 20, 800);
	   addChild(p);
	   
	   
	}
}
