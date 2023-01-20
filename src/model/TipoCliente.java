package model;

public enum TipoCliente {
    PESSOA_FISICA(0.95, 5), PESSOA_JURIDICA(0.9, 3);

    double desconto;
    int quantidadeDeDiasParaDesconto;
    
    TipoCliente(double desconto, int quantidadeDeDiasParaDesconto) {
        this.desconto = desconto;
        this.quantidadeDeDiasParaDesconto = quantidadeDeDiasParaDesconto;
    }
    public double getDesconto(){
        return desconto;
    }

    public int getQuantidadeDeDiasParaDesconto(){
        return quantidadeDeDiasParaDesconto;
    }
}
