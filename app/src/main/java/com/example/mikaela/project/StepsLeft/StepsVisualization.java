package com.example.mikaela.project.StepsLeft;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.ProgressBar;
import android.widget.TableLayout;

/** This class is the visualisation of the steps left. The default visualization
 * is set to a progress bar. */

public class StepsVisualization extends TableLayout {
    Context context;
    int numberOfSteps = 4, stepsToMoveForward = 1, startProgressAt = 1;
    ProgressBar visualization;


    public StepsVisualization(Context con){
        super(con);
        context = con;
        drawStepsVisualization();
    }
    /** Move the visualisation(here: the progress bar) one step forward. */
    public void updateStep(int current){
        visualization.setProgress(current + stepsToMoveForward);
    }

    /** Draw out the chosen visualisation (here: a progress bar) */
    public void drawStepsVisualization(){

        visualization = new ProgressBar(context,null,android.R.attr.progressBarStyleHorizontal);
        visualization.setMax(numberOfSteps);
        visualization.setProgress(startProgressAt);
        visualization.getProgressDrawable().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);

        this.addView(visualization);

    }

}
