package controller;

import util.ConsoleUIHelper;

public class MenuController {

    public static void obterOpcaoMenu(int quantidadeOpcoes){
        int opcao =  ConsoleUIHelper.chooseOption(quantidadeOpcoes);
        direcionarMenu(opcao);
    }
    public static void direcionarMenu(int opcao){
        switch (opcao){
            case 0 -> VeiculoController.getInstancia().cadastrarVeiculo();    //método da opção 0 do menu
            case 1 -> VeiculoController.getInstancia().alterarVeiculo();
            case 2 -> VeiculoController.getInstancia().buscarVeiculo();
            case 3 -> AgenciaController.getInstancia().cadastrarAgencia();
            case 4 -> AgenciaController.getInstancia().alterarAgencia();
            case 5 -> AgenciaController.getInstancia().buscarAgencia();
            case 6 -> {}
            case 7 -> {}
            case 8 -> {AluguelController.getInstancia().alugar();}
            case 9 -> {}
            case 10 -> {}
            case 11 -> {}
            case 12 -> {}
            case 13 -> {}
            default -> System.out.println("\nErro desconhecido\n");       //tratamento de erro feito por ConsoleUIHelper
        }
    }

}
