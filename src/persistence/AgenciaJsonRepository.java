package persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.AgenciaController;
import model.Agencia;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AgenciaJsonRepository extends RepositorioJsonGenericoAbstract<Agencia> implements IAgenciaRepository{

  public AgenciaJsonRepository(String pathOfFile) {
    super(pathOfFile);
  }

  @Override
  public void lerJson() {
    if(Files.exists(Paths.get(this.pathOfFile))) {
      try (FileReader reader = new FileReader(pathOfFile)) {
        Type listType = new TypeToken<List<Agencia>>() {}.getType();
        List<Agencia> lista = new Gson().fromJson(reader, listType);

        if(lista != null) this.entidades.addAll(lista);

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
    public List<Agencia> buscarPorNomeOuLogradouro(String nomeOuLogradouro) {
      return this.entidades.stream()
              .filter(agencia -> agencia.getNome().concat(
                      agencia.getLogradouro()).toLowerCase().contains(nomeOuLogradouro.toLowerCase()))
                .toList();
    }

    public Agencia selecionarAgencia(){
      return AgenciaController.getInstancia().validarBuscaAgenciaPorNome();
    }
    
}
