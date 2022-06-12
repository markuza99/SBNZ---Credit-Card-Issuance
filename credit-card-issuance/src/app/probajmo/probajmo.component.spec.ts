import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProbajmoComponent } from './probajmo.component';

describe('ProbajmoComponent', () => {
  let component: ProbajmoComponent;
  let fixture: ComponentFixture<ProbajmoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProbajmoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProbajmoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
