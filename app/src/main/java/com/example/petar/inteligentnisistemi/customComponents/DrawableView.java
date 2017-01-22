package com.example.petar.inteligentnisistemi.customComponents;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.petar.inteligentnisistemi.R;
import com.example.petar.inteligentnisistemi.helpers.Constants;
import com.example.petar.inteligentnisistemi.models.Edge;
import com.example.petar.inteligentnisistemi.models.Node;

import static android.R.attr.x;
import static android.R.attr.y;

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
        setPaintAndParams();
    }

    public DrawableView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setWillNotDraw(false);
        setPaintAndParams();
    }

    public DrawableView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
        setPaintAndParams();
    }

    private void setPaintAndParams()
    {
        yellowPaint =new Paint();
        yellowPaint.setColor(Color.YELLOW);
        yellowPaint.setStrokeWidth(10);


    }

    Paint paint = new Paint();
    Bitmap preview;
    Bitmap traffic;
    RelativeLayout.LayoutParams progressBarParams;
    RelativeLayout.LayoutParams nodeParams;
    public void drawMap()
    {
        preview = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
        preview.eraseColor(Color.WHITE);
        traffic=BitmapFactory.decodeResource(getResources(), R.drawable.ic_traffic_black_24dp);
        Canvas canvas = new Canvas(preview);
        /*for (Node node : Constants.getInstance().map.nodes)
        {
            for(Edge edge:node.edges)
            {
                int startX= (int) (edge.from.X/100*getWidth())+traffic.getWidth()/2;
                int endX= (int) (edge.to.X/100*getWidth())+traffic.getWidth()/2;
                int startY= (int) (edge.from.Y/100*getHeight())+traffic.getHeight()/2;
                int endY= (int) (edge.to.Y/100*getHeight())+traffic.getHeight()/2;
                int distance= (int) getDistance(startX,startY,endX,endY);
                progressBarParams=new LayoutParams(distance, 20);
                ProgressBar progressBar=new ProgressBar(getContext(), null, android.R.attr.progressBarStyleHorizontal);
                progressBar.setLayoutParams(progressBarParams);
                progressBar.setPivotX(0f);
                progressBar.setX(startX);
                progressBar.setY(startY);
                progressBar.setRotation((float) calcRotationAngleInDegrees(startX,startY,endX,endY)-90);
                progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progress_drawable));

                addView(progressBar);
//                canvas.drawLine(startX,startY,endX,endY, yellowPaint);
            }
        }
        for (Node node : Constants.getInstance().map.nodes)
        {
            int x = (int) (node.X/100 * getWidth());
            int y = (int) (node.Y/100 * getHeight());
//            canvas.drawBitmap(traffic, x, y, new Paint());

            ImageView imageView=new ImageView(getContext());
            imageView.setX(x);
            imageView.setY(y);
            nodeParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(nodeParams);
            imageView.setImageResource(R.drawable.ic_traffic_black_24dp);
            addView(imageView);
        }*/
//        invalidate();
    }

    public float getDistance(int x1,int y1,int x2,int y2)
    {
        return (float) Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }
    public static double calcRotationAngleInDegrees(int x1,int y1,int x2,int y2)
    {
        double theta = Math.atan2(y2 - y1, x2 - x1);
        theta += Math.PI/2.0;

        double angle = Math.toDegrees(theta);

        if (angle < 0) {
            angle += 360;
        }

        return angle;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (preview != null)
            canvas.drawBitmap(preview, 0, 0, paint);
    }
}
