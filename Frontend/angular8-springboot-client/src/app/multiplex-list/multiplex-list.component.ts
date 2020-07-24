import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Multiplex } from '../model/multiplex';
import { MultiplexService } from '../service/multiplex.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-multiplex-list',
  templateUrl: './multiplex-list.component.html',
  styleUrls: ['./multiplex-list.component.css']
})
export class MultiplexListComponent implements OnInit {

  multiplexlist: Observable<Multiplex[]>;

  constructor(private multiplexService: MultiplexService,
              private router: Router
    ) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.multiplexlist = this.multiplexService.getMultiplexList();
  }

  deleteMultiplex(id: string) {
    this.multiplexService.deleteMultiplex(id)
        .subscribe(
          data => {
            console.log(data);
            this.reloadData();
            //this.deletemsg=data;
          },
          error => console.log(error));
  
    }
  
    updateMultiplex(id: string){
      this.router.navigate(['updatemultiplex', id]);
    }

}
