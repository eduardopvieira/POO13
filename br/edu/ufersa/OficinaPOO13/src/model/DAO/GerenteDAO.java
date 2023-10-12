package model.DAO;

import java.sql.*;
import java.util.List;

import model.VO.Gerente;

import java.util.ArrayList;


public class GerenteDAO extends BaseDAOImpl<Gerente> {
	

    //=================================== INSERIR ===========================================    
	@Override
	public void inserir(Gerente func) {
		Connection con = BaseDAOImpl.getConnection();
		String sql = "INSERT INTO tb_funcionarios (nome_func, cpf_func, senha_func, endereco_func, is_gerente) values (?, ?, ?, ?, ?)";
		String nome = func.getNome();
		String cpf = func.getCPF();
		String senha = func.getSenha();
		String endereco = func.getEndereco();
		Boolean isGerente = func.getIsGerente();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, cpf);
			ps.setString(3, senha);
			ps.setString(4, endereco);
			ps.setBoolean(5, isGerente);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
            BaseDAOImpl.closeConnection();
		}
	}
	
    //==================================== DELETAR =========================================
	@Override
	public void deletar(Gerente func){
        Connection con = BaseDAOImpl.getConnection();
        String sql = "DELETE FROM tb_funcionarios WHERE cpf_func = ?";
        try {
			PreparedStatement ps = con.prepareStatement(sql);
			String cpf = func.getCPF();
            ps.setString(1, cpf);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
            BaseDAOImpl.closeConnection();
		}
    }
    //===================================== ALTERAR ========================================
	@Override
	public void alterar(Gerente func){
        Connection con = BaseDAOImpl.getConnection();
        String sql = "UPDATE tb_funcionarios SET nome_func = ?, senha_func = ?, endereco_func = ? WHERE cpf_func = ?";
        try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, func.getNome());
            ps.setString(2, func.getSenha());
            ps.setString(3, func.getEndereco());
            ps.setString(4, func.getCPF());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
            BaseDAOImpl.closeConnection();
		}
    }
  //==================================== BUSCAR =============================================  
	@Override    
	public ResultSet buscar (Gerente entity) {

        String sql = "SELECT * FROM tb_funcionarios WHERE cpf_func = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getCPF());
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

  //==================================== BUSCAR POR NOME =============================================  
	    public ResultSet buscarPorNome (Gerente entity) {

        String sql = "SELECT * FROM tb_funcionarios WHERE nome_func = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getNome());
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    //=================================== LISTAR ===========================================
	    @Override
	    public ResultSet listar() {
	        ResultSet rs = null;
	        try {
	            Connection con = BaseDAOImpl.getConnection();
	            String sql = "SELECT * FROM tb_funcionarios WHERE isGerente = 1";
	            PreparedStatement statement = con.prepareStatement(sql);
	            rs = statement.executeQuery();
	            BaseDAOImpl.closeConnection();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return rs;
	    }
}