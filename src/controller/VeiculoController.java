package controller;

import model.TipoVeiculo;
import model.Veiculo;
import persistence.RepositoryFactory;
import persistence.VeiculoJsonRepository;
import persistence.VeiculosEmMemoriaRepository;
import util.ConsoleUIHelper;
import view.VeiculoView;

import java.util.List;
import java.util.stream.Collectors;

public class VeiculoController implements IVeiculoController{
    private final VeiculoJsonRepository VEICULOS_REPOSITORY;
    private final VeiculoView VEICULO_VIEW;

    private VeiculoController() {
        this.VEICULO_VIEW = VeiculoView.getInstance();
        this.VEICULOS_REPOSITORY = RepositoryFactory.VEICULOS_REPOSITORY;
    }

    public static VeiculoController getInstancia(){
        return new VeiculoController();
    }

    @Override
    public void cadastrarVeiculo() {
        String placa = VEICULO_VIEW.obterDadoString("Entre com o número da placa");
        String cor = VEICULO_VIEW.obterDadoString("Entre com a cor do Veículo");
        String modelo = VEICULO_VIEW.obterDadoString("Entre com o modelo do Veículo");
        String fabricante = VEICULO_VIEW.obterDadoString("Entre com o nome do Fabricante");
        TipoVeiculo tipoVeiculo = VEICULO_VIEW.obterDadoEnum("Tipo de Veículo", TipoVeiculo.class);
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
            String placa = VEICULO_VIEW.obterDadoString("Entre com o número da placa");
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
    public void buscarVeiculo() {
        String modeloASerProcurado = VEICULO_VIEW.obterDadoString("Entre com o modelo do Veículo");
        List<Veiculo> veiculosRetornados = VEICULOS_REPOSITORY.buscarPorModelo(modeloASerProcurado);
        VEICULO_VIEW.imprimirLista(veiculosRetornados);
    }

    public Veiculo escolherVeiculoParaAlugar(){
        
        String veiculoString = ConsoleUIHelper.askSimpleInput("Qual o modelo do veículo desejado?");
        List<Veiculo> veiculosRetornados = VEICULOS_REPOSITORY.buscarPorModelo(veiculoString).stream().filter(x -> x.isDisponivel() == true).collect(Collectors.toList());
        VEICULO_VIEW.imprimirLista(veiculosRetornados);
        return VEICULOS_REPOSITORY.buscarVeiculoPelaPlaca(veiculosRetornados);
    }
}
