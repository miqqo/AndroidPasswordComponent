package com.example.mikaela.project;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class LoginMaster extends TableLayout {
    public TextView text1, text2, text3;
    public EditText username, fullName, pwd;
    LoginMaster lm = LoginMaster.this;
    ComponentAlgorithm componentAlgorithm;
    DrawComponent drawComponent;

    Context con;

    //** Default constructor **
    public LoginMaster(Context context) {
        super(context);
        componentAlgorithm = new ComponentAlgorithm();
        drawComponent = new DrawComponent(context);
        init(context);
    }

   /* //hämta algorithm
    public LoginMaster(Context context, String s){
        super(context);
        ComponentAlgorithm ca = new ComponentAlgorithm(context, s);

    }

    public LoginMaster(Context con, int n, String s){
        super(con);
        dc = new DrawComponent(con, n);
    }*/

    private void init(Context context){
        con = context;
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        setUpView(context, width);

        pwd.addTextChangedListener(watch);

        lm.addView(drawComponent);
    }


    private void setUpView(Context context, int witdh){

        TableRow tableRow1 = new TableRow(context);
        TableRow tableRow2 = new TableRow(context);
        TableRow tableRow3 = new TableRow(context);

        text1 = new TextView(context);
        text1.setText("Full name");

        text2 = new TextView(context);
        text2.setText("Username");

        text3 = new TextView(context);
        text3.setText("Password");

        fullName = new EditText(context);
        fullName.setWidth(witdh);
        fullName.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        username = new EditText(context);
        username.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        pwd = new EditText(context);
        pwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        tableRow1.addView(text1);
        tableRow2.addView(text2);
        tableRow3.addView(text3);

        tableRow1.addView(username);
        tableRow2.addView(fullName);
        tableRow3.addView(pwd);


        lm.addView(tableRow1);
        lm.addView(tableRow2);
        lm.addView(tableRow3);

    }

    TextWatcher watch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String input = s.toString();
            int n;
            n = componentAlgorithm.PasswordStrength(input);
            drawComponent.updatePassword(n);

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };




}
