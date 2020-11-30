import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StudentService } from '../student.service';
import { Student } from './IStudent';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent {
  student = {} as Student;
  students: Student[] = [];
  showAllStudentsTable = false;
  showOneStudentTable = false;

  constructor(private studentservice: StudentService) { }

  addStudent(newStudent: NgForm) {
    this.student.name = newStudent.value.name;
    this.studentservice.addStudent(this.student).subscribe(res => {
      console.log(res);
    });

    alert("New Student Details Saved.")
    this.showAllStudentsTable = false;
    this.showOneStudentTable = false;
  }

  getAllStudents() {
    this.studentservice.getAllStudents().subscribe(data => this.students = data);
    this.showAllStudentsTable = true;
    this.showOneStudentTable = false;
  }

  getStudentDetails(id: string) {
    this.studentservice.getStudentDetails(parseInt(id)).subscribe(data => this.student = data);
    this.showAllStudentsTable = false;
    this.showOneStudentTable = true;
  }
}
