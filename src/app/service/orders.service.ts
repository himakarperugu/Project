import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Orders } from '../model/Orders';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(private http:HttpClient) { }
  baseURL:string = 'http://localhost:8181/api/v1/';
  getAll(token:any){
   
      const headers = new HttpHeaders().set('Authorization',` Bearer ${token}`);
  
      return this.http.get(this.baseURL+"order/getAllOrder",{headers,responseType:'text' as 'json'});
  
  }

  add(add: Orders, token: string): Observable<Orders> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.post<Orders>(`${this.baseURL}order/addOrder`, add, { headers });
  }


  // delete(Id: number, token: any): Observable<string> {
  //   const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
  //   return this.http.delete<string>(this.baseURL+`order/deleteById/${Id}`,{headers});
  // }

  
  update(update: Orders, token: string): Observable<Orders> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.put<Orders>(`${this.baseURL}order/updateOrder`,update, { headers });
  }

}
