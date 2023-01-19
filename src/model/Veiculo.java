package model;

import java.util.Objects;

public class Veiculo implements IEntidade {
    private String placa;
    private String cor;
    private String modelo;
    private String fabricante;
    private boolean disponivel;
    private TipoVeiculo tipoVeiculo;

    public Veiculo(String placa, String cor, String modelo, String fabricante, TipoVeiculo tipoVeiculo) {
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.disponivel = true;
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public boolean alugar(){
        if(disponivel == false){
            System.out.println("O carro já está alugado. ");
            return false;
        }
        disponivel = !disponivel;
        return true;
    }
    
    public boolean devolver(){
        if(disponivel == true){
            System.out.println("O carro não foi alugado. ");
            return false;
        }
        disponivel = !disponivel;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(placa, veiculo.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-13s %-13s %-10s %-10s",
                this.placa, this.tipoVeiculo, this.modelo,
                this.fabricante, this.cor, this.disponivel ? "Sim" : "Não");
    }

    @Override
    public String getDadosCabecalho() {
        return String.format("%-10s %-15s %-13s %-13s %-10s %-10s",
                "Placa", "Tipo Veículo", "Modelo", "Fabricante","Cor", "Disponível");
    }

    @Override
    public String getTituloCabecalho() {
        return "Lista de Veículos";
    }

    @Override
    public String getId() {
        return this.placa;
    }
}
