package com.example.mikaela.project.PasswordForm;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


/**
 *  This class creates the password text field and its functionality.
 *
 */

public class PasswordForm extends TableLayout {
    public TextView text;
    public EditText pwd;
    PasswordForm lm = PasswordForm.this;
    PasswordListener listener;
    PasswordAlgorithm passwordAlgorithm;
    PasswordVisualization drawComponent;
    boolean useGivenVisualization = false, useGivenAlgorithm = false;
    int oldLevel = 0;

    Context con;

    /** Default constructor */
    public PasswordForm(Context context) {
        super(context);
        con = context;
        passwordAlgorithm = new PasswordAlgorithm();
        drawComponent = new PasswordVisualization(context);
        useGivenVisualization = true;
        useGivenAlgorithm = true;

        init();
    }

    /** Constructor with custom Algorithm. */
    public PasswordForm(Context context, PasswordAlgorithm pa){
        super(context);
        passwordAlgorithm = pa;
        drawComponent = new PasswordVisualization(context);
        useGivenVisualization = true;
        useGivenAlgorithm = false;

        init();
    }

    /** Constructor with custom drawComponent */
    public PasswordForm(Context context, PasswordVisualization pc){
        super(context);
        passwordAlgorithm = new PasswordAlgorithm();
        drawComponent = pc;
        useGivenVisualization = false;
        useGivenAlgorithm = true;

        init();
    }

    /** Constructor with custom drawComponent and algorithm.*/
    public PasswordForm(Context context, PasswordAlgorithm ca, PasswordVisualization dc){
        super(context);
        passwordAlgorithm = ca;
        drawComponent = dc;
        useGivenVisualization = false;
        useGivenAlgorithm = false;

        init();
    }

    public void setListener(PasswordListener listener){
        this.listener = listener;
    }

    private void init(){
        setUpPassword();
    }

    /* If you are using a custom visualization, you need to decide where in the view
    * you want to put it. Add the component to the current row or create a new row. */
    private void setUpPassword(){

        DisplayMetrics metrics = con.getResources().getDisplayMetrics();
        int width = metrics.widthPixels - metrics.widthPixels/2;

        TableRow row = new TableRow(con);

        text = new TextView(con);
        text.setText("Password");

        pwd = new EditText(con);
        pwd.setWidth(width);
        pwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        row.addView(text);
        row.addView(pwd);

        /** Here the visualization is added to the view*/
        row.addView(drawComponent);


        lm.addView(row);
        pwd.addTextChangedListener(watch);

    }


    TextWatcher watch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String input = s.toString();
            int n = 0, numberOfSteps = 0;

            numberOfSteps = passwordAlgorithm.getNumberOfSteps();
            n = passwordAlgorithm.PasswordStrength(input);

            drawComponent.updatePassword(n, numberOfSteps);

            //notify the password has updated a level
            if(n != oldLevel){
                oldLevel = n;
                listener.Passwordupdate(n);
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}
