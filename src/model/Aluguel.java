package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Aluguel implements IEntidade {
    private LocalDateTime dataRetirada;
    private LocalDateTime dataDevolucao;
    private Veiculo veiculo;
    private Agencia agenciaRetirada;
    private Agencia agenciaDevolucao;
    private Cliente cliente;
    private UUID id;
    

    public Aluguel(LocalDateTime dataRetirada,
    LocalDateTime dataDevolucao, Veiculo veiculo,
    Agencia agenciaRetirada, Cliente cliente) {
      if(!dataRetiradaValida(dataRetirada)){
        System.out.println("Data inválida. Não alugamos carro no passado.");
        return;
      }

      if (dataDevolucao.isBefore(dataRetirada)){
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
      return ChronoUnit.DAYS.between(dataRetirada, dataDevolucao);
    }    
    
    public LocalDateTime getDataAluguel() {
      return dataRetirada;
    }

    public void setAgenciaDevolucao(Agencia agenciaDevolucao){
      this.agenciaDevolucao = agenciaDevolucao;

    }
    
    public void alterarDataDevolução(LocalDateTime novaDataDevolucao) {
      if(novaDataDevolucao.isBefore(dataRetirada)){
          System.out.println("Data inválida. Data anterior a data de retirada.");
          return;
        }
        System.out.println("Data alterada. ");
        dataDevolucao = novaDataDevolucao;
    }

    private Boolean dataRetiradaValida(LocalDateTime dataRetirada){
      if(dataRetirada.isBefore(LocalDateTime.now())) return false;
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
