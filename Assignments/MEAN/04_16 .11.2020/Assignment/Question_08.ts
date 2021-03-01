/* 
Question : Write a TypeScipt class Product that has Product-id, Product-name and product-price.
	printProduct() should print product details.
*/

class Product {
    productId:number;
    productName:string;
    productPrice:number;

    constructor(productId:number, productName:string, productPrice:number) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }
    printProduct() {
        console.log("Product ID : " + this.productId);
        console.log("Product Name : " + this.productName);
        console.log("Product Price : " + this.productPrice);
    }
}

var product1 = new Product(1, "Bluetooth Speakers", 5900);
product1.printProduct();