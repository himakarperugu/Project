import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Product } from '../model/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }
  baseURL:string = 'http://localhost:8181/api/v1/';
  getAll(token:any){
console.log('In Product Service: GET ALL');
console.log(token);
const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
return this.http.get(this.baseURL + "product/getAllProduct", { headers, responseType: 'text' as 'json' });
}

add(add: Product, token: string): Observable<Product> {
  const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
  return this.http.post<Product>(`${this.baseURL}product/addProduct`, add, { headers });
}

update(update: Product, token: string): Observable<Product> {
  const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
  return this.http.put<Product>(`${this.baseURL}product/updateProduct/${update.productId}`,update, { headers });
}
// delete(Id: number, token: any): Observable<string> {
//   const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
//   return this.http.delete<string>(`${this.baseURL}product/deleteById/${Id}`, { headers });
// }
// delete(Id: number, token: any): Observable<Product> {
//   const headers = new HttpHeaders().set('Authorization',`Bearer ${token}`);
//   return this.http.delete<Product>(`${this.baseURL}product/deleteById/${Id}`, { headers });
// }


getName(Name: String, token: any): Observable<Product> {
  const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
  return this.http.get<Product>(`${this.baseURL}product/getByProductName/${Name}`, { headers });
}
getCategory(Category: String, token: any): Observable<Product> {
  const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
  return this.http.get<Product>(`${this.baseURL}product/getByCategory/${Category}`, { headers });
}


}
