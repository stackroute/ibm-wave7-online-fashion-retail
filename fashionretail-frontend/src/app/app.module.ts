import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatToolbarModule,MatIconModule, MatButtonModule,MatMenuModule,MatFormFieldModule} from '@angular/material';
import { MatInputModule } from '@angular/material/input';
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
import { ManufactureviewprofileComponent, manufactureEditDialog } from './manufactureviewprofile/manufactureviewprofile.component';
import { ProfilebuttonComponent } from './profilebutton/profilebutton.component';
import { MatCardModule} from '@angular/material';
import {MatDialogModule} from '@angular/material/dialog';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AddmaterialsbuttonComponent, manufactureAddDialog } from './addmaterialsbutton/addmaterialsbutton.component';
import { DisplaymaterialsComponent } from './displaymaterials/displaymaterials.component';




@NgModule({
  declarations: [
    AppComponent,
    SearchboxComponent,
    FooterComponent,
    ContactComponent, 
    HeroComponent,
    HeaderComponent,
    AboutComponent,
    ManufactureviewprofileComponent,
    ProfilebuttonComponent,
    manufactureEditDialog,
    AddmaterialsbuttonComponent,
    DisplaymaterialsComponent,
    manufactureAddDialog

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
     MatCardModule,
     MatDialogModule,
     HttpClientModule,
     FormsModule
     

    
  ],
  providers: [],
  entryComponents: [manufactureEditDialog,manufactureAddDialog],
  bootstrap: [AppComponent]
})
export class AppModule { }
