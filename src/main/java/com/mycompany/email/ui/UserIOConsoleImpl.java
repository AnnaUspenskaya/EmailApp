/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.email.ui;

import java.util.Scanner;

/**
 *
 * @author anechka
 */
public class UserIOConsoleImpl implements UserIO{

 @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    
    @Override
    public String readString(String prompt) {
        print(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
}
        @Override
    public double readDouble(String prompt) {
        double result = 0;
        try {
            result = Double.parseDouble(readString(prompt));
        } catch (NumberFormatException ex) {
            print("Please enter a number.");
            result = readInt(prompt);
        }
        return result;     
    }
    @Override
    public double readDouble(String prompt, double min, double max) {
        double result = 0;
        try {
            result = Double.parseDouble(readString(prompt));
            if (result < min || result > max) {
            }
        } catch (NumberFormatException ex) {
            print("Please enter a number between " + min + " and " + max);
            result = readDouble(prompt);
        }
        return result;
        }
   

    @Override
    public float readFloat(String prompt) {
float result = 0;
        try {
            result = Long.parseLong(readString(prompt));
        } catch (NumberFormatException ex) {
            print("Please enter a number.");
            result = readFloat(prompt);
        }
        return result;        }   
        
    @Override
    public float readFloat(String prompt, float min, float max) {
        float result = 0;
        try {
            result = Float.parseFloat(readString(prompt));
            if (result < min || result > max) {
            }
        } catch (NumberFormatException ex) {
            print("Please enter a number between " + min + " and " + max);
            result = readFloat(prompt);
        }
        return result;    }


    @Override
    public int readInt(String prompt) {
        int result = 0;
        try {
            result = Integer.parseInt(readString(prompt));
        } catch (NumberFormatException ex) {
            print("Please enter a number.");
            result = readInt(prompt);
        }
        return result;    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int result = 0;
        try {
            result = Integer.parseInt(readString(prompt));
            if (result < min || result > max) {
            }
        } catch (NumberFormatException ex) {
            print("Please enter a number between " + min + " and " + max);
            result = readInt(prompt);
        }
        return result;
    }

    @Override
    public long readLong(String prompt) {
long result = 0;
        try {
            result = Long.parseLong(readString(prompt));
        } catch (NumberFormatException ex) {
            print("Please enter a number.");
            result = readLong(prompt);
        }
        return result;        }

    @Override
    public long readLong(String prompt, long min, long max) {
        long result = 0;
        try {
            result = Long.parseLong(readString(prompt));
            if (result < min || result > max) {
            }
        } catch (NumberFormatException ex) {
            print("Please enter a number between " + min + " and " + max);
            result = readLong(prompt);
        }
        return result;    }
    
}
