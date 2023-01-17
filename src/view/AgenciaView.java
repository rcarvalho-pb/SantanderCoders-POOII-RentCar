package view;

import util.ConsoleUIHelper;

public class AgenciaView implements IView, IAgenciaView{
    @Override
    public String obterNome() {
        return ConsoleUIHelper.askSimpleInput("Entre com o nome da Agência");
    }

    @Override
    public String obterLogradouro() {
        return ConsoleUIHelper.askSimpleInput("Entre com o logradouro da Agência");
    }

    @Override
    public String obterDadosPesquisa() {
        return ConsoleUIHelper.askSimpleInput("Entre com o Nome ou logradouro da Agência");
    }


}
