package com.example.shop.repo;

import com.example.shop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b.books from Author b where b.id = :id")
    List<Book> findBooksByAuthorId(@Param("id") Long id);
}
