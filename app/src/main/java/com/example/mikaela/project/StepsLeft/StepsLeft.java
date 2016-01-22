package com.example.mikaela.project.StepsLeft;

import android.content.Context;
import android.view.View;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

/**
 *  This class is the connection between the visualization of the component and
 *  the container in which you can put in views from CreateForm.java
 */

public class StepsLeft extends TableLayout{
    Context context;
    int numberOfSteps = 2, currentStep;

    ArrayList<View> views = new ArrayList<View>(numberOfSteps);
    List<Boolean> isViewDone = new ArrayList<>(numberOfSteps);
    StepsVisualization stepsVisualization;
    StepsListener listener;

    /** Default constructor*/
    public StepsLeft(Context con){
        super(con);
        context = con;
        stepsVisualization = new StepsVisualization(con);

    }
    /** Constructor with custom Visualization */
    public StepsLeft(Context con, StepsVisualization sv){
        super(con);
        stepsVisualization = sv;
    }

    public void setListener(StepsListener listener){
        this.listener = listener;
    }
    /** Adds one step to the component by putting the view in the array of views*/
    public void addStep(View view){

        views.add(view);
    }

    /** Set the current view and the visualization to the container*/
    public void setStep(int currentStep){
        this.removeAllViews();

        setUpVisualization();
        this.addView(views.get(currentStep));

    }

    /** If the user has pressed ok, the step is set to done in this function.
     * The array isViewDone can be used in cases you want to mark a done step if you
     * have the opportunity to choose what order you want to do the steps in*/
    public void setDone(int s){
        isViewDone.set(s, true);
    }


    public int getCurrentStep(){
        return currentStep;
    }

    /** This function updates the step in the visualization to move one step forward.*/
    public void updateStep(int step){
        stepsVisualization.updateStep(step);
        listener.StepsUpdate(step);
    }

    /** This function is setting up the visualization*/
    public void setUpVisualization(){
             this.addView(stepsVisualization);
    }


}
