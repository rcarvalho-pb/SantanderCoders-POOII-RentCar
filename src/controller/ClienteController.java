package controller;

import model.Cliente;
import model.TipoCliente;
import persistence.ClienteEmMemoriaRepository;
import util.Constantes;
import view.ClienteView;

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

    @Override
    public void alterarCliente() {

    }

    @Override
    public void buscarCliente() {

    }
}
