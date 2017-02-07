package com.example.petar.inteligentnisistemi.customComponents;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.example.petar.inteligentnisistemi.R;
import com.example.petar.inteligentnisistemi.UIApplication;
import com.example.petar.inteligentnisistemi.helpers.Constants;
import com.example.petar.inteligentnisistemi.models.Car;
import com.example.petar.inteligentnisistemi.models.Node;

import static com.example.petar.inteligentnisistemi.R.drawable.roundabout;

/**
 * Created by petar on 9.10.16..
 */

public class DrawableView extends RelativeLayout
{
    Paint yellowPaint;
    Paint redPaint;

    RelativeLayout layoutForStreets;
    RelativeLayout layoutForCars;

    private void init(Context context)
    {
        setWillNotDraw(false);
        setPaintAndParams();
        RelativeLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutForStreets = new RelativeLayout(context);
        layoutForCars = new RelativeLayout(context);
        layoutForStreets.setLayoutParams(params);
        layoutForCars.setLayoutParams(params);
        addView(layoutForStreets);
        addView(layoutForCars);
    }

    public DrawableView(Context context)
    {
        super(context);
        init(context);

    }

    public DrawableView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    public DrawableView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void setPaintAndParams()
    {
        yellowPaint = new Paint();
        yellowPaint.setColor(getResources().getColor(R.color.roadColor));
        yellowPaint.setStrokeWidth(10);
        redPaint = new Paint();
        redPaint.setColor(Color.RED);
        redPaint.setStrokeWidth(10);
        traffic = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ic_traffic_black_24dp), UIApplication.HEIGHT / 13, UIApplication.HEIGHT / 13, true);
        car = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ic_car_black_24dp), UIApplication.HEIGHT / 13, UIApplication.HEIGHT / 13, true);
        myCar = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.my_car), UIApplication.HEIGHT / 13, UIApplication.HEIGHT / 13, true);
        roundabout = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.roundabout), UIApplication.HEIGHT / 13, UIApplication.HEIGHT / 13, true);


    }

    boolean firstInit = true;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        if (firstInit)
        {
            if (Constants.getInstance().map.nodes.size() > 0)
            {
                firstInit = false;
                drawMap();
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    Paint paint = new Paint();
    Bitmap preview;
    Bitmap traffic;
    Bitmap car;
    Bitmap myCar;
    Bitmap roundabout;
    RelativeLayout.LayoutParams progressBarParams;
    RelativeLayout.LayoutParams nodeParams;

    public void drawMap()
    {
        preview = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
        preview.eraseColor(Color.WHITE);

        Canvas canvas = new Canvas(preview);
        for (Node node : Constants.getInstance().map.nodes)
        {
            for (Node n : node.connectedNodes)
            {
                if (node.getLongitude() != null && n.getLatitude() != null)
                {
                    int startX = (int) (Float.valueOf(node.getLongitude()) / 100 * getWidth()) + traffic.getWidth() / 2;
                    int endX = (int) (Float.valueOf(n.getLongitude()) / 100 * getWidth()) + traffic.getWidth() / 2;
                    int startY = (int) (Float.valueOf(node.getLatitude()) / 100 * getHeight()) + traffic.getHeight() / 2;
                    int endY = (int) (Float.valueOf(n.getLatitude()) / 100 * getHeight()) + traffic.getHeight() / 2;
                    int distance = (int) getDistance(startX, startY, endX, endY);
                    /*canvas.drawLine(startX, startY, endX, endY, yellowPaint);*/


                    progressBarParams = new LayoutParams(distance, 20);
                    RoundCornerProgressBar progressBar = new RoundCornerProgressBar(getContext(), null);
//                    ProgressBar progressBar = new ProgressBar(getContext(), null,android.R.attr.progressBarStyleHorizontal);
                    progressBar.setLayoutParams(progressBarParams);
                    progressBar.setPivotX(0f);
                    progressBar.setX(startX);
                    progressBar.setY(startY);
                    progressBar.setMax(100);
//                    progressBar.setProgress(100);
                    progressBar.setProgressColor(Color.parseColor("#58858e"));
                    progressBar.setRotation((float) calcRotationAngleInDegrees(startX, startY, endX, endY) - 90);
                    progressBar.setOnClickListener(onProgressBarClick);
                    layoutForStreets.addView(progressBar);
                }

            }
        }
        for (Node node : Constants.getInstance().map.nodes)
        {
            if (node.getLongitude() != null && node.getLatitude() != null)
            {
                int x = (int) (Float.valueOf(node.getLongitude()) / 100 * getWidth());
                int y = (int) (Float.valueOf(node.getLatitude()) / 100 * getHeight());
                /*if (node.getNodeType().getName().equals("Intersection"))
                {
                    canvas.drawBitmap(traffic, x, y, new Paint());
                } else
                {
                    canvas.drawBitmap(roundabout, x, y, new Paint());
                }*/
//                canvas.drawText("" + node.getId(), x, y - 18, redPaint);
                ImageView imageView = new ImageView(getContext());
                imageView.setX(x);
                imageView.setY(y);
                nodeParams = new LayoutParams(UIApplication.HEIGHT / 15, UIApplication.HEIGHT / 15);
                imageView.setLayoutParams(nodeParams);
                if (node.getNodeType().getName().equals("Intersection"))
                {
                    imageView.setImageResource(R.drawable.ic_traffic_black_24dp);
                } else
                {
                    imageView.setImageResource(R.drawable.roundabout);
                }
                imageView.setOnClickListener(onIntersectionClick);
                layoutForStreets.addView(imageView);
            }
        }
        setBackground(new BitmapDrawable(preview));
        invalidate();
    }

    View.OnClickListener onProgressBarClick = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            double theta = 0;
        }
    };
    View.OnClickListener onIntersectionClick = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {

        }
    };
    ImageView currentCarImageView;

    public void drawCars()
    {
//        removeAllViews();
        for (Car currCar : Constants.getInstance().map.cars)
        {
            if (currCar.getPositionNode1() != null && currCar.getPositionNode2() != null && currCar.getPositionNode1().getLongitude() != null)
            {
                ImageView carOnMap;
                carOnMap = new ImageView(getContext());
                int x = (int) ((Float.valueOf(currCar.getPositionNode1().getLongitude()) + Float.valueOf(currCar.getPositionNode2().getLongitude())) / 2 / 100 * getWidth());
                int y = (int) ((Float.valueOf(currCar.getPositionNode1().getLatitude()) + Float.valueOf(currCar.getPositionNode2().getLatitude())) / 2 / 100 * getHeight());
                carOnMap.setX(x);
                carOnMap.setY(y);
                if (currCar.getRegBr().equals(Constants.getInstance().regbr))
                {
                    carOnMap.setImageBitmap(myCar);
                    currentCarImageView = carOnMap;
                    Constants.getInstance().myCar = currCar;
                } else
                {
                    carOnMap.setImageBitmap(car);
                }
                addView(carOnMap);
            }

        }
    }

    public float getDistance(int x1, int y1, int x2, int y2)
    {
        return (float) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static double calcRotationAngleInDegrees(int x1, int y1, int x2, int y2)
    {
        double theta = Math.atan2(y2 - y1, x2 - x1);
        theta += Math.PI / 2.0;

        double angle = Math.toDegrees(theta);

        if (angle < 0)
        {
            angle += 360;
        }

        return angle;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (preview != null)
        {
            canvas.drawBitmap(preview, 0, 0, paint);
        }
    }
}
