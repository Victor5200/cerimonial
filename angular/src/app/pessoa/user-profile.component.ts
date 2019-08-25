import { Component, OnInit } from '@angular/core';
import {Pessoa} from '../model';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  public pessoa: Pessoa = new Pessoa();

  constructor() { }

  ngOnInit() {
  }

}
