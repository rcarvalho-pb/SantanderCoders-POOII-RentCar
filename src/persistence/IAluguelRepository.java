package persistence;

import model.Aluguel;

import java.util.List;

public interface IAluguelRepository extends RepositoryGenerico<Aluguel>{
    List<Aluguel> buscarPorId(String idAluguel);
}
