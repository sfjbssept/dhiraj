import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-ragistration',
  templateUrl: './user-ragistration.component.html',
  styleUrls: ['./user-ragistration.component.css']
})
export class UserRagistrationComponent implements OnInit {

  constructor() { }
  public firstName : string = "";
  public lastName : string = "";
  public email : string = "";
  public phoneNumber : string = "";
  public address : string = "";
  public userName : string = "";
  public password : string = "";
  ngOnInit(): void {
  }

  saveUser(){
    
  }
}
