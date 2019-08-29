import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DesignerHomePageComponent } from './designer-home-page.component';

describe('DesignerHomePageComponent', () => {
  let component: DesignerHomePageComponent;
  let fixture: ComponentFixture<DesignerHomePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DesignerHomePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DesignerHomePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
