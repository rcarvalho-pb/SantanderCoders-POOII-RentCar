import model.*;
import persistence.*;
import view.MenuView;

public class Main {
    public static void main(String[] args) {

      RepositorioJsonGenericoAbstract.importarDadosJson();
      MenuView.iniciarMenuPrincipal();
      System.out.println("\nFim do programa!\n");
    }
}
