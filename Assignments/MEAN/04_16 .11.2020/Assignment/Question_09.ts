/*
Question : Create a class Products that will have an array of Product objects. 
    printAllProducts() must iterate through array and print out all products.
*/

class product {
    id: number;
    name: string;
    price: number;

    constructor(id: number, name: string, price: number) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    printAllProducts() {
        console.log("Product ID : " + this.id + "\n Product Name : " + this.name + "\n Product Price : " + this.price);
    }
}

class productArray {
    products: product[];

    constructor(products: product[]) {
        this.products = products;
    }

    printAllProducts() {
        for (var prod of this.products) {
            prod.printAllProducts();
        }
    }
}

var products = new productArray([new product(1, "Chocolate Box", 150), new product(2, "Headphones", 3000), new product(3, "Fruit Basket", 2000)]);
products.printAllProducts();
