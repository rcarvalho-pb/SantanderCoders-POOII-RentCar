import model.Agencia;
import model.Cliente;
import model.TipoCliente;
import model.TipoVeiculo;
import model.Veiculo;
import persistence.RepositorioGenericoAbstract;
import persistence.RepositoryFactory;
import view.MenuView;

public class Main {
    public static void main(String[] args) {

        RepositorioGenericoAbstract<Veiculo> VEICULO_REPOSITORY = RepositoryFactory.VEICULOS_REPOSITORY;
      Veiculo veiculo = new Veiculo("123", "vermelho", "uno", "fiat", TipoVeiculo.CARRO);
      VEICULO_REPOSITORY.salvar(veiculo);
      veiculo = new Veiculo("321", "amarelo", "uno", "fiat", TipoVeiculo.CARRO);
      VEICULO_REPOSITORY.salvar(veiculo);
      veiculo = new Veiculo("456", "laranja", "corolla", "toyota", TipoVeiculo.CARRO);
      VEICULO_REPOSITORY.salvar(veiculo);
       veiculo = new Veiculo("654", "verde", "ckawasaki", "ninja", TipoVeiculo.CARRO);
      VEICULO_REPOSITORY.salvar(veiculo);
      
      RepositorioGenericoAbstract<Cliente> CLIENTE_REPOSITORY = RepositoryFactory.CLIENTE_REPOSITORY;
      Cliente cliente = new Cliente(TipoCliente.PESSOA_FISICA, "Ramon", "123456");
      CLIENTE_REPOSITORY.salvar(cliente);
      cliente = new Cliente(TipoCliente.PESSOA_FISICA, "Pamella", "321123");
      CLIENTE_REPOSITORY.salvar(cliente);
      cliente = new Cliente(TipoCliente.PESSOA_FISICA, "Paulo", "991548");
      CLIENTE_REPOSITORY.salvar(cliente);
      cliente = new Cliente(TipoCliente.PESSOA_FISICA, "Raruo", "666666");
      CLIENTE_REPOSITORY.salvar(cliente);
      
      RepositorioGenericoAbstract<Agencia> AGENCIA_REPOSITORY = RepositoryFactory.AGENCIA_REPOSITORY;
      Agencia agencia = new Agencia("Ag1", "Rua T");
      AGENCIA_REPOSITORY.salvar(agencia);
      agencia = new Agencia("Ag2", "Rua K");
      AGENCIA_REPOSITORY.salvar(agencia);
      agencia = new Agencia("Ag3", "Rua H");
      AGENCIA_REPOSITORY.salvar(agencia);
      agencia = new Agencia("Ag4", "Rua R");
      AGENCIA_REPOSITORY.salvar(agencia);

        MenuView.iniciarMenuPrincipal();
        System.out.println("\nFim do programa!\n");
    }
}
