import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerViewOrdersComponent } from './customer-view-orders.component';

describe('CustomerViewOrdersComponent', () => {
  let component: CustomerViewOrdersComponent;
  let fixture: ComponentFixture<CustomerViewOrdersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerViewOrdersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerViewOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
