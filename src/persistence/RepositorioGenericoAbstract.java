package persistence;


import controller.Controller;
import model.IEntidade;

import java.util.ArrayList;
import java.util.List;

public class RepositorioGenericoAbstract<T extends IEntidade> implements RepositoryGenerico<T> {

    protected List<T> entidades;

    public RepositorioGenericoAbstract() {
        this.entidades = new ArrayList<>();
    }

    public List<T> getEntidades() {
        return entidades;
    }

    @Override
    public boolean remover(String identicador) {
        for (T entidade : this.entidades){
            if(entidade.getId().equalsIgnoreCase(identicador)){
                this.entidades.remove(entidade);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean salvar(T entidade) {
        if(Controller.verificarItemDuplicado(this.entidades, entidade))
            return false;
        this.entidades.add(entidade);
        return true;
    }

    @Override
    public T buscarPeloId(String identificador) {
        for (T entidade : this.entidades){
            if(entidade.getId().equals(identificador))
                return entidade;
        }
        return null;

    }
}
