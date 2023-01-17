package persistence;


import model.Cliente;

import java.util.List;

public interface IClienteRepository extends RepositoryGenerico<Cliente>{
    List<Cliente> buscarPorDocumento(String idDocumento);
}
