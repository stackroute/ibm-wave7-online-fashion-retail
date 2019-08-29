import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManufactureviewprofileComponent } from './manufactureviewprofile.component';

describe('ManufactureviewprofileComponent', () => {
  let component: ManufactureviewprofileComponent;
  let fixture: ComponentFixture<ManufactureviewprofileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManufactureviewprofileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManufactureviewprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
