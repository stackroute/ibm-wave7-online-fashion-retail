import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BodyComponent } from './body/body.component';
import { CardComponent } from './card/card.component';
// import { Manufacture } from './order.service';
import { OrderService } from './order.service';
import { MatInputModule, MatDialogModule, MatToolbarModule, MatCardModule, MatButtonModule, MatFormFieldModule } from '@angular/material';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    BodyComponent,
    CardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatInputModule,
    MatDialogModule,
    MatToolbarModule,
    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    HttpClientModule,
    BrowserAnimationsModule
    
  ],
  providers: [OrderService],
  bootstrap: [AppComponent]
})
export class AppModule { }
