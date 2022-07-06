package com.example.shop.controllers;

import com.example.shop.dto.BookDTO;
import com.example.shop.dto.BooksCoastDTO;
import com.example.shop.model.Author;
import com.example.shop.model.Book;
import com.example.shop.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookControllers {

    private final BookService bookService;

    @GetMapping("/allbook")
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks().stream()
                .map(book -> BookDTO.builder()
                        .name(book.getName())
                        .coast(book.getCoast())
                        .booksAuthorsName(book.getAuthors().stream()
                                .map(Author::getLastName)
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping("/author/{id}")
    public List<BookDTO> getBooksByAuthorId(@PathVariable("id") Long id) {
        return bookService.getBooksByAuthorId(id).stream()
                .map(book -> BookDTO.builder()
                        .name(book.getName())
                        .coast(book.getCoast())
                        .booksAuthorsName(book.getAuthors().stream()
                                .map(Author::getLastName)
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping("/information/{id}")
    public BookDTO getInformationBook(@PathVariable("id") Long id) {
        Book book = bookService.getInformationBook(id);
        return BookDTO.builder()
                .name(book.getName())
                .coast(book.getCoast())
                .booksAuthorsName(book.getAuthors().stream()
                        .map(Author::getLastName)
                        .collect(Collectors.toList()))
                .build();
    }

    @GetMapping("/coast/{id}")
    public BooksCoastDTO getCoastBooksByAuthor(@PathVariable("id") Long id) {
       Integer coast = bookService.getCoastBooksByAuthor(id);
        return BooksCoastDTO.builder()
                .coast(coast)
                .build();
    }
}
