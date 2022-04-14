/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.email;

import com.mycompany.email.controller.EmailController;
import com.mycompany.email.dao.EmailDao;
import com.mycompany.email.dao.EmailDaoFileImpl;
import com.mycompany.email.dao.EmployeeAuditDao;
import com.mycompany.email.dao.EmployeeAuditDaoFileImpl;
import com.mycompany.email.service.EmailServiceLayer;
import com.mycompany.email.service.EmailServiceLayerImpl;
import com.mycompany.email.ui.EmailView;
import com.mycompany.email.ui.UserIO;
import com.mycompany.email.ui.UserIOConsoleImpl;

/**
 *
 * @author anechka
 */
public class App {
    	    public static void main(String[] args) {
                //Instantiate UserIO
                UserIO myIo = new UserIOConsoleImpl();
                //instatiate myView and wire with UserIO
                EmailView myView = new EmailView(myIo);
                //Instatiate the DAO(data access objects)
                EmailDao myDao = new EmailDaoFileImpl();
                //Instantiate the Audit DAO
                EmployeeAuditDao audit = new EmployeeAuditDaoFileImpl();
                //Instatiate the Service Layer and wire with DAO and Audit
                EmailServiceLayer service = new EmailServiceLayerImpl(myDao, audit);
                //Instantiate the Controller and wire wire Service Layer and View
                EmailController controller = new EmailController(service, myView);
                controller.run();
            }
}
