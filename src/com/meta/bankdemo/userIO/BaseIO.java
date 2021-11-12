package com.meta.bankdemo.userIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BaseIO {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    public void display(String message) {
        System.out.println(message);
    }

    public String read(String fieldName) {
        try {
            display("------------------------------");
            display("Enter customer's " + fieldName);
            display("------------------------------");
            return bufferedReader.readLine();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public String readChoice(String message) {
        try {
            display("------------------------------");
            display(message);

            return bufferedReader.readLine();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
}


