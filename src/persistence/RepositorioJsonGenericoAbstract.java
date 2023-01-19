package persistence;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.IEntidade;

public class RepositorioJsonGenericoAbstract<T extends IEntidade> extends RepositorioGenericoAbstract<T> {
  final private String pathOfFile;
  private Gson gson = new GsonBuilder().setPrettyPrinting().create();

  public RepositorioJsonGenericoAbstract(String pathOfFile) {
    this.pathOfFile  = "db/"+pathOfFile+".json";
  }

  @Override
  public boolean salvar(T entidade) {
    boolean entidadeSalva = super.salvar(entidade);
    try (FileWriter writer = new FileWriter(pathOfFile)) {
      gson.toJson(this.entidades, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return entidadeSalva;
  }

  
  
}
