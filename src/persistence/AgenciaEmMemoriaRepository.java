package persistence;

import model.Agencia;

import java.util.List;

public class AgenciaEmMemoriaRepository extends RepositorioGenericoAbstract<Agencia> implements IAgenciaRepository{

    @Override
    public List<Agencia> buscarPorNomeOuLogradouro(String nomeOuLogradouro) {
        return this.entidades.stream()
                .filter(agencia -> agencia.getNome().concat(
                        agencia.getLogradouro()).toLowerCase().contains(nomeOuLogradouro.toLowerCase()))
                .toList();
    }
}
