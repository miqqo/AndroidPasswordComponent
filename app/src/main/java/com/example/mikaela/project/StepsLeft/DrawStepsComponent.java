package com.example.mikaela.project.StepsLeft;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by mikaela on 16-01-14.
 */
public class DrawStepsComponent extends View{

    private boolean progressBar;

    public DrawStepsComponent(Context con){
        super(con);
        progressBar = true;

    }

    public boolean isProgressBarShown(){
        return progressBar;

    }


}
