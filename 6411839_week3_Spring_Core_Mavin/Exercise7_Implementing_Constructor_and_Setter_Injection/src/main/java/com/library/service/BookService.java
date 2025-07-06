package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private String librarianName;
    private BookRepository bookRepository;

    // Constructor Injection
    public BookService(String librarianName) {
        this.librarianName = librarianName;
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void issueBook() {
        System.out.println("👤 Librarian: " + librarianName + " issued a book.");
        bookRepository.save();
    }
}
