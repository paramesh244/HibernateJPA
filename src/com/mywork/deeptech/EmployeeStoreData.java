
package com.mywork.deeptech;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.MetadataSources;


public class EmployeeStoreData {
    
    public static void main(String[] args) {
        StandardServiceRegistry s = new StandardServiceRegistryBuilder().configure("hibconfig.cfg.xml").build();
        Metadata meta = new MetadataSources(s).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        
        
    //connection between java app with database establish time
    Session session = factory.openSession();
    
    Transaction t = session.beginTransaction();
    
    Employee e1 = new Employee();
    
    e1.setEmpname("Param");
    e1.setDesignation("Developer");
    e1.setSalary(250000);
    session.save(e1);
    t.commit();
    
        System.out.println("Data saved successfully");
        
        factory.close();
        session.close();
        
    }      
    
}
