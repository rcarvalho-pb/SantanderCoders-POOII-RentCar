package persistence;

public class RepositoryFactory {

    public static final VeiculosEmMemoriaRepository VEICULOS_REPOSITORY = new VeiculosEmMemoriaRepository();
    public static final AgenciaJsonRepository AGENCIA_REPOSITORY = new AgenciaJsonRepository();
    public static final ClienteEmMemoriaRepository CLIENTE_REPOSITORY = new ClienteEmMemoriaRepository();
    public static final AluguelEmMemoriaRepository ALUGUEL_REPOSITORY = new AluguelEmMemoriaRepository();
}
