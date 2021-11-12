package com.meta.bankdemo.utils;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;




public class DateTimeUtils {
     private  static String pattern = "yyyy-MM-dd";
     private  static String pattern1 = "yyyy-MM-dd EEEE";

    public static Date convertToDate(String date) {
       try {
           DateFormat dateFormat = new SimpleDateFormat(pattern);
           //how to convert java util date to sql date.
           return new Date(dateFormat.parse(date).getTime());
       } catch (Exception ex){
           ex.printStackTrace();
           return null;

       }
    }
    public static String convertDateToString(Date date){
        try {
            DateFormat dateFormat = new SimpleDateFormat(pattern1);
            //how to convert java util date to sql date.
            return dateFormat.format(date);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;

        }
    }
}
