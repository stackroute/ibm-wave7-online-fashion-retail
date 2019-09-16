import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManufacturerViewOrderComponent } from './manufacturer-view-order.component';

describe('ManufacturerViewOrderComponent', () => {
  let component: ManufacturerViewOrderComponent;
  let fixture: ComponentFixture<ManufacturerViewOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManufacturerViewOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManufacturerViewOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
