package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Load Spring XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the bookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Use the service
        bookService.issueBook();
    }
}
