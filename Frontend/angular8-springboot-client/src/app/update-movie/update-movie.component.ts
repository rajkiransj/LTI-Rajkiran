import { Component, OnInit } from '@angular/core';
import { Movie } from '../model/movie';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../service/movie.service';
import { ResponseMessage } from '../model/response-message';

@Component({
  selector: 'app-update-movie',
  templateUrl: './update-movie.component.html',
  styleUrls: ['./update-movie.component.css']
})
export class UpdateMovieComponent implements OnInit {

  id: string;
  responseMessage: ResponseMessage;
  movie: Movie;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private movieservice: MovieService
    ) { }

  ngOnInit() {

    this.movie = new Movie();
    this.responseMessage = new ResponseMessage();
    
    this.id = this.route.snapshot.params['id'];
   // this.moviename = this.route.snapshot.params['name'];
    //console.log('Update the movie '+this.moviename);
    
    this.movieservice.getMovie(this.id)
    .subscribe(data => {
      console.log(data)
      this.movie= data;
    }, error => console.log(error));
  }

  updateMovie() {
    this.movieservice.updateMovie(this.id, this.movie)
      .subscribe(data =>{ 
        console.log('-------------------------------------------------')
       // console.log(data)
      //  this.responseMessage = data;
      }, error => console.log(error));
    this.movie = new Movie();
    this.gotoList();
  }

  onSubmit(){
    this.updateMovie();
  }

  gotoList() {
    this.router.navigate(['/moviesList']);
  }

}
