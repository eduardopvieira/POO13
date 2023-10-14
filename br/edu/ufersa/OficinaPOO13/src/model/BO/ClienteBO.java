package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Exceptions.InfoNaoCompativelException;
import Exceptions.InsertException;
import Exceptions.NotFoundException;
import model.DAO.AutomovelDAO;
import model.DAO.ClienteDAO;
import model.VO.Automovel;
import model.VO.Cliente;

public class ClienteBO implements BaseInterBO<Cliente> {
	ClienteDAO cliDAO = new ClienteDAO();
	
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
	            throw new InsertException("erro ao buscar cliente");
	        }
	    }
	

	@Override
	public Cliente alterar(Cliente vo) throws InsertException {
		try {
			ResultSet verificarCliente = cliDAO.buscar(vo);

	            if (!verificarCliente.next() || vo.getCPF() == null) {
	                throw new InsertException("Cliente não encontrado");
	            }

	            return cliDAO.alterar(vo);
	            
	        }
	        catch (Exception e) {
	            throw new InsertException(e.getMessage());
	        }
	    }

	@Override
	public boolean deletar(Cliente vo) throws InsertException {
	        ResultSet cliRS = cliDAO.buscar(vo);
	        try {
	        if (cliRS.next())
	        {
	        	cliDAO.deletar(vo);
	        	return true;
	        }
	        else
	        {
	            throw new NotFoundException("Placa não encontrada.");
	        }
	        }catch (SQLException e) {
	            e.printStackTrace();
	            throw new InsertException("Falha na alteração.");
	        } finally {
	            if (cliRS != null) {
	                try {
	                	cliRS.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	       }
		
	}



	@Override
	public ArrayList<Cliente> buscarPorPK(Cliente vo) throws NotFoundException, InfoNaoCompativelException {
			ResultSet clientesBuscados = cliDAO.buscar(new Cliente(vo.getCPF()));
			ArrayList<Cliente> clientes = new ArrayList<>();		            
			    try {
			    	while(clientesBuscados.next()) {
			    	clientes.add(new Cliente(clientesBuscados.getString("cpf_cliente"),
			    	clientesBuscados.getString("nome_cliente"),
			    	clientesBuscados.getString("endereco_cliente")));
			    	}
			    	
			    } catch (InfoNaoCompativelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    return clientes;
	}	
	
	public ArrayList<Cliente> buscarPorNome(Cliente vo) throws NotFoundException, InfoNaoCompativelException {
		ResultSet clientesBuscados = cliDAO.buscarPorNome(vo.getNome());
		ArrayList<Cliente> clientes = new ArrayList<>();		            
		    try {
		    	while(clientesBuscados.next()) {
		    	clientes.add(new Cliente(clientesBuscados.getString("cpf_cliente"),
		    	clientesBuscados.getString("nome_cliente"),
		    	clientesBuscados.getString("endereco_cliente")));
		    	}
		    	
		    } catch (InfoNaoCompativelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return clientes;
}	
}

