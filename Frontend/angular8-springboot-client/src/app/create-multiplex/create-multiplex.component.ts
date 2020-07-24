import { Component, OnInit } from '@angular/core';
import { MultiplexService } from '../service/multiplex.service';
import { Router } from '@angular/router';
import { Multiplex } from '../model/multiplex';
import { Screens } from '../model/screens';
import { Observable, from } from 'rxjs';
import { ScreensService } from '../service/screens.service';

@Component({
  selector: 'app-create-multiplex',
  templateUrl: './create-multiplex.component.html',
  styleUrls: ['./create-multiplex.component.css']
})
export class CreateMultiplexComponent implements OnInit {

   mplex: Multiplex = new Multiplex();

  //screensList:  Observable<Screen[]>;

   submitted= false;
   alert: boolean=false;

  constructor(private multiplexService: MultiplexService, private router: Router
            , private screensService: ScreensService
    ) { }

  ngOnInit() {
   // this.getScreensList();
    
  }

  // getScreensList(){
  //   this.screensList = this.screensService.getScreensList();
  //   //  .subscribe(data => console.log(data), error => console.log(error)
  //   //  );
  //  // console.log(this.screensList);
  // }

  newMultiplex(): void{
    this.submitted= false;
    this.alert =false;
    this.mplex = new  Multiplex();
  }

  save(){
    this.multiplexService.createMultiplex(this.mplex)
    .subscribe(data => console.log(data), error => console.log(error));
    this.mplex = new Multiplex();
    this.gotoList();
  }

  onSubmit() {
    this.alert =true;
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/multiplex']);
  }

  closeAlert(){
    this.alert =false;
  }

}
