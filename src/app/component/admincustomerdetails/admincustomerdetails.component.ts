import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthRequest } from 'src/app/model/AuthRequest';
import { customer } from 'src/app/model/Customer';
import { AdminService } from 'src/app/service/admin.service';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-admincustomerdetails',
  templateUrl: './admincustomerdetails.component.html',
  styleUrls: ['./admincustomerdetails.component.css']
})
export class AdmincustomerdetailsComponent {
  key:any;
  response: any;
  menuService:any
  adminKey:any;
  authRequest: customer = new customer();
  deleteId!: number;
  getName!:String;
  getresponseName:any;

  admin:boolean=false;
  customer:boolean=false;
  constructor(private jwtService:CustomerService,admintoken:AdminService,private route:Router){
    this.menuService=jwtService;
      this.admin=true;
      this.customer=false;
    this.key=admintoken.Token;
    this.key.subscribe((genToken: any) => {
      this.adminKey = genToken;
       console.log(genToken);
       console.log("hi")
      // this.accessApi(this.adminKey);
      this.authorizationTest();
    });
  }
  ngOnInit(): void {
    
  }

   public authorizationTest(){
    this.accessApi(this.adminKey)
    console.log(this.adminKey);
    console.log("hello")
    console.log(this.response)
   }

   public accessApi(adminKey: any) {
    console.log('accessApi', adminKey);  
    let response = this.menuService.authorizationTest(adminKey);
    response.subscribe((responseData: any) => {
      if (typeof responseData === 'string') {
        this.response = JSON.parse(responseData); // Parse string to array
        console.log('Response Data:', this.response);
      } else {
        console.log('Unexpected response type:', responseData);
        // Handle unexpected response if necessary
      } 
    });
  }
  goBack()
      {
        this.route.navigate(['/admindashboard'])
      }


}