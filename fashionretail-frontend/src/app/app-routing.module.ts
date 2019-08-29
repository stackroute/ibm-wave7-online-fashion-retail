import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FooterComponent } from './footer/footer.component';
import { ContactComponent } from './contact/contact.component';
import { HeroComponent } from './hero/hero.component';
import { AboutComponent } from './about/about.component';
import { ProfilebuttonComponent } from './profilebutton/profilebutton.component';
import { ManufactureviewprofileComponent } from './manufactureviewprofile/manufactureviewprofile.component';




const routes: Routes = [
  {path:'',component:HeroComponent},
  {path:'contact',component:ContactComponent},
  {path:'about', component:AboutComponent},
  {path:'edit', component:ProfilebuttonComponent},
  {path:'edit/manufactureviewprofile', component:ManufactureviewprofileComponent},
  {path:'login',component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
