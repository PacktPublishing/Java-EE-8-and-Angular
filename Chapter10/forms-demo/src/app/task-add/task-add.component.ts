import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { NgForm } from '@angular/forms/src/directives/ng_form';
import { Task } from '../task';

@Component({
  selector: 'app-task-add',
  templateUrl: './task-add.component.html',
  styleUrls: ['./task-add.component.css']
})
export class TaskAddComponent implements OnInit {
  @Output() created: EventEmitter<Task> = new EventEmitter<Task>();

  constructor() { }

  ngOnInit() {
  }

  onSave(taskForm : NgForm) {
    let newTask: Task = taskForm.value;
    newTask.created = new Date();
    /* Fire the event which emits the Task instance */
    this.created.emit(newTask);
    taskForm.reset();
  }

}
