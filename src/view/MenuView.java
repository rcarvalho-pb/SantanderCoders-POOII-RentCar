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
                "Remover Veículos",
                "Alterar um veículo cadastrado",
                "Buscar um veículo por parte do nome",
                "Cadastrar agência onde o veículo será alugado/devolvido",
                "Remover agências",
                "Alterar agência onde o veículo será alugado/devolvido;",
                "Buscar uma agência por parte do nome ou logradouro do endereço",
                "Cadastrar o cliente",
                "Remover um cliente",
                "Alterar o cliente",
                "Buscar o cliente por documento",
                "Alugar um Veículo",
                "Devolver um Veículo",
                "Gerar comprovante de aluguel",
                "Gerar comprovante de devolução",
                "Sair da aplicação");

    }

    private static boolean continuarMenuPrincipal(){
        return ConsoleUIHelper.askConfirm("Deseja continuar?", "sim", "não");
    }
}
