export class Employee {
    empNo: number;
    empName: string;
    salary: number;
    designation: string;

    constructor(empNo: number, empName: string, salary: number, designation: string) {
        this.empNo = empNo;
        this.empName = empName;
        this.salary = salary;
        this.designation = designation;
    }
}