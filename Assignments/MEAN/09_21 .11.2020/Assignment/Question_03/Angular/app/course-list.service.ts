import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable, of } from 'rxjs';
import { Course } from './course-list/ICourse';

@Injectable({
  providedIn: 'root'
})
export class CourseListService {

  baseUrl: string = 'http://localhost:8080/courses';

  constructor(private httpClient: HttpClient) { }

  getCourses(): Observable<Course[]> {
    return this.httpClient.get<Course[]>(this.baseUrl);
  }
}
