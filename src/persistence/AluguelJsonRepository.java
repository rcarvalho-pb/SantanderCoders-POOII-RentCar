package persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Agencia;
import model.Aluguel;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


public class AluguelJsonRepository extends RepositorioJsonGenericoAbstract<Aluguel> implements IAluguelRepository{

    public AluguelJsonRepository(String pathOfFile) {
        super(pathOfFile);
    }

    @Override
    public List<Aluguel> buscarPorId(String idAluguel) {
        return this.entidades.stream()
                .filter(aluguel -> aluguel.getId().toLowerCase().contains(idAluguel.toLowerCase()))
                .toList();
    }

    public List<Aluguel> buscarPorCliente(String nomeCliente) {
        return this.entidades.stream()
                .filter(c -> c.getCliente().getNome().toLowerCase().contains(nomeCliente.toLowerCase()))
                .toList();
    }

    @Override
    public boolean salvar(Aluguel entidade){
        entidade.getVeiculo().alugar();
        return super.salvar(entidade);
    }

    @Override
    public void lerJson() {
        try (FileReader reader = new FileReader(pathOfFile)) {
            Type listType = new TypeToken<List<Aluguel>>() {}.getType();
            List<Aluguel> lista = new Gson().fromJson(reader, listType);
            this.getEntidades().addAll(lista);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
