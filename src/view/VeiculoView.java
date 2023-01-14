package view;

import model.TipoVeiculo;
import util.ConsoleUIHelper;


public class VeiculoView implements IView, IVeiculoView{
    @Override
    public String obterPlaca(){
        return ConsoleUIHelper.askSimpleInput("Entre com o número da placa");
    }
    @Override
    public String obterCor(){
        return ConsoleUIHelper.askSimpleInput("Entre com a cor do Veículo");
    }
    @Override
    public String obterModelo(){
        return ConsoleUIHelper.askSimpleInput("Entre com o modelo do Veículo");
    }
    @Override
    public String obterFabricante(){
        return ConsoleUIHelper.askSimpleInput("Entre com o nome do Fabricante");
    }
    @Override
    public TipoVeiculo obterTipoVeiculo(){
        TipoVeiculo[] tiposVeiculos = TipoVeiculo.values();
        int quantidadeOpcoes = ConsoleUIHelper.printChooseOption("Tipo de Veículo", obterArrayNameVeiculos());
        int opcaoVeiculo = ConsoleUIHelper.chooseOption(quantidadeOpcoes);
        return tiposVeiculos[opcaoVeiculo];

    }

    private static String[] obterArrayNameVeiculos(){
        TipoVeiculo[] tiposVeiculos = TipoVeiculo.values();
        String[] tiposVeiculosString = new String[tiposVeiculos.length];
        for (int i = 0; i < tiposVeiculos.length; i++) {
            tiposVeiculosString[i] = tiposVeiculos[i].name();
        }
        return tiposVeiculosString;
    }

}
