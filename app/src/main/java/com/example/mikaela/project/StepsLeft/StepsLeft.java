package com.example.mikaela.project.StepsLeft;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 *  This class is the connection between the visualization of steps left and
 *  the content in every step.
 */

public class StepsLeft extends View{
    Context context;
    int numberOfSteps = 2, currentStep;

    ArrayList<View> views = new ArrayList<View>(numberOfSteps);
    List<Boolean> isViewDone = new ArrayList<>(numberOfSteps);
    StepsView stepsView;
    StepsVisualization stepsVisualization;

    /** Default constructor*/
    public StepsLeft(Context con){
        super(con);
        context = con;
        stepsVisualization = new StepsVisualization(con);
        setArray();

    }
    /** Constructor with custom Visualization */
    public StepsLeft(Context con, StepsVisualization sv){
        super(con);
        stepsVisualization = sv;
    }

    /** Adds one step to the component by putting the view in the array of views*/
    public void addStep(View view){

        views.add(view);
    }

    /** Returns the current step and content to show*/
    public View setStep(int currentStep){
        return views.get(currentStep);
    }

    /** This function initialize an array with all our predefined views.
     * It retrieves the content for each step from the stepsView-class*/
    private void setArray(){

        for(int i = 0; i < numberOfSteps; i++){
            stepsView = new StepsView(context, i);
            views.add(stepsView);
        }
    }

    /** If the user has pressed ok, the step is set to done in this function.
     * The array isViewDone can be used in cases you want to mark a done step if you
     * have the opportunity to choose what order you want to fill in the steps in*/
    public void setDone(int s){
        isViewDone.set(s, true);
    }


    public int getCurrentStep(){
        return currentStep;
    }

    /** This function update the step in the visualization to move one step forward.*/
    public void updateStep(int step){
        stepsVisualization.updateStep(step);
    }

    /** This function is setting up the chosen visualization*/
    public View setUpVisualization(){
            return this.stepsVisualization;
    }




}
