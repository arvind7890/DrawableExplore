package dnivra.droid.arvind.linepattern;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;


public class DashDrawable extends Drawable {
    Paint mPaint;
    Path mPath;

    int lineColor;
    int lineAlpha;
    int lineWidth;
    float dashLength;
    float gapLength;

    public DashDrawable() {
        mPaint=new Paint();
        mPath=new Path();
        mPaint.setAntiAlias(true);
    }

    public DashDrawable(int lineColor, int lineAlpha, int lineWidth, float dashLength, float gapLength) {

        this.lineColor = lineColor;
        this.lineAlpha = lineAlpha;
        this.lineWidth = lineWidth;
        this.dashLength = dashLength;
        this.gapLength = gapLength;
        mPaint=new Paint();
        mPath=new Path();
        mPaint.setAntiAlias(true);
        mPaint.setColor(this.lineColor);
        mPaint.setStyle(Paint.Style.STROKE);
        // Line width in pixels
        mPaint.setAlpha(lineAlpha);
        mPaint.setStrokeWidth(lineWidth);
        mPaint.setPathEffect(new DashPathEffect(new float[]{this.dashLength,this.gapLength},0));
        mPaint.setAntiAlias(true);


    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        int height = getBounds().height();
        int width = getBounds().width();
        Log.e("DRAW","height:"+height+"Width:"+width);
        mPath.moveTo(0,height/2);
        mPath.lineTo(width,height/2);
        //canvas.drawLine(0,height/2,width,height/2,mPaint);
        canvas.drawPath(mPath,mPaint);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }
}

