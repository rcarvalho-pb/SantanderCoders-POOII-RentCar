package persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Veiculo;
import util.ConsoleUIHelper;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class VeiculoJsonRepository extends RepositorioJsonGenericoAbstract<Veiculo> implements IVeiculoRepository{

    public VeiculoJsonRepository(String pathOfFile) {
        super(pathOfFile);
    }

    @Override
    public void lerJson() {
        if(Files.exists(Paths.get(this.pathOfFile))) {
            try (FileReader reader = new FileReader(pathOfFile)) {
                Type listType = new TypeToken<List<Veiculo>>() {}.getType();
                List<Veiculo> lista = new Gson().fromJson(reader, listType);

                this.entidades.addAll(lista);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public List<Veiculo> buscarPorModelo(String modelo) {
        return this.entidades.stream()
                .filter(veiculo -> veiculo.getModelo().toLowerCase().contains(modelo.toLowerCase()))
                .toList();
    }

    public Veiculo buscarVeiculoPelaPlaca(List<Veiculo> veiculos){
        if (!veiculos.isEmpty() && veiculos.size() == 1){
            return veiculos.get(0);
        }

        String placa = ConsoleUIHelper.askSimpleInput("Qual a placa do veiculo? ");

        return buscarPeloId(placa);
    }
}
