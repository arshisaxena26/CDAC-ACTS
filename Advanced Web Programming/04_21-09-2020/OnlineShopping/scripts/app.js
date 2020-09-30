var loginAuthentication = function(){
    var uname = document.getElementById("uname").value;
    var pass = document.getElementById("pass").value;
    if (uname == "admin" && pass == "admin") {
        alert("Login Successful!")
    } else {
        alert("Invalid Username or Password")
    }
    
};

var userRegistration = function(){
    var email = document.getElementById("email").value;
    var name = document.getElementById("name").value;
    var country = document.getElementById("country").value;
    var gender;

    if(document.getElementById("male").checked){
         gender = document.getElementById("male").value;
    }
    else if(document.getElementById("female").checked){
         gender = document.getElementById("female").value;
    }
    else{
         gender = document.getElementById("other").value;
    }

    console.log("Email: "+email);
    console.log("Name: "+name);
    console.log("Gender: "+gender);
    console.log("Country: "+country);
    alert("Registration Complete!");

};

var drawRectangle = function(){
    var c = document.getElementById("myCanvas");
    var ctx = c.getContext("2d");
    ctx.rect(220,19,220,19);
    ctx.stroke();
}

var drawCircle = function(){
    var c = document.getElementById("myCanvas");
    var ctx = c.getContext("2d");
    ctx.beginPath();
    ctx.arc(100, 75, 50, 0, 2 * Math.PI);
    ctx.stroke();
}

var drawLine = function(){
    var c = document.getElementById("myCanvas");
    var ctx = c.getContext("2d");
    ctx.moveTo(50, 250);
    ctx.lineTo(200,100);
    ctx.stroke();
}