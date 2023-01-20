package view;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import model.Agencia;
import model.Aluguel;
import model.Cliente;
import model.TipoCliente;
import model.TipoVeiculo;
import model.Veiculo;
import util.ConsoleUIHelper;
import util.DataFormatada;

public class AluguelView implements IView, IAluguelView{

    @Override
    public String obterAgencia() {
        return ConsoleUIHelper.askSimpleInput("Entre com o nome da agência");
    }

    @Override
    public String obterVeiculo() {
        return ConsoleUIHelper.askSimpleInput("Entre com o a placa do veículo");
    }

    @Override
    public String obterAno() {
        return ConsoleUIHelper.askSimpleInput("Entre com o ano");
    }

    @Override
    public String obterMes() {
        return ConsoleUIHelper.askSimpleInput("Entre com o mes");
    }

    @Override
    public String obterDia() {
        return ConsoleUIHelper.askSimpleInput("Entre com o dia");
    }

    @Override
    public String obterHora() {
        return ConsoleUIHelper.askSimpleInput("Entre com o hora");
    }

    @Override
    public String obterMinuto() {
        return ConsoleUIHelper.askSimpleInput("Entre com o minuto");
    }

    public String obterDataCompleta(){
      return ConsoleUIHelper.askSimpleInput("Entre com a data para reserva: (dd/mm/aaaa hh:mm)");
    }

    @Override
    public String mostrarDadosAluguel() {
        return null;
    }

    public static AluguelView getInstance(){
        return new AluguelView();
    }

    public static void comprovanteAluguel(Aluguel aluguel){
        System.out.printf("""

                Aluguel realizado com sucesso.
                Protocolo: %s
                Valor: R$ %.2f
                
                """, aluguel.getId(), aluguel.getValorAPagar());
    }

    public String obterDadoString(String mensagem){
      return ConsoleUIHelper.askSimpleInput(mensagem);
    }

    public void imprimirComprovante(Aluguel aluguel) {
      System.out.println(aluguel);
      String id = aluguel.getId();
      Veiculo veiculo = aluguel.getVeiculo();
      TipoVeiculo tipoVeiculo = veiculo.getTipoVeiculo();
      BigDecimal valorAluguelDiario = tipoVeiculo.getValorAluguel();
      Cliente cliente = aluguel.getCliente();
      TipoCliente tipoCliente = cliente.getTipoCliente();
      int diasParaDesconto = tipoCliente.getQuantidadeDeDiasParaDesconto();
      Agencia agenciaRetirada = aluguel.getAgenciaRetirada();
      Agencia agenciaDevolucao = aluguel.getAgenciaDevolucao();
      LocalDateTime dataRetirada = DataFormatada.stringParaLocalDateTime(aluguel.getDataRetirada());
      LocalDateTime dataDevolucao = DataFormatada.stringParaLocalDateTime(aluguel.getDataDevolucao());
      long diasAlugados = aluguel.quantidadeDeDiasAlugado(aluguel.getDataRetirada(), aluguel.getDataDevolucao());
      double desconto = diasAlugados >= diasParaDesconto ? tipoCliente.getDesconto() : 0.0;
      BigDecimal valorAluguel = aluguel.getValorAPagar();

      ConsoleUIHelper.drawHeader("Comprovante de Aluguel", 80);
      ConsoleUIHelper.drawWithRightPadding(("Id do aluguel: " + id), 80, ' ');
      ConsoleUIHelper.drawWithRightPadding(("Data de retirada: " + dataRetirada), 80, ' ');
      ConsoleUIHelper.drawWithRightPadding(("Data de devolução: " + dataDevolucao), 80, ' ');
      ConsoleUIHelper.fillVSpace(0, 80);
      ConsoleUIHelper.drawLine(80);

      ConsoleUIHelper.drawWithPadding("Dados VEÍCULO", 80);
      ConsoleUIHelper.fillVSpace(0,80);
      ConsoleUIHelper.drawWithRightPadding(("Placa: " + veiculo.getPlaca()), 80, ' ');
      ConsoleUIHelper.drawWithRightPadding(("Fabricante: " + veiculo.getFabricante()), 80, ' ');
      ConsoleUIHelper.drawWithRightPadding(("Modelo: " + veiculo.getModelo()), 80, ' ');
      ConsoleUIHelper.drawWithRightPadding(("Cor: " + veiculo.getCor()), 80, ' ');
      ConsoleUIHelper.drawWithRightPadding(("Tipo: " + veiculo.getTipoVeiculo()), 80, ' ');

      ConsoleUIHelper.fillVSpace(0, 80);
      ConsoleUIHelper.drawLine(80);

      ConsoleUIHelper.drawWithPadding("Dados CLIENTE", 80);
      ConsoleUIHelper.fillVSpace(0,80);
      ConsoleUIHelper.drawWithRightPadding(("Nome: " + cliente.getNome()), 80, ' ');
      ConsoleUIHelper.drawWithRightPadding(("Tipo " + cliente.getTipoCliente()), 80, ' ');
      ConsoleUIHelper.drawWithRightPadding(("Documento: " + cliente.getDocumento()), 80, ' ');

      ConsoleUIHelper.fillVSpace(0, 80);
      ConsoleUIHelper.drawLine(80);

      ConsoleUIHelper.drawWithPadding("Dados AGÊNCIA", 80);
      ConsoleUIHelper.fillVSpace(0,80);
      ConsoleUIHelper.drawWithRightPadding(("Agência de Retirada: " +
              agenciaRetirada.getNome() + " " + agenciaRetirada.getLogradouro()), 80, ' ');
      ConsoleUIHelper.drawWithRightPadding(("Agência de Devolução " +
              agenciaDevolucao.getNome() + " " + agenciaRetirada.getLogradouro()), 80, ' ');

      ConsoleUIHelper.fillVSpace(0, 80);
      ConsoleUIHelper.drawLine(80);

      ConsoleUIHelper.drawWithPadding("Cálculo do Aluguel", 80);
      ConsoleUIHelper.fillVSpace(0,80);
      ConsoleUIHelper.drawWithRightPadding("Preço do aluguel por hora: R$" + valorAluguelDiario, 80,' ');
      ConsoleUIHelper.drawWithRightPadding("Quantidade de dias alugado: " + diasAlugados, 80,' ');
      ConsoleUIHelper.drawWithRightPadding("Desconto: " + desconto + "%", 80,' ');
      ConsoleUIHelper.drawWithRightPadding("Total do aluguel : R$" + valorAluguel, 80, ' ');
      ConsoleUIHelper.drawLine(80);

    }
}
