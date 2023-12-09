import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmincustomerdetailsComponent } from './admincustomerdetails.component';

describe('AdmincustomerdetailsComponent', () => {
  let component: AdmincustomerdetailsComponent;
  let fixture: ComponentFixture<AdmincustomerdetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdmincustomerdetailsComponent]
    });
    fixture = TestBed.createComponent(AdmincustomerdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
