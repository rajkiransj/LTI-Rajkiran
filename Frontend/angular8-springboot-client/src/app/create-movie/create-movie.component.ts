import { Component, OnInit } from '@angular/core';
import { Movie } from '../model/movie';
import { MovieService } from '../service/movie.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-movie',
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.css']
})
export class CreateMovieComponent implements OnInit {

  movie: Movie = new Movie();
  submitted= false;

  alert: boolean=false;

  constructor(private movieservice: MovieService,
      private router: Router){}

  ngOnInit() {
  }

  newMovie(): void{
    this.submitted= false;
    this.alert =false;
    this.movie = new  Movie();
  }

  save(){
    this.movieservice.createMovie(this.movie)
    .subscribe(data => console.log(data), error => console.log(error));
    this.movie = new Movie();
    this.gotoList();
  }

  onSubmit() {
    this.alert =true;
    this.submitted = true;
    this.save();    
  }
  gotoList() {
    this.router.navigate(['/movies']);
  }

  closeAlert(){
    this.alert =false;
  }
}
