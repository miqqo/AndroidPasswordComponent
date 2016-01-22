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
import com.example.mikaela.project.PasswordForm.PasswordListener;
import com.example.mikaela.project.StepsLeft.StepsLeft;
import com.example.mikaela.project.StepsLeft.StepsListener;

/**
 *  This class creates an example of an log-in form. If the booleans are set to true in MainActivity,
 *  the log-in form will use the two components: passwordForm and stepsLeft.
 *  These are possible to modify by adding your own parameters.
 *
 */

public class CreateForm extends TableLayout {

    int currentStep;
    public int numberOfViews = 4;
    Button ok;
    TextView text;
    Context con;
    boolean usePassword, useSteps;

    public TextView text1, text2, text3;
    public EditText username, fullName;

    CreateForm cf = CreateForm.this;
    PasswordForm passwordForm;
    StepsLeft stepsLeft;

    public CreateForm(Context context, boolean usePasswordForm, boolean useStepsForm){
        super(context);
        con = context;

        /** Possible to choose if you want to use your own way of visualizing the steps.
         * To do so, add a parameter connected to your class to StepsLeft(). For example:
         * StepsLeft(context, new YourNewClass())
         * */
        if(useStepsForm){
            stepsLeft = new StepsLeft(context);
            currentStep = stepsLeft.getCurrentStep();
            stepsLeft.setListener(new StepsListener() {
                @Override
                public void StepsUpdate(int n) {
                    System.out.println("Step updated");
                }
            });
        }
        /** Possible to choose if you want to use your own algorithm and if you want to use
         *  your own way of visualizing the strength of the password. To do so, add a new
         *  parameter to PasswordForm(context).*/
        if(usePasswordForm){
            passwordForm = new PasswordForm(context);
            passwordForm.setListener(new PasswordListener() {
                @Override
                public void Passwordupdate(int n) {
                    System.out.println("Password updated");
                }
            });

        }

        usePassword = usePasswordForm;
        useSteps = useStepsForm;

        setUpView();
    }

    /** Sets up an example log-in form. The views are added to an array in the steps-component.
     *  The current view is then added to the container in the component. To add a new view,
     *  change the parameter numberOfViews, add a new TableRow with content and add the view to
     *  the array in the steps-component.*/
    private void setUpView(){

        ok = new Button(con);
        ok.setText("ok");

        text = new TextView(con);
        text.setText("Well done!");
        text.setGravity(Gravity.CENTER_HORIZONTAL);

        DisplayMetrics metrics = con.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;


        TableRow tableRow1 = new TableRow(con);
        TableRow tableRow2 = new TableRow(con);
        TableRow tableRow3 = new TableRow(con);

        text1 = new TextView(con);
        text1.setText("Full name");

        text2 = new TextView(con);
        text2.setText("Username");

        text3 = new TextView(con);
        text3.setText("Well done!");
        text3.setGravity(Gravity.CENTER_HORIZONTAL);

        fullName = new EditText(con);
        fullName.setWidth(width);
        fullName.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        username = new EditText(con);
        username.setWidth(width);
        username.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);


        tableRow1.addView(text1);
        tableRow1.addView(username);

        tableRow2.addView(text2);
        tableRow2.addView(fullName);

        tableRow3.addView(text3);

        //only need to be added once.
        if(currentStep == 0){
            stepsLeft.addStep(tableRow1);
            stepsLeft.addStep(tableRow2);

            if(usePassword) {
                stepsLeft.addStep(passwordForm);
            }
            stepsLeft.addStep(tableRow3);

        }

        cf.removeAllViews();

        if(useSteps){
            stepsLeft.setStep(currentStep);
            cf.addView(stepsLeft);
        }


        //do not add the button to the last view
        if(currentStep != numberOfViews-1){
            cf.addView(ok);
        }

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // stepsLeft.setDone(currentStep);

                currentStep++;
                setUpView();

                if (useSteps) {
                    stepsLeft.updateStep(currentStep);
                }
            };
        });

    }

}
