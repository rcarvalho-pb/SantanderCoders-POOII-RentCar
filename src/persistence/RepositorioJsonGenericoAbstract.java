package persistence;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.reflect.TypeToken;
import model.Agencia;
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

  public abstract void lerJson();

  public static void importarDadosJson(){
    ClienteJsonRepository clienteJsonRepository = RepositoryFactory.CLIENTE_REPOSITORY;
    VeiculoJsonRepository veiculosRepository = RepositoryFactory.VEICULOS_REPOSITORY;
    AgenciaJsonRepository agenciaJsonRepository = RepositoryFactory.AGENCIA_REPOSITORY;
    AluguelJsonRepository aluguelJsonRepository = RepositoryFactory.ALUGUEL_REPOSITORY;
    aluguelJsonRepository.lerJson();
    veiculosRepository.lerJson();
    agenciaJsonRepository.lerJson();
    clienteJsonRepository.lerJson();
  }

}
