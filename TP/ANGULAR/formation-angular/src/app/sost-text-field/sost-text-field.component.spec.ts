import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SostTextFieldComponent } from './sost-text-field.component';

describe('SostTextFieldComponent', () => {
  let component: SostTextFieldComponent;
  let fixture: ComponentFixture<SostTextFieldComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SostTextFieldComponent]
    });
    fixture = TestBed.createComponent(SostTextFieldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
