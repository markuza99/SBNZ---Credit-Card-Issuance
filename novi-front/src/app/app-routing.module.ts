import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { BasketOfGoodsComponent } from './basket-of-goods/basket-of-goods.component';
import { CardRequestComponent } from './card-request/card-request.component';
import { CardsComponent } from './cards/cards.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MakeTransactionComponent } from './make-transaction/make-transaction.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';

const routes: Routes = [{
  path:"login",
  component:LoginComponent,

},
{
  path:"logout",
  component:LogoutComponent,
  canActivate: [AuthGuard],
  data: {
    expectedRoles: ['ROLE_BANKER','ROLE_CLIENT'],
  }
},
{
  path:"basket",
  component:BasketOfGoodsComponent,
  canActivate: [AuthGuard],
  data: {
    expectedRoles: ['ROLE_BANKER'],
  }
},
{
  path:"request",
  component:CardRequestComponent,
  canActivate: [AuthGuard],
  data: {
    expectedRoles: ['ROLE_BANKER','ROLE_CLIENT'],
  },
},
{
  path:"make-transaction",
  component:MakeTransactionComponent,
  canActivate: [AuthGuard],
  data: {
    expectedRoles: ['ROLE_BANKER','ROLE_CLIENT'],
  },
},
{
  path: 'cards',
  component:CardsComponent,
  canActivate: [AuthGuard],
  data: {
    expectedRoles: ['ROLE_BANKER','ROLE_CLIENT'],
  },
},
{
  path: 'transaction-history/:id',
  component: TransactionHistoryComponent,
  canActivate: [AuthGuard],
  data: {
    expectedRoles: ['ROLE_BANKER','ROLE_CLIENT'],
  },
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
