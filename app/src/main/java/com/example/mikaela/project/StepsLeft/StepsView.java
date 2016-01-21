package com.example.mikaela.project.StepsLeft;

import android.content.Context;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by mikaela on 16-01-19.
 */
public class StepsView extends TableLayout {
    Context context;
    public TextView text1, text2, text3;
    public EditText username, fullName;
    int currentStep;

    StepsView sv = StepsView.this;

    public StepsView(Context con, int n){
        super(con);
        context = con;
        addToArray(n);
    }

    private void addToArray(int current){
        currentStep = current;

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;


        TableRow tableRow1 = new TableRow(context);
        TableRow tableRow2 = new TableRow(context);
        TableRow tableRow3 = new TableRow(context);

        text1 = new TextView(context);
        text1.setText("Full name");

        text2 = new TextView(context);
        text2.setText("Username");

        text3 = new TextView(context);
        text3.setText("Well done!");
        text3.setGravity(Gravity.CENTER_HORIZONTAL);

        fullName = new EditText(context);
        fullName.setWidth(width);
       // fullName.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        fullName.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        username = new EditText(context);
        username.setWidth(width);
       // username.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        username.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        if(currentStep == 0){
            tableRow1.addView(text1);
            tableRow1.addView(username);
            sv.addView(tableRow1);
        }
        else if(currentStep == 1){
            tableRow2.addView(text2);
            tableRow2.addView(fullName);
            sv.addView(tableRow2);
        }
      /*  else if(currentStep == 3){
            tableRow3.addView(text3);
            sv.addView(tableRow3);
        }
*/
    }
}
