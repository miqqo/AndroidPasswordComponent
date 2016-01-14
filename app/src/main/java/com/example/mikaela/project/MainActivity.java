package com.example.mikaela.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import com.example.mikaela.project.PasswordForm.PasswordAlgorithm;
import com.example.mikaela.project.PasswordForm.DrawPasswordComponent;
import com.example.mikaela.project.PasswordForm.PasswordForm;

public class MainActivity extends AppCompatActivity {

    //gör 3 klasser, 1 för komponenten (lösenordsfältet med indikator på om det är bra eller inte)
    // 1 för algorithmen vi använder för att beräkna om det är bra eller inte
    // och 1 för hur indikatorn ser ut


    // en användare ska kunna välja att använda vår eller en egen variant av algorithm eller indikator

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
