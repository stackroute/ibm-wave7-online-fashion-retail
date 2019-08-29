import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DesignereditdialogueComponent } from './designereditdialogue.component';

describe('DesignereditdialogueComponent', () => {
  let component: DesignereditdialogueComponent;
  let fixture: ComponentFixture<DesignereditdialogueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DesignereditdialogueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DesignereditdialogueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
