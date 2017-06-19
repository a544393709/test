package com.example.wugang.test.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.wugang.test.R;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


/**
 * Created by wugang on 2017/6/5.
 */

public class CustomTitleTextView extends View implements View.OnClickListener {
    /**
     * 文本
     */
    private String mTitleText;
    /**
     * 文本颜色
     */
    private  int mTitleColor;
    /**
     * 文本大小
     */
    private int mTitleSize;
    /**
     * 绘制时文本范围  矩形
     */
    private Rect mBound;
    private Paint mPaint;
    public CustomTitleTextView(Context context) {
        this(context,null);
    }

    public CustomTitleTextView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public CustomTitleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**
         * 获得自定义样式属性
         */

        TypedArray array = context.getTheme().obtainStyledAttributes(attrs
                , R.styleable.CustomTitleTextView,defStyleAttr,0);
        int indexCount = array.getIndexCount();
        for (int i = 0 ; i <indexCount ; i++){
            int index = array.getIndex(i);
            switch (index){
                case R.styleable.CustomTitleTextView_titleText:
                    mTitleText = array.getString(index);
                    break;
                case R.styleable.CustomTitleTextView_titleTextColor:
                    mTitleColor = array.getColor(index,Color.BLUE);
                    break;
                case R.styleable.CustomTitleTextView_titleTextSize:
                    mTitleSize  = array.getDimensionPixelSize(index, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP
                    ,16,getResources().getDisplayMetrics()));
                    break;
            }
        }
        array.recycle();
        mPaint = new Paint();
        mPaint.setTextSize(mTitleSize);
        mBound = new Rect();
       mPaint.getTextBounds(mTitleText,0,mTitleText.length(),mBound);
        this.setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        mPaint.setColor(mTitleColor);
        canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height ;
        if (widthMode == MeasureSpec.EXACTLY)
        {
            width = widthSize;
        } else
        {
            mPaint.setTextSize(mTitleSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
            float textWidth = mBound.width();
            int desired = (int) (getPaddingLeft() + textWidth + getPaddingRight());
            width = desired;
        }

        if (heightMode == MeasureSpec.EXACTLY)
        {
            height = heightSize;
        } else
        {
            mPaint.setTextSize(mTitleSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
            float textHeight = mBound.height();
            int desired = (int) (getPaddingTop() + textHeight + getPaddingBottom());
            height = desired;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    public void onClick(View v) {
        mTitleText = randomText();
        postInvalidate();

    }
    private String randomText()
    {
        Random random = new Random();
        Set<Integer> set = new HashSet<Integer>();
        while (set.size() < 4)
        {
            int randomInt = random.nextInt(10);
            set.add(randomInt);
        }
        StringBuffer sb = new StringBuffer();
        for (Integer i : set)
        {
            sb.append("" + i);
        }

        return sb.toString();
    }
}
