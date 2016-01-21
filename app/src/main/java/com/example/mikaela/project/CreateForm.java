package com.example.mikaela.project;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.mikaela.project.PasswordForm.PasswordForm;
import com.example.mikaela.project.StepsLeft.StepsLeft;

/**
 *  This class creates an example of an log-in form. If the bools are set to true in MainActivity,
 *  the log-in form will use the two components: passwordForm and stepsLeft.
 *  These are possible to modify by adding your own parameters.
 *
 */

public class CreateForm extends TableLayout {

    int currentStep;
    Button ok;
    TextView text, text2;
    Context con;
    boolean usePassword, useSteps;

    CreateForm cf = CreateForm.this;
    PasswordForm passwordForm;
    StepsLeft stepsLeft;

    public CreateForm(Context context, boolean usePasswordForm, boolean useStepsForm){
        super(context);
        con = context;

        /** Possible to choose if you want to use your own way of visualizing the steps.
         * To do so, add a parameter to Stepsleft(context)*/
        if(useStepsForm){
            stepsLeft = new StepsLeft(context);
            currentStep = stepsLeft.getCurrentStep();

        }
        /** Possible to choose if you want to use your own algorithm and if you want to use
         *  your own way of visualizing the strength of the password. To do so, add a new
         *  parameter to PasswordForm(context).*/
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

        text = new TextView(con);
        text.setText("Well done!");
        text.setGravity(Gravity.CENTER_HORIZONTAL);

        cf.removeAllViews();

        if(usePassword) {
            stepsLeft.addStep(passwordForm);
        }

        if(useSteps){
            cf.addView(stepsLeft.setUpVisualization());
            cf.addView(stepsLeft.setStep(currentStep));

        }
        cf.addView(ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // stepsLeft.setDone(currentStep);
                if(currentStep == 2){
                    cf.removeAllViews();
                    cf.addView(text);
                }
                else{
                    currentStep++;
                    setUpView();
                }
                if (useSteps) {
                    stepsLeft.updateStep(currentStep);
                }


            };
        });

    }

}
