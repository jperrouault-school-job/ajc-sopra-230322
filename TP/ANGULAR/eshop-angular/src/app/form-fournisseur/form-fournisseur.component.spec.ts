import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormFournisseurComponent } from './form-fournisseur.component';

describe('FormFournisseurComponent', () => {
  let component: FormFournisseurComponent;
  let fixture: ComponentFixture<FormFournisseurComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormFournisseurComponent]
    });
    fixture = TestBed.createComponent(FormFournisseurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
