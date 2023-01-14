package view;

import model.TipoVeiculo;

public interface IVeiculoView {
    String obterPlaca();
    String obterCor();
    String obterModelo();
    String obterFabricante();
    TipoVeiculo obterTipoVeiculo();

}
