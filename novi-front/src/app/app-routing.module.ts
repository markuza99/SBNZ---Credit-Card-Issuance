import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BasketOfGoodsComponent } from './basket-of-goods/basket-of-goods.component';
import { CardRequestComponent } from './card-request/card-request.component';
import { CardsComponent } from './cards/cards.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MakeTransactionComponent } from './make-transaction/make-transaction.component';

const routes: Routes = [{
  path:"login",
  component:LoginComponent
},
{
  path:"logout",
  component:LogoutComponent
},
{
  path:"basket",
  component:BasketOfGoodsComponent
},
{
  path:"request",
  component:CardRequestComponent
},
{
  path:"make-transaction",
  component:MakeTransactionComponent
},
{
  path: 'cards/:id',
  component:CardsComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
