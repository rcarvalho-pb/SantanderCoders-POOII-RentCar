package controller;

import model.Agencia;
import persistence.AgenciaEmMemoriaRepository;
import util.Constantes;
import view.AgenciaView;

import java.util.List;

public class AgenciaController implements IAgenciaController{

    private final AgenciaView AGENCIA_VIEW;
    private final AgenciaEmMemoriaRepository AGENCIA_REPOSITORY;

    private AgenciaController() {
        this.AGENCIA_VIEW = new AgenciaView();
        this.AGENCIA_REPOSITORY = Constantes.AGENCIA_REPOSITORY;
    }

    public static AgenciaController getInstancia(){
        return new AgenciaController();
    }

    @Override
    public void cadastrarAgencia() {
        String nome = AGENCIA_VIEW.obterNome();
        String logradouro = AGENCIA_VIEW.obterLogradouro();
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
            String nome = AGENCIA_VIEW.obterNome();
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

        String agenciaBuscada = AGENCIA_VIEW.obterDadosPesquisa();
        List<Agencia> agenciasRetornadas = AGENCIA_REPOSITORY.buscarPorNomeOuLogradouro(agenciaBuscada);
        AGENCIA_VIEW.imprimirLista(agenciasRetornadas);
    }
}
