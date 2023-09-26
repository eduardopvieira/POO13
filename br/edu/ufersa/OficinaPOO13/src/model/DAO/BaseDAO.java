package model.DAO;
import java.util.List;

import java.sql.ResultSet;

public interface BaseDAO<E> {  //O BaseDAO "declara" todos os metodos comuns. nesse caso,
//os metodos comuns sao "inserir", que insere no bd, "deletar" que deleta no bd, etc.


    public Long inserir(E entity);
    public void deletar(E entity);
    public void alterar(E entity);
    public ResultSet buscar(E entity);
    public List<E> listar();

}
