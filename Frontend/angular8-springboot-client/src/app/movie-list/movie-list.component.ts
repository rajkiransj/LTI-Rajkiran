import { Component, OnInit } from '@angular/core';
import { Observable, from } from 'rxjs';
import { Movie } from '../model/movie';
import { MovieService } from '../service/movie.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  movies: Observable<Movie[]>;

  deletemsg: Observable<string>;

  constructor(private movieservice: MovieService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.movies = this.movieservice.getMoviesList();
  }

  deleteMovie(id: string) {
  this.movieservice.deleteMovie(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
          //this.deletemsg=data;
        },
        error => console.log(error));

  }

  updateMoive(id: string){
    this.router.navigate(['updatemovie', id]);
  }

}
