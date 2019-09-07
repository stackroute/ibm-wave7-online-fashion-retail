import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DesignerviewordersComponent } from './designervieworders.component';

describe('DesignerviewordersComponent', () => {
  let component: DesignerviewordersComponent;
  let fixture: ComponentFixture<DesignerviewordersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DesignerviewordersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DesignerviewordersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
