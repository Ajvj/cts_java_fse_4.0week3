package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public void saveBook() {
        System.out.println("📘 Book saved using annotation-based repository!");
    }
}
