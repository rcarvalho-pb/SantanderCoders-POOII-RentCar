package controller;

import java.util.List;

import model.Veiculo;

public interface IVeiculoController {
    void cadastrarVeiculo();
    void alterarVeiculo();
    List<Veiculo> buscarVeiculo();

}
