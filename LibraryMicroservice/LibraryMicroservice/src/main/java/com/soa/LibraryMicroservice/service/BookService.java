package com.soa.LibraryMicroservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soa.LibraryMicroservice.domain.NotificationRabbitDto;
import com.soa.LibraryMicroservice.domain.entity.Book;
import com.soa.LibraryMicroservice.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final NotificationPublisher notificationPublisher;
    private final StatisticsPubliser statisticsPubliser;
    private final ObjectMapper objectMapper;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public void burrowBook(String title) {
        var optionalBook = bookRepository.findByTitle(title);
        if (optionalBook.isEmpty()) {
            throw new RuntimeException("Book not found by title %s".formatted(title));
        }
        var product = optionalBook.get();

        product.setStatus(false);
        bookRepository.save(product);

        publishNotification(product);
        publishStatistics(product);
    }

    @Transactional
    public void returnBook(String title) {
        var optionalBook = bookRepository.findByTitle(title);
        if (optionalBook.isEmpty()) {
            throw new RuntimeException("Book not found by title %s".formatted(title));
        }
        var product = optionalBook.get();

        product.setStatus(true);
        bookRepository.save(product);

        publishNotification(product);
        publishStatistics(product);
    }

    private void publishNotification(Book book) {
        var emailRequest = NotificationRabbitDto.builder()
                .title(book.getTitle())
                .status(book.isStatus())
                .build();
        notificationPublisher.publishNotification(emailRequest);
    }

    private void publishStatistics(Book book){
        try {
            statisticsPubliser.publishStatistics(objectMapper.writeValueAsString(book));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error while trying to serilize message to send it to Kafka");
        }
    }
}
