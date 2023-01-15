package model;

import java.time.LocalDateTime;

public class Aluguel implements IEntidade {
    private LocalDateTime dataAluguel;
    private String ano;
    private String mes;
    private String dia;
    private String hora;
    private String minuto;

    public Aluguel(String ano, String mes, String dia, String hora, String minuto) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minuto = minuto;
        this.dataAluguel = LocalDateTime.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia),
                Integer.parseInt(hora), Integer.parseInt(minuto));
    }


    public LocalDateTime getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDateTime dataAluguel) {
        this.dataAluguel = dataAluguel;
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
        return this.dataAluguel.toString();
    }


}
