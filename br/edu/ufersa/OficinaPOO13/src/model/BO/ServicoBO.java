package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Exceptions.InsertException;
import Exceptions.NotFoundException;
import model.DAO.ServicoDAO;
import model.VO.Servico;

public class ServicoBO implements BaseInterBO<Servico>{

	@Override
	public void cadastrar(Servico vo) throws InsertException {
		ServicoDAO servDAO = new ServicoDAO();
		servDAO.inserir(vo);		
	}

	@Override
	public ResultSet buscar(Servico vo) throws NotFoundException {
		ServicoDAO servDAO = new ServicoDAO();
		return servDAO.buscar(vo);	
	}

	@Override
	public ResultSet listar() throws InsertException {
		ServicoDAO servDAO = new ServicoDAO();
		return servDAO.listar();	
	}

	@Override
	public void alterar(Servico vo) throws InsertException {
		ServicoDAO servDAO = new ServicoDAO();
		ResultSet servRS = servDAO.buscar(vo);
        try {
        if (servRS.next())
        {
            servDAO.alterar(vo);
        }
        else
        {
            throw new NotFoundException("ID não encontrado.");
        }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new InsertException("Falha na alteração.");
        } finally {
            if (servRS != null) {
                try {
                	servRS.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}

	@Override
	public void deletar(Servico vo) throws InsertException {
		ServicoDAO servDAO = new ServicoDAO();
		ResultSet servRS = servDAO.buscar(vo);
        try {
        if (servRS.next())
        {
            servDAO.deletar(vo);
        }
        else
        {
            throw new NotFoundException("ID não encontrado.");
        }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new InsertException("Falha na alteração.");
        } finally {
            if (servRS != null) {
                try {
                	servRS.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
