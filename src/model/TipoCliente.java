package model;

public enum TipoCliente {
    PESSOA_FISICA(5), PESSOA_JURIDICA(10);

    
    private int desconto;

    TipoCliente(int desconto){
        this.desconto = desconto;}

    public int descontoPorCliente(){
        return desconto;
    }
}
