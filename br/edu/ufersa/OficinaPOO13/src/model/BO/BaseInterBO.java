package model.BO;

import java.util.ArrayList;

import Exceptions.InfoNaoCompativelException;
import Exceptions.InsertException;
import Exceptions.NotFoundException;

public interface BaseInterBO<VO> {
	
	public boolean cadastrar(VO vo) throws InsertException;
	public ArrayList<VO> buscarPorPK(VO vo) throws NotFoundException, InfoNaoCompativelException;
	public ArrayList<VO> listar() throws InsertException;
	public VO alterar(VO vo) throws InsertException;
	public boolean deletar(VO vo) throws InsertException;	
}