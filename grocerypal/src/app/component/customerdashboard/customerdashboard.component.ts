import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-customerdashboard',
  templateUrl: './customerdashboard.component.html',
  styleUrls: ['./customerdashboard.component.css']
})
export class CustomerdashboardComponent {
  constructor(private router:Router){}

  customerproduct(){
  this.router.navigate(['/customerproduct'])
  

 }
 customercart(){
  this.router.navigate(['/customercart'])

}
customerorder(){
  this.router.navigate(['/customerorder'])

}
}
