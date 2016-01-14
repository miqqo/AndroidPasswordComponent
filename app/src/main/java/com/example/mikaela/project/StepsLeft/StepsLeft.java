package com.example.mikaela.project.StepsLeft;

import android.content.Context;

import android.view.View;
import android.widget.TableLayout;

/**
 * Created by mikaela on 16-01-14.
 */
public class StepsLeft extends View{
    DrawStepsComponent drawStepsComponent;
    StepsAlgorithm stepsAlgorithm;
    Context con;
    int currentStep = 0;

    public StepsLeft(Context context){
        super(context);
        con = context;
        stepsAlgorithm = new StepsAlgorithm();
        drawStepsComponent = new DrawStepsComponent(context);

    }

    public StepsLeft(Context context, StepsAlgorithm sa){
        super(context);

        stepsAlgorithm = sa;
        drawStepsComponent = new DrawStepsComponent(context);
    }

    public StepsLeft(Context context, DrawStepsComponent dsc){
        super(context);

        stepsAlgorithm = new StepsAlgorithm();
        drawStepsComponent = dsc;
    }

    public StepsLeft(Context context, StepsAlgorithm sa, DrawStepsComponent dsc){
        super(context);

        stepsAlgorithm = sa;
        drawStepsComponent = dsc;

    }

    public boolean isProgressBarShown(){
        return drawStepsComponent.isProgressBarShown();
    }

    public int getCurrentStep(){
        return currentStep;
    }

    public int setNumberOfSteps(){
        return stepsAlgorithm.setUpSteps();
    }

}
