import { Component } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-customerdashboard',
  templateUrl: './customerdashboard.component.html',
  styleUrls: ['./customerdashboard.component.css']
})
export class CustomerdashboardComponent {
  customerid: any;
  constructor(private router:Router,private activatedRoute: ActivatedRoute){

    this.activatedRoute.params.subscribe((params) => {
      this.customerid = params['id'];
      console.log('customer ID customerdash:', this.customerid);
      
    });


  }

  customerproduct(){
  this.router.navigate(['/customerproduct',this.customerid])
  

 }
 customercart(){
  this.router.navigate(['/customercart'])

}
customerorder(){
  this.router.navigate(['/customerorder'])

}
}
