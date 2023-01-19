package model;

import java.math.BigDecimal;

public enum TipoVeiculo {
    MOTO(new BigDecimal("100.00")),
    CARRO(new BigDecimal("150.00")),
    CAMINHAO(new BigDecimal("200.00"));

    BigDecimal VALOR_ALUGUEL;

    TipoVeiculo(BigDecimal VALOR_ALUGUEL) {
        this.VALOR_ALUGUEL = VALOR_ALUGUEL;
    }

    public BigDecimal getValorAluguel(){
        return VALOR_ALUGUEL;
    }
}
