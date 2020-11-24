export class Book {
    name: string;
    author: string;
    publicationHouse: string;
    price: number;

    constructor(name: string, author: string, publication: string, price: number) {
        this.name = name;
        this.author = author;
        this.publicationHouse = publication;
        this.price = price;
    }
}