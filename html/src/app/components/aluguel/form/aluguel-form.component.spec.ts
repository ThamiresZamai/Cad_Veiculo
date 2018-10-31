import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AluguelFormComponent } from './aluguel-form.component';

describe('AluguelFormComponent', () => {
  let component: AluguelFormComponent;
  let fixture: ComponentFixture<AluguelFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AluguelFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AluguelFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
