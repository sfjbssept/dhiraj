import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
const BASE_URL = 'http://localhost:5000/students/';


@Injectable({
  providedIn: 'root',
})
export class StudentsService {

  createStudent(student: {
    firstname: String;
    lastname: String;
    age: number;
    class: number;
    subject: String;
    gender: String;
  }) {
    return this.http.post(BASE_URL, student);
  }
  
  getStudents() {
    return this.http.get(BASE_URL);
  }

  constructor(public http: HttpClient) {}
}
