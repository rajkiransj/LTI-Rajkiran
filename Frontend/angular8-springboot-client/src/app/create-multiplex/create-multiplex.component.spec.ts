import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateMultiplexComponent } from './create-multiplex.component';

describe('CreateMultiplexComponent', () => {
  let component: CreateMultiplexComponent;
  let fixture: ComponentFixture<CreateMultiplexComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateMultiplexComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateMultiplexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
