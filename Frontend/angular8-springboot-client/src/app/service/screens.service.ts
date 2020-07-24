import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
    providedIn: 'root'
  })

  export class ScreensService{

    private baseUrl = 'http://localhost:8082/api/screens';

     constructor(private http: HttpClient){}

     getScreensList(): Observable<any>{
         console.log('hi there');
        return this.http.get(this.baseUrl);
     }

  }