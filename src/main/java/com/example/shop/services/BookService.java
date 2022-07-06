package com.example.shop.services;

import com.example.shop.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    List<Book> getBooksByAuthorId(Long Id);
    Book getInformationBook(Long id);
    Integer getCoastBooksByAuthor(Long id);
}
