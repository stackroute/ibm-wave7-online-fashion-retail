import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MatToolbarModule,MatIconModule, MatButtonModule,MatMenuModule,MatFormFieldModule} from '@angular/material';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material';
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
import { HeaderComponent, SignUpDialogue } from './header/header.component';
import { AboutComponent } from './about/about.component';
import {MatDialogModule} from '@angular/material/dialog';
import { MatCardModule } from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatSelectModule } from '@angular/material/select';
import { MatTabsModule } from '@angular/material';
import { SupplierviewprofileComponent } from './supplierviewprofile/supplierviewprofile.component';
import { ProfilebuttonComponent } from './profilebutton/profilebutton.component';
import { CardComponent } from './card/card.component';
import { OrderService } from './order.service';
import { BodyComponent } from './body/body.component';
import { DesignerHomePageComponent , UploadDesignsDialogue} from './designer-home-page/designer-home-page.component';
import { from } from 'rxjs';
import { Header1Component } from './header1/header1.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchboxComponent,
    FooterComponent,
    ContactComponent, 
    HeroComponent,
    // HeaderComponent,
    AboutComponent,
    // SignUpDialogue,
    SupplierviewprofileComponent,
    ProfilebuttonComponent,
    CardComponent,
    BodyComponent,
    DesignerHomePageComponent,
    UploadDesignsDialogue,
    HeaderComponent,
    SignUpDialogue,
    Header1Component,
    ],
  imports: [
    BrowserModule,
    MatCardModule,
    MatListModule,
    FormsModule,
    ReactiveFormsModule,
    MatAutocompleteModule,
    HttpClientModule,
    AppRoutingModule,
    MatToolbarModule,
    MatJumbotronModule,
    MatIconModule,
    MatButtonModule,
    FlexLayoutModule,
    MatSelectModule,
    MatMenuModule,
    MatInputModule,
    MatFormFieldModule,
    Ng2CarouselamosModule,
    MatSidenavModule,
    MatDialogModule,
     BrowserAnimationsModule,
     MatTabsModule,
    
  ],
  providers: [OrderService],
  entryComponents : [SignUpDialogue,UploadDesignsDialogue],
  bootstrap: [AppComponent]
})
export class AppModule { }
