import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsumerShippingComponent } from './consumer-shipping.component';

describe('ConsumerShippingComponent', () => {
  let component: ConsumerShippingComponent;
  let fixture: ComponentFixture<ConsumerShippingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsumerShippingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsumerShippingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
