window.ECommerce = window.ECommerce || {};
window.ECommerce.OnlineShopping = window.ECommerce.OnlineShopping || {};
window.ECommerce.Accounting = window.ECommerce.Accounting || {};

ECommerce.OnlineShopping.Products = [
    {id:1, title:"Sapiens", author:"Yuval Noah Harrari", qty:2, price:300},
    {id:2, title:"Old Man and The Sea", author:"Ernest Hemmingway", qty:5, price:150},
    {id:3, title:"Anarchy", author:"William Darymple", qty:1, price:500},
    {id:4, title:"The Testaments", author:"Margaret Atwood", qty:4, price:450},
    {id:5, title:"Fire and Blood", author:"George R.R Martin", qty:2, price:700}
]

function showAllProducts() {
    var products = ECommerce.OnlineShopping.Products;
    var element = document.getElementById("showProducts");
    var i;
    var text = "";
    for(i=0;i<products.length;i++){
        text+= "<li>"+ products[i].title + "</li><br>";
    }
    element.innerHTML= "<ol>"+text+"</ol>";
}

function showAllProductsTable() {
    var products = ECommerce.OnlineShopping.Products;
    var element = document.getElementById("showProducts");
    var i;
    var header = "<tr><th>Title</th><th>Author</th><th>Price</th><th>In Stock</th></tr>";
    var text = "";
    for(i=0;i<products.length;i++){
        text+= "<tr><td>"+ products[i].title +"</td><td>"+ products[i].author +"</td><td>"+ products[i].price +"</td><td>"+ products[i].qty + "</td></tr>";
    }
    element.innerHTML= "<table>"+header+text+"</table>";
}

function account(){
    var balance = 5000;

    function withdraw(amount){
        balance = balance - amount;
        showBalance();
    }

    function deposit(amount){
        balance = balance + amount;
        showBalance();
    }
    function showBalance(){
        console.log(balance);
    }

    return{
        withdraw: withdraw,
        deposit:deposit
    }
}

var accounts = new account();
accounts.withdraw(2000);
accounts.deposit(7000);

function checkQuantity(){
    var quantity = document.getElementById("quantity").value;
    var displayQuantity = document.getElementById("displayQuantity");

    try {
        if (quantity == "") throw "Please Enter a Value.";
        quantity = Number(quantity);
        
        if (quantity > 10) throw "Out of Stock";
        else if (quantity < 5) throw "Minimun Order Value : 5";
        else{
            displayQuantity.innerHTML = "Successfully Added to Cart!";
        }

    } catch (err) {
        displayQuantity.innerHTML = err;
    }
    finally{
        document.getElementById("quantity").value="";
    }
}