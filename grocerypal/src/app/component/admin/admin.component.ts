import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/service/admin.service';
import { AuthRequest } from 'src/app/model/AuthRequest';
import { Admin } from 'src/app/model/Admin';
import { Router } from '@angular/router';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  deleteId!: number;
  getId!:number;
  getName!: string;
  adminDetails:Admin | undefined;
  getresponse: any;
  getresponseName: any;
  response: any;
  token: any;
  admin: Admin | undefined;
  adminId: number | undefined;
 


  authRequest: AuthRequest = new AuthRequest();
  isLoggedIn: boolean = false;

  login(formData: any) {
    // Implement your login logic here
    // Set this.isLoggedIn to true upon successful login
    this.isLoggedIn = true;
  }
  

constructor(private adminService:AdminService, private router:Router){}

ngOnInit(): void {
  

}

readFormData(formData: any) {
  this.authRequest.username = formData.form.value.username;
  this.authRequest.password = formData.form.value.password;
  this.getAccessToken(this.authRequest);
}

public getAccessToken(authRequest:any){

 let response =  this.adminService.getGeneratedToken(authRequest);

    response.subscribe( (genToken:any)=> {  this.token = genToken ;console.log(genToken); 

    this.accessApi(this.token) });

    

}


public accessApi(token:any){

let response =    this.adminService.authorizationTest(token);

response.subscribe((responseData: any) => {
  if (typeof responseData === 'string') {
    this.response = JSON.parse(responseData); // Parse string to array
    console.log('Response Data:', this.response);
    alert("Admin Login Successfull");
    this.router.navigate(['admindashboard'])
  } else {
    console.log('Unexpected response type:', responseData);
    // Handle unexpected response if necessary
  }
});
}

isFormVisible: boolean = false;
  toggleForm() {
    this.isFormVisible = !this.isFormVisible;
  }
  isshowFormVisible: boolean = false;
  showForm() {
    this.isshowFormVisible = !this.isshowFormVisible;
  }
  isdeleteFormVisible: boolean = false;
  deleteForm() {
    this.isdeleteFormVisible = !this.isdeleteFormVisible;
  }
  isgetFormVisible: boolean = false;
  getForm() {
    this.isgetFormVisible = !this.isgetFormVisible;
  }
  isgetFormNameVisible: boolean = false;
  getFormName() {
    this.isgetFormNameVisible = !this.isgetFormNameVisible;
  }
  isupdateFormVisible: boolean = false;
  updateForm() {
    this.isupdateFormVisible = !this.isupdateFormVisible;
  }





insertEmployee(data:Admin){
    
  this.adminService.insert(data)
  .subscribe(
    (admin)=>{console.log('Added Admin is: '+admin);}
    );
}
deleteById() {
  debugger
this.getAccessToken(this.authRequest);
this.adminService.delete(this.deleteId, this.token).subscribe((message) => {
console.log("Deleted " + message);
});
}

getById(){
  this.getAccessToken(this.authRequest);
  this.adminService.getId(this.getId,this.token).subscribe((message) => {
    this.getresponse=message
    console.log("get id is success " + message);
  });
}
getByName(){
  this.getAccessToken(this.authRequest);
  this.adminService.getName(this.getName,this.token).subscribe((message) => {
    this.getresponseName=message;
    console.log("get Name is success " + message);
  });
}

update(formData: any) {
  const adminId: number = formData.form.value.AdminId;
  const username: string = formData.form.value.username;
  const password: string = formData.form.value.password;

  const updatedAdmin: Admin = {
    adminId: adminId, // Include the adminId property
    userName: username,
    password: password
  };

  this.adminService.updateAdmin(updatedAdmin, this.token)
    .subscribe(
      (updatedAdmin: Admin) => {
        console.log('Updated Admin is: ', updatedAdmin);
        // Handle any further logic or UI updates after a successful update
      },
      (error: any) => {
        console.error('Error updating Admin: ', error);
        // Handle error scenarios
      }
    );
}



}