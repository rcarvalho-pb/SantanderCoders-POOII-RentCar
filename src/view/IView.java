package view;

import model.IEntidade;
import util.ConsoleUIHelper;

import java.util.List;


public interface IView {

    default void imprimirCabecalhoLista(String titulo, String dados){
        ConsoleUIHelper.drawHeader(titulo,80);
        ConsoleUIHelper.drawWithPadding(dados,80);
    }

    default void imprimirListaVazia(int width){
        ConsoleUIHelper.drawWithPadding("",width);
        ConsoleUIHelper.drawWithPadding("Não há dados", width);
        ConsoleUIHelper.drawWithPadding("",width);
    }

    default void imprimirLista(List<? extends IEntidade> lista){

        final int ITENS_POR_PAGINA = 2;
        final int numeroPaginas = (int) (Math.ceil(lista.size() / (float) ITENS_POR_PAGINA));
        int paginaAtual = 1;

        if(lista.isEmpty()){
            imprimirListaVazia(80);
        }else{
            String titulo = lista.get(0).getTituloCabecalho();
            String dados = lista.get(0).getDadosCabecalho();

            do{
                imprimirCabecalhoLista(titulo, dados);
                imprimirPaginacao(paginaAtual,ITENS_POR_PAGINA,lista);

                paginaAtual = (numeroPaginas == 1) ? -1 : obterPagina(paginaAtual,numeroPaginas);

            }while(paginaAtual != -1);
        }
    }

    default void imprimirPaginacao(int paginaAtual, int itensPorPagina, List<?> lista){

        final int numeroPaginas = (int) (Math.ceil(lista.size() / (float) itensPorPagina));

        lista.stream().skip((long) (paginaAtual - 1) * itensPorPagina)
                .limit(itensPorPagina)
                .forEach(item-> ConsoleUIHelper.drawWithPadding(item.toString(),80));
        ConsoleUIHelper.fillVSpace(1,80);
        String paginacao = "Página " + paginaAtual + "/" + numeroPaginas;
        ConsoleUIHelper.drawWithPadding(paginacao,80);
        System.out.println();
    }

    default int obterPagina(int paginaAtual, int numeroPaginas){
        int opcoes = ConsoleUIHelper.printChooseOption("Escolha a opção",
                "Avançar página", "Voltar página", "Encerrar paginação");

        while (true){
            int paginaTeste = paginaAtual;
            switch (ConsoleUIHelper.chooseOption(opcoes)){
                case 0 -> paginaAtual = paginaAtual == numeroPaginas ? paginaAtual : paginaAtual + 1;
                case 1 -> paginaAtual = paginaAtual == 1 ? paginaAtual : paginaAtual - 1;
                case 2 -> paginaAtual = -1;
            }
            if(paginaTeste != paginaAtual)
                break;
        }
        return paginaAtual;
    }




}
