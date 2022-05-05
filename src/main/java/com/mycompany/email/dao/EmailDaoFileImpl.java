/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.email.dao;

import com.mycompany.email.dto.Employee;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author anechka
 */
public class EmailDaoFileImpl implements EmailDao {

    private Map<String, Employee> employees = new HashMap<>();
    public static final String EMAIL_FILE = "EmployeeEmail.txt";
    public static final String DELIMITER = "::";

    @Override
    public Employee addEmployee(String employeeId, Employee employee) throws EmployeePersistenceException {
        Employee newEmployee = employees.put(employeeId, employee);
        writeFile();
        return newEmployee;
    }
    
     @Override
    public Employee updateEmp(String id, Employee employee) throws EmployeePersistenceException{
              loadFile();
       
        
        Employee emp =  employees.get(id);
        Employee updatedEmp = employees.put(id, emp);
        //1writeFile();
        return updatedEmp;
    }

    @Override
    public List<Employee> getAllEmployee() throws EmployeePersistenceException {
       loadFile();
        return new ArrayList<Employee>(employees.values());
    }

    @Override
    public Employee getEmployee(String employeeId) throws EmployeePersistenceException {
       loadFile();
        return employees.get(employeeId);
    }

    @Override
    public Employee removeEmployee(String employeeId) throws EmployeePersistenceException {
        Employee removedEmployee = employees.remove(employeeId);
        writeFile();
        return removedEmployee;
    }

    // reads file into memory
    private void loadFile() throws EmployeePersistenceException {
        Scanner sc;
        try {
            sc = new Scanner(new BufferedReader(new FileReader(EMAIL_FILE)));
        } catch (FileNotFoundException e) { 
            throw new EmployeePersistenceException(
                    "Could not download Email list ", e);
        }
        String currentLine;
        String[] currentTokens;
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Employee currentEmployee = new Employee(currentTokens[0]);
            currentEmployee.setFirstName(currentTokens[1]);
            currentEmployee.setLastName(currentTokens[2]);
            currentEmployee.setDepartment(currentTokens[3]);
            currentEmployee.setEmail(currentTokens[4]);
            currentEmployee.setPassword(currentTokens[5]);
            //put employee into the map 
            employees.put(currentEmployee.getEmployeeId(), currentEmployee);
        }
        sc.close();
    }

    //writes into the file 
    private void writeFile() throws EmployeePersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(EMAIL_FILE));
        } catch (IOException e) {
            throw new EmployeePersistenceException("Cound not save new employee", e);
        }
        List<Employee> employeeList = this.getAllEmployee();
        for (Employee currentEmployee : employeeList) {
            out.println( currentEmployee.getEmployeeId()+DELIMITER
                    +currentEmployee.getFirstName()+ DELIMITER
                    + currentEmployee.getLastName() + DELIMITER
                    + currentEmployee.getDepartment() + DELIMITER
                    + currentEmployee.getEmail() + DELIMITER
                    + currentEmployee.getPassword());
            out.flush();
        }
        out.close();
    }

}
