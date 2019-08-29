import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatToolbarModule,MatIconModule, MatButtonModule,MatMenuModule,MatFormFieldModule} from '@angular/material';
import { MatInputModule } from '@angular/material';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchboxComponent } from './searchbox/searchbox.component';
import { FooterComponent } from './footer/footer.component';
import { ContactComponent } from './contact/contact.component';
import { MatJumbotronModule } from '@angular-material-extensions/jumbotron';
import { Ng2CarouselamosModule } from 'ng2-carouselamos';
import { HeroComponent } from './hero/hero.component';
import { FlexLayoutModule } from "@angular/flex-layout";
import { MatSidenavModule} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './header/header.component';
import { AboutComponent } from './about/about.component';
<<<<<<< HEAD:fashionretail-frontend/src/app/app.module.ts
import { MatCardModule } from '@angular/material/card';
import { DesignerviewprofileComponent } from './designerviewprofile/designerviewprofile.component';
import { DesignerprofileComponent } from './designerprofile/designerprofile.component';
import { DesignereditdialogueComponent } from './designereditdialogue/designereditdialogue.component';

=======
//import { ManufactureeditComponent } from './manufactureedit/manufactureedit.component';
import { ManufactureviewprofileComponent } from './manufactureviewprofile/manufactureviewprofile.component';
import { ProfilebuttonComponent } from './profilebutton/profilebutton.component';
import { MatCardModule} from '@angular/material';
import {MatDialogModule} from '@angular/material/dialog';
>>>>>>> 94d52dd0c43a508cc5f2e0888afd6f81857f4c3e:fashionretail-frontend/src/app/app.module.ts



@NgModule({
  declarations: [
    AppComponent,
    SearchboxComponent,
    FooterComponent,
    ContactComponent, 
    HeroComponent,
    HeaderComponent,
    AboutComponent,
<<<<<<< HEAD:fashionretail-frontend/src/app/app.module.ts
    DesignerviewprofileComponent,
    DesignerprofileComponent,
    DesignereditdialogueComponent
=======
    // ManufactureeditComponent,
    ManufactureviewprofileComponent,
    ProfilebuttonComponent
>>>>>>> 94d52dd0c43a508cc5f2e0888afd6f81857f4c3e:fashionretail-frontend/src/app/app.module.ts
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatJumbotronModule,
    MatIconModule,
    MatButtonModule,
    FlexLayoutModule,
    MatMenuModule,
    MatInputModule,
    MatFormFieldModule,
    Ng2CarouselamosModule,
    MatSidenavModule,
     BrowserAnimationsModule,
<<<<<<< HEAD:fashionretail-frontend/src/app/app.module.ts
     MatCardModule
=======
     MatCardModule,
     MatDialogModule
>>>>>>> 94d52dd0c43a508cc5f2e0888afd6f81857f4c3e:fashionretail-frontend/src/app/app.module.ts
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
