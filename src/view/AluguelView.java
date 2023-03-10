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

public class AluguelView implements IView{

    public static AluguelView getInstance(){
        return new AluguelView();
    }

    public String obterDadoString(String mensagem){
      return ConsoleUIHelper.askSimpleInput(mensagem);
    }

    public String obterData(String dataDevolucaoOuRetirada) {
        return getInstance().obterDadoString("Digite a data de "
                + dataDevolucaoOuRetirada + " formato DD/MM/AAAA HH:MM");
    }

    public void imprimirComprovante(Aluguel aluguel, String texto) {
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
      double desconto = diasAlugados > diasParaDesconto ? (1 - tipoCliente.getDesconto())*100 : 0.0;
      BigDecimal valorAluguel = aluguel.getValorAPagar();

      ConsoleUIHelper.drawHeader(String.format("Comprovante de %s", texto), 80);
      ConsoleUIHelper.drawWithRightPadding(("Id do aluguel: " + id), 80, ' ');
      ConsoleUIHelper.drawWithRightPadding(("Data de retirada: " + DataFormatada.localDateTimeParaString(dataRetirada)), 80, ' ');
      ConsoleUIHelper.drawWithRightPadding(("Data de devolu????o: " + DataFormatada.localDateTimeParaString(dataDevolucao)), 80, ' ');
      ConsoleUIHelper.fillVSpace(0, 80);
      ConsoleUIHelper.drawLine(80);

      ConsoleUIHelper.drawWithPadding("Dados VE??CULO", 80);
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

      ConsoleUIHelper.drawWithPadding("Dados AG??NCIA", 80);
      ConsoleUIHelper.fillVSpace(0,80);
      ConsoleUIHelper.drawWithRightPadding(("Ag??ncia de Retirada: " +
              agenciaRetirada.getNome() + " " + agenciaRetirada.getLogradouro()), 80, ' ');
      ConsoleUIHelper.drawWithRightPadding(("Ag??ncia de Devolu????o " +
              agenciaDevolucao.getNome() + " " + agenciaRetirada.getLogradouro()), 80, ' ');

      ConsoleUIHelper.fillVSpace(0, 80);
      ConsoleUIHelper.drawLine(80);

      ConsoleUIHelper.drawWithPadding("C??lculo do Aluguel", 80);
      ConsoleUIHelper.fillVSpace(0,80);
      ConsoleUIHelper.drawWithRightPadding("Pre??o do aluguel por dia: R$" + valorAluguelDiario, 80,' ');
      ConsoleUIHelper.drawWithRightPadding("Quantidade de dias alugado: " + diasAlugados, 80,' ');
      ConsoleUIHelper.drawWithRightPadding(String.format("Desconto: %.2f %%",desconto), 80,' ');
      ConsoleUIHelper.drawWithRightPadding(String.format("Valor total: R$%.2f",valorAluguel), 80, ' ');
      ConsoleUIHelper.fillVSpace(0, 80);
      ConsoleUIHelper.drawLine(80);

    }
}
