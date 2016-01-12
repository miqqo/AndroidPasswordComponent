package com.example.mikaela.project;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by mikaela on 16-01-07.
 */
public class DrawComponent extends View {
    Paint paint;
    int colorNumber;

    public DrawComponent(Context con){
        super(con);
    }

    public void updatePassword(int n){
        colorNumber = n;
        invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();

        if(colorNumber < 3){
            paint.setColor(Color.RED);
        }
        else if(colorNumber == 9){
            paint.setColor(Color.GREEN);

        }
        else paint.setColor(Color.YELLOW);


        canvas.drawCircle(10, 10, 10, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(100,100);
    }
}
