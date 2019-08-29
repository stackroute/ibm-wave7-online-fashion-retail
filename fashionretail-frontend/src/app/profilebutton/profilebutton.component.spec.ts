import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilebuttonComponent } from './profilebutton.component';

describe('ProfilebuttonComponent', () => {
  let component: ProfilebuttonComponent;
  let fixture: ComponentFixture<ProfilebuttonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfilebuttonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilebuttonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
