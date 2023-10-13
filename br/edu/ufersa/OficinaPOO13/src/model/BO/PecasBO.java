package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Exceptions.InsertException;
import Exceptions.NotFoundException;
import model.DAO.PecasDAO;
import model.VO.Pecas;

public class PecasBO implements BaseInterBO<Pecas>{
	@Override
	public void cadastrar(Pecas vo) throws InsertException {
	    PecasDAO pecaDAO = new PecasDAO();
	    pecaDAO.inserir(vo);
	}

	@Override
	public ResultSet buscar(Pecas vo) throws NotFoundException {
		PecasDAO pecaDAO = new PecasDAO();
		return pecaDAO.buscar(vo);
	}

	@Override
	public ResultSet listar() throws InsertException {
		PecasDAO pecaDAO = new PecasDAO();
		return pecaDAO.listar();
	}

	@Override
	public void alterar(Pecas vo) throws InsertException {
		PecasDAO pecaDAO = new PecasDAO();
        ResultSet pecaRS = pecaDAO.buscar(vo);
        try {
        if (pecaRS.next())
        {
            pecaDAO.alterar(vo);
        }
        else
        {
            throw new NotFoundException("ID não encontrado.");
        }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new InsertException("Falha na alteração.");
        } finally {
            if (pecaRS != null) {
                try {
                	pecaRS.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
       }
	}
	@Override
	public void deletar(Pecas vo) throws InsertException {
		PecasDAO pecaDAO = new PecasDAO();
        ResultSet pecaRS = pecaDAO.buscar(vo);
        try {
        if (pecaRS.next())
        {
            pecaDAO.deletar(vo);
        }
        else
        {
            throw new NotFoundException("ID não encontrado.");
        }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new InsertException("Falha na alteração.");
        } finally {
            if (pecaRS != null) {
                try {
                	pecaRS.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
       }
		
	}
	
	
	
}
