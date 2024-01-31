import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cart } from 'src/app/model/Cart';
import { CartService } from 'src/app/service/cart.service';
import { CustomerService } from 'src/app/service/customer.service';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-customercart',
  templateUrl: './customercart.component.html',
  styleUrls: ['./customercart.component.css']
})
export class CustomercartComponent {
  key:any;
  response: any;
  cartService:any
  adminKey:any;
  authRequest: Cart = new Cart();
  deleteId!: number;
  getName!:String;
  cartId:number=0;
  Token:any;
  getId!:number;
  quant!:number;

  customerid:any;
  idcustomer: any;
  quantity: any;
  custid: any;

  constructor(private jwtService:CartService,private admintoken:CustomerService,private variable:ProductService,private router:Router,private activatedRoute: ActivatedRoute){
    this.cartService=jwtService;
    this.key=admintoken.Token;
    console.log(this.key+"food");
    this.key.subscribe((genToken: any) => {
      this.adminKey = genToken;
      console.log(this.adminKey+"food by");
      this.customerid=admintoken.customerId;
      console.log("customer id is:"+this.customerid);



      this.activatedRoute.params.subscribe((params) => {
        this.custid=params['custid']
        this.idcustomer=params['id']
        this.quantity = params['quantity'];
        console.log("customercart"+this.idcustomer,this.quantity,this.custid);
        
      });


      this.getall()

    });
    
   }
   public getall(){
    this.accessApi(this.adminKey)
    console.log(this.adminKey);
    
  }
  public accessApi(adminKey: any) {
    console.log('accessApi', adminKey); 
    let response = this.cartService.getByCustomerId(this.custid,adminKey);
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
  isGetFormNameVisible: boolean = false;
  getFormName() {
    this.isGetFormNameVisible = !this.isGetFormNameVisible;
  }
  isUpdateFormVisible: boolean = false;
  updateForm() {
    this.isUpdateFormVisible = !this.isUpdateFormVisible;
  }

  add() {
    const customerId: number =this.admintoken.mainId;
    const quantity: number = this.variable.quant;
    const totalAmount: number = this.variable.price*quantity
    
    console.log(customerId,quantity,totalAmount);
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
          const addedCartId: number = updatedAdmin.cartId; // assuming cartId is returned in the response
                alert("Added to cart with cartId " + addedCartId);
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
  this.cartService.getById(this.getId,this.Token).subscribe((message:any) => {
    this.response=message
    console.log("get id is success " + message);
  });
}
getBycustomerId(){
  this.cartService.getByName(this.admintoken.mainId,this.Token).subscribe((message:any) => {
    this.response=message
    console.log("get id is success " + message);
  });
}
order(){
  this.router.navigate(["/customerorder"]);
}

}
