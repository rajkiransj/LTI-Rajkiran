import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule  } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component'
import { HttpClientModule } from '@angular/common/http';

import { CreateMovieComponent } from './create-movie/create-movie.component';
import { MovieListComponent } from './movie-list/movie-list.component';
import { UpdateMovieComponent } from './update-movie/update-movie.component';
import { CreateMultiplexComponent } from './create-multiplex/create-multiplex.component';
import { MultiplexListComponent } from './multiplex-list/multiplex-list.component';
import { UpdateMultiplexComponent } from './update-multiplex/update-multiplex.component';
@NgModule({
  declarations: [
    AppComponent,

    CreateMovieComponent,
    MovieListComponent,
    UpdateMovieComponent,
    CreateMultiplexComponent,
    MultiplexListComponent,
    UpdateMultiplexComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
