package view;


import util.ConsoleUIHelper;

import java.util.EnumSet;


public class ViewGenerico implements IView{

    protected ViewGenerico() {

    }

    public String obterDadoString(String mensagem){
        return ConsoleUIHelper.askSimpleInput(mensagem);
    }

    public <E extends Enum<E>> E obterDadoEnum(String mensagem, Class<E> eNum){
        EnumSet<E> enumSet = EnumSet.allOf(eNum);

        String[] enumNames = obterArrayNamesEnum(enumSet);

        int opcaoEnum = ConsoleUIHelper.printChooseOption(mensagem, enumNames);
        int opcoes = ConsoleUIHelper.chooseOption(enumSet.size());

        for (E elemento : enumSet){
            if(elemento.name().equals(enumNames[opcoes])){
                return elemento;
            }
        }
        return null;
    }

    private static <E extends Enum<E>>  String[] obterArrayNamesEnum(EnumSet<E> enumSet){
        String[] enumNames = new String[enumSet.size()];
        int i = 0;
        for(E elemento : enumSet){
            enumNames[i] = elemento.name();
            i++;
        }
        return enumNames;
    }
}
