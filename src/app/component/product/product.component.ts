// import { Component, OnInit } from '@angular/core';
// import { Product } from 'src/app/model/Product';
// import { ProductService } from 'src/app/service/product.service';
// import { AdminService } from 'src/app/service/admin.service';
// import { Observable } from 'rxjs';
// import { NgForm } from '@angular/forms';
// import { Router } from '@angular/router';
// @Component({
//   selector: 'app-product',
//   templateUrl: './product.component.html',
//   styleUrls: ['./product.component.css']
// })
// export class ProductComponent implements  OnInit{

//   key:any;
//   response: any;
//   productService:any
//   adminKey:any;
//   authRequest: Product = new Product();
//   deleteId!: any;
//   getName!:String;
//   getresponseName:any;
//   adminKey$!: Observable<any>;
//   getCategory!: String;
//   quant!:number;
 

//   constructor(private jwtService: ProductService, private admintoken: AdminService,private router:Router) {
//     this.productService = jwtService;
//     this.key = this.admintoken.Token;
//     this.key.subscribe((genToken: any) => {
//       this.adminKey = genToken;
//      // console.log(this.adminKey)
//     });
//   }
//   ngOnInit(): void {
    
//   }
  


//   public getall(){
//     this.accessApi(this.adminKey)
//     console.log(this.adminKey);
    
//   }

//   public accessApi(adminKey: any) {
//     console.log('accessApi', adminKey);  
//     let response = this.productService.getAll(adminKey);
//     response.subscribe((responseData: any) => {
//       if (typeof responseData === 'string') {
//         this.response = JSON.parse(responseData);
//         console.log('Response Data:', this.response);
//       } else {
//         console.log('Unexpected response type:', responseData);
//       } 
//     });
//   }


//   isaddFormVisible: boolean = false;
//   addForm() {
//     this.isaddFormVisible = !this.isaddFormVisible;
//   }
//   isupdateFormVisible: boolean = false;
//   updateForm() {
//     this.isupdateFormVisible = !this.isupdateFormVisible;
//   }
//   isdeleteFormVisible: boolean = false;
//   deleteForm() {
//     this.isdeleteFormVisible = !this.isdeleteFormVisible;
//   }
//   isgetFormNameVisible: boolean = false;
//   getFormName() {
//     this.isgetFormNameVisible = !this.isgetFormNameVisible;
//   }
//   isgetFormCategoryVisible: boolean = false;
//   getFormCategory() {
//     this.isgetFormCategoryVisible = !this.isgetFormCategoryVisible;
//   }


//   add(formData: any) {
//     //const productId: number = formData.form.value.productId;
//     const productName: string = formData.form.value.productName;
//     const brand: string = formData.form.value.brand;
//     const category: string = formData.form.value.category;
//     const price: number = formData.form.value.price;

  
//     const updatedAdmin: Product = {

//       productId: 0,
//       productName: productName,
//       category: category,
//       brand: brand,
//       price: price
      
//     };
  
//     this.productService.add(updatedAdmin, this.adminKey)
//       .subscribe(
//         (updatedAdmin: Product) => {
//           console.log('Updated product is: ', updatedAdmin);
//           alert("Product is Added");
//         },
//         (error: any) => {
//           console.error('Error updating Product: ', error);

//         }
//       );

//   }
//   delete(productId: number) {
//     this.productService.delete(productId, this.adminKey).subscribe(
//       (msg: any) => {
//         console.log("Product is deleted");
//         this.response = this.response.filter((admin) => admin.productId !== productId);
//         alert("Product is deleted");
//       },
//       (error) => {
//         console.error("Error deleting product:", error);
//       }
//     );
//   }
  

//   // delete(productId:number) {
//   //   this.productService.delete(productId,this.adminKey).subscribe((msg:any) => {
//   //    console.log("Product is deleted");
      
//   //     alert("Product is deleted");
//   //   });

  

//   // deleteById() {
//   //   this.jwtService.delete(this.deleteId, this.adminKey).subscribe((msg:any) => {
//   //     console.log( msg);
//   //     console.log("hi");
//   //   });
//    }
  



//   getByName(){
//     this.jwtService.getName(this.getName,this.adminKey).subscribe((message) => {
//       this.getresponseName=message
//       console.log("get Name is success " + message);
//     });
//   }


//   //  getByCategory(){
//   //   this.jwtService.getCategory(this.getCategory,this.productKey).subscribe((message) => {
//   //     this.getresponseName=message
//   //     console.log("Get Category is success " + message);
//   //   });



