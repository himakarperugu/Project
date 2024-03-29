import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { customer } from '../model/Customer';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
Token:any
customerId:any;
mainId:any
  constructor(private http:HttpClient) { }

  baseURL:string = 'http://localhost:8181/api/v1/';

  getGeneratedToken(requestBody: any){
    
       this.Token=  this.http.post(this.baseURL+"login/customerlogin",requestBody,{responseType: 'text' as 'json'});
    return this.Token
    }

    authorizationTest(token:any){

          let tokenString = "Bearer "+token;

         const headers =  new HttpHeaders().set("Authorization",tokenString);
      console.log(this.customerId+"service");


      
        return this.http.get(this.baseURL+"customer/getAllCustomer",{headers,responseType:'text' as 'json'});

    }
    insert(body:customer):Observable<customer>{

      console.log(body);

        return this.http.post<customer>(this.baseURL+"customer/addCustomer",body);

    }
    delete(customerId: number, token: any): Observable<string> {
      console.log("delete called");
      const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
      console.log('Token:', token); // Log the token for debugging purposes
      // Adjust the return type and the HTTP call
      return this.http.delete<string>(`${this.baseURL}customer/deleteById/${customerId}`, { headers });
    }
    
    updateCustomer(updatedCustomer: customer, token: string): Observable<customer> {
      const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
      return this.http.put<customer>(`${this.baseURL}customer/updateCustomer/${updatedCustomer.customerId}`, updatedCustomer, { headers });
    }


    getcustomer(name:String,token: string){
      const headers = new HttpHeaders().set('Authorization',` Bearer ${token}`);
      console.log('In customer name service')
      

      return this.http.get(`${this.baseURL}customer/getByCustomerName/${name}`,{headers,responseType:'text' as 'json'});


    }
  
  }
    