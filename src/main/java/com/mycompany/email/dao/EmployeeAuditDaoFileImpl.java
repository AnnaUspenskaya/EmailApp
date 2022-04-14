/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.email.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author anechka
 */
public class EmployeeAuditDaoFileImpl implements EmployeeAuditDao{

    public static final String AUDIT_FILE = "audit.txt";
    @Override
    public void writeAuditEntry(String entry) throws EmployeePersistenceException {
PrintWriter out;
try {
out = new PrintWriter(new FileWriter(AUDIT_FILE, true)); //append mode
}catch (IOException e){
    throw new EmployeePersistenceException("Could not write into audit file. ", e);
}
LocalDateTime timestamp = LocalDateTime.now();
out.println(timestamp.toString()+ " : "+entry);
out.flush();
    }
    
}
