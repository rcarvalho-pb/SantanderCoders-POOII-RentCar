package model;

import java.util.Objects;

public class Agencia implements IEntidade {
    private String nome;
    private String logradouro;

    public Agencia(String nome, String logradouro) {
        this.nome = nome;
        this.logradouro = logradouro;
    }

    public String getNome() {
        return nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agencia agencia = (Agencia) o;
        return nome.equals(agencia.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return String.format("%-20s %-50s",
                this.nome, this.logradouro);
    }

    @Override
    public String getDadosCabecalho() {
        return String.format("%-20s %-50s",
                "Nome", "Logradouro");
    }

    @Override
    public String getTituloCabecalho() {
        return "Lista de Agencias";
    }

    @Override
    public String getId() {
        return this.nome;
    }
}
