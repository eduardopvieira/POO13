package model.DAO;

import java.sql.ResultSet;

public interface BaseDAO<E> { 

    public void inserir(E entity);
    public void deletar(E entity);
    public void alterar(E entity);
    public ResultSet buscar(E entity);
    public ResultSet listar();

}
