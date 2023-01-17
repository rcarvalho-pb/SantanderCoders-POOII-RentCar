package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Aluguel implements IEntidade {
    private LocalDateTime dataRetirada;
    private LocalDateTime dataDevolucao;
    private Veiculo veiculo;
    private Agencia agencia;
    private Cliente cliente;
    private UUID id;
    private Long quantidadeDeDiasAlugado;
    

    public Aluguel(LocalDateTime dataRetirada,
    LocalDateTime dataDevolucao, Veiculo veiculo,
    Agencia agencia, Cliente cliente) {
      if(!dataRetiradaValida(dataRetirada) || !dataDevolucaoValida(dataDevolucao)){
        System.out.println("Data inválida. Não alugamos carro no passado.");
        return;
      }
      this.dataRetirada = dataRetirada;
      this.dataDevolucao = dataDevolucao;
      this.veiculo = veiculo;
      this.agencia = agencia;
      this.cliente = cliente;
      id = UUID.randomUUID();
      quantidadeDeDiasAlugado = ChronoUnit.DAYS.between(dataRetirada, dataDevolucao);
    }


    
    
    public LocalDateTime getDataAluguel() {
      return dataRetirada;
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
    
    private boolean dataDevolucaoValida(LocalDateTime dataDevolucao) {
      if (dataDevolucao.isBefore(dataRetirada)) return false;
      return true;
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
