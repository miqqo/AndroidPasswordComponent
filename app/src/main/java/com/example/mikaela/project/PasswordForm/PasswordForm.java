package com.example.mikaela.project.PasswordForm;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class PasswordForm extends TableLayout {
    public TextView text;
    public EditText pwd;
    PasswordForm lm = PasswordForm.this;
    PasswordAlgorithm passwordAlgorithm;
    DrawPasswordComponent drawComponent;

    Context con;

    //** Default constructor **
    public PasswordForm(Context context) {
        super(context);
        con = context;
        passwordAlgorithm = new PasswordAlgorithm();
        drawComponent = new DrawPasswordComponent(context);

        init(context);
    }

    //** Constructor with specified Algorithm **
    public PasswordForm(Context context, PasswordAlgorithm pa){
        super(context);
        passwordAlgorithm = pa;
        drawComponent = new DrawPasswordComponent(context);

        init(context);
    }

    //** Constructor with specified drawComponent **
    public PasswordForm(Context context, DrawPasswordComponent pc){
        super(context);
        passwordAlgorithm = new PasswordAlgorithm();
        drawComponent = pc;

        init(context);
    }

    //** Constructor with specified drawComponent and algorithm**
    public PasswordForm(Context context, PasswordAlgorithm ca, DrawPasswordComponent dc){
        super(context);
        passwordAlgorithm = ca;
        drawComponent = dc;

        init(context);

    }

    private void init(Context context){
        con = context;
        setUpPassword();

    }

    public void setUpPassword(){
        TableRow row = new TableRow(con);

        text = new TextView(con);
        text.setText("Password");

        pwd = new EditText(con);
        pwd.setWidth(500);
        pwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        row.addView(text);
        row.addView(pwd);
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
            int n;
            n = passwordAlgorithm.PasswordStrength(input);
            drawComponent.updatePassword(n);

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };




}
