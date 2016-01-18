package com.example.mikaela.project.StepsLeft;

import android.content.Context;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.ProgressBar;
import android.widget.TableLayout;

/**
 *  This class creates the visualization of how to show steps left.
 *
 *  It is possible to change number of steps, how many steps to move forward every time
 *  and what level of progress you want to begin with.
 *
 *  The progress bar can be changed to some other visualization by changing the
 *  code in drawStepsVisualization().
 *
 */

public class StepsLeft extends TableLayout{
    Context con;

    int numberOfSteps = 4, currentStep, stepsToMoveForward = 1, startProgressAt = 1;
    ProgressBar visualization;

    public StepsLeft(Context context){
        super(context);
        con = context;
        drawStepsVisualization();
    }

    public int getCurrentStep(){
        return currentStep;
    }

    private int setUpSteps(){
        return numberOfSteps;
    }

    public void updateStep(int level){
        visualization.setProgress(level + stepsToMoveForward);
    }

    public void drawStepsVisualization(){

        currentStep = getCurrentStep();

        numberOfSteps = setUpSteps();

        /** Progress bar */
        visualization = new ProgressBar(con,null,android.R.attr.progressBarStyleHorizontal);
        visualization.setMax(numberOfSteps);
        visualization.setProgress(startProgressAt);
        visualization.getProgressDrawable().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);

        this.addView(visualization);

    }



}
