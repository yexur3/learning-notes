import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KnihaForm } from './kniha-form';

describe('KnihaForm', () => {
  let component: KnihaForm;
  let fixture: ComponentFixture<KnihaForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [KnihaForm],
    }).compileComponents();

    fixture = TestBed.createComponent(KnihaForm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
