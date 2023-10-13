package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Exceptions.InsertException;
import Exceptions.NotFoundException;
import model.DAO.ClienteDAO;
import model.VO.Cliente;

public class ClienteBO implements BaseInterBO<Cliente> {

	@Override
    public boolean cadastrar(Cliente vo) throws InsertException{
        ClienteDAO cliDAO = new ClienteDAO();
        ResultSet clienteRS = cliDAO.buscar(vo);
        try {
            if (clienteRS.next()) {
                throw new InsertException("CPF já cadastrado");
            } else {
              	cliDAO.inserir(vo);
              	return (true);
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
	public ArrayList<Cliente> listar() throws InsertException {
	        try {
	            ClienteDAO cliDAO = new ClienteDAO();
	        	ResultSet clientesBuscados = cliDAO.listar();
	            ArrayList<Cliente> clientes = new ArrayList<>();
	            while(clientesBuscados.next()) {
	                clientes.add(new Cliente(clientesBuscados.getString("cpf_cliente"),
	                clientesBuscados.getString("nome_cliente"),
	                clientesBuscados.getString("endereco_cliente")));
	            }

	            return clientes;
	        } catch (Exception e) {
	            throw new InsertException("erro ao buscar veiculos");
	        }
	    }
	

	@Override
	public Object alterar(Cliente vo) throws InsertException {
		return vo;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deletar(Cliente vo) throws InsertException {
		return false;
		
	}

	
	
}

