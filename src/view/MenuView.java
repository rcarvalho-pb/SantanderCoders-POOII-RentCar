package view;

import controller.MenuController;
import util.ConsoleUIHelper;

public class MenuView {

    public static void iniciarMenuPrincipal(){
        do{
            int width = 80;
            ConsoleUIHelper.drawHeader("LocateCar - Model.Locadora de Veículos", width);
            ConsoleUIHelper.fillVSpace(1, width);
            MenuController.direcionarMenu(obterOpcaoMenuPrincipal());
        }while(continuarMenuPrincipal());
    }

    public static int obterOpcaoMenuPrincipal(){
        return ConsoleUIHelper.askChooseOption("Escolha uma opção",
                "Cadastrar Veículos",
                "Alterar um veículo cadastrado",
                "Buscar um veículo por parte do nome",
                "Cadastrar agência",
                "Alterar agência",
                "Buscar agência por parte do nome ou logradouro do endereço",
                "Cadastrar Model.Cliente(Pessoa Física/Jurídica)",
                "Alterar Model.Cliente(Pessoa Física/Jurídica)",
                "Alugar um Veículo para Pessoa Física",
                "Alugar um Veículo para Pessoa Jurídica",
                "Devolver um Veículo para Pessoa Física",
                "Devolver um Veículo para Pessoa Jurídica",
                "Gerar comprovante de aluguel",
                "Gerar comprovante de devolução");
    }

    public static boolean continuarMenuPrincipal(){
        return ConsoleUIHelper.askConfirm("Deseja continuar?", "sim", "não");
    }

}
