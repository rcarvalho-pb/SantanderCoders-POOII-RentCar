package view;

import util.ConsoleUIHelper;

public class AluguelView implements IView, IAluguelView{

    @Override
    public String obterAgencia() {
        return ConsoleUIHelper.askSimpleInput("Entre com o nome da agência");
    }

    @Override
    public String obterVeiculo() {
        return ConsoleUIHelper.askSimpleInput("Entre com o a placa do veículo");
    }

    @Override
    public String obterAno() {
        return ConsoleUIHelper.askSimpleInput("Entre com o ano");
    }

    @Override
    public String obterMes() {
        return ConsoleUIHelper.askSimpleInput("Entre com o mes");
    }

    @Override
    public String obterDia() {
        return ConsoleUIHelper.askSimpleInput("Entre com o dia");
    }

    @Override
    public String obterHora() {
        return ConsoleUIHelper.askSimpleInput("Entre com o hora");
    }

    @Override
    public String obterMinuto() {
        return ConsoleUIHelper.askSimpleInput("Entre com o minuto");
    }

    @Override
    public String mostrarDadosAluguel() {
        return null;
    }

    public String obterDataRetiradaCompleta(){
        return ConsoleUIHelper.askSimpleInput("Data de Retirada (dd/mm/aaaa hh:mm):");
    }
    
    public String obterDataDevolucaoCompleta(){
        return ConsoleUIHelper.askSimpleInput("Data de Devolução (dd/mm/aaaa hh:mm):");
    }
}
