import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateMultiplexComponent } from './update-multiplex.component';

describe('UpdateMultiplexComponent', () => {
  let component: UpdateMultiplexComponent;
  let fixture: ComponentFixture<UpdateMultiplexComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateMultiplexComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateMultiplexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
