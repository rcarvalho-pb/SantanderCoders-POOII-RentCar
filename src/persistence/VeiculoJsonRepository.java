package persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.VeiculoController;
import model.Veiculo;

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

                if(lista != null) this.entidades.addAll(lista);

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
        return VeiculoController.getInstancia().validarBuscaVeiculoPorPlaca();
    }
}
