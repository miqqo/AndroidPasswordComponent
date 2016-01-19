package com.example.mikaela.project;

import android.content.Context;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.mikaela.project.PasswordForm.PasswordForm;
import com.example.mikaela.project.StepsLeft.StepsLeft;

/**
 *  This class creates an example of an log-in form.
 *
 *  It also uses stepsLeft and PasswordForm if the bool is set to true in MainActivity
 *
 *  For the password, you can choose if you want to use your own algorithm for how to calculate
 *  the password, and if you want to use your own way of visualizing the strength of the password.
 *  To do so, add a new parameter to PasswordForm(context).
 *
 *  The visualization for showing steps left is possible to change in the function
 *  drawStepsVisualization() in the StepsLeft class.
 *
 */

public class CreateForm extends TableLayout {

    int currentStep;
    Button ok;
    Context con;
    boolean usePassword, useSteps;

    CreateForm cf = CreateForm.this;
    PasswordForm passwordForm;
    StepsLeft stepsLeft;

    public CreateForm(Context context, boolean usePasswordForm, boolean useStepsForm){
        super(context);
        con = context;


        if(useStepsForm){
            stepsLeft = new StepsLeft(context);
            currentStep = stepsLeft.getCurrentStep();

        }
        if(usePasswordForm){
            passwordForm = new PasswordForm(context);

        }

        usePassword = usePasswordForm;
        useSteps = useStepsForm;

        setUpView();
    }

    private void setUpView(){

        ok = new Button(con);
        ok.setText("ok");

        cf.removeAllViews();
        stepsLeft.addStep(passwordForm);

        cf.addView(stepsLeft.setStep(currentStep));
        cf.addView(ok);
        System.out.println("HÄÄR");



        ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                currentStep++;
                setUpView();
               // if(useSteps)stepsLeft.updateStep(currentStep);

            };
        });

    }

}
