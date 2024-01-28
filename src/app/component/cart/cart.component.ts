import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Cart } from 'src/app/model/Cart';
import { AdminService } from 'src/app/service/admin.service';
import { CartService } from 'src/app/service/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {

  key:any;
  response: any;
  cartService:any
  adminKey:any;
  authRequest: Cart = new Cart();
  deleteId!: number;
  getName!:String;
  cartId:number=0;
  Token:any;
  

  constructor(private jwtService:CartService,admintoken:AdminService,private router:Router){
    this.cartService=jwtService;
    this.key=admintoken.Token;
    this.key.subscribe((genToken: any) => {
      this.adminKey = genToken;
    });
    
   }
   public getall(){
    this.accessApi(this.adminKey)
    console.log(this.adminKey);
    
  }
  public accessApi(adminKey: any) {
    console.log('accessApi', adminKey);  
    let response = this.cartService.getAll(adminKey);
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

  isAddFormVisible: boolean = false;
  addForm() {
    this.isAddFormVisible = !this.isAddFormVisible;
  }
  isDeleteFormVisible: boolean = false;
  deleteForm() {
    this.isDeleteFormVisible = !this.isDeleteFormVisible;
  }
  isgetFormVisible: boolean = false;
  getFormName() {
    this.isgetFormVisible = !this.isgetFormVisible;
  }
  isUpdateFormVisible: boolean = false;
  updateForm() {
    this.isUpdateFormVisible = !this.isUpdateFormVisible;
  }

  add(formData: any) {
    const customerId: number = formData.form.value.customerId;
    const quantity: number = formData.form.value.quantity;
    const totalAmount: number = formData.form.value.totalAmount;
  
    const updatedAdmin: Cart = {
      cartId:0,
   customerId:customerId,
   quantity: quantity,
   totalAmount:totalAmount,
   
    };
    
    this.cartService.add(updatedAdmin, this.adminKey)
      .subscribe(
        (updatedAdmin: Cart) => {
          console.log('Updated cart is: ', updatedAdmin);
          alert("Added to cart with cartId"+this.cartId);
          // Handle any further logic or UI updates after a successful update
        },
        (error: any) => {
          console.error('Error updating cart: ', error);
          // Handle error scenarios
        }
      );
  }
  update(formData: any) {
    const cartId: number = formData.form.value.cartId;

    const customerId: number = formData.form.value.customerId;
    const quantity: number = formData.form.value.quantity;
    const totalAmount: number = formData.form.value.totalAmount;
  
    const updatedAdmin: Cart = {
      
      cartId:cartId,
   customerId:customerId,
   quantity: quantity,
   totalAmount:totalAmount,
    };
  
    this.cartService.updateMenu(updatedAdmin, this.adminKey)
      .subscribe(
        (updatedAdmin: Cart) => {
          console.log('Updated Admin is: ', updatedAdmin);
          // Handle any further logic or UI updates after a successful update
        },
        (error: any) => {
          console.error('Error updating Admin: ', error);
          // Handle error scenarios
        }
      );



}


getById(){
  this.accessApi(this.authRequest);
  this.cartService.getId(this.getById,this.Token).subscribe((message:any) => {
    this.response=message
    console.log("get id is success " + message);
  });
}
goBack()
    {
      this.router.navigate(['/admindashboard'])
    }


}
