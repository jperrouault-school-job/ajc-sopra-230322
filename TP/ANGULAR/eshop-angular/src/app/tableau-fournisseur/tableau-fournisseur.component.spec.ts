import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableauFournisseurComponent } from './tableau-fournisseur.component';

describe('TableauFournisseurComponent', () => {
  let component: TableauFournisseurComponent;
  let fixture: ComponentFixture<TableauFournisseurComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TableauFournisseurComponent]
    });
    fixture = TestBed.createComponent(TableauFournisseurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
