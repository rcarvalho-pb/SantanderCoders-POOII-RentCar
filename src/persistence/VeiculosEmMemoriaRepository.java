package persistence;

import model.Veiculo;

import java.util.List;

public class VeiculosEmMemoriaRepository extends RepositorioGenericoAbstract<Veiculo> implements IVeiculoRepository{

    @Override
    public List<Veiculo> buscarPorModelo(String modelo) {
        return this.entidades.stream()
                .filter(veiculo -> veiculo.getModelo().toLowerCase().contains(modelo.toLowerCase()))
                .toList();
    }

}
