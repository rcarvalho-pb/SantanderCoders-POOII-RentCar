package persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.ClienteController;
import model.Cliente;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ClienteJsonRepository extends RepositorioJsonGenericoAbstract<Cliente> implements IClienteRepository{

    public ClienteJsonRepository(String pathOfFile) {
        super(pathOfFile);
      }

    @Override
    public void lerJson() {
        if(Files.exists(Paths.get(this.pathOfFile))) {
            try (FileReader reader = new FileReader(pathOfFile)) {
                Type listType = new TypeToken<List<Cliente>>() {}.getType();
                List<Cliente> lista = new Gson().fromJson(reader, listType);

                this.entidades.addAll(lista);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

    public Cliente selecionarCliente(){

        return ClienteController.getInstancia().validarBuscaClientePorDocumento();
    }
}
