import { Component, OnInit } from '@angular/core';
import { WebsocketService } from '../shared/websocket.service';
import { Chat } from '../domain/chat';
import { AuthService } from '../shared/auth.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {
  messages: Array<Chat>;
  chatBox: any;

  constructor(private socketService: WebsocketService,
    private authService: AuthService) { }

  ngOnInit() {
    this.messages = [];

    this.socketService.getEventListener().subscribe(event => {
      console.log('listening in for chat messages', event);
      if (event.type == "message") {
        let chatMessage: Chat = event.data;
        console.log('chat ' + chatMessage);
        this.messages.push(chatMessage);
      }
    });
    this.socketService.connect();
  }

  public onSubmit(event: Event) {
    let chatMessage: Chat = new Chat();
    chatMessage.sender = this.authService.currentUser;
    
    chatMessage.message = this.chatBox;
    chatMessage.created = new Date();
    
    if (this.chatBox) {
      this.socketService.send(JSON.stringify(chatMessage));
      this.chatBox = '';
      event.preventDefault();
    }
  }

  public get currentUser() {
    return this.authService.currentUser;
  }
}
