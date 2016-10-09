package com.example.petar.inteligentnisistemi.customComponents;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by petar on 9.10.16..
 */

public class DrawableView  extends RelativeLayout{
    public DrawableView(Context context) {
        super(context);
    }

    public DrawableView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawableView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
