package com.soa.LibraryMicroservice.repository;

import com.soa.LibraryMicroservice.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    Optional<Book> findByTitle(String title);
}
