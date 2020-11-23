import { Component, OnInit } from '@angular/core';
import { Module } from './module1';

@Component({
  selector: 'app-people-list',
  templateUrl: './people-list.component.html',
  styleUrls: ['./people-list.component.css']
})
export class PeopleListComponent {
  module = new Module();

  getAllPeople() {
    return this.module.people;
  }
}
