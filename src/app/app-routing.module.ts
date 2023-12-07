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

const routes: Routes = [ {path:'', component:HomeComponent},

{path:'aboutus', component:AboutusComponent},
{path:'adminlogin',component:LoginComponent},
{path:'customerlogin',component:CustomerComponent},
// {path:'registration',component:RegistrationComponent},
{path:'product',component:ProductComponent},
{path:'cart',component:CartComponent},
{path:'order',component:OrderComponent},
{path:'**',component:NotfoundComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
