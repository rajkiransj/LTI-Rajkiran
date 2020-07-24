

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import { CreateMovieComponent } from './create-movie/create-movie.component';
import { MovieListComponent } from './movie-list/movie-list.component';
import { UpdateMovieComponent } from './update-movie/update-movie.component';
import { CreateMultiplexComponent } from './create-multiplex/create-multiplex.component';
import { MultiplexListComponent } from './multiplex-list/multiplex-list.component';
import { UpdateMultiplexComponent } from './update-multiplex/update-multiplex.component';

const routes: Routes = [
  { path: '', redirectTo: 'movies', pathMatch: 'full' },
  { path: 'movies', component: CreateMovieComponent },
  { path: 'moviesList', component: MovieListComponent},
  { path: 'updatemovie/:id', component: UpdateMovieComponent },
  { path: 'multiplex', component:CreateMultiplexComponent},
  { path: 'multiplex-list', component: MultiplexListComponent},
  { path: 'updatemultiplex/:id', component: UpdateMultiplexComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
