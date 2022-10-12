import { Component, OnInit } from '@angular/core';
import Student from 'src/app/Entity/Student';
import { StudentsService } from 'src/app/Services/students.service';

@Component({
  selector: 'app-registeredstudent',
  templateUrl: './registeredstudent.component.html',
  styleUrls: ['./registeredstudent.component.css'],
})
export class RegisteredstudentComponent implements OnInit {
  students: Student[] = [];

  constructor(private studentService: StudentsService) {}

  ngOnInit(): void {
    const data = this.studentService.getStudents();
    data.subscribe((response) => {
      console.log(response);
      this.students = response as Student[];
    });
  }
}
