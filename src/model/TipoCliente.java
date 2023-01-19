package model;

public enum TipoCliente {
    PESSOA_FISICA(0.95), PESSOA_JURIDICA(0.9);

    double desconto;
    TipoCliente(double desconto) {
        this.desconto = desconto;
    }
    public double getDesconto(){
        return desconto;
    }
}
