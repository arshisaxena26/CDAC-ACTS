import { Component, OnInit } from '@angular/core';
import { CourseListService } from '../course-list.service';
import { Course } from './ICourse';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {
  courses: Course[] = [];

  constructor(private courseservice: CourseListService) { }

  ngOnInit(): void {
    this.courseservice.getCourses().subscribe(data => this.courses = data);
  }
}
