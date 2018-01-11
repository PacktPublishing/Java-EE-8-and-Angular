import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardService } from './dashboard.service';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ItemComponent } from './item/item.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [DashboardComponent, ItemComponent],
  exports: [DashboardComponent],
  providers: [DashboardService]
})
export class DashFeatureModule { }
