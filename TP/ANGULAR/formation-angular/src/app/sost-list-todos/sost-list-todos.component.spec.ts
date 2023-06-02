import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SostListTodosComponent } from './sost-list-todos.component';

describe('SostListTodosComponent', () => {
  let component: SostListTodosComponent;
  let fixture: ComponentFixture<SostListTodosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SostListTodosComponent]
    });
    fixture = TestBed.createComponent(SostListTodosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
