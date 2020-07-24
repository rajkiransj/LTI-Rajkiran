import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MultiplexListComponent } from './multiplex-list.component';

describe('MultiplexListComponent', () => {
  let component: MultiplexListComponent;
  let fixture: ComponentFixture<MultiplexListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MultiplexListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MultiplexListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
