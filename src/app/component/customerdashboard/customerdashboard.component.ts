import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customerdashboard',
  templateUrl: './customerdashboard.component.html',
  styleUrls: ['./customerdashboard.component.css']
})
export class CustomerdashboardComponent {
  constructor(private router:Router){}
  goBack()
      {
        this.router.navigate(['/customerdashboard'])
      }
}
