package com.example.petar.inteligentnisistemi.customComponents;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.example.petar.inteligentnisistemi.R;
import com.example.petar.inteligentnisistemi.helpers.Constants;
import com.example.petar.inteligentnisistemi.models.Edge;
import com.example.petar.inteligentnisistemi.models.Node;

/**
 * Created by petar on 9.10.16..
 */

public class DrawableView extends RelativeLayout
{
    Paint yellowPaint;
    public DrawableView(Context context)
    {
        super(context);
        setWillNotDraw(false);
        setPaint();
    }

    public DrawableView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setWillNotDraw(false);
        setPaint();
    }

    public DrawableView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
        setPaint();
    }

    private void setPaint()
    {
        yellowPaint =new Paint();
        yellowPaint.setColor(Color.YELLOW);
        yellowPaint.setStrokeWidth(10);
    }

    Paint paint = new Paint();
    Bitmap preview;
    Bitmap traffic;

    public void drawMap()
    {
        preview = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
        preview.eraseColor(Color.WHITE);
        traffic=BitmapFactory.decodeResource(getResources(), R.drawable.ic_traffic_black_24dp);
        Canvas canvas = new Canvas(preview);
        for (Node node : Constants.getInstance().map.nodes)
        {
            for(Edge edge:node.edges)
            {
                int startX= (int) (edge.from.X/100*getWidth())+traffic.getWidth()/2;
                int endX= (int) (edge.to.X/100*getWidth())+traffic.getWidth()/2;
                int startY= (int) (edge.from.Y/100*getHeight())+traffic.getHeight()/2;
                int endY= (int) (edge.to.Y/100*getHeight())+traffic.getHeight()/2;
                canvas.drawLine(startX,startY,endX,endY, yellowPaint);
            }
        }
        for (Node node : Constants.getInstance().map.nodes)
        {
            int x = (int) (node.X/100 * getWidth());
            int y = (int) (node.Y/100 * getHeight());
            canvas.drawBitmap(traffic, x, y, new Paint());
        }
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (preview != null)
            canvas.drawBitmap(preview, 0, 0, paint);
    }
}
