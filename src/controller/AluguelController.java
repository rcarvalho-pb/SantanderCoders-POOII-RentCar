package controller;


import model.Agencia;
import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import persistence.RepositorioGenericoAbstract;
import persistence.RepositoryFactory;
import persistence.VeiculosEmMemoriaRepository;
import util.ConsoleUIHelper;
import util.DataFormatada;
import view.AgenciaView;
import view.VeiculoView;
import view.ViewGenerico;

public class AluguelController implements IAluguelController{

  private final ViewGenerico ALUGUEL_VIEW;
  private final RepositorioGenericoAbstract<Aluguel> ALUGUEL_REPOSITORY;

  public AluguelController(){
    ALUGUEL_VIEW = AgenciaView.getInstance();
    ALUGUEL_REPOSITORY = RepositoryFactory.ALUGUEL_REPOSITORY;
  }

  public static AluguelController getInstancia(){
      return new AluguelController();
  }


@Override
public void alugar() {
  Cliente cliente = ClienteController.getInstancia().escolherCliente();  
  Veiculo veiculo = VeiculoController.getInstancia().escolherVeiculoParaAlugar();
  Agencia agencia = AgenciaController.getInstancia().escolherAgenciaParaAlugar();

  String dataRetirada = ConsoleUIHelper.askSimpleInput("Informe a data de retirada: (dd/mm/aaaa hh:mm)");

  String dataDevolucao = ConsoleUIHelper.askSimpleInput("Informe a data de devolução: (dd/mm/aaaa hh:mm)");

  Aluguel aluguel = new Aluguel(dataRetirada, dataDevolucao, veiculo, agencia, cliente);
  if(ALUGUEL_REPOSITORY.salvar(aluguel)){
            System.out.printf("\nAluguel Efetuado com sucesso. Protocolo: %s\n\n", aluguel.getId());
            veiculo.alugar();
            return;
        }
        System.out.println("\nProtocolo de aluguel em duplicidade. Operação não realizada.\n");

}


@Override
public void devolver() {
    // TODO Auto-generated method stub
    
}
}
