import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from '../model/Cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  constructor(private http:HttpClient) { }
  baseURL:string = 'http://localhost:8181/api/v1/';


  getAll(token:any){
    console.log('In Cart Service: GET ALL');
    console.log(token);
      const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
  
      return this.http.get(this.baseURL+"cart/getAllCart",{headers,responseType:'text' as 'json'});
  
    }

    add(id:number, token: string): Observable<Cart> {
      const headers = new HttpHeaders().set('Authorization',`Bearer ${token}`);
      return this.http.post<Cart>(`${this.baseURL}cart/addCart`,id,  { headers });
    }
  
    
  
  
    delete(Id: number, token: any): Observable<string> {
      const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
      return this.http.delete<string>(`${this.baseURL}cart/cart`, { headers });
    }
  
    
    updateMenu(updatedcart: Cart, token: string): Observable<Cart> {
      const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
      return this.http.put<Cart>(`${this.baseURL}cart/updateCart`,updatedcart, { headers });
    }
    getById(Id: number, token: any){
      const headers = new HttpHeaders().set('Authorization',` Bearer ${token}`);
      return this.http.get(`${this.baseURL}cart/getById/${Id}`,{headers});
    }

    getByName(Id: number, token: any){
      const headers = new HttpHeaders().set('Authorization',` Bearer ${token}`);
      return this.http.get(`${this.baseURL}cart/getByCustomerId/${Id}`,{headers});
    }

  
}
