package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseDAO<E> { 

    public void inserir(E entity) throws SQLException;
    public void deletar(E entity) throws SQLException;
    public E alterar(E entity) throws SQLException;
    public ResultSet buscar(E entity) throws SQLException;
    public ResultSet listar() throws SQLException;

}
