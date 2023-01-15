package model;

import java.time.LocalDateTime;

public class Aluguel implements IEntidade {
    private LocalDateTime dataInicioAluguel;
    private LocalDateTime dataFinalAluguel;
    private String agencia;
    private String veiculo;

    public Aluguel(LocalDateTime dataInicioAluguel, LocalDateTime dataFinalAluguel, String agencia, String veiculo) {
        
        this.dataInicioAluguel = dataInicioAluguel;
        this.dataFinalAluguel = dataFinalAluguel;
        this.agencia = agencia;
        this.veiculo = veiculo;
    }


    public LocalDateTime getDataAluguel() {
        return dataInicioAluguel;
    }

    public void MudarDataFinalAluguel(LocalDateTime novaDataFinal) {
        if(dataFinalAluguel.isBefore(novaDataFinal)){
            dataFinalAluguel = novaDataFinal;
            return;
        }
        System.out.println("Data informada inválida. ");
        return;
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
        return this.dataInicioAluguel.toString();
    }


}
