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

    alert("Email: "+email+"\nName: "+name+"\nGender: "+gender+"\nCountry: "+country+"\nRegistration Complete!");
};