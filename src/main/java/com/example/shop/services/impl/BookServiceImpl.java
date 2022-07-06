package com.example.shop.services.impl;

import com.example.shop.model.Book;
import com.example.shop.repo.BookRepository;
import com.example.shop.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByAuthorId(Long id) {
        return bookRepository.findBooksByAuthorId(id);
    }

    @Override
    public Book getInformationBook(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Integer getCoastBooksByAuthor(Long id) {
        return bookRepository.findBooksByAuthorId(id).stream()
                .mapToInt(Book::getCoast)
                .sum();
    }


}
