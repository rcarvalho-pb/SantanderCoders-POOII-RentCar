package persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Aluguel;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class AluguelJsonRepository extends RepositorioJsonGenericoAbstract<Aluguel>{

    public AluguelJsonRepository(String pathOfFile) {
        super(pathOfFile);
    }


    @Override
    public void lerJson() {
        if(Files.exists(Paths.get(this.pathOfFile))) {
            try (FileReader reader = new FileReader(pathOfFile)) {
                Type listType = new TypeToken<List<Aluguel>>() {}.getType();
                List<Aluguel> lista = new Gson().fromJson(reader, listType);
                if(lista != null) this.entidades.addAll(lista);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

  public List<Aluguel> listarTodosOsAlugueisEmAberto(){
    return entidades.stream()
            .filter(alugueis -> !alugueis.getDevolvido())
            .toList();
  }

  public List<Aluguel> listarTodosOsAlugueisEncerrados(){
    return entidades.stream()
            .filter(Aluguel::getDevolvido)
            .toList();
  }

  public boolean removerAluguel(Aluguel aluguel){
      return entidades.remove(aluguel);
  }

}
