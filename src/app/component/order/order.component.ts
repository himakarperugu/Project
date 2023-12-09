import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Orders } from 'src/app/model/Orders';
import { AdminService } from 'src/app/service/admin.service';
import { OrdersService } from 'src/app/service/orders.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent {
  key:any;
  response: any;
  orderService:any
  adminKey:any;
  authRequest: Orders = new Orders();
  deleteId!: number;
  getName!:String;
  getresponseName:any;
  constructor(private jwtService:OrdersService,admintoken:AdminService,private router:Router){

    
    this.orderService=jwtService;
    this.key=admintoken.Token;
    this.key.subscribe((genToken: any) => {
      this.adminKey = genToken;
      // console.log(genToken);
      // this.accessApi(this.adminKey);
    });
    
   }

   public getall(){
    this.accessApi(this.adminKey)
    console.log(this.adminKey);
    
  }

  public accessApi(adminKey: any) {
    console.log('accessApi', adminKey);  
    let response = this.orderService.getAll(adminKey);
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
  isaddFormVisible: boolean = false;
  addForm() {
    this.isaddFormVisible = !this.isaddFormVisible;
  }
  isdeleteFormVisible: boolean = false;
  deleteForm() {
    this.isdeleteFormVisible = !this.isdeleteFormVisible;
  }
  isgetFormNameVisible: boolean = false;
  getFormName() {
    this.isgetFormNameVisible = !this.isgetFormNameVisible;
  }
  isupdateFormVisible: boolean = false;
  updateForm() {
    this.isupdateFormVisible = !this.isupdateFormVisible;
  }


  add(formData: any) {
    const customerId: number = formData.form.value.customerId;
    const orderDate: Date = formData.form.value.orderDate;
    const deliveryAddress: string = formData.form.value.deliveryAddress;
    const paymentMethod: string = formData.form.value.paymentMethod;
  

  
    const updatedAdmin: Orders = {
      orderId:0,
      customerId: customerId,
      orderDate: orderDate,
      deliveryAddress: deliveryAddress,
      paymentMethod: paymentMethod
      };
    
  
    this.orderService.add(updatedAdmin, this.adminKey)
      .subscribe(
        (updatedAdmin: Orders) => {
          console.log('Updated Admin is: ', updatedAdmin);
          // Handle any further logic or UI updates after a successful update
        },
        (error: any) => {
          console.error('Error updating Admin: ', error);
          // Handle error scenarios
        }
      );
  }

  // deleteById() {
  //   // Remove this line, as it is not needed
  //   // this.menuService(this.authRequest);
  
  //   // Now, make the delete request with the entered ID
  //   this.jwtService.delete(this.deleteId, this.adminKey).subscribe((msg: any) => {
  //     console.log("Deleted " + msg);
  //   });
  // }

  update(formData: any) {
    const orderId: number = formData.form.value.orderId;

    const customerId: number = formData.form.value.customerId;
    const orderDate: Date = formData.form.value.orderDate;
    const deliveryAddress: string = formData.form.value.deliveryAddress;
    const paymentMethod: string = formData.form.value.paymentMethod;
  
  
  
    const updatedAdmin: Orders = {
      
      orderId:orderId,
      customerId: customerId,
      orderDate: orderDate,
      deliveryAddress: deliveryAddress,
      paymentMethod: paymentMethod,
    };
  
    this.orderService.update(updatedAdmin, this.adminKey)
      .subscribe(
        (updatedAdmin: Orders) => {
          console.log('Updated Admin is: ', updatedAdmin);
          // Handle any further logic or UI updates after a successful update
        },
        (error: any) => {
          console.error('Error updating Admin: ', error);
          // Handle error scenarios
        }
      );
  }
  
  goBack()
  {
    this.router.navigate(['/admindashboard'])
  }




}


