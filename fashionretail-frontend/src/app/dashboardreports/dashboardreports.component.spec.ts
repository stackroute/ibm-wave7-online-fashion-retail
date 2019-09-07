import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardreportsComponent } from './dashboardreports.component';

describe('DashboardreportsComponent', () => {
  let component: DashboardreportsComponent;
  let fixture: ComponentFixture<DashboardreportsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashboardreportsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardreportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
