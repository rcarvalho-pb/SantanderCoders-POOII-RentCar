package controller;

import model.Agencia;
import persistence.AgenciaEmMemoriaRepository;
import persistence.RepositoryFactory;
import view.AgenciaView;

import java.util.List;

public class AgenciaController implements IAgenciaController{

    private final AgenciaView AGENCIA_VIEW;
    private final AgenciaEmMemoriaRepository AGENCIA_REPOSITORY;

    private AgenciaController() {
        this.AGENCIA_VIEW = AgenciaView.getInstance();
        this.AGENCIA_REPOSITORY = RepositoryFactory.AGENCIA_REPOSITORY;
    }

    public static AgenciaController getInstancia(){
        return new AgenciaController();
    }

    @Override
    public void cadastrarAgencia() {
        String nome = AGENCIA_VIEW.obterDadoString("Entre com o Nome da Agência");
        String logradouro = AGENCIA_VIEW.obterDadoString("Entre com o logradouro");
        Agencia agencia = new Agencia(nome, logradouro);
        if(AGENCIA_REPOSITORY.salvar(agencia)){
            System.out.println("\nAgência cadastrada com sucesso\n");
            return;
        }
        System.out.println("\nAgência duplicada. Não foi cadastrado\n");
    }

    private Agencia validarBuscaVeiculoPorPlaca(){
        Agencia agencia;
        do{
            String nome = AGENCIA_VIEW.obterDadoString("Entre com o Nome da Agência");
            agencia = AGENCIA_REPOSITORY.buscarPeloId(nome);
        }while (agencia == null);
        return agencia;
    }

    @Override
    public void alterarAgencia() {
        List<Agencia> agencias = AGENCIA_REPOSITORY.getEntidades();
        AGENCIA_VIEW.imprimirLista(agencias);
        if(!Controller.isListaVazia(agencias)){
            Agencia agenciaASerAlterada = validarBuscaVeiculoPorPlaca();
            System.out.println("\nDigite os novos dados\n");
            AGENCIA_REPOSITORY.remover(agenciaASerAlterada.getNome());
            cadastrarAgencia();
        }
    }

    @Override
    public void buscarAgencia() {

        String agenciaBuscada = AGENCIA_VIEW.obterDadoString("Entre com o Nome ou logradouro da Agência");
        List<Agencia> agenciasRetornadas = AGENCIA_REPOSITORY.buscarPorNomeOuLogradouro(agenciaBuscada);
        AGENCIA_VIEW.imprimirLista(agenciasRetornadas);
    }
}
