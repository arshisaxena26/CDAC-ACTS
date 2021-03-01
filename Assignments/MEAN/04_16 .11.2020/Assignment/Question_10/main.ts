/*
Question: Create Employee class module and organization class module. Create a main.ts import both modules in main.ts

	a)Implement function to find total no of employees in main.ts
	b)Display organization information
	c)Store employee objects in array
	d)Implement Employee search function to find employee and display all his details
	
Note:Employee(Name,id,address,phone,email),Organization(name,registration_id,address).
*/

import { Employee } from "./Employee";
import { Organization } from "./Organization";

function findEmployeeNum(employees:Employee[]):number{
    return employees.length;
}

function searchEmployee(empid:number,employees:Employee[]){

    for(let i = 0;i<employees.length;i++){
        if(employees[i].id == empid)
            employees[i].display();
    }
}

let empArray:Employee[] = [
    new Employee("Rob",1,"Address 01","900800088","rob@gmail.com"),
    new Employee("Ross",2,"Address 02","900800088","ross@gmail.com"),
    new Employee("John",3,"Address 03","900800088","john@gmail.com"),
    new Employee("Grace",4,"Address 04","900800088","grace@gmail.com"),
    new Employee("Emma",5,"Address 05","900800088","emma@gmail.com")
];

let organization = new Organization("Airtel",1,"Airtel Corporate Office,Delhi");
organization.display();

console.log("Total Employees : "+findEmployeeNum(empArray));
searchEmployee(3,empArray);
