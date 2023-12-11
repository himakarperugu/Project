import { Token } from '@angular/compiler';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthRequest } from 'src/app/model/AuthRequest';
import { customer } from 'src/app/model/Customer';
import { CustomerService } from 'src/app/service/customer.service';


@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent {
  deleteId!: number;
  response: any;
  token: any;
  authRequest: AuthRequest = new AuthRequest();
  mainCustomerId:any;
  


  

  constructor(private customerService: CustomerService, private router:Router) {}

  readFormData(formData: any) {
    this.authRequest.username = formData.form.value.username;
    this.authRequest.password = formData.form.value.password;
    this.getAccessToken(this.authRequest);
  }
 
  public accessApi(token: any) {
    let response = this.customerService.authorizationTest(token);
    response.subscribe((responseData: any) => {
      if (typeof responseData === 'string') {
        this.response = JSON.parse(responseData); 
        console.log('Response Data:', this.response);
        this.getbyname(token);
        alert("Customer Login Successfull");
        this.router.navigate(['customerdashboard'])
      } else {
        console.log('Unexpected response type:', responseData);
      }
    });
  }
  isshowFormVisible: boolean = false;
  showForm() {
    this.isshowFormVisible = !this.isshowFormVisible;
  }
  isFormVisible: boolean = false;
  toggleForm() {
    this.isFormVisible = !this.isFormVisible;
  }
  isdeleteFormVisible: boolean = false;
  deleteForm() {
    this.isdeleteFormVisible = !this.isdeleteFormVisible;
  }
  isupdateFormVisible: boolean = false;
  updateForm() {
    this.isupdateFormVisible = !this.isupdateFormVisible;
  }




  insertEmployee(data:customer){
    console.log(data)
    
    this.customerService.insert(data)
    .subscribe(
      (adm)=>{console.log(adm);}
      );
}

deleteById() {
  this.getAccessToken(this.authRequest);
  console.log("Delete ID: " + this.deleteId);
  // Now, make the delete request with the entered ID
  this.customerService.delete(this.deleteId, this.token).subscribe((msg) => {
    console.log("Deleted " + msg);
    
  });
}

public getAccessToken(authRequest: any) {
  let response = this.customerService.getGeneratedToken(authRequest);
  response.subscribe((genToken:any) => {
    this.token = genToken;
    console.log(genToken);
     this.accessApi(this.token);
    
  });
}

update(formData: any) {
  const customerId: number = formData.form.value.customerId;
  const customerName: string = formData.form.value.customerName;
  const email: string = formData.form.value.email;

  const phoneNumber: string = formData.form.value.phoneNumber;

  const deliveryAddress: string = formData.form.value.deliveryAddress;


  const password: string = formData.form.value.password;

  const updatedAdmin: customer = {
    

    customerId:customerId,
    customerName:customerName,
    email:email,
    phoneNumber:phoneNumber,
    deliveryAddress:deliveryAddress,
    password:password


  };

  this.customerService.updateCustomer(updatedAdmin, this.token)
    .subscribe(
      (updatedCustomer: customer) => {
        console.log('Updated Customer is: ', updatedCustomer);
        // Handle any further logic or UI updates after a successful update
      },
      (error: any) => {
        console.error('Error updating Customer: ', error);
        // Handle error scenarios
      }
    );
}

getbyname(adminKey: string) { // Accept adminKey as a parameter
  if (adminKey) {
    let response = this.customerService.getcustomer(this.authRequest.username, adminKey);

    response.subscribe((responseData: any) => {
      if (responseData && typeof responseData === 'string') {
        this.response = JSON.parse(responseData);
        this.mainCustomerId=this.response.customerId;
        console.log('Response Data:', this.response);
       this.customerService.customerId=this.mainCustomerId;
      console.log("hi");

        // Convert object properties to an array, excluding the 'password' property

      }
    });
  } else {
    console.error('Admin key is null.');
  }
}


}