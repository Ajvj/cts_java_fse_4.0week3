package com.example.hibernate;

import java.io.InputStream;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        // Check if employee.hbm.xml is found in classpath
        InputStream is = MainApp.class.getClassLoader().getResourceAsStream("employee.hbm.xml");
        System.out.println(is != null ? "✅ employee.hbm.xml Found!" : "❌ employee.hbm.xml Not Found!");

        // Set up Hibernate SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Hibernate config file
                .buildSessionFactory();

        // Open Hibernate session
        Session session = factory.openSession();

        try {
            // Begin transaction
            session.beginTransaction();

            // Create Employee object
            Employee emp = new Employee();
            emp.setFirstName("Ajay");
            emp.setLastName("Sai");
            emp.setSalary(90000);

            // Save to DB
            session.save(emp);

            // Commit transaction
            session.getTransaction().commit();
            System.out.println("✅ Employee saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
            factory.close();
        }
    }
}
