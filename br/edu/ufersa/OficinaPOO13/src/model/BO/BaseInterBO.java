package model.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import Exceptions.InfoNaoCompativelException;
import Exceptions.InsertException;
import Exceptions.NotFoundException;

public interface BaseInterBO<VO> {
	
	public boolean cadastrar(VO vo) throws InsertException, SQLException;
	public ArrayList<VO> buscarPorPK(VO vo) throws NotFoundException, InfoNaoCompativelException;
	public VO alterar(VO vo) throws InsertException;
	public boolean deletar(VO vo) throws InsertException;	
}