import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable,of } from 'rxjs';
import { Student } from './student-list/IStudent';

@Injectable({
  providedIn: 'root'
})
export class StudentListService {

  baseUrl :string = 'assets/students.json';

  constructor(private httpClient: HttpClient) { }

  getStudents(): Observable<Student[]> {
    return this.httpClient.get<Student[]>(this.baseUrl);
  }
}
