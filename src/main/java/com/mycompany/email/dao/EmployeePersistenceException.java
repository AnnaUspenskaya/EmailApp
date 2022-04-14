/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.email.dao;

/**
 *
 * @author anechka
 */
public class EmployeePersistenceException extends Exception{
    public EmployeePersistenceException(String message){
        super(message);
    }
    public EmployeePersistenceException(String message, Throwable cause){
        super(message, cause);
    }
}
