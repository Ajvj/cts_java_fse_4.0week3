package com.library.service;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    public void issueBook() {
        System.out.println("Issuing book...");
        try {
            Thread.sleep(500); // Simulate some processing time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
