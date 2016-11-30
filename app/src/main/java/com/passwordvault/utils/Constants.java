package com.passwordvault.utils;

import com.passwordvault.R;
import com.passwordvault.pojo.TypeOfCategory;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bpanchal on 03-Sep-16.
 */
public class Constants {

    public static HashMap<String,String> keyValueForCategory = new HashMap<>();

    static {

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
        keyValueForCategory.put("others","others");

    }

    public static List<TypeOfCategory> categoryList;

    public static List<TypeOfCategory> getCategoryList() {
        return categoryList;
    }

    public static void setCategoryList(List<TypeOfCategory> categoryList) {
       if(Constants.categoryList ==null) Constants.categoryList = categoryList;
    }


}
