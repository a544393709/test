package com.example.wugang.test.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wugang on 2017/6/19.
 */

public class RinkView extends View {
    private Paint mPaint;
    public RinkView(Context context) {
        this(context,null);
    }

    public RinkView(Context context, @Nullable AttributeSet attrs) {
        this(context,null,0);
    }

    public RinkView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true); //消除锯齿
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE); //
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int center = getWidth()/2;

        //绘制内圆
        this.mPaint.setARGB(155, 167, 255, 255);
        this.mPaint.setStrokeWidth(20);
        canvas.drawCircle(center,center, 30, this.mPaint);

        //绘制圆环
        this.mPaint.setARGB(255, 0 ,225, 233);
        this.mPaint.setStrokeWidth(30);
        canvas.drawCircle(center,center, 50, this.mPaint);

        //绘制外圆
        this.mPaint.setARGB(155, 167, 0, 206);
        this.mPaint.setStrokeWidth(30);
        canvas.drawCircle(center,center, 70, this.mPaint);
        super.onDraw(canvas);
    }
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
//        int width;
//        int height ;
//        if (widthMode == MeasureSpec.EXACTLY)
//        {
//            width = widthSize;
//        } else
//        {
//            mPaint.setTextSize(mTitleSize);
//            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
//            float textWidth = mBound.width();
//            int desired = (int) (getPaddingLeft() + textWidth + getPaddingRight());
//            width = desired;
//        }
//
//        if (heightMode == MeasureSpec.EXACTLY)
//        {
//            height = heightSize;
//        } else
//        {
//            mPaint.setTextSize(mTitleSize);
//            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
//            float textHeight = mBound.height();
//            int desired = (int) (getPaddingTop() + textHeight + getPaddingBottom());
//            height = desired;
//        }
//
//        setMeasuredDimension(width, height);
//    }
}
