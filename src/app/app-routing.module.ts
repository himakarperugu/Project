import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductComponent } from './component/product/product.component';
import { CartComponent } from './component/cart/cart.component';
import { NotfoundComponent } from './component/notfound/notfound.component';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';
import { AboutusComponent } from './component/aboutus/aboutus.component';
import { CustomerComponent } from './component/customer/customer.component';
import { OrderComponent } from './component/order/order.component';
import { AdmindashboardComponent } from './component/admindashboard/admindashboard.component';
import { CustomerdashboardComponent } from './component/customerdashboard/customerdashboard.component';

const routes: Routes = [ {path:'', component:HomeComponent},

{path:'aboutus', component:AboutusComponent},
{path:'adminlogin',component:LoginComponent},
{path:'customerlogin',component:CustomerComponent},
{path:'admindashboard',component:AdmindashboardComponent},
{path:'customerdashboard',component:CustomerdashboardComponent},
{path:'product',component:ProductComponent},
{path:'cart',component:CartComponent},
{path:'order',component:OrderComponent},
{path:'**',component:NotfoundComponent}];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
