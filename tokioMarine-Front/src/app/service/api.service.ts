import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';



interface UserData {
  balance: number | null;
  cpf: string | null;
  id: number | null;
  name: string | null;
  originAccount: string | null;
  password: string | null;
}

@Injectable({
  providedIn: 'root'
})

export class ApiService {

  private baseUrl = '/api'; 
  
  constructor(private http: HttpClient) { }

  saveTransfer(data: any): Observable<any> {
    const barToken = localStorage.getItem('token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${barToken}` 
    });
    return this.http.post(`${this.baseUrl}/transferencia`, data, { headers })
    .pipe(
      catchError((error) => {
        if (error.status === 403) {
          const errorMessage = error?.error?.error || 'Erro de autenticação';
          return throwError(() => new Error(errorMessage));
        }
        return throwError(() => error);
      })
    ); 
  }

  listTransfers(): Observable<any> {
    const accountNumber = localStorage.getItem('originAccount')
    const barToken = localStorage.getItem('token');
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${barToken}`
    });
  
    return this.http.get(`${this.baseUrl}/transferencia/listar/${accountNumber}`, { headers })
      .pipe(
        catchError((error) => {
          if (error.status === 403) {
            const errorMessage = 'Erro de autenticação';
            return throwError(() => new Error(errorMessage));
          }
          return throwError(() => error);
        })
      );
  }

  register(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/authentication/register`, data);
  }

  login(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/authentication/login`, data);
  }

  localStorageset(data: UserData): void {
    localStorage.setItem('token', data.password || '');
    localStorage.setItem('name', data.name || '');
    localStorage.setItem('cpf', data.cpf || '');
    localStorage.setItem('balance', data.balance?.toString() || '');
    localStorage.setItem('originAccount', data.originAccount || '');
    console.log(localStorage);
  }
  clearLocalStorage(): void {
    localStorage.setItem('token', '');
    localStorage.setItem('name', '');
    localStorage.setItem('cpf', '');
    localStorage.setItem('balance', '0');
    localStorage.setItem('originAccount', '');
    console.log('LocalStorage limpo:', localStorage);
  }

}
