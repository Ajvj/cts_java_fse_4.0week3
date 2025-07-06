package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBook(int id) {
        String book = bookRepository.findBookById(id);
        System.out.println("Book Details: " + book);
    }
}
