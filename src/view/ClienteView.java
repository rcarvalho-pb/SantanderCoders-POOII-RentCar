package view;

import model.TipoCliente;
import model.TipoVeiculo;
import util.ConsoleUIHelper;

public class ClienteView implements IView, IClienteView {
    @Override
    public String obterNome() {
        return ConsoleUIHelper.askSimpleInput("Entre com o nome do Cliente");
    }

    @Override
    public String obterDocumento() {
        return ConsoleUIHelper.askSimpleInput("Entre com o documento do Cliente");
    }

    @Override
    public TipoCliente obterTipoCliente() {
        TipoCliente[] tiposClientes = TipoCliente.values();
        int quantidadeOpcoes = ConsoleUIHelper.printChooseOption("Tipo de Cliente", obterArrayNameClientes());
        int opcaoCliente = ConsoleUIHelper.chooseOption(quantidadeOpcoes);
        return tiposClientes[opcaoCliente];
    }
    private static String[] obterArrayNameClientes(){
        TipoCliente[] tiposClientes = TipoCliente.values();
        String[] tiposClientesString = new String[tiposClientes.length];
        for (int i = 0; i < tiposClientes.length; i++) {
            tiposClientesString[i] = tiposClientes[i].name();
        }
        return tiposClientesString;
    }

}
