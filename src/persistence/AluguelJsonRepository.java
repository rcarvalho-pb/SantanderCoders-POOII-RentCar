package persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Aluguel;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


public class AluguelJsonRepository extends RepositorioJsonGenericoAbstract<Aluguel> implements IAluguelRepository{

    public AluguelJsonRepository(String pathOfFile) {
        super(pathOfFile);
    }


    @Override
    public void lerJson() {
        try (FileReader reader = new FileReader(pathOfFile)) {
            Type listType = new TypeToken<List<Aluguel>>() {}.getType();
            List<Aluguel> lista = new Gson().fromJson(reader, listType);

            this.entidades.addAll(lista);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Aluguel> buscarPorId(String idAluguel) {
        return this.entidades.stream()
                .filter(aluguel -> aluguel.getId().toLowerCase().contains(idAluguel.toLowerCase()))
                .toList();
    }

    @Override
    public boolean salvar(Aluguel entidade){
        entidade.getVeiculo().alugar();
        return super.salvar(entidade);
    }

}
