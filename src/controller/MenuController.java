package controller;

import util.ConsoleUIHelper;

public class MenuController {

    public static void obterOpcaoMenu(int quantidadeOpcoes) {
        int opcao = ConsoleUIHelper.chooseOption(quantidadeOpcoes);
        direcionarMenu(opcao);
    }

    public static void direcionarMenu(int opcao) {
        switch (opcao) {
            case 0 -> VeiculoController.getInstancia().cadastrarVeiculo();    //método da opção 0 do menu
            case 1 -> VeiculoController.getInstancia().removerVeiculo();
            case 2 -> VeiculoController.getInstancia().alterarVeiculo();
            case 3 -> VeiculoController.getInstancia().buscarVeiculo();
            case 4 -> AgenciaController.getInstancia().cadastrarAgencia();
            case 5 -> AgenciaController.getInstancia().removerAgencia();
            case 6 -> AgenciaController.getInstancia().alterarAgencia();
            case 7 -> AgenciaController.getInstancia().buscarAgencia();
            case 8 -> ClienteController.getInstancia().cadastrarCliente();
            case 9 -> ClienteController.getInstancia().removerCliente();
            case 10 -> ClienteController.getInstancia().alterarCliente();
            case 11 -> ClienteController.getInstancia().buscarCliente();
            case 12 -> AluguelController.getInstancia().alugar();
            case 13 -> {}
            case 14 -> {}
            case 15 -> {}
            case 16 -> {}
            case 17 -> {}
            case 18 -> {
                System.out.println("Finalizando aplicação...");
                System.exit(0);
            }
            default -> System.out.println("\nErro desconhecido\n");       //tratamento de erro feito por ConsoleUIHelper
        }
    }

}
