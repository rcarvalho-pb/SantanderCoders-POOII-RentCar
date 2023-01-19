package persistence;

import model.Veiculo;
import util.ConsoleUIHelper;

import java.util.List;

public class VeiculoJsonRepository extends RepositorioJsonGenericoAbstract<Veiculo> implements IVeiculoRepository{

    public VeiculoJsonRepository(String pathOfFile) {
        super(pathOfFile);
    }

    @Override
    public List<Veiculo> buscarPorModelo(String modelo) {
        return this.entidades.stream()
                .filter(veiculo -> veiculo.getModelo().toLowerCase().contains(modelo.toLowerCase()))
                .toList();
    }

    public Veiculo buscarVeiculoPelaPlaca(List<Veiculo> veiculos){
        if (!veiculos.isEmpty() && veiculos.size() == 1){
            return veiculos.get(0);
        }

        String placa = ConsoleUIHelper.askSimpleInput("Qual a placa do veiculo? ");

        return buscarPeloId(placa);
    }
}
