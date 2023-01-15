package controller;

import java.time.LocalDateTime;

import model.Agencia;
import model.Aluguel;
import persistence.AluguelEmMemoriaRepository;
import util.Constantes;
import util.DataFormatada;
import view.AluguelView;

public class AluguelController implements IAluguelController{
    private AluguelView ALUGUEL_VIEW = null;
    private AluguelEmMemoriaRepository ALUGUEL_REPOSITORY = null;
    public AluguelController() {
        ALUGUEL_VIEW = new AluguelView();
        ALUGUEL_REPOSITORY  = Constantes.ALUGUEL_REPOSITORY;
    }


    public static AluguelController getInstancia(){
        return new AluguelController();
    }
    @Override
    public void alugar() {
            AgenciaController.getInstancia().buscarAgencia();
            String agencia = ALUGUEL_VIEW.obterAgencia();
            String veiculo = ALUGUEL_VIEW.obterVeiculo();
            String data = ALUGUEL_VIEW.obterDataRetiradaCompleta();
            LocalDateTime dataInicioAluguel = DataFormatada.data(data);
            data = ALUGUEL_VIEW.obterDataDevolucaoCompleta();
            LocalDateTime dataFinalAluguel = DataFormatada.data(data);
            Aluguel aluguel = new Aluguel(dataInicioAluguel, dataFinalAluguel, agencia, veiculo);
            if(ALUGUEL_REPOSITORY.salvar(aluguel)){
                System.out.println("\nAluguel realizado com sucesso\n");
                return;
            }
            System.out.println("\nAluguel duplicado. Não foi cadastrado\n");
    }
}
