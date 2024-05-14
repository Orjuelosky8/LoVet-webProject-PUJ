import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentUserSubject: BehaviorSubject<any>;
  public currentUser: Observable<any>;

  constructor(private http: HttpClient, private router: Router) {
    const storedUser = localStorage.getItem('currentUser');
    this.currentUserSubject = new BehaviorSubject<any>(storedUser ? JSON.parse(storedUser) : null);
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): any {
    return this.currentUserSubject.value;
  }

  // login(username: string, password: string): Observable<any {
  //   // return this.http.post<any>(`http://localhost:8090/login/authenticate`, { username, password })
  //   //   .pipe(map(user => {
  //   //     alert('Login exitoso1');
  //   //     // store user details and jwt token in local storage to keep user logged in between page refreshes
  //   //     localStorage.setItem('currentUser', JSON.stringify(user));
  //   //     alert('Login exitoso2');
  //   //     this.currentUserSubject.next(user);
  //   //     alert('Login exitoso3');
  //   //     return user;
  //   //   }));

  //   this.http.post<any>(`http://localhost:8090/login/authenticate`, { username, password })
  //   .subscribe(response => {
  //     console.log('Respuesta del servidor:', response);
  //   });

  //   // return this.http.post<any>(`http://localhost:8090/login/authenticate`, { username, password })
  //   //   .pipe(map(response => {
  //   //     // Verificar la respuesta del servidor
  //   //     alert('Login exitoso1');
  //   //     if (response && response.username) {
  //   //       alert('Login exitoso2');
  //   //       // Almacenar detalles del usuario en el almacenamiento local
  //   //       localStorage.setItem('currentUser', JSON.stringify(response));
  //   //       // Redirigir a otra ventana
  //   //       alert('Login exitoso3');
  //   //       this.router.navigate(['/clientes']);
  //   //     }
  //   //     return response;
  //   //   }));
  // }

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>(`http://localhost:8090/login/authenticate`, { username, password })
      .pipe(
        map(user => {
          localStorage.setItem('currentUser', JSON.stringify(user));
          this.currentUserSubject.next(user);
          return user;
        }),
        catchError(error => {
          // alert('Error durante el login' + error.message);
          throw error;
        })
      );
  }

  logout() {
    // remove user from local storage and set current user to null
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }
}
