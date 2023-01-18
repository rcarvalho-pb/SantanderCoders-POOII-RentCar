package persistence;

import model.Aluguel;
import model.Cliente;

import java.util.List;

import controller.Controller;


public class AluguelEmMemoriaRepository extends RepositorioGenericoAbstract<Aluguel> implements IAluguelRepository{

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

}
