package persistence;

import model.Agencia;
import util.ConsoleUIHelper;

import java.util.List;

public class AgenciaEmMemoriaRepository extends RepositorioGenericoAbstract<Agencia> implements IAgenciaRepository{

    @Override
    public List<Agencia> buscarPorNomeOuLogradouro(String nomeOuLogradouro) {
      return this.entidades.stream()
              .filter(agencia -> agencia.getNome().concat(
                      agencia.getLogradouro()).toLowerCase().contains(nomeOuLogradouro.toLowerCase()))
                .toList();
    }

    public Agencia selecionarAgencia(){
      if (!entidades.isEmpty() && entidades.size() == 1){
            return entidades.get(0);
        }

        String agencia = ConsoleUIHelper.askSimpleInput("Qual a agencia? ");

        return buscarPeloId(agencia);
    }
    
}
