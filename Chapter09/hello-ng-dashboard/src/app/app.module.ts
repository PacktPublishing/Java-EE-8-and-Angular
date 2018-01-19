import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { NavComponent } from './nav/nav.component';
import { PositiveNumbersPipe } from './positive-numbers.pipe';
import { AboutComponent } from './about/about.component';
import { DashFeatureModule } from './dash-feature/dash-feature.module';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    PositiveNumbersPipe,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    DashFeatureModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
