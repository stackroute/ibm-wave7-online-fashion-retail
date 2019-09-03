import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddmaterialPageComponent } from './addmaterial-page/addmaterial-page.component';
import { BodyComponent } from './body/body.component';


const routes: Routes = [
  {
    path: 'materials' , component:AddmaterialPageComponent
  },
  {
      path: '', component: BodyComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents=[AddmaterialPageComponent,BodyComponent]
