package com.library.service;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    public void issueBook() {
        System.out.println("Book has been issued!");
    }
}
