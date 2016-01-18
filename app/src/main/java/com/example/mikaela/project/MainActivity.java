package com.example.mikaela.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import com.example.mikaela.project.PasswordForm.PasswordAlgorithm;
import com.example.mikaela.project.PasswordForm.DrawPasswordComponent;
import com.example.mikaela.project.PasswordForm.PasswordForm;

/**
 *  By setting passwordForm and stepsForm to true or false,
 *  you specify if you want to use any or both or none of these functions.
 *
 *  It is still possible to choose if you want to use both the password algorithm
 *  and visualization or only one of them if you set the passwordForm to true. This you
 *  do in CreateForm.
 *
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TableLayout layout = new TableLayout(this);

        boolean passwordForm = false;
        boolean stepsForm = true;

        CreateForm createForm = new CreateForm(this, passwordForm, stepsForm);

        layout.addView(createForm);

        setContentView(layout);
    }
}
