/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.email.service;

/**
 *
 * @author anechka
 */
public class EmployeeDataValidationException extends Exception{
    
    public EmployeeDataValidationException(String message){
        super(message);
    }
    public EmployeeDataValidationException(String message, Throwable cause){
        super(message, cause);
    }
    
}
