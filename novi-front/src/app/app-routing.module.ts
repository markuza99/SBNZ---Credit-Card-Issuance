import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BasketOfGoodsComponent } from './basket-of-goods/basket-of-goods.component';
import { CardRequestComponent } from './card-request/card-request.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';

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
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
