import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManufactureCardComponent } from './manufacturecard.component';

describe('CardComponent', () => {
  let component: ManufactureCardComponent;
  let fixture: ComponentFixture<ManufactureCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManufactureCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManufactureCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
