package persistence;

import controller.Controller;
import model.Cliente;
import util.ConsoleUIHelper;

import java.util.List;

public class ClienteJsonRepository extends RepositorioJsonGenericoAbstract<Cliente> implements IClienteRepository{

    public ClienteJsonRepository(String pathOfFile) {
        super(pathOfFile);
      }

    @Override
    public List<Cliente> buscarPorDocumento(String idDocumento) {
        return this.entidades.stream()
                .filter(cliente -> cliente.getId().toLowerCase().contains(idDocumento.toLowerCase()))
                .toList();
    }

    public List<Cliente> buscarPorNome(String nome) {
        return this.entidades.stream()
                .filter(cliente -> cliente.getNome().toLowerCase().contains(nome.toLowerCase()))
                .toList();
    }
    
    // public boolean salvar(Cliente cliente) {
    //     if(Controller.verificarItemDuplicado(this.entidades, cliente)) {
    //         return false;
    //     }
    //     this.entidades.add(cliente);
    //     return true;
    // }

    public Cliente selecionarCliente(){
      if (!entidades.isEmpty() && entidades.size() == 1){
            return entidades.get(0);
        }

        String documentoCliente = ConsoleUIHelper.askSimpleInput("Qual o documento do cliente? ");

        return buscarPeloId(documentoCliente);
    }
}
