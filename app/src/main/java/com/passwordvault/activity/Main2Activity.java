package com.passwordvault.activity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.passwordvault.R;
import com.passwordvault.utils.GenerateView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String title = bundle.getString("title");
        int imageId = bundle.getInt("imageId");
        //int imageBackGroundColor = bundle.getInt("imageBackGroundColor");
        // Set Title
        TextView tileTextView = (TextView)findViewById(R.id.activity_main2_title);
        tileTextView.setText(title);

        //Set Image
        ImageView image = (ImageView)findViewById(R.id.activity_main2_Image);
        image.setImageResource(imageId);
        image.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorCreditCard, null));

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.activity_main2_linearLayout);


        GenerateView generateView = new GenerateView(this);
        ArrayList<View> viewGroup = generateView.generateViewGroup(name);
        for (View view:viewGroup) {
            linearLayout.addView(view);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_save) {
            return true;
        }

        if (id== R.id.home){
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
