package persistence;

import model.Agencia;

import java.util.List;

public interface IAgenciaRepository extends RepositoryGenerico<Agencia>{
    List<Agencia> buscarPorNomeOuLogradouro(String nomeOuLogradouro);
}
