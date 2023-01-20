import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import model.Agencia;
import model.Aluguel;
import model.Cliente;
import model.TipoCliente;
import model.TipoVeiculo;
import model.Veiculo;
import util.DataFormatada;

public class Teste {
  public static void main(String[] args) {
    
    Agencia ag1 = new Agencia("ag1", "rua t");
    Agencia ag2 = new Agencia("ag2", "rua t");

    Cliente cliente = new Cliente(TipoCliente.PESSOA_FISICA, "Ramon", "123");

    Veiculo veiculo = new Veiculo("123", "vermelho", "uno", "Fiat", TipoVeiculo.CARRO);

    String dataRetirada = "21/01/2023 12:00";
    String dataDevolucao = "22/01/2023 12:00";

    Aluguel aluguel = new Aluguel(dataRetirada, dataDevolucao, veiculo, ag1, ag2, cliente);
    System.out.println();
    System.out.println(aluguel.getAgenciaDevolucao());
  }
  
}
