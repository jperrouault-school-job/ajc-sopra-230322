import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SostBoldComponent } from './sost-bold.component';

describe('SostBoldComponent', () => {
  let component: SostBoldComponent;
  let fixture: ComponentFixture<SostBoldComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SostBoldComponent]
    });
    fixture = TestBed.createComponent(SostBoldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
