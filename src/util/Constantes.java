package util;

import persistence.AgenciaEmMemoriaRepository;
import persistence.AluguelEmMemoriaRepository;
import persistence.VeiculosEmMemoriaRepository;

public class Constantes {
    public static final VeiculosEmMemoriaRepository VEICULOS_REPOSITORY = new VeiculosEmMemoriaRepository();
    public static final AgenciaEmMemoriaRepository AGENCIA_REPOSITORY = new AgenciaEmMemoriaRepository();
    public static final AluguelEmMemoriaRepository ALUGUEL_REPOSITORY = new AluguelEmMemoriaRepository();
}
