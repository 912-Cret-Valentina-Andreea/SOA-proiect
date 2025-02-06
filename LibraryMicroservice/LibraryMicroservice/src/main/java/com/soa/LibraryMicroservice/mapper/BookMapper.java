package com.soa.LibraryMicroservice.mapper;

import com.library.model.BookDto;
import com.soa.LibraryMicroservice.domain.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    BookDto map(Book book);
    List<BookDto> map(List<Book> book);
}
