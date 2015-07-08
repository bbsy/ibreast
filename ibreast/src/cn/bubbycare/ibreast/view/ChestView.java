/**
 * 文件名：ChestView.java 2015-7-5 下午11:03:19
 * @author Administrator 	许仕永
 */
package cn.bubbycare.ibreast.view;

import cn.bubbycare.ibreast.R;
import android.R.integer;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * Description : 胸部管理视图 Create time : 2015-7-5 下午11:03:19 Project name: ibreast
 * File name : ChestView.java Encoded : UTF-8
 * 
 * @author 许仕永
 * @JKD JDK 1.6.0_21
 * @version v1.0.0
 */
public class ChestView extends View implements OnTouchListener {
    public static final int DEGREE_SOFT   = 1;
    public static final int DEGREE_MIDDLE = 2;
    public static final int DEGREE_HARD   = 3;

//    public static final int DEGREE_SOFT   = 1;
//    public static final int DEGREE_MIDDLE = 2;
//    public static final int DEGREE_HARD   = 3;

    
    private Context context;
    private int radius; // 硬块半径
    private int degree;// 硬块程度 1|软 2|中等 3|硬
    private Bitmap bmpChest;

    private Bitmap bmpOvalSoftSmall;
    private Bitmap bmpOvalSoftMiddle;
    private Bitmap bmpOvalSoftBig;

    private Bitmap bmpOvalMiddleSmall;
    private Bitmap bmpOvalMiddleMiddle;
    private Bitmap bmpOvalMiddleBig;

    private Bitmap bmpOvalHardSmall;
    private Bitmap bmpOvalHardMiddle;
    private Bitmap bmpOvalHardBig;

    private int viewHeight, viewWidth;
    Paint paint;
    private boolean isDrawOval = false;
    private int x, y;
    private Bitmap oval;

    public ChestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.setOnTouchListener(this);
        paint = new Paint();
        initBmps();
    }

    private void initBmps() {
        // TODO Auto-generated method stub
        if (bmpChest == null)
            bmpChest = BitmapFactory.decodeResource(getResources(), R.drawable.mm);
        if (bmpOvalSoftSmall == null)
            bmpOvalSoftSmall = BitmapFactory.decodeResource(getResources(), R.drawable.icon_soft_small);
        if (bmpOvalSoftMiddle == null)
            bmpOvalSoftMiddle = BitmapFactory.decodeResource(getResources(), R.drawable.icon_soft_middle);
        if (bmpOvalSoftBig == null)
            bmpOvalSoftBig = BitmapFactory.decodeResource(getResources(), R.drawable.icon_soft_big);
        if (bmpOvalMiddleSmall == null)
            bmpOvalMiddleSmall = BitmapFactory.decodeResource(getResources(), R.drawable.icon_middle_small);
        if (bmpOvalMiddleMiddle == null)
            bmpOvalMiddleMiddle = BitmapFactory.decodeResource(getResources(), R.drawable.icon_middle_middle);
        if (bmpOvalMiddleBig == null)
            bmpOvalMiddleBig = BitmapFactory.decodeResource(getResources(), R.drawable.icon_middle_big);
        if (bmpOvalHardSmall == null)
            bmpOvalHardSmall = BitmapFactory.decodeResource(getResources(), R.drawable.icon_hard_small);
        if (bmpOvalHardMiddle == null)
            bmpOvalHardMiddle = BitmapFactory.decodeResource(getResources(), R.drawable.icon_hard_middle);
        if (bmpOvalHardBig == null)
            bmpOvalHardBig = BitmapFactory.decodeResource(getResources(), R.drawable.icon_hard_big);
    }
    
    

    @Override
	protected void onDetachedFromWindow()
	{
		// TODO Auto-generated method stub
		super.onDetachedFromWindow();
	    if(bmpChest!=null)
	    	bmpChest.recycle();
	    if(bmpOvalSoftSmall!=null)
	    	bmpOvalSoftSmall.recycle();
	    if(bmpOvalSoftMiddle!=null)
	    	bmpOvalSoftMiddle.recycle();
	    if(bmpOvalSoftBig!=null)
	    	bmpOvalSoftBig.recycle();
	    if(bmpOvalMiddleSmall!=null)
	    	bmpOvalMiddleSmall.recycle();
	    if(bmpOvalMiddleMiddle!=null)
	    	bmpOvalMiddleMiddle.recycle();
	    if(bmpOvalMiddleBig!=null)
	    	bmpOvalMiddleBig.recycle();
	    if(bmpOvalHardSmall!=null)
	    	bmpOvalHardSmall.recycle();
	    if(bmpOvalHardMiddle!=null)
	    	bmpOvalHardMiddle.recycle();
	    if(bmpOvalHardBig!=null)
	    	bmpOvalHardBig.recycle();
	}

	@Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        viewHeight = getHeight();
        viewWidth = getWidth();
//        canvas.drawColor(Color.RED);

//        canvas.drawColor(R.color.pick);
        canvas.drawBitmap(bmpChest, viewWidth / 2 - bmpChest.getWidth() / 2, viewHeight / 2 - bmpChest.getHeight() / 2, paint);
        if (isDrawOval) {
            canvas.drawBitmap(oval, x, y, paint);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // TODO Auto-generated method stub

        return true;
    }

    public void addPoint() {
        oval = bmpOvalHardSmall;
        x = viewWidth / 2 - bmpOvalSoftSmall.getWidth() / 2;
        y = viewHeight / 2 - bmpOvalSoftSmall.getHeight() / 2;
        isDrawOval = true;
        invalidate();
    }
    
    public void deletePoint() {
        oval = null;
        x = viewWidth / 2 - bmpOvalSoftSmall.getWidth() / 2;
        y = viewHeight / 2 - bmpOvalSoftSmall.getHeight() / 2;
        isDrawOval = false; //重置取消绘图变量
        invalidate();  // 重绘
    }

    public void movePoint(int x, int y) {
        this.x = x;
        this.y = y;
        invalidate();
    }

    public void changePointSizeOrDegree(int degree, int size) {
        if (degree == 1) {
            if (size == 1)
                oval = bmpOvalSoftSmall;
            if (size == 2)
                oval = bmpOvalSoftMiddle;
            if (size == 3)
                oval = bmpOvalSoftBig;
        }
        if (degree == 2) {
            if (size == 1)
                oval = bmpOvalMiddleSmall;
            if (size == 2)
                oval = bmpOvalMiddleMiddle;
            if (size == 3)
                oval = bmpOvalMiddleBig;
        }
        if (degree == 3) {
            if (size == 1)
                oval = bmpOvalHardSmall;
            if (size == 2)
                oval = bmpOvalHardMiddle;
            if (size == 3)
                oval = bmpOvalHardBig;
        }
        invalidate();
    }
}
