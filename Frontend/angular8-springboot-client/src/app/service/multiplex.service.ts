import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })

export class MultiplexService{

    //private baseUrl = 'http://localhost:8082/api/multiplex'; 
    private baseUrl = 'http://localhost:8765/multiplex-management-ms/api/multiplex';

    constructor(private http: HttpClient) { }

    createMultiplex(multiplex: Object): Observable<Object> {
        return this.http.post(this.baseUrl, multiplex);
      }

      getMultiplexList(): Observable<any>{
        return this.http.get(this.baseUrl);
      }

      deleteMultiplex(id: string): Observable<any> {
        console.log('delete id '+ id);
        return this.http.delete(this.baseUrl+'/'+id, { responseType: 'text' });
      }
    
      getMultiplex(id: string): Observable<any> {
        return this.http.get(this.baseUrl+'/'+id);
      }
    
      updateMultiplex(id: string, value: any): Observable<Object> {
        console.log('id :'+id + ' and value :' + value );
        return this.http.put(this.baseUrl+'/'+id, value);
      }
}