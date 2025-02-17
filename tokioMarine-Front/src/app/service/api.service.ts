import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private baseUrl = 'http://localhost:8080'; 
  
  constructor(private http: HttpClient) { }

  salvarTransferencia(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/transferencia`, data); 
  }
}
