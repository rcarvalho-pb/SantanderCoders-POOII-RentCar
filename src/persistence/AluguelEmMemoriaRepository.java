package persistence;

import model.Aluguel;

import java.util.List;


public class AluguelEmMemoriaRepository extends RepositorioGenericoAbstract<Aluguel> implements IAluguelRepository{

    @Override
    public List<Aluguel> buscarPorId(String idAluguel) {
        return this.entidades.stream()
                .filter(aluguel -> aluguel.getId().toLowerCase().contains(idAluguel.toLowerCase()))
                .toList();
    }
}
