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
import { MatCardModule } from '@angular/material/card';
import { DesignerviewprofileComponent } from './designerviewprofile/designerviewprofile.component';
import { DesignerprofileComponent } from './designerprofile/designerprofile.component';
import { DesignereditdialogueComponent } from './designereditdialogue/designereditdialogue.component';




@NgModule({
  declarations: [
    AppComponent,
    SearchboxComponent,
    FooterComponent,
    ContactComponent, 
    HeroComponent,
    HeaderComponent,
    AboutComponent,
    DesignerviewprofileComponent,
    DesignerprofileComponent,
    DesignereditdialogueComponent
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
     MatCardModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
