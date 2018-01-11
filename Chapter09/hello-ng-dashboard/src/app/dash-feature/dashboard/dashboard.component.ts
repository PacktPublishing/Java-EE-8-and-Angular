import { Component, OnInit } from '@angular/core';
import { Statistics } from '../../domain/statistics';
import { DashboardService } from '../dashboard.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {  
  feeds: string[];
  stats: Statistics;  
  selected: string;

  constructor(private service: DashboardService) {
    this.feeds = [
      'Product ABC sold to customer Bob M',
      'New booking in Electronics category for product AAA',
      'Service Booking cancelled by customer Bob M',
      '*Sales for the current month has crossed 20000'      
    ];
  }

  ngOnInit(): void {
    this.stats = this.service.getStats();
  }

  show(feed: string) {
    this.selected = feed;
  }

  remove(feed: string) {
    this.feeds = this.feeds.filter( f => f !== feed);
  }
}