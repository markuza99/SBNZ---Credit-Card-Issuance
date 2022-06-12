import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ButtonModule} from 'primeng/button';
import { ProbajmoComponent } from './probajmo/probajmo.component';
import { NavbarComponent } from './navbar/navbar.component';
import {MenubarModule} from 'primeng/menubar';
import { LoginComponent } from './login/login.component';
import {Card, CardModule} from 'primeng/card';


@NgModule({
  declarations: [
    AppComponent,
    ProbajmoComponent,
    NavbarComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ButtonModule,
    MenubarModule,
    CardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
