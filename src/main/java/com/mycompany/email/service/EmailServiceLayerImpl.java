/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.email.service;

import com.mycompany.email.dao.EmailDao;
import com.mycompany.email.dao.EmployeeAuditDao;
import com.mycompany.email.dao.EmployeePersistenceException;
import com.mycompany.email.dto.Employee;
import java.util.List;

/**
 *
 * @author anechka
 */
public class EmailServiceLayerImpl implements EmailServiceLayer{

    private EmailDao dao;
    private EmployeeAuditDao audit;
    
    public EmailServiceLayerImpl (EmailDao dao, EmployeeAuditDao audit){
        this.dao= dao;
        this.audit = audit;
    }
    
    @Override
    public void addEmployee(Employee emp) throws EmployeeDataValidationException, EmployeePersistenceException {
        
        
        validateEmployeeData(emp);
//if all the fields are filled, persist the object Employee

dao.addEmployee(emp.getEmployeeId(), emp); 

//The employee is created, write into the audit log

audit.writeAuditEntry(" + The NEW employee "+ emp.getFirstName()+ " "+ emp.getLastName()
+" with ID: "+emp.getEmployeeId() + " joined the company.");
    }
    
    @Override
    public void updateEmployee (String id, Employee emp) throws EmployeeDataValidationException, EmployeePersistenceException {
                validateEmployeeData(emp);
//if all the fields are filled, persist the object Employee

dao.updateEmp(emp.getEmployeeId(), emp);

//The employee is created, write into the audit log
audit.writeAuditEntry(" 0 The  employee "+ emp.getFirstName()+ " "+ emp.getLastName()
+" with ID: "+emp.getEmployeeId() + " has been updated.");
    }

    @Override
    public List<Employee> getAllEmployees() throws EmployeePersistenceException {
return dao.getAllEmployee();
    }

    @Override
    public Employee getEmployee(String id) throws EmployeePersistenceException {
return dao.getEmployee(id);
    }

    @Override
    public Employee removeEmployee(String id) throws EmployeePersistenceException {
        

Employee removedEmp = dao.removeEmployee(id);

audit.writeAuditEntry(" - The employee "+removedEmp.getFirstName()+ " "+ removedEmp.getLastName()
+" with ID: "+removedEmp.getEmployeeId() + " was REMOVED from the company.");
    
    return removedEmp;}
    private void validateEmployeeData(Employee emp) throws EmployeeDataValidationException {
        if (emp.getFirstName()== null
                || emp.getFirstName().trim().length() ==0
                || emp.getLastName() == null
                || emp.getLastName().trim().length() ==0 
                || emp.getDepartment() == null) {
            throw new EmployeeDataValidationException(
            "ERROR: All fields are required.");
        }
    }
}
