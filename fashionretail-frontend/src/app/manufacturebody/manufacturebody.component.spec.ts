import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManufactureBodyComponent } from './manufacturebody.component';

describe('BodyComponent', () => {
  let component: ManufactureBodyComponent;
  let fixture: ComponentFixture<ManufactureBodyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManufactureBodyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManufactureBodyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
