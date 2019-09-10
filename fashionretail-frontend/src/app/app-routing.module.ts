import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddmaterialPageComponent } from './addmaterial-page/addmaterial-page.component';
import { ViewOrdersComponent } from './view-orders/view-orders.component';
import { CardComponent } from './card/card.component';


const routes: Routes = [
  {
    path: 'materials' , component:AddmaterialPageComponent
  },
{
  path:'suppliers',component:CardComponent
},
  {
    path:'vieworders',component:ViewOrdersComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents=[AddmaterialPageComponent]
