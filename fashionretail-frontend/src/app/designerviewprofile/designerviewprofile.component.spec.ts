import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DesignerviewprofileComponent } from './designerviewprofile.component';

describe('DesignerviewprofileComponent', () => {
  let component: DesignerviewprofileComponent;
  let fixture: ComponentFixture<DesignerviewprofileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DesignerviewprofileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DesignerviewprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
