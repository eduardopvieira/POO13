package model.BO;

import java.sql.SQLException;
import java.util.List;

import Exceptions.InfoNaoCompativelException;
import model.DAO.CadastradoDAO;
import model.VO.Cadastrado;

public class CadastradoBO {
	CadastradoDAO caDAO = new CadastradoDAO();
	
	 public List<Cadastrado> listar() throws SQLException, InfoNaoCompativelException
	    {
			CadastradoDAO caDAO = new CadastradoDAO();
	        return caDAO.listarView();
	    } 
}
