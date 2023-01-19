package persistence;

public class RepositoryFactory {

    public static final VeiculoJsonRepository VEICULOS_REPOSITORY = new VeiculoJsonRepository("veiculos");
    public static final AgenciaJsonRepository AGENCIA_REPOSITORY = new AgenciaJsonRepository("agencias");
    public static final ClienteJsonRepository CLIENTE_REPOSITORY = new ClienteJsonRepository("clientes");
    public static final AluguelJsonRepository ALUGUEL_REPOSITORY = new AluguelJsonRepository("alugueis");
}
