import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Cart } from 'src/app/model/Cart';
import { Product } from 'src/app/model/Product';
import { CartService } from 'src/app/service/cart.service';
import { CustomerService } from 'src/app/service/customer.service';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-customerproduct',
  templateUrl: './customerproduct.component.html',
  styleUrls: ['./customerproduct.component.css']
})
export class CustomerproductComponent implements  OnInit{

  key:any;
  response: any;
  productService:any
  adminKey:any;
  authRequest: Product = new Product();
  deleteId!: number;
  getName!:String;
  getresponseName:any;
  adminKey$!: Observable<any>;
  getCategory!: String;
  // quant:any;
  quantities: { [productId: number]: number } = {};
  customerid: any;


  constructor(private jwtService: ProductService, private admintoken: CustomerService,private cartService:CartService,private router:Router,private activatedRoute: ActivatedRoute) {
    this.productService = jwtService;
    this.activatedRoute.params.subscribe((params) => {
      this.customerid = params['id'];
      console.log('customer ID customerproduct:', this.customerid);
      
    });

    this.key = this.admintoken.Token;
    this.key.subscribe((genToken: any) => {
      this.adminKey = genToken;
     // console.log(this.adminKey)
    });
    this.getall();
  }
  ngOnInit(): void {
    
  }
  
  


  public getall(){
    this.accessApi(this.adminKey)
    console.log(this.adminKey);
    
  }

  public accessApi(adminKey: any) {
    console.log('accessApi', adminKey);  
    let response = this.productService.getAll(adminKey);
    response.subscribe((responseData: any) => {
      if (typeof responseData === 'string') {
        this.response = JSON.parse(responseData);
        console.log('Response Data:', this.response);

      } 
      else {
        console.log('Unexpected response type:', responseData);
      } 
    });
  }


  isaddFormVisible: boolean = false;
  addForm() {
    this.isaddFormVisible = !this.isaddFormVisible;
  }
  isupdateFormVisible: boolean = false;
  updateForm() {
    this.isupdateFormVisible = !this.isupdateFormVisible;
  }
  isdeleteFormVisible: boolean = false;
  deleteForm() {
    this.isdeleteFormVisible = !this.isdeleteFormVisible;
  }
  isgetFormNameVisible: boolean = false;
  getFormName() {
    this.isgetFormNameVisible = !this.isgetFormNameVisible;
  }
  isgetFormCategoryVisible: boolean = false;
  getFormCategory() {
    this.isgetFormCategoryVisible = !this.isgetFormCategoryVisible;
  }

  getByName(){
    this.jwtService.getName(this.getName,this.adminKey).subscribe((message) => {
      this.getresponseName=message
      console.log("get Name is success " + message);
    });
  }
 

  // add(price:any){
    
  //   this.jwtService.quant=this.quant;
  //   this.jwtService.price=price;
    
  //   console.log(this.jwtService.quant,this.jwtService.price=price);
  //   this.gotoCustomercart();
  //   };
  //   gotoCustomercart(){
  //     this.router.navigate(["/customercart"])
  //   }
  // add(product: any, quantity: number) {
  //   console.log(product, quantity);
  //   this.gotoCustomercart(product, quantity);
  // }

  // gotoCustomercart(product: any, quantity: number) {
  //   this.router.navigate(['/customercart',this.customerid, product.productId, quantity]);
  // }


  add(product: any, quantity: number) {
    console.log(product, quantity);

    // Construct a Cart object using the properties from the product and quantity
    const cartToAdd: Cart = {
        cartId: 0, // assuming cartId is not relevant here
        customerId: this.customerid, // You may need to obtain the customerId from your component
        quantity: quantity,
        totalAmount: product.price * quantity
    };

    // Call the add method from CartService
    this.cartService.add(cartToAdd, this.adminKey)
        .subscribe(
            (addedCart: Cart) => {
                console.log('Added Cart:', addedCart);
                alert("Added to cart with cartId " + addedCart.cartId);
               this.router.navigate(['/customercart',this.customerid]);

            },
            (error: any) => {
                console.error('Error adding cart: ', error);
            }
        );
}






   }



  
  
  





  