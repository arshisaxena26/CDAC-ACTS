import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StudentService } from '../student.service';
import { Student } from './student';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent {
  student: Student = new Student(0, "", "", "", 0);
  students: Student[] = [];
  studentId: number = 0;
  showAllStudentsTable = false;
  showOneStudentTable = false;

  constructor(private studentservice: StudentService) { }

  addStudent(newStudent: NgForm) {
    this.studentservice.addStudent(newStudent.value).subscribe(res => {
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

  getStudentDetails() {
    console.log(this.studentId);
    this.studentservice.getStudentDetails(this.studentId).subscribe(data => this.student = data);
    this.showAllStudentsTable = false;
    this.showOneStudentTable = true;
  }
}
