package com.passwordvault.utils;

import android.os.Environment;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;

/**
 * Created by bpanchal on 02-Nov-16.
 */

public class CommonUtilities {



    public String exceptionToString(Exception e){
        String exceptionString = "";
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            exceptionString = sw.toString();
        }catch (Exception e1 ){
            e1.printStackTrace();
        }
        return exceptionString;
    }

    public void configureLoggers(){
        try {

        }
        catch (Exception e){

        }
    }
}
