import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  //private baseUrl = 'http://localhost:8090/api/movies';
  private baseUrl = 'http://localhost:8765/movie-management-ms/api/movies';

  constructor(private http: HttpClient) { }


  createMovie(movies: Object): Observable<Object> {
    return this.http.post(this.baseUrl, movies);
  }

  getMoviesList(): Observable<any> {
    return this.http.get(this.baseUrl);
    
  }

  deleteMovie(id: string): Observable<any> {
    //console.log(this.baseUrl+'/'+id);
    return this.http.delete(this.baseUrl+'/'+id, { responseType: 'text' });
  }

  getMovie(id: string): Observable<any> {
    return this.http.get(this.baseUrl+'/'+id);
  }

  updateMovie(id: string, value: any): Observable<Object> {
    return this.http.put(this.baseUrl+'/'+id, value);
  }

  
}