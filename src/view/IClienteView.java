package view;

import model.TipoCliente;

public interface IClienteView {
    String obterNome();
    String obterDocumento();
    TipoCliente obterTipoCliente();
    String obterDadosPesquisa();
}
