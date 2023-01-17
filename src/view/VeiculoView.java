package view;

import model.TipoVeiculo;
import util.ConsoleUIHelper;


public class VeiculoView extends ViewGenerico implements IView{
    public static VeiculoView getInstance(){
        return new VeiculoView();
    }

}
