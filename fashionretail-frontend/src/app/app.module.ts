import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CardComponent } from './card/card.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule, MatDialogModule, MatToolbarModule, MatCardModule, MatButtonModule, MatFormFieldModule } from '@angular/material';
import { OrderService } from './order.service';
import { HttpClientModule } from '@angular/common/http';
import { AddmaterialPageComponent } from './addmaterial-page/addmaterial-page.component';
import {MatSelectModule} from '@angular/material/select';
import { ViewOrdersComponent } from './view-orders/view-orders.component';
import {MatMenuModule} from '@angular/material/menu';
import {MatIconModule} from '@angular/material/icon';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    AddmaterialPageComponent,
    ViewOrdersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatDialogModule,
    MatToolbarModule,
    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    MatSelectModule,
    HttpClientModule,
    MatMenuModule,
    MatIconModule
  ],
  providers: [OrderService],
  bootstrap: [AppComponent]
})
export class AppModule { }
