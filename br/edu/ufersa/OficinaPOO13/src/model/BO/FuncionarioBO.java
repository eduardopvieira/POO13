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
import model.VO.Funcionario;

public class FuncionarioBO implements FuncionarioInterBO<Funcionario>{

	
//=================================================AUTENTICAR=========================================================
	@Override
	public Funcionario autenticar(Funcionario vo) throws AutenticationException, InfoNaoCompativelException {
		FuncionarioDAO funcDAO = new FuncionarioDAO();
		ResultSet trabalhadorRS = funcDAO.buscar(vo);
	    try {
	        if (trabalhadorRS.next()) {
	            String senhaTrab = trabalhadorRS.getString("senha_func");

	            if (vo.getSenha().equals(senhaTrab)) {
	                    Funcionario funcionario = new Funcionario();
	                    funcionario.setCPF(vo.getCPF());
	                    funcionario.setNome(trabalhadorRS.getString("nome_func"));
	                    funcionario.setEndereco(trabalhadorRS.getString("endereco_func"));
	                    funcionario.setSenha(trabalhadorRS.getString("senha_func"));
	                    funcionario.setIsGerente(trabalhadorRS.getBoolean("isgerente"));
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
	public boolean cadastrar(Funcionario vo) throws InsertException{
		FuncionarioDAO funcDAO = new FuncionarioDAO();
		ResultSet trabalhadorRS = funcDAO.buscar(vo);
		try {
			//encontrou usuario
			if(trabalhadorRS.next()) {
				throw new InsertException("CPF já cadastrado.");
			}
			else
			{
				funcDAO.inserir(vo);
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
//=================================================LISTAR=============================================================

	 public List<Funcionario> listar() throws SQLException
	    {
	        FuncionarioDAO cliDAO = new FuncionarioDAO();

	        return cliDAO.listar();
	    }

//=================================================ALTERAR=============================================================

	
	@Override
	 public Funcionario alterar(Funcionario vo) throws InsertException 	 {
	            FuncionarioDAO funcDAO = new FuncionarioDAO();
	            ResultSet funcRS = funcDAO.buscar(vo);
	            try {
	            if (funcRS.next())
	            {
	            	return (funcDAO.alterar(vo));
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
	public boolean deletar(Funcionario vo) throws InsertException {
		FuncionarioDAO funcDAO = new FuncionarioDAO();
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
	public ArrayList<Funcionario> buscarPorPK(Funcionario vo) throws NotFoundException, InfoNaoCompativelException {
	    FuncionarioDAO funcDAO = new FuncionarioDAO();
	    ResultSet funcsBuscados = funcDAO.buscar(new Funcionario(vo.getCPF()));
	    ArrayList<Funcionario> funcs = new ArrayList<>();		            
	    try {
	        while (funcsBuscados.next()) {
	            Funcionario funcionario = new Funcionario(
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
	public ArrayList<Funcionario> buscarPorNome(Funcionario vo) throws NotFoundException, InfoNaoCompativelException {
		FuncionarioDAO funcDAO = new FuncionarioDAO();
		ResultSet funcsBuscados = funcDAO.buscarPorNome((vo.getNome()));
		ArrayList<Funcionario> funcs = new ArrayList<>();		            
		    try {
		    	while(funcsBuscados.next()) {
		    	funcs.add(new Funcionario(funcsBuscados.getString("cpf_func"),
		    	funcsBuscados.getString("nome_func"),
		    	funcsBuscados.getString("endereco_func"),
		    	funcsBuscados.getString("senha_func")));
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
