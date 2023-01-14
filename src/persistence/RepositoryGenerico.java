package persistence;

public interface RepositoryGenerico<T> {

    boolean remover(String identicador);

    boolean salvar(T entidade);

    T buscarPeloId(String identificador);
}
