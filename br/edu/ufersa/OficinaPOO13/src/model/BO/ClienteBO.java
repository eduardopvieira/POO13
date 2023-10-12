package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import Exceptions.AutenticationException;
import Exceptions.InsertException;
import Exceptions.JaCadastradoException;
import Exceptions.NotFoundException;
import model.DAO.ClienteDAO;
import model.VO.Cliente;

public class ClienteBO implements BaseInterBO<Cliente> {

	@Override
    public void cadastrar(Cliente vo) throws InsertException{
        ClienteDAO cliDAO = new ClienteDAO();
        ResultSet clienteRS = cliDAO.buscar(vo);
        try {
            if (clienteRS.next()) {
                throw new InsertException("CPF já cadastrado");
              	} else {
              	cliDAO.inserir(vo);
              	}
            } catch (SQLException e) {
            	e.printStackTrace();
            }throw new InsertException("Falha no cadastro.");
}
	
	@Override
	public ResultSet buscar(Cliente vo) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet listar() throws InsertException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Cliente vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Cliente vo) throws InsertException {
		
	}

	
	
}
