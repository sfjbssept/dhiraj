import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserRagistrationComponent } from './user-ragistration.component';

describe('UserRagistrationComponent', () => {
  let component: UserRagistrationComponent;
  let fixture: ComponentFixture<UserRagistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserRagistrationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserRagistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
