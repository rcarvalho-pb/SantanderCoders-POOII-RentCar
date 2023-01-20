package controller;

import model.Agencia;
import persistence.AgenciaJsonRepository;
import persistence.RepositoryFactory;
import util.ConsoleUIHelper;
import view.AgenciaView;

import java.util.List;

public class AgenciaController {

    private final AgenciaView AGENCIA_VIEW;
    private final AgenciaJsonRepository AGENCIA_REPOSITORY;

    private AgenciaController() {
        this.AGENCIA_VIEW = AgenciaView.getInstance();
        this.AGENCIA_REPOSITORY = RepositoryFactory.AGENCIA_REPOSITORY;
    }

    public static AgenciaController getInstancia(){
        return new AgenciaController();
    }

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

    private Agencia validarBuscaAgenciaPorNome(){
        Agencia agencia;
        do{
            String nome = AGENCIA_VIEW.obterDadoString("Entre com o Nome da Agência");
            agencia = AGENCIA_REPOSITORY.buscarPeloId(nome);
        }while (agencia == null);
        return agencia;
    }
    
    public void removerAgencia() {
        List<Agencia> agencias = AGENCIA_REPOSITORY.getEntidades();
        AGENCIA_VIEW.imprimirLista(agencias);
        if (Controller.isListaNaoVazia(agencias)) {
            Agencia agenciaASerAlterada = validarBuscaAgenciaPorNome();
            System.out.printf("\nAgencia %s removida...\n\n", agenciaASerAlterada.getNome());
            AGENCIA_REPOSITORY.remover(agenciaASerAlterada.getNome());
        }
    }
    
    public void alterarAgencia() {
        List<Agencia> agencias = AGENCIA_REPOSITORY.getEntidades();
        AGENCIA_VIEW.imprimirLista(agencias);
        if(Controller.isListaNaoVazia(agencias)){
            Agencia agenciaASerAlterada = validarBuscaAgenciaPorNome();
            System.out.println("\nDigite os novos dados\n");
            AGENCIA_REPOSITORY.remover(agenciaASerAlterada.getNome());
            cadastrarAgencia();
        }
    }

    
    public void buscarAgencia() {

        String agenciaBuscada = AGENCIA_VIEW.obterDadoString("Entre com o Nome ou logradouro da Agência");
        List<Agencia> agenciasRetornadas = AGENCIA_REPOSITORY.buscarPorNomeOuLogradouro(agenciaBuscada);
        AGENCIA_VIEW.imprimirLista(agenciasRetornadas);
    }

    public Agencia escolherAgencia(){
        
        String agenciaString = ConsoleUIHelper.askSimpleInput("Qual o nome ou logradouro da agencia?");
        List<Agencia> agenciasRetornadas = AGENCIA_REPOSITORY.buscarPorNomeOuLogradouro(agenciaString);
        AGENCIA_VIEW.imprimirLista(agenciasRetornadas);
        return AGENCIA_REPOSITORY.selecionarAgencia();
    }
}
