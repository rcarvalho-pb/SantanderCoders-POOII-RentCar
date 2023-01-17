package controller;

import model.Aluguel;
import persistence.AgenciaEmMemoriaRepository;
import persistence.AluguelEmMemoriaRepository;
import persistence.RepositorioGenericoAbstract;
import util.Constantes;
import util.Data;
import view.AluguelView;

public class AluguelController implements IAluguelController{
  private AluguelView ALUGUEL_VIEW = null;
  private AluguelEmMemoriaRepository ALUGUEL_REPOSITORY = null;
  private RepositorioGenericoAbstract AGENCIA_REPOSITORY = null;

  public AluguelController() {
      ALUGUEL_VIEW = new AluguelView();
      ALUGUEL_REPOSITORY  = Constantes.ALUGUEL_REPOSITORY;
      AGENCIA_REPOSITORY = new AgenciaEmMemoriaRepository();
  }


  public static AluguelController getInstancia(){
      return new AluguelController();
  }
  @Override
  public void alugar() {
          String agencia = ALUGUEL_VIEW.obterAgencia();
          String veiculo = ALUGUEL_VIEW.obterVeiculo();
          String dataRetirada = ALUGUEL_VIEW.obterDataCompleta();
          String dataDevolucao = ALUGUEL_VIEW.obterDataCompleta();
          Aluguel aluguel = new Aluguel(Data.stringParaLocalDateTime(dataRetirada), 
          Data.stringParaLocalDateTime(dataDevolucao),
          ));
          if(ALUGUEL_REPOSITORY.salvar(aluguel)){
              System.out.println("\nAluguel realizado com sucesso\n");
              return;
          }
          System.out.println("\nAluguel duplicado. Não foi cadastrado\n");
  }

  public void devolver(){

  }
}
