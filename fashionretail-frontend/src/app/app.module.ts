import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';
import { MatInputModule,MatListModule} from '@angular/material';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatSelectModule } from '@angular/material/select';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatButtonModule} from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import {MatMenuModule} from '@angular/material/menu';
// import { LoginComponent } from './login/login.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDividerModule} from '@angular/material/divider';
import { RouterModule, Routes } from '@angular/router';
import {MatDialogModule} from '@angular/material/dialog';
import { DesignerHomePageComponent,UploadDesignsDialogue } from './designer-home-page/designer-home-page.component';
import {
  MatSidenavModule,
} from '@angular/material';
import { MatProgressSpinnerModule } from "@angular/material";
import { Ng2CarouselamosModule } from 'ng2-carouselamos';
import { MatTabsModule } from '@angular/material';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import { HeroComponent } from './hero/hero.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';
import { from } from 'rxjs';
// import { MatMenuTrigger } from '@angular/material';
// import { from } from 'rxjs';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    DesignerHomePageComponent,
    UploadDesignsDialogue,
    HeroComponent,
    ContactComponent,
    AboutComponent

  ],
  imports: [
    MatDialogModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatCardModule,
    HttpClientModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatAutocompleteModule,
    MatSelectModule,
    FlexLayoutModule,
    MatListModule,
    MatButtonModule,
    MatIconModule,
    MatMenuModule,
    MatFormFieldModule,
    MatDividerModule,
    RouterModule,
    MatSidenavModule,
    MatProgressSpinnerModule,
    Ng2CarouselamosModule,
    MatTabsModule,
    MatProgressBarModule,
    // MatMenuTrigger
  ],
  providers: [],
  entryComponents : [DesignerHomePageComponent,UploadDesignsDialogue],
  bootstrap: [AppComponent]
})
export class AppModule { }
