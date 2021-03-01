import { Component } from '@angular/core';
import { Employee } from "./employee";

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent {

  empNo: number = 0;
  empName: string = "";
  salary: number = 0;
  designation: string = "";
  employeesArray: Employee[] = [];
  employee = new Employee(this.empNo, this.empName, this.salary, this.designation);
  tableVisible = false;
  listVisible = false;

  constructor() {

    this.employeesArray = [
      {
        empNo: 1,
        empName: "John Sanders",
        salary: 250000,
        designation: "Devops Engineer"
      },
      {
        empNo: 2,
        empName: "Rob Goldman",
        salary: 350000,
        designation: "Cloud Architect"
      },
      {
        empNo: 3,
        empName: "Grace Brown",
        salary: 450000,
        designation: "Software Engineer"
      },
      {
        empNo: 4,
        empName: "Julian Smith",
        salary: 550000,
        designation: "Marketing Head"
      }
    ];
  }

  add() {
    if (this.empNo != 0 && this.empName != "" && this.salary != 0 && this.designation != "") {
      this.employee = new Employee(this.empNo, this.empName, this.salary, this.designation);
      this.employeesArray.push(this.employee);
    }
  }

  showTable() {
    this.tableVisible = true;
  }

  showList() {
    this.listVisible = true;
  }

  clearForm() {
    this.tableVisible = false;
    this.listVisible = false;
    this.empNo = 0;
    this.empName = "";
    this.salary = 0;
    this.designation = "";
  }
}
