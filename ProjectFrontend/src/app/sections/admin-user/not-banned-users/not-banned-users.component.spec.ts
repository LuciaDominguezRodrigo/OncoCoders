import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotBannedUsersComponent } from './not-banned-users.component';

describe('NotBannedUsersComponent', () => {
  let component: NotBannedUsersComponent;
  let fixture: ComponentFixture<NotBannedUsersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NotBannedUsersComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NotBannedUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
