import { Component, OnInit } from '@angular/core';
import Student from 'src/app/Entity/Student';
import { StudentsService } from 'src/app/Services/students.service';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css'],
})
export class UserformComponent implements OnInit {
  student: Student = new Student();

  save() {
    const observables = this.studentService.createStudent(this.student);
    observables.subscribe(
      (response: any) => {
        console.log(response);
      },
      function (error) {
        console.log(error);
        alert('Something went wrong try again!');
      }
    );
  }

  constructor(public studentService: StudentsService) {}

  ngOnInit(): void {}
}
