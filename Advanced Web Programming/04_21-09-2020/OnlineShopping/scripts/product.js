var products = [
    {id:1, title:"Sapiens", author:"Yuval Noah Harrari", qty:2, price:300},
    {id:2, title:"Old Man and The Sea", author:"Ernest Hemmingway", qty:5, price:150},
    {id:3, title:"Anarchy", author:"William Darymple", qty:1, price:500},
    {id:4, title:"The Testaments", author:"Margaret Atwood", qty:4, price:450},
    {id:5, title:"Fire and Blood", author:"George R.R Martin", qty:2, price:700}
]

var showProducts = function(){
var element = document.getElementById("showProducts");

var i;
var text = "";
for(i=0; i<products.length; i++) {
     text+= "<li>" + products[i].title + "</li><br>";
    }
element.innerHTML = text;   
}