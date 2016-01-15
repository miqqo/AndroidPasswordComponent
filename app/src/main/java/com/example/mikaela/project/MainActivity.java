package com.example.mikaela.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import com.example.mikaela.project.PasswordForm.PasswordAlgorithm;
import com.example.mikaela.project.PasswordForm.DrawPasswordComponent;
import com.example.mikaela.project.PasswordForm.PasswordForm;

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
