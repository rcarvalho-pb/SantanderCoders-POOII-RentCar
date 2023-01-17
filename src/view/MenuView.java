package view;

import controller.MenuController;
import util.ConsoleUIHelper;

public class MenuView {
    public static void iniciarMenuPrincipal(){

        do{
            int width = 80;
            ConsoleUIHelper.drawHeader("LocateCar - Locadora de Veículos", width);
            ConsoleUIHelper.fillVSpace(1, width);
            MenuController.obterOpcaoMenu(mostarOpcoesMenu());
        }while(continuarMenuPrincipal());
    }

    private static int mostarOpcoesMenu(){
        return ConsoleUIHelper.printChooseOption("Escolha uma opção",
                "Cadastrar Veículos",
                "Alterar um veículo cadastrado",
                "Buscar um veículo por parte do nome",
                "Cadastrar agência onde o veículo será alugado/devolvido",
                "Alterar agência onde o veículo será alugado/devolvido;",
                "Buscar uma agência por parte do nome ou logradouro do endereço",
                "Cadastrar o cliente (Pessoa Física/Jurídica)",
                "Alterar o cliente (Pessoa Física/Jurídica)",
                "Buscar o cliente por documento",
                "Alugar um Veículo para Pessoa Física",
                "Alugar um Veículo para Pessoa Jurídica",
                "Devolver um Veículo para Pessoa Física",
                "Devolver um Veículo para Pessoa Jurídica",
                "Gerar comprovante de aluguel",
                "Gerar comprovante de devolução");

    }

    private static boolean continuarMenuPrincipal(){
        return ConsoleUIHelper.askConfirm("Deseja continuar?", "sim", "não");
    }
}
