import model.Agencia;
import model.Cliente;
import model.TipoCliente;
import model.TipoVeiculo;
import model.Veiculo;
import persistence.RepositorioGenericoAbstract;
import persistence.RepositorioJsonGenericoAbstract;
import persistence.RepositoryFactory;
import view.MenuView;

public class Main {
    public static void main(String[] args) {

      RepositorioJsonGenericoAbstract.importarDadosJson();
      MenuView.iniciarMenuPrincipal();
      System.out.println("\nFim do programa!\n");
    }
}
