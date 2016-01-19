package com.example.mikaela.project.StepsLeft;

import android.content.Context;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

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

//skapa en arraylist med views
public class StepsLeft extends View{
    Context context;
    public TextView text1, text2, text3;
    public EditText username, fullName;
    Button ok;
    ArrayList<View> views = new ArrayList<View>(4);
    StepsView stepsView;

    int numberOfSteps = 4, currentStep, stepsToMoveForward = 1, startProgressAt = 1;
    ProgressBar visualization;
   // StepsVisualization stepsVisualization;

    public StepsLeft(Context con){
        super(con);
        context = con;
       // stepsVisualization = new StepsVisualization(con);
        setArray();

    }

    //för att lägga till ett steg i min arraylist
    public void addStep(View view){

        views.add(view);
    }

    //för att visa vilket steg som ska visas just nu
    public View setStep(int currentStep){
        return views.get(currentStep);
    }

    private void setArray(){

        for(int i = 0; i < 3; i++){
          //  updateStep(i);
            stepsView = new StepsView(context, i);
            views.add(stepsView);
        }
    }

    public int getCurrentStep(){
        return currentStep;
    }

    private int setUpSteps(){
        return numberOfSteps;
    }

  /*  public void updateStep(int step){
        stepsVisualization.updateStep(step);
    }*/




}
