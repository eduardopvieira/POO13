package DAO;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
//import br.edu.ufersa.Oficina.src.model.entity.Funcionario;

import model.entity.Funcionario;


public class FuncionarioDAO extends BaseDAOImpl<Funcionario> {
	

    //=================================== INSERIR ===========================================    
	public Long inserir(Funcionario func) {
		Connection con = BaseDAOImpl.getConnection();
		String sql = "INSERT INTO tb_funcionarios (nome_func, cpf_func, senha_func, endereco_func) values (?, ?, ?, ?)";
		String nome = func.getNome();
		String cpf = func.getCPF();
		String senha = func.getSenha();
		String endereco = func.getEndereco();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, cpf);
			ps.setString(3, senha);
			ps.setString(4, endereco);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
            BaseDAOImpl.closeConnection();
		}
		return null;
	}
	
    //==================================== DELETAR =========================================
	public void deletar(Funcionario func){
        Connection con = BaseDAOImpl.getConnection();
        //String rua = func.getId();
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
	public void alterar(Funcionario func){
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
	    public ResultSet buscar (Funcionario entity) {

        String sql = "SELECT * FROM tb_funcionarios WHERE cpf_func= ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getCPF()); // Parâmetro para o CPF
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

  //================================ BUSCAR POR NOME =============================================  
	    public ResultSet buscarPorNome (Funcionario entity) {

        String sql = "SELECT * FROM tb_funcionarios WHERE nome_func= ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getNome()); // Parâmetro para o CPF
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    //=================================== LISTAR ===========================================
	public List<Funcionario> listar(){
		Connection con = BaseDAOImpl.getConnection();
        String sql = "SELECT * FROM tb_funcionarios";
        List<Funcionario> lista = new ArrayList<>();
        try {
			PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
            BaseDAOImpl.closeConnection();
		}
		return lista;
	}
}