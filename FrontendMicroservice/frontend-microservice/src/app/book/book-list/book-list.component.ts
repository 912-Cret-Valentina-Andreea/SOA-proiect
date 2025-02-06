import { Component, OnInit } from '@angular/core';
import {Book, BookService} from "../../../../api-client/generated-sources/library-api";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {
  books: Book[] = [];

  constructor(private booksService: BookService) {}

  ngOnInit(): void {
    this.loadBooks();
  }

  loadBooks(): void {
    this.booksService.getAllBooks().subscribe(
      (books) => (this.books = books.sort((a, b) => a.title.localeCompare(b.title))),
      (error) => console.error('Error fetching books', error)
    );
  }

  borrowBook(title: string): void {
    this.booksService.borrowBook(title).subscribe(
      () => this.loadBooks(),
      (error) => console.error('Error borrowing book', error)
    );
  }

  returnBook(title: string): void {
    this.booksService.returnBook(title).subscribe(
      () => this.loadBooks(),
      (error) => console.error('Error returning book', error)
    );
  }
}
