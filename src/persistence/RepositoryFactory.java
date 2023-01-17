package persistence;

public class RepositoryFactory {

    public static final VeiculosEmMemoriaRepository VEICULOS_REPOSITORY = new VeiculosEmMemoriaRepository();
    public static final AgenciaEmMemoriaRepository AGENCIA_REPOSITORY = new AgenciaEmMemoriaRepository();
    public static final ClienteEmMemoriaRepository CLIENTE_REPOSITORY = new ClienteEmMemoriaRepository();
    public static final AluguelEmMemoriaRepository ALUGUEL_REPOSITORY = new AluguelEmMemoriaRepository();
}
