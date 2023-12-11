import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
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
  quant!:number;


  constructor(private jwtService: ProductService, private admintoken: CustomerService,private cartService:CartService,private router:Router) {
    this.productService = jwtService;
    this.key = this.admintoken.Token;
    this.key.subscribe((genToken: any) => {
      this.adminKey = genToken;
     // console.log(this.adminKey)
    });
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

  add(product:any,price:any){
    this.jwtService.productId=product;
    this.jwtService.quant=this.quant;
    this.jwtService.price=price;
    console.log(this.jwtService.productId,this.jwtService.quant=this.quant,this.jwtService.price=price);
    this.gotoCustomercart();
    };
    gotoCustomercart(){
      this.router.navigate(["/customercart"])
    }

  //  getByCategory(){
  //   this.jwtService.getCategory(this.getCategory,this.productKey).subscribe((message) => {
  //     this.getresponseName=message
  //     console.log("Get Category is success " + message);
  //   });
  
}

  