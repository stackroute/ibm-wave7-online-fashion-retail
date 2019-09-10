import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FooterComponent } from './footer/footer.component';
import { ContactComponent } from './contact/contact.component';
import { HeroComponent } from './hero/hero.component';
import { AboutComponent } from './about/about.component';
import { ProfilebuttonComponent } from './profilebutton/profilebutton.component';
import { ManufactureviewprofileComponent } from './manufactureviewprofile/manufactureviewprofile.component';
import { AddmaterialsbuttonComponent } from './addmaterialsbutton/addmaterialsbutton.component';
import { SupplierviewprofileComponent } from './supplierviewprofile/supplierviewprofile.component';
import { BodyComponent } from './body/body.component';
import { DesignerviewprofileComponent } from './designerviewprofile/designerviewprofile.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { DesignerHomePageComponent } from './designer-home-page/designer-home-page.component';
import { AddmaterialPageComponent } from './addmaterial-page/addmaterial-page.component';
import {ConsumerDashboardComponent} from './consumer-dashboard/consumer-dashboard.component';
import {ManufacturerDashboardComponent} from './manufacturer-dashboard/manufacturer-dashboard.component'
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { ViewOrdersComponent } from './view-orders/view-orders.component';
import { CardComponent } from './card/card.component';





const routes: Routes = [
  {path:'',component:HeroComponent},
  {path:'contact',component:ContactComponent},
  {path:'about', component:AboutComponent},
  {path: 'login', component : LoginComponent},
  {path: 'sign-up',component : SignUpComponent},
  {path:'reset-password',component:ResetPasswordComponent},
  {path:'forgotpassword',component:ForgotpasswordComponent},
  {
    path: 'designer',
    component: DesignerHomePageComponent},
  {path:'edit', component:ProfilebuttonComponent},
  {path:'manufacturer/manufactureviewprofile', component:ManufactureviewprofileComponent},
  // {path:'login',component:LoginComponent}
   {path:'addMaterial',component:AddmaterialsbuttonComponent},
  {path: 'designer',component: DesignerHomePageComponent
  },
  {path: 'edit', component:ProfilebuttonComponent},
  {path: 'edit/supplierviewprofile', component:SupplierviewprofileComponent},
{
path:'suppliers',component:CardComponent
},
{
path:'vieworders',component:ViewOrdersComponent
}
  // {path:'edit/designerviewprofile',component:DesignerviewprofileComponent},
  {
    path: '/materials' , component:AddmaterialPageComponent},{
    path: 'consumer' , component: ConsumerDashboardComponent
  },
  {
      path: '', component: BodyComponent
  },

  {path:'designerviewprofile',component:DesignerviewprofileComponent},
  { path : 'manufacturer' , component : ManufacturerDashboardComponent},
  // {
  //     path: '', component: BodyComponent
  // },
  { path : '**/LogOut' ,component: HeroComponent},
  { path : '**' ,component: HeroComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
