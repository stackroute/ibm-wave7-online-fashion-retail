import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplaymaterialsComponent } from './displaymaterials.component';

describe('DisplaymaterialsComponent', () => {
  let component: DisplaymaterialsComponent;
  let fixture: ComponentFixture<DisplaymaterialsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplaymaterialsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplaymaterialsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
