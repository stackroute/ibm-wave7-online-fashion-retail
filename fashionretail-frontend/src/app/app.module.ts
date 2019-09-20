import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {MatToolbarModule, MatButtonModule} from '@angular/material';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material';
import {MatListModule} from '@angular/material';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SearchboxComponent} from './searchbox/searchbox.component';
import {FooterComponent} from './footer/footer.component';
import {ContactComponent} from './contact/contact.component';
import {MatJumbotronModule} from '@angular-material-extensions/jumbotron';
import {Ng2CarouselamosModule} from 'ng2-carouselamos';
import {HeroComponent} from './hero/hero.component';
import {FlexLayoutModule} from '@angular/flex-layout';
import {MatSidenavModule} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HeaderComponent, SignUpDialogue} from './header/header.component';
import {SupplierEditDialogue} from './supplierviewprofile/supplierviewprofile.component';
import {AboutComponent} from './about/about.component';
import {MatCardModule} from '@angular/material';
import {MatDialogModule} from '@angular/material/dialog';
import {HttpClientModule} from '@angular/common/http';
import {AddmaterialsbuttonComponent, manufactureAddDialog} from './addmaterialsbutton/addmaterialsbutton.component';
import {DisplaymaterialsComponent} from './displaymaterials/displaymaterials.component';
import {MatTableModule} from '@angular/material/table';
import {ForgotpasswordComponent} from './forgotpassword/forgotpassword.component';
import {ResetPasswordComponent} from './reset-password/reset-password.component';
import {AddmaterialPageComponent} from './addmaterial-page/addmaterial-page.component';
import {MatBottomSheetModule} from '@angular/material/bottom-sheet';
import {ConsumerDashboardComponent} from './consumer-dashboard/consumer-dashboard.component';
import {CartBottomSheetComponent} from './cart-bottom-sheet/cart-bottom-sheet.component';
import {MatBadgeModule} from '@angular/material/badge';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {ConsumerService} from './services/consumer.service';
import {ProductService} from './services/product.service';
import {ConsumerShippingComponent} from './consumer-shipping/consumer-shipping.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatMenuModule} from '@angular/material/menu';
import {MatIconModule} from '@angular/material/icon';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatSelectModule } from '@angular/material/select';
import { MatTabsModule } from '@angular/material';
import { SupplierviewprofileComponent } from './supplierviewprofile/supplierviewprofile.component';
import { ProfilebuttonComponent } from './profilebutton/profilebutton.component';
import { CardComponent } from './card/card.component';
// import { OrderService } from './order.service';
// import { ManufactureeditComponent } from './manufactureedit/manufactureedit.component';
//  import { ReactiveFormsModule } from '@angular/forms';
//  import { BrowserModule } from '@angular/platform-browser';
import { DesignerviewordersComponent } from './designervieworders/designervieworders.component';
import { ViewOrdersComponent } from './view-orders/view-orders.component';
import {BodyComponent} from './body/body.component';
import {
  DesignerHomePageComponent,
  UploadDesignsDialogueComponent,
  AddPriceDialogueComponent
} from './designer-home-page/designer-home-page.component';
import {Header1Component} from './header1/header1.component';
import {PieChartComponent} from 'angular-d3-charts'; // this is needed!
// import { ManufactureeditComponent } from './manufactureedit/manufactureedit.component';
import {ManufactureviewprofileComponent, ManufactureEditDialogComponent} from './manufactureviewprofile/manufactureviewprofile.component';
import {DashboardreportsComponent} from './dashboardreports/dashboardreports.component';
import {DesignerviewprofileComponent, designerEditDialogue} from './designerviewprofile/designerviewprofile.component';
import {SignUpComponent} from './sign-up/sign-up.component';
import {LoginComponent} from './login/login.component';
import {ManufacturerDashboardComponent} from './manufacturer-dashboard/manufacturer-dashboard.component';
import {LoginService} from './services/login.service';
import {AuthenticateService} from './services/authenticate.service';
import {OrderService} from './services/order.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ManufacturerViewOrderComponent } from './manufacturer-view-order/manufacturer-view-order.component';
import { PaymentComponent } from './payment/payment.component';
import {UniqueEmailValidator} from './sign-up/unique-email-validator';
import { CustomerViewProfileComponent } from './customer-view-profile/customer-view-profile.component';
import { CustomerViewOrdersComponent } from './customer-view-orders/customer-view-orders.component';



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
    AddmaterialsbuttonComponent,
    DisplaymaterialsComponent,
    manufactureAddDialog,
    SupplierEditDialogue,
    CardComponent,
    BodyComponent,
    DesignerHomePageComponent,
    UploadDesignsDialogueComponent,
    HeaderComponent,
    SignUpDialogue,
    Header1Component,
    AboutComponent,
    DesignerviewprofileComponent,
        ManufactureviewprofileComponent,
    ProfilebuttonComponent,
    SignUpComponent,
    LoginComponent,
    AddmaterialPageComponent,
    SupplierviewprofileComponent,
    designerEditDialogue,
    CartBottomSheetComponent,
    ManufactureviewprofileComponent,
    ProfilebuttonComponent,
    DashboardreportsComponent,
    PieChartComponent,
    SupplierviewprofileComponent,
    AddmaterialPageComponent,
    ConsumerDashboardComponent,
    ManufacturerDashboardComponent,
    DesignerviewordersComponent,
    AddPriceDialogueComponent,
     ForgotpasswordComponent,
     ResetPasswordComponent,
    ViewOrdersComponent,
    ManufactureEditDialogComponent,
    ConsumerShippingComponent,
    PaymentComponent,
    ManufacturerViewOrderComponent,

    CustomerViewProfileComponent,

    CustomerViewOrdersComponent,


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
    MatMenuModule,
    MatInputModule,
    MatFormFieldModule,
    Ng2CarouselamosModule,
    MatSidenavModule,
     BrowserAnimationsModule,
     MatCardModule,
     MatDialogModule,
     HttpClientModule,
     FormsModule,
    MatTabsModule,
    MatSelectModule,
    MatTableModule,
    MatBottomSheetModule,
    MatBadgeModule,
    MatSnackBarModule
  ],

  providers: [ProductService, ConsumerService, LoginService, AuthenticateService, OrderService, UniqueEmailValidator,
    { provide: MAT_DIALOG_DATA, useValue: {} },
    { provide: MatDialogRef, useValue: {} }],
  // entryComponents : [SupplierEditDialogue,UploadDesignsDialogue,manufactureEditDialog,manufactureAddDialog,],
  entryComponents: [SignUpDialogue,
    SupplierEditDialogue,
    UploadDesignsDialogueComponent,
    ManufactureEditDialogComponent,
    manufactureAddDialog,
    designerEditDialogue,
    AddPriceDialogueComponent,
    CartBottomSheetComponent,
  ],
  bootstrap: [AppComponent]

})
export class AppModule { }
