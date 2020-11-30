import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable, of } from 'rxjs';
import { Student } from './student/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  baseUrl: string = 'http://localhost:8080/students';

  constructor(private httpClient: HttpClient) { }

  addStudent(newStudent: Student): Observable<Student> {
    return this.httpClient.post<Student>("http://localhost:8080/create", newStudent);
  }

  getStudentDetails(studentId: number): Observable<Student> {
    return this.httpClient.get<Student>("http://localhost:8080/student/studentId");
  }

  getAllStudents(): Observable<Student[]> {
    return this.httpClient.get<Student[]>("http://localhost:8080/students");
  }
}
