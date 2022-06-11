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
    
    Employee addEmployee (int employeeId, Employee employee) throws EmployeePersistenceException;
    
   public  void updateEmp (int id, Employee emp) throws EmployeePersistenceException;

    
    List<Employee> getAllEmployee() throws EmployeePersistenceException;
    
    Employee getEmployee(int employeeId) throws EmployeePersistenceException;
    
    Employee removeEmployee(int employeeId) throws EmployeePersistenceException;
    
}
