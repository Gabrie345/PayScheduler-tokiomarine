import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private baseUrl = '/api'; 
  
  constructor(private http: HttpClient) { }

  saveTransfer(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/transferencia`, data); 
  }
  listTransfers(account: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/transferencia/listar/${account}`);
  }
}
