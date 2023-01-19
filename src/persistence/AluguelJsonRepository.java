package persistence;

import model.Aluguel;
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

    @Override
    public boolean salvar(Aluguel entidade){
        entidade.getVeiculo().alugar();
        return super.salvar(entidade);
    }

}
