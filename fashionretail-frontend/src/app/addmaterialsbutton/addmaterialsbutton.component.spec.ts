import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddmaterialsbuttonComponent } from './addmaterialsbutton.component';

describe('AddmaterialsbuttonComponent', () => {
  let component: AddmaterialsbuttonComponent;
  let fixture: ComponentFixture<AddmaterialsbuttonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddmaterialsbuttonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddmaterialsbuttonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
