package com.example.mikaela.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

/**
 *  By setting passwordForm and stepsForm to true or false,
 *  you specify if you want to use any or both or none of these functions.
 *
 *  It is still possible to choose if you want to use both the password algorithm
 *  and visualization or only one of them if you set the passwordForm to true. This you
 *  do in CreateForm.
 *
 *  It is also possible to choose if you want to use a custom visualization for the
 *  steps component. This you also do in CreateForm.
 *
 *  If you want to use your own class (e.g a new visualization class for the steps-component)
 *  you need to extend the default class StepsVisualization. That gives the new class access
 *  to all functions in the default class.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TableLayout layout = new TableLayout(this);

        boolean passwordForm = true;
        boolean stepsForm = true;

        CreateForm createForm = new CreateForm(this, passwordForm, stepsForm);

        layout.addView(createForm);

        setContentView(layout);
    }
}
