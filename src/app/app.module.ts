import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductComponent } from './component/product/product.component';
import { OrderComponent } from './component/order/order.component';
import { CartComponent } from './component/cart/cart.component';
import { HomeComponent } from './component/home/home.component';
import { NotfoundComponent } from './component/notfound/notfound.component';
import { RouterModule,Routes } from '@angular/router';
import { HeaderComponent } from './component/header/header.component';
import{HttpClientModule} from '@angular/common/http';
import { AdminComponent } from './component/admin/admin.component';
import { FooterComponent } from './component/footer/footer.component';
import { LoginComponent } from './component/login/login.component';
import { RegistrationComponent } from './component/registration/registration.component';
import { AboutusComponent } from './component/aboutus/aboutus.component';
import { CustomerComponent } from './component/customer/customer.component';
import { AdmindashboardComponent } from './component/admindashboard/admindashboard.component';
import { CustomerdashboardComponent } from './component/customerdashboard/customerdashboard.component';


@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    OrderComponent,
    CartComponent,
    HomeComponent,
    NotfoundComponent,
    HeaderComponent,
    AdminComponent,
    FooterComponent,
    LoginComponent,
    RegistrationComponent,
    AboutusComponent,
    CustomerComponent,
    AdmindashboardComponent,
    CustomerdashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
