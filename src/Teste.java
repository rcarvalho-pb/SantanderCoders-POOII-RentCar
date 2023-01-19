import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import model.TipoCliente;
import util.DataFormatada;

public class Teste {
  public static void main(String[] args) {
    
    TipoCliente cliente = TipoCliente.PESSOA_JURIDICA;
    System.out.println(cliente.getDesconto());
  }
  
}
