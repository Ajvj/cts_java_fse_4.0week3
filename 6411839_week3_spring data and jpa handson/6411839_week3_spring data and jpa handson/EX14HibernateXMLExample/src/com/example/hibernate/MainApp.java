package com.example.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // Create SessionFactory and Session
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Create a new Employee object and save it
            Employee emp = new Employee();
            emp.setFirstName("Ajay");
            emp.setLastName("VK");
            emp.setSalary(50000);
            session.save(emp);

            // Fetch all employees and display details
            List<Employee> list = session.createQuery("FROM Employee", Employee.class).list();
            System.out.println("--------- EMPLOYEE LIST ---------");
            for (Employee e : list) {
                System.out.println("ID: " + e.getId()
                        + " | Name: " + e.getFirstName() + " " + e.getLastName()
                        + " | Salary: ₹" + e.getSalary());
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}

