package com.example.hibernate;

public class MainApp {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();

        Employee emp = new Employee("Ajay", "VK");
        Integer id = dao.addEmployee(emp);

        System.out.println("Employee added with ID: " + id);
    }
}
