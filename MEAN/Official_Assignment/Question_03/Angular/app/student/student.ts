import { fn } from '@angular/compiler/src/output/output_ast';

export class Student {
    studentId: number;
    name: string;
    email: string;
    course: string;
    cgpa: number;

    constructor(id: number, name: string, email: string, course: string, cgpa: number) {
        this.studentId = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.cgpa = cgpa;
    }
}