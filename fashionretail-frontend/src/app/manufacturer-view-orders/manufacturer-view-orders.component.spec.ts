import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManufacturerViewOrdersComponent } from './manufacturer-view-orders.component';

describe('ManufacturerViewOrdersComponent', () => {
  let component: ManufacturerViewOrdersComponent;
  let fixture: ComponentFixture<ManufacturerViewOrdersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManufacturerViewOrdersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManufacturerViewOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
