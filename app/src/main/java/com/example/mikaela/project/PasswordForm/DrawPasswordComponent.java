package com.example.mikaela.project.PasswordForm;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by mikaela on 16-01-07.
 */
public class DrawPasswordComponent extends View {
    Paint paint;
    int colorNumber;

    public DrawPasswordComponent(Context con){
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

        if(colorNumber == 0){
            paint.setColor(Color.RED);
        }
        else if(colorNumber > 0 && colorNumber < 3){
            paint.setColor(Color.YELLOW);

        }
        else paint.setColor(Color.GREEN);


        canvas.drawCircle(20, 20, 20, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(100,100);
    }
}
