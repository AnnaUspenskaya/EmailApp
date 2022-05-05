/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.email.dao;

import com.mycompany.email.dto.Employee;
import java.util.List;

/**
 *
 * @author anechka
 */
public interface EmailDao {
    
    Employee addEmployee (String employeeId, Employee employee) throws EmployeePersistenceException;
    
    Employee updateEmp (String employeeId, Employee emp) throws EmployeePersistenceException;

    
    List<Employee> getAllEmployee() throws EmployeePersistenceException;
    
    Employee getEmployee(String employeeId) throws EmployeePersistenceException;
    
    Employee removeEmployee(String employeeId) throws EmployeePersistenceException;
    
}
