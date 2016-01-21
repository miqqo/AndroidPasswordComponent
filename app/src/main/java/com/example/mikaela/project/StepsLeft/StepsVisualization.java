package com.example.mikaela.project.StepsLeft;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.ProgressBar;
import android.widget.TableLayout;

/**
 * Created by mikaela on 16-01-19.
 */
public class StepsVisualization extends TableLayout {
    Context context;
    int numberOfSteps = 4, stepsToMoveForward = 1, startProgressAt = 1;
    ProgressBar visualization;


    public StepsVisualization(Context con){
        super(con);
        context = con;
        drawStepsVisualization();
    }
    public void updateStep(int current){
        visualization.setProgress(current + stepsToMoveForward);
    }

    public void drawStepsVisualization(){

        /** Progress bar */
        visualization = new ProgressBar(context,null,android.R.attr.progressBarStyleHorizontal);
        visualization.setMax(numberOfSteps);
        visualization.setProgress(startProgressAt);
        visualization.getProgressDrawable().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);

        this.addView(visualization);

    }

}
