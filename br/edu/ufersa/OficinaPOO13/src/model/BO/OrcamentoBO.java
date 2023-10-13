package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Exceptions.InsertException;
import Exceptions.NotFoundException;
import model.DAO.OrcamentoDAO;
import model.DAO.PecasDAO;
import model.VO.Orcamento;

public class OrcamentoBO implements BaseInterBO<Orcamento>{

	@Override
	public void cadastrar(Orcamento vo) throws InsertException {
		OrcamentoDAO orcDAO = new OrcamentoDAO();
	    orcDAO.inserir(vo);
		
	}

	@Override
	public ResultSet buscar(Orcamento vo) throws NotFoundException {
		OrcamentoDAO orcDAO = new OrcamentoDAO();
	    return orcDAO.buscar(vo);
	}

	@Override
	public ResultSet listar() throws InsertException {
		OrcamentoDAO orcDAO = new OrcamentoDAO();
	    return orcDAO.listar();
	}

	@Override
	public void alterar(Orcamento vo) throws InsertException {
		OrcamentoDAO orcDAO = new OrcamentoDAO();
        ResultSet orcRS = orcDAO.buscar(vo);
        try {
        if (orcRS.next())
        {
        	orcDAO.alterar(vo);
        }
        else
        {
            throw new NotFoundException("ID não encontrado.");
        }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new InsertException("Falha na alteração.");
        } finally {
            if (orcRS != null) {
                try {
                	orcRS.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
       }
		
	}

	@Override
	public void deletar(Orcamento vo) throws InsertException {
		OrcamentoDAO orcDAO = new OrcamentoDAO();
        ResultSet orcRS = orcDAO.buscar(vo);
        try {
        if (orcRS.next())
        {
        	orcDAO.deletar(vo);
        }
        else
        {
            throw new NotFoundException("ID não encontrado.");
        }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new InsertException("Falha na alteração.");
        } finally {
            if (orcRS != null) {
                try {
                	orcRS.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
       }
		
	}

}
