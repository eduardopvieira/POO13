package model.BO;

import java.sql.ResultSet;
import Exceptions.InsertException;
import Exceptions.NotFoundException;

public interface BaseInterBO<VO> {
	
	public void cadastrar(VO vo) throws InsertException;
	public ResultSet buscar(VO vo) throws NotFoundException;
	public ResultSet listar() throws InsertException;
	public void alterar(VO vo) throws InsertException;
	public void deletar(VO vo) throws InsertException;
}