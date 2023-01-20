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
                .filter(aluguel -> aluguel.getId().toLowerCase().contains(idAluguel.toLowerCase()) && aluguel.getDevolvido() == false)
                .toList();
    }

    public List<Aluguel> buscarPorCliente(String nomeCliente) {
        return this.entidades.stream()
                .filter(c -> c.getCliente().getNome().toLowerCase().contains(nomeCliente.toLowerCase()) && c.getDevolvido() == false)
                .toList();
    }

    public List<Aluguel> buscarDevolucaoPorId(String idAluguel) {
      return this.entidades.stream()
              .filter(aluguel -> aluguel.getDevolvido() == true)
              .filter(aluguel -> aluguel.getId().toLowerCase().contains(idAluguel.toLowerCase()))
              .toList();
  }

  public List<Aluguel> buscarDevolucaoPorCliente(String nomeCliente) {
      return this.entidades.stream()
              .filter(c -> c.getCliente().getNome().toLowerCase().contains(nomeCliente.toLowerCase()) && c.getDevolvido() == true)
              .toList();
  }

  public List<Aluguel> listarTodosOsAlugueisEmAberto(){
    return entidades.stream()
            .filter(alugueis -> alugueis.getDevolvido() == false)
            .toList();
  }

  public List<Aluguel> listarTodosOsAlugueisEncerrados(){
    return entidades.stream()
            .filter(alugueis -> alugueis.getDevolvido() == false)
            .toList();
  }

}
