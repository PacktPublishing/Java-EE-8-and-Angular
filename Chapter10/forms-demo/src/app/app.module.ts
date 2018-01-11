import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';

import { BasicFormComponent } from './basic-template-form/basic-form.component';
import { BasicFormStrictComponent } from './basic-template-form/basic-form-strict.component';

import { ReactiveFormComponent } from './basic-reactive-form/reactive-form.component';
import { ReactiveFormStrictComponent } from './basic-reactive-form/reactive-form-strict.component';

import { TaskListComponent } from './task-list/task-list.component';
import { TaskAddComponent } from './task-add/task-add.component';



@NgModule({
  declarations: [
    AppComponent,
    BasicFormComponent,
    BasicFormStrictComponent,
    TaskListComponent,
    TaskAddComponent,
    ReactiveFormComponent,
    ReactiveFormStrictComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
