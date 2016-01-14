package com.example.mikaela.project;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.mikaela.project.PasswordForm.DrawPasswordComponent;
import com.example.mikaela.project.PasswordForm.PasswordAlgorithm;
import com.example.mikaela.project.PasswordForm.PasswordForm;
import com.example.mikaela.project.StepsLeft.StepsLeft;

/**
 * Created by mikaela on 16-01-14.
 */
public class CreateForm extends TableLayout {
    public TextView text1, text2, text3;
    public EditText username, fullName;

    int currentStep, numberOfSteps;
    Button ok;
    ProgressBar progressBar;
    Context con;

    CreateForm cf = CreateForm.this;
    PasswordForm passwordForm;
    StepsLeft stepsLeft;

    public CreateForm(Context context, boolean usePasswordForm, boolean useStepsForm){
        super(context);
        con = context;


        if(usePasswordForm){
            //här kan man välja om man vill använda både algoritmen och visualiseringen eller
            //om man bara vill använda någon av dem
            passwordForm = new PasswordForm(context);
        }
        if(useStepsForm){
            stepsLeft = new StepsLeft(context);
            currentStep = stepsLeft.getCurrentStep();
            numberOfSteps = stepsLeft.setNumberOfSteps();
        }

        setUpView(context);
    }

    public void setUpView(final Context context){

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
        fullName.setWidth(600);
        fullName.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        username = new EditText(context);
        username.setWidth(600);
        username.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        cf.removeAllViews();

        progressBar = new ProgressBar(context,null,android.R.attr.progressBarStyleHorizontal);
        progressBar.setMax(numberOfSteps);
        progressBar.setProgress(1);
        progressBar.getProgressDrawable().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);

        if(stepsLeft.isProgressBarShown()){
            cf.addView(progressBar);
        }

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
            tableRow3.addView(passwordForm);
            tableRow3.addView(ok);
            cf.addView(tableRow3);
        }
        else cf.addView(text3);


        ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                currentStep++;
                setUpView(context);
                updateProgressBar(currentStep);

            };
        });

    }

    private void updateProgressBar(int level){
        progressBar.setProgress(level +1);

    }
}
