/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.email.service;

import com.mycompany.email.dao.EmployeePersistenceException;
import com.mycompany.email.dto.Employee;
import java.util.List;

/**
 *
 * @author anechka
 */
public interface EmailServiceLayer {

    void addEmployee(Employee emoloyee) throws
            EmployeeDataValidationException,
            EmployeePersistenceException;

    void updateEmployee(int id, Employee emp) throws
            EmployeeDataValidationException,
            EmployeePersistenceException;

    List<Employee> getAllEmployees() throws
            EmployeePersistenceException;

    Employee getEmployee(int id) throws
            EmployeePersistenceException;

    Employee removeEmployee(int id) throws
            EmployeePersistenceException;

}
