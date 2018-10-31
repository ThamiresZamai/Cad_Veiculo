import { AluguelModule } from './aluguel.module';

describe('AluguelModule', () => {
  let aluguelModule: AluguelModule;

  beforeEach(() => {
    aluguelModule = new AluguelModule();
  });

  it('should create an instance', () => {
    expect(aluguelModule).toBeTruthy();
  });
});
