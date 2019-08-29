import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FooterComponent } from './footer/footer.component';
import { ContactComponent } from './contact/contact.component';
import { HeroComponent } from './hero/hero.component';
import { AboutComponent } from './about/about.component';
import { DesignerprofileComponent } from './designerprofile/designerprofile.component';
import { DesignerviewprofileComponent } from './designerviewprofile/designerviewprofile.component';
import { DesignereditdialogueComponent } from './designereditdialogue/designereditdialogue.component';




const routes: Routes = [
  {path:'',component:HeroComponent},
  {path:'contact',component:ContactComponent},
  {path:'about', component:AboutComponent},
  {path:'edit',component:DesignerprofileComponent},
  {path:'edit/designerviewprofile',component:DesignerviewprofileComponent},
  {path:'edit/designerviewprofile/designerEdit',component:DesignereditdialogueComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
