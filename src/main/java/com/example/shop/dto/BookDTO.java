package com.example.shop.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookDTO {
    private String name;
    private Integer coast;
    private List<String> booksAuthorsName;
}
