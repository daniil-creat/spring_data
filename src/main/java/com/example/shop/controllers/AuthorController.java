package com.example.shop.controllers;

import com.example.shop.dto.AuthorDTO;
import com.example.shop.model.Book;
import com.example.shop.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/allauthors")
    public List<AuthorDTO> getAllAuthors() {
        return authorService.getAllAuthors().stream()
                .map(author -> AuthorDTO.builder()
                        .firstname(author.getFirstName())
                        .lastname(author.getLastName())
                        .bookNames(author.getBooks().stream()
                                .map(Book::getName)
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }
}
