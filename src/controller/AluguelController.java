package controller;

import model.Aluguel;
import persistence.AluguelEmMemoriaRepository;
import persistence.RepositoryFactory;
import view.AluguelView;

public class AluguelController implements IAluguelController{
    private AluguelView ALUGUEL_VIEW;
    private AluguelEmMemoriaRepository ALUGUEL_REPOSITORY;
    public AluguelController() {
        ALUGUEL_VIEW = AluguelView.getInstance();
        ALUGUEL_REPOSITORY  = RepositoryFactory.ALUGUEL_REPOSITORY;
    }


    public static AluguelController getInstancia(){
        return new AluguelController();
    }
    @Override
    public void alugar() {
            String agencia = ALUGUEL_VIEW.obterAgencia();
            String veiculo = ALUGUEL_VIEW.obterVeiculo();
            String ano = ALUGUEL_VIEW.obterAno();
            String mes = ALUGUEL_VIEW.obterMes();
            String dia = ALUGUEL_VIEW.obterDia();
            String hora = ALUGUEL_VIEW.obterHora();
            String minuto = ALUGUEL_VIEW.obterMinuto();
            Aluguel aluguel = new Aluguel(ano, mes, dia, hora, minuto);
            if(ALUGUEL_REPOSITORY.salvar(aluguel)){
                System.out.println("\nAluguel realizado com sucesso\n");
                return;
            }
            System.out.println("\nAluguel duplicado. Não foi cadastrado\n");
    }
}
