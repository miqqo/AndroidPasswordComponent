package com.example.mikaela.project.PasswordForm;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


/**
 *  This class draw out the visualization for how good your password is.
 */

public class DrawPasswordComponent extends View {
    Paint paint;
    int colorNumber, numberOfSteps;

    public DrawPasswordComponent(Context con){
        super(con);
    }

    public void updatePassword(int n, int nrOfSteps){
        colorNumber = n;
        numberOfSteps = nrOfSteps;
        invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();

        for(int i = 0; i < numberOfSteps; i++){
            if(colorNumber == 0) {
                paint.setColor(Color.RED);
            }
            else if(colorNumber == numberOfSteps){
                paint.setColor(Color.GREEN);
            }
            else paint.setColor(Color.YELLOW);
        }

        if(numberOfSteps == 0) paint.setColor(Color.RED);

        canvas.drawCircle(20, 20, 20, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(100,100);
    }
}
