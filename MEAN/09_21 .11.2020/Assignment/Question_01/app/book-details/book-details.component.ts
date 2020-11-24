import { Component } from '@angular/core';
import { BookService } from '../book.service';
import { Book } from './book';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent {
  name: string = "";
  author: string = "";
  publicationHouse: string = "";
  publicationHouses: string[] = [];
  price: number = 0;
  book = new Book(this.name, this.author, this.publicationHouse, this.price);
  books: Book[] = [];
  visible = false;

  constructor(private bookservice: BookService) {
    this.publicationHouses = bookservice.getPublicationHouses();
  }

  storeBook() {
    if (this.name != "" && this.author != "" && this.publicationHouse != "" && this.price != 0) {
      this.book = new Book(this.name, this.author, this.publicationHouse, this.price);
      this.bookservice.books.push(this.book);
      this.books = this.bookservice.getBooks();
      this.visible = true;
    }
  }
}
