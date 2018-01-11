import { Component, OnInit } from '@angular/core';
import { Task } from '../task';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  tasks: Array<Task>;
  
  constructor() { 
    this.tasks = new Array<Task>();
  }

  ngOnInit() {
  }

  addTask(task: Task) {
    this.tasks.push(task);
  }

}
