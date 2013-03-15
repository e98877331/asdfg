package ytwhyc.wcm.menduel;

import android.graphics.Bitmap;
import ytwhyc.wcm.engine.Engine;
import ytwhyc.wcm.entity.Sprite;
import ytwhyc.wcm.wcmengine.bitmap.WCMBitmap;

public class Enemy extends Sprite {

	boolean hitting;
	
	public Enemy(Engine pEngine, WCMBitmap pWCMBitmap, int pX, int pY) {
		super(pEngine, pWCMBitmap, pX, pY);
		// TODO Auto-generated constructor stub
		
		hitting = false;
	}
	
//    public onHit()
//    {
//    	hitting = true;
//    	
//    }
//	
    
    

}
