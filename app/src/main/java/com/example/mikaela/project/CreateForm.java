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
 *  the password and of you want to use your own way of visualizing the strength of the password.
 *  To do so, add a new parameter to PasswordForm(context).
 *
 *  The visualization for showing steps left is possible to change in the function
 *  drawStepsVisualization() in the StepsLeft class.
 *
 */

public class CreateForm extends TableLayout {
    public TextView text1, text2, text3;
    public EditText username, fullName;

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

        setUpView(context);
    }

    private void setUpView(final Context context){

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels - metrics.widthPixels/2;

        TableRow tableRow1 = new TableRow(context);
        TableRow tableRow2 = new TableRow(context);
        TableRow tableRow3 = new TableRow(context);


        ok = new Button(context);
        ok.setText("ok");

        text1 = new TextView(context);
        text1.setText("Full name");

        text2 = new TextView(context);
        text2.setText("Username");

        text3 = new TextView(context);
        text3.setText("Well done!");
        text3.setGravity(Gravity.CENTER_HORIZONTAL);

        fullName = new EditText(context);
        fullName.setWidth(width);
        fullName.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        username = new EditText(context);
        username.setWidth(width);
        username.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        cf.removeAllViews();


        if(useSteps) cf.addView(stepsLeft);


        if(currentStep == 0){
            tableRow1.addView(text1);
            tableRow1.addView(username);
            tableRow1.addView(ok);
            cf.addView(tableRow1);

        }
        else if(currentStep == 1){
            tableRow2.addView(text2);
            tableRow2.addView(fullName);
            tableRow2.addView(ok);
            cf.addView(tableRow2);
        }

        else if(currentStep == 2){
            if(usePassword) tableRow3.addView(passwordForm);
            tableRow3.addView(ok);
            cf.addView(tableRow3);
        }
        else cf.addView(text3);


        ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                currentStep++;
                setUpView(context);
                if(useSteps)stepsLeft.updateStep(currentStep);

            };
        });

    }

}
