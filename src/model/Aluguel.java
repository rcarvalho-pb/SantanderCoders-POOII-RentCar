package model;

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

    }

    public Long quantidadeDeDiasAlugado(){
      return ChronoUnit.DAYS.between(DataFormatada.stringParaLocalDateTime(dataRetirada), DataFormatada.stringParaLocalDateTime(dataDevolucao));
    }    
    
    public String getDataAluguel() {
      return dataRetirada;
    }

    public void setAgenciaDevolucao(Agencia agenciaDevolucao){
      this.agenciaDevolucao = agenciaDevolucao;

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
