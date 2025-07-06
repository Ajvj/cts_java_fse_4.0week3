package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    // Field injection using @Autowired
    @Autowired
    private BookRepository bookRepository;

    public void issueBook() {
        System.out.println("📖 Issuing book using annotation-configured service...");
        bookRepository.saveBook();
    }
}
