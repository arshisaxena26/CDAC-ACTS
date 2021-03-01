import { Component, OnInit } from '@angular/core';
import { StudentListService } from '../student-list.service';
import { Student } from './IStudent';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students: Student[] = [];

  constructor(private studentservice: StudentListService) { }

  ngOnInit(): void {
    this.studentservice.getStudents().subscribe(data => this.students = data);
  }
}
