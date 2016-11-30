package com.passwordvault.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.text.InputType;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;

import android.view.inputmethod.InputMethod;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.passwordvault.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpanchal on 03-Nov-16.
 */

public class GenerateView extends Activity{

    Context context;

    public GenerateView(Context context){
        this.context = context;
    }

    public ArrayList<View> generateViewGroup(String viewGroupFor ){

        ArrayList<View> viewGroup = new ArrayList<View>();
        String[] array=null;
        try{

            /*
             keyValueForCategory.put("creditCard","creditCard");
        keyValueForCategory.put("bankAccount","bankAccount");
        keyValueForCategory.put("eMail","eMail");
        keyValueForCategory.put("eShopping","eShopping");
        keyValueForCategory.put("eBanking","eBanking");
        keyValueForCategory.put("documents","documents");
        keyValueForCategory.put("insurancePolicy","insurancePolicy");
        keyValueForCategory.put("secureNotes","secureNotes");
        keyValueForCategory.put("websiteLogin","websiteLogin");
        keyValueForCategory.put("computerLogin","computerLogin");
        keyValueForCategory.put("Others","Others");
             */
            if(viewGroupFor.equals("creditCard")){
                array = context.getResources().getStringArray(R.array.creditCardTextView);
            }else if(viewGroupFor.equals("websiteLogin")){
                array = context.getResources().getStringArray(R.array.webloginTextView);
            }else if(viewGroupFor.equals("eMail")){
                array = context.getResources().getStringArray(R.array.emailTextView);
            }else if(viewGroupFor.equals("eShopping")){
                array = context.getResources().getStringArray(R.array.eShoppingTextView);
            }else if(viewGroupFor.equals("computerLogin")){
                array = context.getResources().getStringArray(R.array.computerLoginTextView);
            }else if(viewGroupFor.equals("eBanking")){
                array = context.getResources().getStringArray(R.array.eBankingTextView);
            }else if(viewGroupFor.equals("bankAccount")){
                array = context.getResources().getStringArray(R.array.bankAccountTextView);
            }else if(viewGroupFor.equals("others")){
                array = context.getResources().getStringArray(R.array.othersTextView);
            }else if(viewGroupFor.equals("documents")){
                array = context.getResources().getStringArray(R.array.documentsTextView);
            }else if(viewGroupFor.equals("insurancePolicy")){
                array = context.getResources().getStringArray(R.array.insurancePolicyTextView);
            }
            for (String itemName:array) {
                viewGroup.add(getNewTextView(itemName));
                viewGroup.add(getNewEditTextView(itemName));
                viewGroup.add(generateDividerView());
            }
        }
        catch (Exception e){
                e.printStackTrace();
        }
        return viewGroup;
    }


    public View generateDividerView(){

        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,2));
        view.setBackgroundColor(Color.parseColor("#d4d3d4"));

        return view;
    }

    public TextView getNewTextView(String title){

        TextView textView = new TextView(context);
        if(title.toLowerCase().contains("date"))textView.setText(title.concat("  (dd/mm/yyyy)"));
        else textView.setText(title);

        textView.setTextColor(Color.BLACK);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        if (Build.VERSION.SDK_INT < 23)
            textView.setTextAppearance(context,android.R.style.TextAppearance);
        else
            textView.setTextAppearance(android.R.style.TextAppearance);
        return textView;
    }

    public TextInputLayout getNewEditTextView(String hint){

        TextInputLayout textInputLayout = new TextInputLayout(context);
        textInputLayout.setPasswordVisibilityToggleEnabled(true);

        textInputLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        EditText editTextInputLayout = new EditText(context);
        //editTextInputLayout.setId(R.id.editTextInputLayout);
        //editTextInputLayout.setHint(hint);
        editTextInputLayout.setTextSize(16);
        editTextInputLayout.setSingleLine(true);
        editTextInputLayout.setBackgroundColor(Color.TRANSPARENT);

        //Properties set depending upon hint value
        if(hint.toLowerCase().contains("number") && hint.toLowerCase().contains("card")){
            editTextInputLayout.setInputType(InputType.TYPE_CLASS_NUMBER );
        }else if( hint.toLowerCase().contains("number") && hint.toLowerCase().contains("pin")){
            editTextInputLayout.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        }else if(hint.toLowerCase().contains("number") && hint.toLowerCase().contains("cvv")){
            editTextInputLayout.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        }else if(hint.toLowerCase().contains("password")){
            editTextInputLayout.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }else if(hint.toLowerCase().contains("date")){
            editTextInputLayout.setInputType(InputType.TYPE_CLASS_DATETIME |InputType.TYPE_DATETIME_VARIATION_DATE);
        }else if(hint.toLowerCase().contains("time")){
            editTextInputLayout.setInputType(InputType.TYPE_CLASS_DATETIME |InputType.TYPE_DATETIME_VARIATION_TIME);
        }else if(hint.toLowerCase().contains("note")){
            editTextInputLayout.setInputType(InputType.TYPE_CLASS_TEXT| InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            editTextInputLayout.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
            editTextInputLayout.setMinHeight(250);
        }else if(hint.toLowerCase().contains("email")){
            editTextInputLayout.setInputType(InputType.TYPE_CLASS_TEXT| InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        }else
            editTextInputLayout.setInputType(InputType.TYPE_CLASS_TEXT);

        textInputLayout.addView(editTextInputLayout);
        return textInputLayout;
    }
}
