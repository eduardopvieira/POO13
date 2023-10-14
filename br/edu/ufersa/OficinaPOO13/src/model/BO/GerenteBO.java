package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.AutenticationException;
import Exceptions.InfoNaoCompativelException;
import Exceptions.InsertException;
import Exceptions.NotFoundException;
import model.DAO.FuncionarioDAO;
import model.DAO.GerenteDAO;
import model.VO.Funcionario;
import model.VO.Gerente;

public class GerenteBO implements FuncionarioInterBO<Gerente>{

	
//=================================================AUTENTICAR=========================================================
	@Override
	public Gerente autenticar(Gerente vo) throws AutenticationException, InfoNaoCompativelException {
		GerenteDAO gerDAO = new GerenteDAO();
		ResultSet trabalhadorRS = gerDAO.buscar(vo);
	    try {
	        if (trabalhadorRS.next()) {
	            String senhaTrab = trabalhadorRS.getString("senha_func");

	            if (vo.getSenha().equals(senhaTrab)) {
	                    Gerente funcionario = new Gerente();
	                    funcionario.setCPF(vo.getCPF());
	                    funcionario.setNome(trabalhadorRS.getString("nome_func"));
	                    funcionario.setEndereco(trabalhadorRS.getString("endereco_func"));
	                    funcionario.setSenha(trabalhadorRS.getString("senha_func"));
	                    funcionario.setIsGerente(true);
	                    return funcionario;
	            } else {
	                throw new AutenticationException("Senha incorreta.");
	            }
	        } else {
	            throw new AutenticationException("CPF não encontrado.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new AutenticationException("Falha na autenticação.");
	    }
	}				

//==========================================CADASTRAR===============================================================

	@Override
	public boolean cadastrar(Gerente vo) throws InsertException{
		GerenteDAO gerDAO = new GerenteDAO();
		ResultSet trabalhadorRS = gerDAO.buscar(vo);
		try {
			//encontrou usuario
			if(trabalhadorRS.next()) {
				throw new InsertException("CPF já cadastrado.");
			}
			else
			{
				gerDAO.inserir(vo);
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
//=================================================LISTAR=============================================================

	 public List<Gerente> listar() throws SQLException
	    {
		 GerenteDAO cliDAO = new GerenteDAO();

	        return cliDAO.listar();
	    }

//=================================================ALTERAR=============================================================

	
	@Override
	 public Gerente alterar(Gerente vo) throws InsertException 	 {
		GerenteDAO gerDAO = new GerenteDAO();
	            ResultSet funcRS = gerDAO.buscar(vo);
	            try {
	            if (funcRS.next())
	            {
	            	return (gerDAO.alterar(vo));
	            }
	            else
	            {
	                throw new NotFoundException("CPF não encontrado.");
	            }
	            }catch (SQLException e) {
	                e.printStackTrace();
	                throw new InsertException("Falha na alteração.");
	            } finally {
	                if (funcRS != null) {
	                    try {
	                        funcRS.close();
	                    } catch (SQLException e) {
	                        e.printStackTrace();
	                    }
	                }
	           }
	     }
//========================================DELETAR=====================================================================

	@Override
	public boolean deletar(Gerente vo) throws InsertException {
		GerenteDAO funcDAO = new GerenteDAO();
        ResultSet funcRS = funcDAO.buscar(vo);
        try {
        if (funcRS.next())
        {
            funcDAO.deletar(vo);
            return true;
        }
        else
        {
            throw new NotFoundException("CPF não encontrado.");
        }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new InsertException("Falha na alteração.");
        } finally {
            if (funcRS != null) {
                try {
                    funcRS.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
       }
	}
//========================================BUSCAR POR PK=================================================================

	@Override
	public ArrayList<Gerente> buscarPorPK(Gerente vo) throws NotFoundException, InfoNaoCompativelException {
		GerenteDAO gerDAO = new GerenteDAO();
	    ResultSet funcsBuscados = gerDAO.buscar(new Gerente(vo.getCPF()));
	    ArrayList<Gerente> funcs = new ArrayList<>();		            
	    try {
	        while (funcsBuscados.next()) {
	        	Gerente funcionario = new Gerente(
	                funcsBuscados.getString("cpf_func"),
	                funcsBuscados.getString("nome_func"),
	                funcsBuscados.getString("endereco_func"),
	                funcsBuscados.getString("senha_func"),
	                funcsBuscados.getBoolean("isGerente")
	            );
	            funcs.add(funcionario);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new InfoNaoCompativelException("Erro ao buscar funcionários.");
	    }
	    return funcs;
	}
//========================================BUSCAR POR NOME=================================================================
	public ArrayList<Gerente> buscarPorNome(Gerente vo) throws NotFoundException, InfoNaoCompativelException {
		FuncionarioDAO funcDAO = new FuncionarioDAO();
		ResultSet funcsBuscados = funcDAO.buscarPorNome((vo.getNome()));
		ArrayList<Gerente> funcs = new ArrayList<>();		            
		    try {
		    	while(funcsBuscados.next()) {
		    	funcs.add(new Gerente(funcsBuscados.getString("cpf_func"),
		    	funcsBuscados.getString("nome_func"),
		    	funcsBuscados.getString("endereco_func"),
		    	funcsBuscados.getString("senha_func"),
                funcsBuscados.getBoolean("isGerente")));
		    	}
		    	
		    } catch (InfoNaoCompativelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return funcs;
	}

}
