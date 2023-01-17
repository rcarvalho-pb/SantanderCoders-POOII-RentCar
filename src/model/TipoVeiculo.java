package model;

import java.math.BigDecimal;

public enum TipoVeiculo {
    MOTO(new BigDecimal("100.00")),
    CARRO(new BigDecimal("150.00")),
    CAMINHAO(new BigDecimal("200.00"));

    TipoVeiculo(BigDecimal VALOR_ALUGUEL) {
    }
}
