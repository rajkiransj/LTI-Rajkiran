import { Component, OnInit } from '@angular/core';
import { ResponseMessage } from '../model/response-message';
import { Multiplex } from '../model/multiplex';
import { ActivatedRoute, Router } from '@angular/router';
import { MultiplexService } from '../service/multiplex.service';

@Component({
  selector: 'app-update-multiplex',
  templateUrl: './update-multiplex.component.html',
  styleUrls: ['./update-multiplex.component.css']
})
export class UpdateMultiplexComponent implements OnInit {

  id: string;
  responseMessage: ResponseMessage;
  mplex: Multiplex;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private multiplexService: MultiplexService
    ) { }

  ngOnInit() {

    this.mplex = new Multiplex();
    this.responseMessage = new ResponseMessage();
    
    this.id = this.route.snapshot.params['id'];
  
    this.multiplexService.getMultiplex(this.id)
    .subscribe(data => {
      console.log(data)
      this.mplex= data;
    }, error => console.log(error));
  }

  updateMultiplex() {
    this.multiplexService.updateMultiplex(this.id, this.mplex)
      .subscribe(data =>{ 
        console.log('-------------------------------------------------')
       // console.log(data)
      //  this.responseMessage = data;
      }, error => console.log(error));
    this.mplex = new Multiplex();
    this.gotoList();
  }

  onSubmit(){
    this.updateMultiplex();
  }

  gotoList() {
    this.router.navigate(['/multiplex-list']);
  }

}
