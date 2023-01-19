package model;

import java.util.Objects;

public class Cliente implements IEntidade{
    private TipoCliente tipoCliente;
    private String nome;
    private String documento;

    public Cliente(TipoCliente tipoCliente, String nome, String documento) {
        this.tipoCliente = tipoCliente;
        this.nome = nome;
        this.documento = documento;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-20s %-20s",
                this.nome, this.documento, this.tipoCliente.toString());
    }

    @Override
    public String getDadosCabecalho() {
        return String.format("%-20s %-20s %-20s",
                "Nome", "Documento", "Classificação");
    }

    @Override
    public String getTituloCabecalho() {
        return "Clientes";
    }

    @Override
    public String getId() {
        return this.documento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return documento.equals(cliente.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}
