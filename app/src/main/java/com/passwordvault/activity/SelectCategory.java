package com.passwordvault.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.ColorRes;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.passwordvault.R;
import com.passwordvault.adapter.CategoryAdapter;
import com.passwordvault.pojo.TypeOfCategory;
import com.passwordvault.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class SelectCategory extends AppCompatActivity {
    private  RecyclerView recyclerView;
    public  static View.OnClickListener myOnClickListener;
    CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        setCategoryList();

        myOnClickListener = new MyOnClickListener(this);
        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(false);

        final LinearLayoutManager llm = new LinearLayoutManager(this.getApplicationContext());
        llm.setSmoothScrollbarEnabled(true);
        recyclerView.setLayoutManager(llm);

        adapter = new CategoryAdapter(Constants.getCategoryList());
        recyclerView.setAdapter(adapter);


    }


    private class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {

            int selectedItemPosition = recyclerView.getChildPosition(v);
            RecyclerView.ViewHolder viewHolder
                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
            TextView name = (TextView) viewHolder.itemView.findViewById(R.id.categoryName);
            TextView title = (TextView) viewHolder.itemView.findViewById(R.id.categoryTitle);
            ImageView image = (ImageView) viewHolder.itemView.findViewById(R.id.categoryImageView);


            Intent intent = new Intent(SelectCategory.this,Main2Activity.class);
            intent.putExtra("title",title.getText().toString());
            intent.putExtra("name",name.getText().toString());
            intent.putExtra("imageId",(Integer)image.getTag());
            //intent.putExtra("imageBackGroundColor",(Integer)image.getTag(1));
            startActivity(intent);

        }
    }

    /**
     * Set Category List from Resource Array
     */
    private void setCategoryList(){

        String[] cat = getResources().getStringArray(R.array.Categories);
        List<TypeOfCategory> typeOfCategoryList = new ArrayList<>();
        for (String item : cat)
        {
            TypeOfCategory typeOfCategory = new TypeOfCategory();
            typeOfCategory.setTitle(item);
            typeOfCategory.setCategoryName(item);

            if((item.contains("Credit")))
            {
                typeOfCategory.setCategoryName(Constants.keyValueForCategory.get("creditCard"));
                typeOfCategory.setImageId(R.drawable.ic_credit_card_white_48dp);
                typeOfCategory.setBackgroundColorId(ResourcesCompat.getColor(getResources(), R.color.colorCreditCard, null));
            }
            else if((item.contains("Website")))
            {
                typeOfCategory.setCategoryName(Constants.keyValueForCategory.get("websiteLogin"));
                typeOfCategory.setImageId(R.drawable.ic_public_white_48dp);
                typeOfCategory.setBackgroundColorId(ResourcesCompat.getColor(getResources(), R.color.colorWebsiteLogin, null));
            }
            else if((item.contains("Computer")))
            {
                typeOfCategory.setCategoryName(Constants.keyValueForCategory.get("computerLogin"));
                typeOfCategory.setImageId(R.drawable.ic_computer_white_48dp);
                typeOfCategory.setBackgroundColorId(ResourcesCompat.getColor(getResources(), R.color.colorComputerLogin, null));
            }
            else if((item.contains("E-Banking")))
            {
                typeOfCategory.setCategoryName(Constants.keyValueForCategory.get("eBanking"));
                typeOfCategory.setImageId(R.drawable.ic_public_white_48dp);
                typeOfCategory.setBackgroundColorId(ResourcesCompat.getColor(getResources(), R.color.colorEbanking, null));
            }
            else if((item.contains("E-Shopping")))
            {
                typeOfCategory.setCategoryName(Constants.keyValueForCategory.get("eShopping"));
                typeOfCategory.setImageId(R.drawable.ic_shopping_cart_white_48dp);
                typeOfCategory.setBackgroundColorId(ResourcesCompat.getColor(getResources(), R.color.colorEshopping, null));
            }
            else if((item.contains("E-mail")))
            {
                typeOfCategory.setCategoryName(Constants.keyValueForCategory.get("eMail"));
                typeOfCategory.setImageId(R.drawable.ic_email_white_48dp);
                typeOfCategory.setBackgroundColorId(ResourcesCompat.getColor(getResources(), R.color.colorEmail, null));
            }else if((item.contains("Insurance")))
            {
                typeOfCategory.setCategoryName(Constants.keyValueForCategory.get("insurancePolicy"));
                typeOfCategory.setImageId(R.drawable.plus);
                typeOfCategory.setBackgroundColorId(ResourcesCompat.getColor(getResources(), R.color.colorOthers, null));
            }else if((item.contains("Documents")))
            {
                typeOfCategory.setCategoryName(Constants.keyValueForCategory.get("documents"));
                typeOfCategory.setImageId(R.drawable.plus);
                typeOfCategory.setBackgroundColorId(ResourcesCompat.getColor(getResources(), R.color.colorOthers, null));
            }else if((item.contains("Secure Note")))
            {
                typeOfCategory.setCategoryName(Constants.keyValueForCategory.get("secureNotes"));
                typeOfCategory.setImageId(R.drawable.plus);
                typeOfCategory.setBackgroundColorId(ResourcesCompat.getColor(getResources(), R.color.colorOthers, null));
            }else if((item.contains("Account")))
            {
                typeOfCategory.setCategoryName(Constants.keyValueForCategory.get("bankAccount"));
                typeOfCategory.setImageId(R.drawable.plus);
                typeOfCategory.setBackgroundColorId(ResourcesCompat.getColor(getResources(), R.color.colorOthers, null));
            }else if((item.contains("Others")))
            {
                typeOfCategory.setCategoryName(Constants.keyValueForCategory.get("others"));
                typeOfCategory.setImageId(R.drawable.plus);
                typeOfCategory.setBackgroundColorId(ResourcesCompat.getColor(getResources(), R.color.colorOthers, null));
            }else{

                typeOfCategory.setImageId(R.drawable.plus);
                typeOfCategory.setBackgroundColorId(ResourcesCompat.getColor(getResources(), R.color.colorOthers, null));

            }

            typeOfCategoryList.add(typeOfCategory);
        }

        if(!typeOfCategoryList.isEmpty())Constants.setCategoryList(typeOfCategoryList);

    }

}
