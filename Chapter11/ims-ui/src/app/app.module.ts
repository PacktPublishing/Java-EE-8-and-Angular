import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { FeedComponent } from './home/feed/feed.component';
import { HomeComponent } from './home/home.component';

import { IssuesModule } from './issues/issues.module';

import { IssuesService } from './shared/issues.service';
import { UsersService } from './shared/users.service';
import { HttpClientModule } from '@angular/common/http';
import { WebsocketService } from './shared/websocket.service';
import { ChatComponent } from './chat/chat.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthService } from './shared/auth.service';

import { JwtModule } from '@auth0/angular-jwt';
import { AuthGuardService } from './shared/auth-guard.service';
import { LoginComponent } from './login/login.component';

export function tokenGetterFn() {
  return localStorage.getItem('token');
};


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FeedComponent,
    ChatComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    IssuesModule,
    FormsModule,
    ReactiveFormsModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: tokenGetterFn
      }
    })
  ],
  providers: [IssuesService, UsersService, WebsocketService, AuthService, AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
