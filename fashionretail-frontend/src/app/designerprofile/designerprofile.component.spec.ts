import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DesignerprofileComponent } from './designerprofile.component';

describe('DesignerprofileComponent', () => {
  let component: DesignerprofileComponent;
  let fixture: ComponentFixture<DesignerprofileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DesignerprofileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DesignerprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
