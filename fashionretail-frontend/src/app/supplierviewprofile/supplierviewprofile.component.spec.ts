import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupplierviewprofileComponent } from './supplierviewprofile.component';

describe('SupplierviewprofileComponent', () => {
  let component: SupplierviewprofileComponent;
  let fixture: ComponentFixture<SupplierviewprofileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupplierviewprofileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupplierviewprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
