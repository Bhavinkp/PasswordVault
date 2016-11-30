package com.passwordvault.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.passwordvault.R;
import com.passwordvault.utils.GenerateView;

import java.util.ArrayList;

public class AddNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_credit_card);
        setContentView(R.layout.activity_add_new);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.addNew_LinearLayout);
        linearLayout.setNestedScrollingEnabled(true);
        GenerateView generateView = new GenerateView(this);

        TextView textView = (TextView)findViewById(R.id.textView3);
        textView.setText("Credit Card");

        ArrayList<View> viewGroup = generateView.generateViewGroup("creditCard");
        for (View view:viewGroup) {
            view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            linearLayout.addView(view);
        }

    }

}
