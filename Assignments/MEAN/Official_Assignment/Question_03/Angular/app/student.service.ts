import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable, of } from 'rxjs';
import { Student } from './student/IStudent';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  baseUrl: string = `http://localhost:8080`;

  constructor(private httpClient: HttpClient) { }

  addStudent(newStudent: Student): Observable<Student> {
    return this.httpClient.post<Student>(this.baseUrl + '/create', newStudent);
  }

  getStudentDetails(studentId: number): Observable<Student> {
    return this.httpClient.get<Student>(this.baseUrl + `/student/${studentId}`);
  }

  getAllStudents(): Observable<Student[]> {
    return this.httpClient.get<Student[]>(this.baseUrl + '/students');
  }
}
