package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import util.DataFormatada;

public class Aluguel implements IEntidade {
    private String dataRetirada;
    private String dataDevolucao;
    private Veiculo veiculo;
    private Agencia agenciaRetirada;
    private Agencia agenciaDevolucao;
    private Cliente cliente;
    private UUID id;
    private BigDecimal valorAPagar;
    

    public Aluguel(String dataRetirada,
    String dataDevolucao, Veiculo veiculo,
    Agencia agenciaRetirada, Cliente cliente) {
      if(!dataRetiradaValida(dataRetirada)){
        System.out.println("Data inválida. Não alugamos carro no passado.");
        return;
      }

      if (DataFormatada.stringParaLocalDateTime(dataDevolucao).isBefore(DataFormatada.stringParaLocalDateTime(dataRetirada))){
        System.out.println("Data inválida. Não é possível devolver o carro antes de alugar. ");
        return;
      }

      id = UUID.randomUUID();
      this.dataRetirada = dataRetirada;
      this.dataDevolucao = dataDevolucao;
      this.veiculo = veiculo;
      this.agenciaRetirada = agenciaRetirada;
      this.cliente = cliente;
      this.agenciaDevolucao = null;

      valorAPagar = valorAPagarPorCliente(cliente, veiculo, dataRetirada, dataDevolucao);
    }

    public BigDecimal valorAPagarPorCliente(Cliente cliente, Veiculo veiculo, String dataRetirada, String dataDevolucao){
      double desconto = cliente.getTipoCliente().getDesconto();
      BigDecimal diaria = veiculo.getTipoVeiculo().getValorAluguel();
      int quantidadeDeDiasAlugado = quantidadeDeDiasAlugado(dataRetirada, dataDevolucao);

      if(cliente.getTipoCliente().equals(TipoCliente.PESSOA_FISICA) && quantidadeDeDiasAlugado > 5){
        return diaria.multiply(BigDecimal.valueOf(quantidadeDeDiasAlugado*desconto));
      }
      if(cliente.getTipoCliente().equals(TipoCliente.PESSOA_JURIDICA) && quantidadeDeDiasAlugado > 3){
        return diaria.multiply(BigDecimal.valueOf(quantidadeDeDiasAlugado*desconto));
      }
      return diaria.multiply(BigDecimal.valueOf(quantidadeDeDiasAlugado));

    }

    public BigDecimal getValorAPagar(){
      return valorAPagar;
    }

    public int quantidadeDeDiasAlugado(String dataRetirada, String dataDevolucao){
      return (int)Math.ceil((double)ChronoUnit.MINUTES.between(DataFormatada.stringParaLocalDateTime(dataRetirada), DataFormatada.stringParaLocalDateTime(dataDevolucao))/(double)(24*60));
    }    
    
    public String getDataAluguel() {
      return dataRetirada;
    }

    public void setAgenciaDevolucao(Agencia agenciaDevolucao){
      this.agenciaDevolucao = agenciaDevolucao;

    }

    public Veiculo getVeiculo(){
      return veiculo;
    }
    
    public void alterarDataDevolução(String novaDataDevolucao) {
      if(DataFormatada.stringParaLocalDateTime(novaDataDevolucao).isBefore(DataFormatada.stringParaLocalDateTime(dataRetirada))){
          System.out.println("Data inválida. Data anterior a data de retirada.");
          return;
        }
        System.out.println("Data alterada. ");
        dataDevolucao = novaDataDevolucao;
    }

    private Boolean dataRetiradaValida(String dataRetirada){
      if(DataFormatada.stringParaLocalDateTime(dataRetirada).isBefore(LocalDateTime.now())) return false;
      return true;
    }

    public Cliente getCliente(){
      return cliente;
    }

    @Override
    public String getDadosCabecalho() {
        return String.format("%-20s %-50s %-20s",
                "Placa", "Agência", "Aluguel");
    }

    @Override
    public String getTituloCabecalho() {
        return "Alugueis";
    }

    @Override
    public String getId() {
        return id.toString();
    }


}
