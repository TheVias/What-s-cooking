package com.application.vias.what_s_cooking.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.application.vias.what_s_cooking.R;

/**
 * TODO: document your custom view class.
 */
public class TimerView extends View {
    private String mExampleString; // TODO: use a default from R.string...
    private int color = Color.RED; // TODO: use a default from R.color...
    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
    private float radius = 0;
    private float circleX = 0;
    private float circleY = 0;
    private Drawable mExampleDrawable;

    public TimerView(Context context) {
        super(context);
        init(null, 0);
    }

    public TimerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public TimerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.TimerView, defStyle, 0);

        mExampleString = a.getString(
                R.styleable.TimerView_exampleString);

        color = a.getColor(
                R.styleable.TimerView_exampleColor,
               color);

        radius = a.getDimension(
                R.styleable.TimerView_radius,
                radius);

        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // TODO: consider storing these as member variables to reduce
        // allocations per draw cycle.
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        // Draw the example drawable on top of the text.
        /*
        if (mExampleDrawable != null) {
            mExampleDrawable.setBounds(paddingLeft, paddingTop,
                    paddingLeft + contentWidth, paddingTop + contentHeight);
            mExampleDrawable.draw(canvas);
        }
        */

        circleX = 0;
        circleY = getHeight();

        Paint paint = new Paint();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        canvas.drawCircle(circleX,
                circleY,
                radius,paint);
    }

    /**
     * Gets the example string attribute value.
     *
     * @return The example string attribute value.
     */
    public String getExampleString() {
        return mExampleString;
    }

    /**
     * Sets the view's example string attribute value. In the example view, this string
     * is the text to draw.
     *
     * @param exampleString The example string attribute value to use.
     */
    public void setExampleString(String exampleString) {
        mExampleString = exampleString;
    }

    /**
     * Gets the example color attribute value.
     *
     * @return The example color attribute value.
     */
    public int getExampleColor() {
        return color;
    }

    /**
     * Sets the view's example color attribute value. In the example view, this color
     * is the font color.
     *
     * @param exampleColor The example color attribute value to use.
     */
    public void setExampleColor(int exampleColor) {
        color = exampleColor;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        //TODO: разобраться, как этот метод может повлиять на размеры блока и как вычисляются размеры родителя
        /*
        this.setLayoutParams(new CoordinatorLayout.LayoutParams(parentWidth,parentHeight));
        */
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int height = getMeasuredHeight();
        final int width = getMeasuredWidth();
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension((int)radius, (int)radius);
    }

}
