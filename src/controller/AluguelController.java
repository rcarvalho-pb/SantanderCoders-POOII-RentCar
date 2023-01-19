package controller;


import model.Agencia;
import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import persistence.RepositorioGenericoAbstract;
import persistence.RepositoryFactory;
import util.ConsoleUIHelper;
import view.AluguelView;

public class AluguelController {

  private final AluguelView ALUGUEL_VIEW;
  private final RepositorioGenericoAbstract<Aluguel> ALUGUEL_REPOSITORY;

  public AluguelController(){
    ALUGUEL_VIEW = AluguelView.getInstance();
    ALUGUEL_REPOSITORY = RepositoryFactory.ALUGUEL_REPOSITORY;
  }

  public static AluguelController getInstancia(){
      return new AluguelController();
  }

  public void alugar() {
    Cliente cliente = ClienteController.getInstancia().escolherCliente();  
    Veiculo veiculo = VeiculoController.getInstancia().escolherVeiculoParaAlugar();
    Agencia agencia = AgenciaController.getInstancia().escolherAgenciaParaAlugar();

    String dataRetirada = ConsoleUIHelper.askSimpleInput("Informe a data de retirada: (dd/mm/aaaa hh:mm)");

    String dataDevolucao = ConsoleUIHelper.askSimpleInput("Informe a data de devolução: (dd/mm/aaaa hh:mm)");

    Aluguel aluguel = new Aluguel(dataRetirada, dataDevolucao, veiculo, agencia, cliente);
    if(ALUGUEL_REPOSITORY.salvar(aluguel)){
              ALUGUEL_VIEW.comprovanteAluguel(aluguel);
              return;
          }
          System.out.println("\nProtocolo de aluguel em duplicidade. Operação não realizada.\n");

  }



}
