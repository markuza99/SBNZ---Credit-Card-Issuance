import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import {CardModule} from 'primeng/card';
import {InputTextModule} from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import { HttpClientModule } from '@angular/common/http';
import {MenubarModule} from 'primeng/menubar';
import { FormsModule } from '@angular/forms';
import { LogoutComponent } from './logout/logout.component';
import { BasketOfGoodsComponent } from './basket-of-goods/basket-of-goods.component';
import {MessagesModule} from 'primeng/messages';
import {ToastModule} from 'primeng/toast';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {PasswordModule} from 'primeng/password';
import {InputNumberModule} from 'primeng/inputnumber';
import { CardRequestComponent } from './card-request/card-request.component';
import {DropdownModule} from 'primeng/dropdown';
import { MakeTransactionComponent } from './make-transaction/make-transaction.component';
import {TableModule} from 'primeng/table';
import { CardsComponent } from './cards/cards.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    LogoutComponent,
    BasketOfGoodsComponent,
    CardRequestComponent,
    MakeTransactionComponent,
    CardsComponent,
    TransactionHistoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CardModule,
    InputTextModule,
    ButtonModule,
    HttpClientModule,
    MenubarModule,
    FormsModule,
    MessagesModule,
    PasswordModule,
    ToastModule,
    BrowserAnimationsModule,
    InputNumberModule,
    DropdownModule,
    TableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
