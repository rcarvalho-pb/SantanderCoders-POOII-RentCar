package controller;

import model.TipoVeiculo;
import model.Veiculo;
import persistence.VeiculosEmMemoriaRepository;
import util.Constantes;
import view.VeiculoView;

import java.util.List;

public class VeiculoController implements IVeiculoController{
    private final VeiculosEmMemoriaRepository VEICULOS_REPOSITORY;
    private final VeiculoView VEICULO_VIEW;

    private VeiculoController() {
        this.VEICULO_VIEW = new VeiculoView();
        this.VEICULOS_REPOSITORY = Constantes.VEICULOS_REPOSITORY;
    }

    public static VeiculoController getInstancia(){
        return new VeiculoController();
    }

    @Override
    public void cadastrarVeiculo() {
        String placa = VEICULO_VIEW.obterPlaca();
        String cor = VEICULO_VIEW.obterCor();
        String modelo = VEICULO_VIEW.obterModelo();
        String fabricante = VEICULO_VIEW.obterFabricante();
        TipoVeiculo tipoVeiculo = VEICULO_VIEW.obterTipoVeiculo();
        Veiculo veiculo = new Veiculo(placa, cor, modelo, fabricante,tipoVeiculo);
        if(VEICULOS_REPOSITORY.salvar(veiculo)){
            System.out.println("\nVeículo cadastrado com sucesso\n");
            return;
        }
        System.out.println("\nVeículo duplicado. Não foi cadastrado\n");


    }

    private Veiculo validarBuscaVeiculoPorPlaca(){
        Veiculo veiculo;
        do{
            String placa = VEICULO_VIEW.obterPlaca();
            veiculo = VEICULOS_REPOSITORY.buscarPeloId(placa);
        }while (veiculo == null);
        return veiculo;
    }

    @Override
    public void alterarVeiculo() {
        List<Veiculo> veiculos = VEICULOS_REPOSITORY.getEntidades();
        VEICULO_VIEW.imprimirLista(veiculos);
        if(!Controller.isListaVazia(veiculos)){
            Veiculo veiculoASerAlterado = validarBuscaVeiculoPorPlaca();
            System.out.println("\nDigite os novos dados\n");
            VEICULOS_REPOSITORY.remover(veiculoASerAlterado.getPlaca());
            cadastrarVeiculo();
        }
    }

    @Override
    public List<Veiculo> buscarVeiculo() {
        String modeloASerProcurado = VEICULO_VIEW.obterModelo();
        List<Veiculo> veiculosRetornados = VEICULOS_REPOSITORY.buscarPorModelo(modeloASerProcurado);
        VEICULO_VIEW.imprimirLista(veiculosRetornados);

        return veiculosRetornados;
    }
}
