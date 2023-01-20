package persistence;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.IEntidade;

public abstract class RepositorioJsonGenericoAbstract<T extends IEntidade> extends RepositorioGenericoAbstract<T> {
  final protected String pathOfFile;
  protected Gson gson = new GsonBuilder().setPrettyPrinting().create();

  public RepositorioJsonGenericoAbstract(String pathOfFile) {
    this.pathOfFile  = "src/db/"+pathOfFile+".json";
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

  abstract void lerJson();

  public static void importarDadosJson(){
    RepositoryFactory.ALUGUEL_REPOSITORY.lerJson();
    RepositoryFactory.VEICULOS_REPOSITORY.lerJson();
    RepositoryFactory.CLIENTE_REPOSITORY.lerJson();
    RepositoryFactory.AGENCIA_REPOSITORY.lerJson();
  }
  
}
