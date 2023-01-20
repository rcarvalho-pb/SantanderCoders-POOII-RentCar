package controller;

import java.util.List;

public class Controller {
    public static <E> boolean verificarItemDuplicado(List<E> lista, E elemento){
        return lista.stream().anyMatch(elementoLista -> elementoLista.equals(elemento));
    }
    static boolean isListaNaoVazia(List<?> lista){
        return !lista.isEmpty();
    }

}
