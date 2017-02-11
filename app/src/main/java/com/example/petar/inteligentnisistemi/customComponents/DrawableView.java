package com.example.petar.inteligentnisistemi.customComponents;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.example.petar.inteligentnisistemi.R;
import com.example.petar.inteligentnisistemi.UIApplication;
import com.example.petar.inteligentnisistemi.connection.Connections;
import com.example.petar.inteligentnisistemi.helpers.Constants;
import com.example.petar.inteligentnisistemi.models.Car;
import com.example.petar.inteligentnisistemi.models.Node;
import com.example.petar.inteligentnisistemi.models.PathObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.tag;
import static com.example.petar.inteligentnisistemi.R.drawable.roundabout;

/**
 * Created by petar on 9.10.16..
 */

public class DrawableView extends RelativeLayout
{
    Paint yellowPaint;
    Paint redPaint;

    RelativeLayout layoutForStreets;
    RelativeLayout layoutForSemaphores;
    RelativeLayout layoutForCars;

    private void init(Context context)
    {
        setWillNotDraw(false);
        setPaintAndParams();
        RelativeLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutForStreets = new RelativeLayout(context);
        layoutForSemaphores = new RelativeLayout(context);
        layoutForCars = new RelativeLayout(context);
        layoutForStreets.setLayoutParams(params);
        layoutForSemaphores.setLayoutParams(params);
        layoutForCars.setLayoutParams(params);
        addView(layoutForStreets);
        addView(layoutForSemaphores);
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
            if (Constants.getInstance().map.nodes.size() > 0 && getWidth() > 0)
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

    int defaultProgressColor;
    public void drawMap()
    {
        layoutForStreets.removeAllViews();
        layoutForSemaphores.removeAllViews();
        preview = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
        preview.eraseColor(Color.WHITE);

        Canvas canvas = new Canvas(preview);
        int progressBarHeight = UIApplication.HEIGHT / 40;
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

                    progressBarParams = new LayoutParams(distance, progressBarHeight);
                    RoundCornerProgressBar progressBar = new RoundCornerProgressBar(getContext(), null);
//                    ProgressBar progressBar = new ProgressBar(getContext(), null,android.R.attr.progressBarStyleHorizontal);
                    progressBar.setLayoutParams(progressBarParams);
                    progressBar.setPivotX(0f);
                    progressBar.setX(startX);
                    progressBar.setY(startY);
                    progressBar.setMax(100);
                    defaultProgressColor=progressBar.getProgressBackgroundColor();
//                    progressBar.setProgress(50);
                    progressBar.setProgressColor(Color.parseColor("#58858e"));
                    progressBar.setRotation((float) calcRotationAngleInDegrees(startX, startY, endX, endY) - 90);
                    progressBar.setOnClickListener(onProgressBarClick);
                    progressBar.setTag(new Long[]{node.getId(), n.getId()});
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
                canvas.drawText("" + node.getId(), x, y - 18, redPaint);
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
                layoutForSemaphores.addView(imageView);
            }
        }
        setBackground(new BitmapDrawable(preview));
        invalidate();
    }

    ArrayList<RoundCornerProgressBar> progressBars = new ArrayList<>();

    private void drawNavigation(ArrayList<Integer> nodesIds)
    {
        if (nodesIds != null)
        {
            progressBars.clear();
            for (int i = 0; i < nodesIds.size() - 1; i++)
            {

                for (int j = 0; j < layoutForStreets.getChildCount(); j++)
                {
                    if (layoutForStreets.getChildAt(j) instanceof RoundCornerProgressBar)
                    {
                        Long[] tag = (Long[]) layoutForStreets.getChildAt(j).getTag();
                        long firstId = tag[0];
                        long second = tag[1];
                        if (nodesIds.get(i) == firstId && nodesIds.get(i + 1) == second)
                        {
                            ((RoundCornerProgressBar) layoutForStreets.getChildAt(j)).setProgressBackgroundColor(Color.RED);
                            progressBars.add((RoundCornerProgressBar) layoutForStreets.getChildAt(j));
                            layoutForStreets.getChildAt(j).bringToFront();
                            break;
                        }
                    }
                }
            }
            if (progressBars.size() > 0)
            {
                AnimatorSet as = new AnimatorSet();
                List<Animator> animators = new ArrayList<>();
                for (int i = 0; i < progressBars.size(); i++)
                {
                    ValueAnimator animator1 = ValueAnimator.ofInt(0, 100);
                    final int c = i;
                    animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
                    {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation)
                        {
                            progressBars.get(c).setProgress((Integer) animation.getAnimatedValue());
                        }
                    });
                    animator1.setDuration(2000);
                    animators.add(animator1);
                }
                as.playSequentially(animators);
                as.start();
            }
        }

    }

    View.OnClickListener onProgressBarClick = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            RoundCornerProgressBar progressBar = (RoundCornerProgressBar) v;
            Long[] tag = (Long[]) progressBar.getTag();
            Connections.getInstance().startNavigation(Constants.getInstance().myCar, Constants.getInstance().findNodeById(tag[0]), new Callback<PathObject>()
            {
                @Override
                public void onResponse(Call<PathObject> call, Response<PathObject> response)
                {
                    if (response.isSuccessful())
                    {
                        PathObject pathObject = response.body();
                        if (pathObject != null)
                        {
                            clearProgressBarsbackground();
                            ArrayList<Integer> nodesIds = new ArrayList<>();
                            for(Node node:pathObject.getNodes())
                            {
                                nodesIds.add((int) node.getId());
                            }
                            drawNavigation(nodesIds);
                        }
                    }
                    Log.i("Sda", "Gotovo");
                }

                @Override
                public void onFailure(Call<PathObject> call, Throwable t)
                {
                    Log.i("Sda", "Gotovo");
                }
            });
            double theta = 0;
        }
    };

    public void clearProgressBarsbackground()
    {
        for (int j = 0; j < layoutForStreets.getChildCount(); j++)
        {
            ((RoundCornerProgressBar) layoutForStreets.getChildAt(j)).setProgressBackgroundColor(defaultProgressColor);
        }
    }
    View.OnClickListener onIntersectionClick = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            ArrayList<Integer> nodesIds = new ArrayList<>();
            nodesIds.add(25);
            nodesIds.add(26);
            nodesIds.add(27);
            nodesIds.add(41);
            nodesIds.add(29);
            drawNavigation(nodesIds);
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
