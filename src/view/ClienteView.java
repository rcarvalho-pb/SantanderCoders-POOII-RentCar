package view;

import model.TipoCliente;
import model.TipoVeiculo;
import util.ConsoleUIHelper;

public class ClienteView extends ViewGenerico implements IView {

    public static ClienteView getInstance(){
        return new ClienteView();
    }
}
