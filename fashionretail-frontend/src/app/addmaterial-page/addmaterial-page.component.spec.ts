import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddmaterialPageComponent } from './addmaterial-page.component';

describe('AddmaterialPageComponent', () => {
  let component: AddmaterialPageComponent;
  let fixture: ComponentFixture<AddmaterialPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddmaterialPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddmaterialPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
