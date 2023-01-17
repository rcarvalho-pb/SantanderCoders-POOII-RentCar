package persistence;

import model.Veiculo;

import java.util.List;

public interface IVeiculoRepository extends RepositoryGenerico<Veiculo>{
    List<Veiculo> buscarPorModelo(String modelo);

}
