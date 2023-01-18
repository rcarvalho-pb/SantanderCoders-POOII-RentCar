package controller;

import model.Cliente;
import model.TipoCliente;
import persistence.ClienteEmMemoriaRepository;
import persistence.RepositoryFactory;
import util.ConsoleUIHelper;
import view.ClienteView;

import java.util.List;

public class ClienteController implements IClienteController{
    private final ClienteView CLIENTE_VIEW;
    private final ClienteEmMemoriaRepository CLIENTE_REPOSITORY;

    public ClienteController() {
        CLIENTE_VIEW = ClienteView.getInstance();
        CLIENTE_REPOSITORY = RepositoryFactory.CLIENTE_REPOSITORY;
    }

    public static ClienteController getInstancia() {
        return new ClienteController();
    }

    @Override
    public void cadastrarCliente() {
        String nome = CLIENTE_VIEW.obterDadoString("Entre com o nome do Cliente");
        TipoCliente tipoCliente = CLIENTE_VIEW.obterDadoEnum("Tipo de Cliente", TipoCliente.class);
        String documento = CLIENTE_VIEW.obterDadoString("Entre com o número do documento");
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
            String documento = CLIENTE_VIEW.obterDadoString("Entre com o número do documento");
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
            String clienteBuscado = CLIENTE_VIEW.obterDadoString("Entre com o Documento do cliente");
            List<Cliente> clientesRetornados = CLIENTE_REPOSITORY.buscarPorDocumento(clienteBuscado);
            CLIENTE_VIEW.imprimirLista(clientesRetornados);
    }

    public Cliente escolherCliente() {
        String clienteString = ConsoleUIHelper.askSimpleInput("Qual o nome do cliente?");
        List<Cliente> clientesRetornadas = CLIENTE_REPOSITORY.buscarPorNome(clienteString);
        CLIENTE_VIEW.imprimirLista(clientesRetornadas);
        return CLIENTE_REPOSITORY.selecionarCliente();
    }
}
