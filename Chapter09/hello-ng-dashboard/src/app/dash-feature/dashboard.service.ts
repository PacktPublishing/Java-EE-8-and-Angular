import { Injectable } from '@angular/core';
import { Statistics } from '../domain/statistics';

@Injectable()
export class DashboardService {
  private dummy: Statistics;

  constructor() {
    this.dummy = {bookings: 10, cancellations: 2, sales: 500 }
  }

  getStats(): Statistics {
    return this.dummy;
  }

}
