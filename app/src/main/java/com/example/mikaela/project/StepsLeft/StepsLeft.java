package com.example.mikaela.project.StepsLeft;

import android.content.Context;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;

/**
 * Created by mikaela on 16-01-14.
 */
public class StepsLeft extends TableLayout{
    Context con;

    int numberOfSteps, currentStep;
    ProgressBar progressBar;

    public StepsLeft(Context context){
        super(context);
        con = context;
        drawProgressBar();
    }

    public int getCurrentStep(){
        return currentStep;
    }

    private int setUpSteps(){
        numberOfSteps = 4;
        return numberOfSteps;
    }

    public void updateStep(int level){
        progressBar.setProgress(level +1);

    }

    public void drawProgressBar(){

        currentStep = getCurrentStep();

        numberOfSteps = setUpSteps();
        progressBar = new ProgressBar(con,null,android.R.attr.progressBarStyleHorizontal);
        progressBar.setMax(numberOfSteps);
        progressBar.setProgress(1);
        progressBar.getProgressDrawable().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);

        this.addView(progressBar);


    }



}
