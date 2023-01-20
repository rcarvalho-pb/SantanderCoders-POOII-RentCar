package controller;


import java.util.List;

import model.Agencia;
import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import persistence.AluguelJsonRepository;
import persistence.RepositoryFactory;
import util.ConsoleUIHelper;
import util.DataFormatada;
import view.AluguelView;

public class AluguelController {

  private final AluguelView ALUGUEL_VIEW;
  private final AluguelJsonRepository ALUGUEL_REPOSITORY;

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
    Agencia agenciaRetirada = AgenciaController.getInstancia().escolherAgencia();
    Agencia agenciaDevolucao = AgenciaController.getInstancia().escolherAgencia();

    String dataRetirada = ConsoleUIHelper.askSimpleInput("Informe a data de retirada: (dd/mm/aaaa hh:mm)");

    String dataDevolucao = ConsoleUIHelper.askSimpleInput("Informe a data de devolução: (dd/mm/aaaa hh:mm)");

    if(!DataFormatada.dataRetiradaValida(dataRetirada)){
      System.out.println("Data inválida. Não alugamos carro no passado.");
      return;
    }

    if(DataFormatada.dataDevolucaoAnteriorRetirada(dataRetirada, dataDevolucao)){
      System.out.println("Data inválida: Devolução anterior a retirada. ");
      return;
    }

    Aluguel aluguel = new Aluguel(dataRetirada, dataDevolucao, veiculo, agenciaRetirada, agenciaDevolucao, cliente);
    if(ALUGUEL_REPOSITORY.salvar(aluguel)){
              ALUGUEL_VIEW.imprimirComprovante(aluguel, "Aluguel");
              return;
          }
          System.out.println("\nProtocolo de aluguel em duplicidade. Operação não realizada.\n");

  }

  public void encerrarAluguel(){
    List<Aluguel> alugueis = ALUGUEL_REPOSITORY.listarTodosOsAlugueisEmAberto();
    ALUGUEL_VIEW.imprimirLista(alugueis);
    if(!Controller.isListaVazia(alugueis)){
        Aluguel aluguel = validarBuscaAluguelPorId();
        aluguel.encerrarAluguel();

        if (ALUGUEL_REPOSITORY.removerAluguel(aluguel)) {
          if(ALUGUEL_REPOSITORY.salvar(aluguel)){
            ALUGUEL_VIEW.imprimirComprovante(aluguel, "devolucao");
            return;
          }

          System.out.println("\nProtocolo de aluguel em duplicidade. Operação não realizada.\n");

          return;
        }

        System.out.println("Aluguel não encontrado. ");       
      
    } 
    
  }

  public void gerarComprovanteAluguel() {
    List<Aluguel> alugueis = ALUGUEL_REPOSITORY.listarTodosOsAlugueisEmAberto();
    ALUGUEL_VIEW.imprimirLista(alugueis);
    if(!Controller.isListaVazia(alugueis)){
        Aluguel aluguel = validarBuscaAluguelPorId();
        ALUGUEL_VIEW.imprimirComprovante(aluguel, "aluguel");
    } 
  }

  public void gerarComprovanteDevolucao(){
    List<Aluguel> alugueis = ALUGUEL_REPOSITORY.listarTodosOsAlugueisEncerrados();
    ALUGUEL_VIEW.imprimirLista(alugueis);
    if(!Controller.isListaVazia(alugueis)){
        Aluguel aluguel = validarBuscaAluguelPorId();
        ALUGUEL_VIEW.imprimirComprovante(aluguel, "devolucao");
    } 
  }

  private Aluguel validarBuscaAluguelPorId(){
    Aluguel aluguel;
    do{
        String id = ALUGUEL_VIEW.obterDadoString("Entre com o Id do aluguel");
        aluguel = ALUGUEL_REPOSITORY.buscarPeloId(id);
    }while (aluguel == null);
    return aluguel;
  }

  

}
