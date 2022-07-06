package com.example.shop.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class AuthorDTO {
    private String firstname;
    private String lastname;
    private List<String> bookNames;
}
