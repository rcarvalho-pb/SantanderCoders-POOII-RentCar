package persistence;

import controller.Controller;
import model.Cliente;
import util.ConsoleUIHelper;

import java.util.List;

public class ClienteEmMemoriaRepository extends RepositorioGenericoAbstract<Cliente> implements IClienteRepository{

    @Override
    public List<Cliente> buscarPorDocumento(String idDocumento) {
        return this.entidades.stream()
                .filter(cliente -> cliente.getId().toLowerCase().contains(idDocumento.toLowerCase()))
                .toList();
    }


    public boolean salvar(Cliente cliente) {
        if(Controller.verificarItemDuplicado(this.entidades, cliente)) {
            return false;
        }
        this.entidades.add(cliente);
        return true;
    }

}
