package controller;

import model.Agencia;
import model.Cliente;
import model.TipoCliente;
import model.Veiculo;
import persistence.ClienteEmMemoriaRepository;
import util.Constantes;
import view.ClienteView;

import java.util.List;

public class ClienteController implements IClienteController{
    private final ClienteView CLIENTE_VIEW;
    private final ClienteEmMemoriaRepository CLIENTE_REPOSITORY;

    public ClienteController() {
        CLIENTE_VIEW = new ClienteView();
        CLIENTE_REPOSITORY = Constantes.CLIENTE_REPOSITORY;
    }

    public static ClienteController getInstancia() {
        return new ClienteController();
    }

    @Override
    public void cadastrarCliente() {
        String nome = CLIENTE_VIEW.obterNome();
        String documento = CLIENTE_VIEW.obterDocumento();
        TipoCliente tipoCliente = CLIENTE_VIEW.obterTipoCliente();
        Cliente cliente = new Cliente(tipoCliente,nome, documento);
        if(CLIENTE_REPOSITORY.salvar(cliente)){
            System.out.println("\nCliente cadastrado com sucesso\n");
            return;
        }
        System.out.println("\nCliente duplicado. Não foi cadastrado\n");
    }
    private Cliente validarBuscaClientePorDocumento(){
        Cliente cliente;
        do{
            String documento = CLIENTE_VIEW.obterDocumento();
            cliente = CLIENTE_REPOSITORY.buscarPeloId(documento);
        }while (cliente == null);
        return cliente;
    }
    @Override
    public void alterarCliente() {
        List<Cliente> clientes = CLIENTE_REPOSITORY.getEntidades();
        CLIENTE_VIEW.imprimirLista(clientes);
        if(!Controller.isListaVazia(clientes)){
            Cliente clienteASerAlterado = validarBuscaClientePorDocumento();
            System.out.println("\nDigite os novos dados\n");
            CLIENTE_REPOSITORY.remover(clienteASerAlterado.getDocumento());
            cadastrarCliente();
        }
    }

    @Override
    public void buscarCliente() {
            String clienteBuscado = CLIENTE_VIEW.obterDadosPesquisa();
            List<Cliente> clientesRetornados = CLIENTE_REPOSITORY.buscarPorDocumento(clienteBuscado);
            CLIENTE_VIEW.imprimirLista(clientesRetornados);
    }
}
