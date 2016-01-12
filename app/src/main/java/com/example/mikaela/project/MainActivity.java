package com.example.mikaela.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    //gör 3 klasser, 1 för komponenten (lösenordsfältet med indikator på om det är bra eller inte)
    // 1 för algorithmen vi använder för att beräkna om det är bra eller inte
    // och 1 för hur indikatorn ser ut

    //komponenten kommer då ha 4 default konstruktorer
    //1 för att skapa komponenten
    //1 för att skapa algorithmen
    //1 för att skapa indikatorn

    // en användare ska kunna välja att använda vår eller en egen variant av algorithm eller indikator

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TableLayout layout = new TableLayout(this);
        LoginMaster lm = new LoginMaster(this);

        layout.addView(lm);

        setContentView(layout);
    }
}
