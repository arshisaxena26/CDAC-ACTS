import { Injectable } from '@angular/core';
import { Book } from './book-details/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  publicationHouse = ["McGraw-Hill Education", "Scholastic", "Springer Nature", "Grupo Planeta", "Hachette Livre"];
  books: Book[] = [];

  getPublicationHouses() {
    return this.publicationHouse;
  }

  getBooks() {
    return this.books;
  }
}