//     update(formData: any) {
//       const formValue = formData?.form?.value; // Safely access form value
    
//       if (!formValue) {
//         console.error('Form data is invalid or empty.');
//         return;
//       }
    
//       const { productId, productName, category, brand, price } = formValue;
    
//       // Validate form values (ensure they exist and are of the correct type)
    
//       if (productId === undefined || productName === undefined || category === undefined || brand === undefined || price === undefined) {
//         console.error('Form data contains undefined values.');
//         return;
//       }
    
//       const updatedAdmin: Product = {
//         productId: productId,
//         productName: productName,
//         category: category,
//         brand: brand,
//         price: price
//       };
    
//       this.productService.update(updatedAdmin, this.adminKey)
//         .subscribe(
//           (updatedAdmin: Product) => {
//             console.log('Updated Admin is: ', updatedAdmin);
//             alert("Product is Updated");
//             // Handle successful update
//           },
//           (error: any) => {
//             console.error('Error updating Admin: ', error);
//             // Handle error during update
//           }
//         );
//     }
//     goBack()
//     {
//       this.router.navigate(['/admindashboard'])
//     }

    
  
// }
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/Product';
import { ProductService } from 'src/app/service/product.service';
import { AdminService } from 'src/app/service/admin.service';
import { Observable } from 'rxjs';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  key: any;
  response: Product[] = [];
  adminKey: any;
  deleteId!: any;
  getName!: String;
  getresponseName: any;
  // adminKey$: Observable<any>;
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

  // isaddFormVisible: boolean = false;
  // isupdateFormVisible: boolean = false;
  // isdeleteFormVisible: boolean = false;
  // isgetFormNameVisible: boolean = false;
  // isgetFormCategoryVisible: boolean = false;

  constructor(
    private productService: ProductService,
    private admintoken: AdminService,
    private router: Router
  ) {
    this.key = this.admintoken.Token;
    this.key.subscribe((genToken: any) => {
      this.adminKey = genToken;
    });
  }
  ngOnInit(): void { }

  public getall() {
    this.accessApi(this.adminKey);
  }

  public accessApi(adminKey: any) {
    this.productService.getAll(adminKey).subscribe(
      (responseData: any) => {
        // Use responseData as needed, adjust type if necessary
        console.log('Response Data:', responseData);
      },
      (error) => {
        console.error('Error fetching products:', error);
      }
    );
  }

  // ngOnInit(): void { }

  // public getall() {
  //   this.accessApi(this.adminKey);
  // }

  // public accessApi(adminKey: any) {
  //   this.productService.getAll(adminKey).subscribe(
  //     (responseData: Product[]) => {
  //       this.response = responseData;
  //       console.log('Response Data:', this.response);
  //     },
  //     (error) => {
  //       console.error('Error fetching products:', error);
  //     }
  //   );
  // }

  add(formData: NgForm) {
    const { productName, brand, category, price } = formData.value;

    const newProduct: Product = {
      productId: 0,
      productName: productName,
      category: category,
      brand: brand,
      price: price
    };

    this.productService.add(newProduct, this.adminKey).subscribe(
      (addedProduct: Product) => {
        console.log('Added product is: ', addedProduct);
        this.response.push(addedProduct);
        alert("Product is Added");
      },
      (error: any) => {
        console.error('Error adding Product: ', error);
      }
    );
  }

  delete(productId: number) {
    this.productService.delete(productId, this.adminKey).subscribe(
      () => {
        console.log("Product is deleted");
        this.response = this.response.filter((product) => product.productId !== productId);
        alert("Product is deleted");
      },
      (error) => {
        console.error("Error deleting product:", error);
      }
    );
  }

  update(formData: NgForm) {
    const formValue = formData?.value;

    if (!formValue) {
      console.error('Form data is invalid or empty.');
      return;
    }

    const { productId, productName, category, brand, price } = formValue;

    const updatedProduct: Product = {
      productId: productId,
      productName: productName,
      category: category,
      brand: brand,
      price: price
    };

    this.productService.update(updatedProduct, this.adminKey).subscribe(
      (updatedProduct: Product) => {
        console.log('Updated Product is: ', updatedProduct);
        alert("Product is Updated");
      },
      (error: any) => {
        console.error('Error updating Product: ', error);
      }
    );
  }

  goBack() {
    this.router.navigate(['/admindashboard']);
  }
}

  
  