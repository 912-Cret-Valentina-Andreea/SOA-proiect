package com.soa.LibraryMicroservice.controller;

import com.library.api.BookApi;
import com.library.model.BookDto;
import com.library.model.NotificationDto;
import com.library.model.StatisticsDto;
import com.soa.LibraryMicroservice.mapper.StatisticsMapper;
import com.soa.LibraryMicroservice.mapper.NotificationMapper;
import com.soa.LibraryMicroservice.mapper.BookMapper;
import com.soa.LibraryMicroservice.service.StatisticsService;
import com.soa.LibraryMicroservice.service.NotificationService;
import com.soa.LibraryMicroservice.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class LibraryController implements BookApi {

    private final BookService bookService;
    private final BookMapper bookMapper;

    private final NotificationService notificationService;
    private final NotificationMapper notificationMapper;
    private final StatisticsService statisticsService;
    private final StatisticsMapper statisticsMapper;

    @Override
    public ResponseEntity<Void> borrowBook(String name) {
        bookService.burrowBook(name);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<StatisticsDto>> getAllStatistics() {
        var analytics = statisticsService.getAllStatistics();
        return ResponseEntity.ok(statisticsMapper.map(analytics));
    }

    @Override
    public ResponseEntity<List<NotificationDto>> getAllNotifications() {
        var emails = notificationService.getAllNotification();
        return ResponseEntity.ok(notificationMapper.map(emails));
    }

    @Override
    public ResponseEntity<List<BookDto>> getAllBooks() {
        var products = bookService.getAllBooks();
        return ResponseEntity.ok(bookMapper.map(products));
    }

    @Override
    public ResponseEntity<Void> returnBook(String name) {
        bookService.returnBook(name);
        return ResponseEntity.ok().build();
    }
}

