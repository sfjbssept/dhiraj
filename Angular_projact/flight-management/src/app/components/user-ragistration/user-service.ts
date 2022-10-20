
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import User from '../../entity/user';
const BASE_USER_URL = 'http://localhost:5000/students/';

@Injectable({
    providedIn: 'root',
   })

 export class UserService {
    constructor(){

    }

    saveUser(user: {
        firstname: String;
        lastname: String;
        age: number;
        class: number;
        subject: String;
        gender: String;
      }) {
        return this.http.post(BASE_USER_URL, user);
      }

 }