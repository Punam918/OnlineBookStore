package com.Ragnar.OnlineBookStore.repository;

import com.Ragnar.OnlineBookStore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // i can add later
}
