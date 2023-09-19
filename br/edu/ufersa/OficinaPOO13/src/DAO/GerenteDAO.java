package DAO;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
//import br.edu.ufersa.Oficina.src.model.entity.Gerente;

import model.entity.Gerente;


public class GerenteDAO extends BaseDAOImpl<Gerente> {
	

    //=================================== INSERIR ===========================================    
	public Long inserir(Gerente func) {
		Connection con = BaseDAOImpl.getConnection();
		String sql = "INSERT INTO tb_gerentes (nome, cpf_gerente, senha, endereco) values (?, ?, ?, ?)";
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
	public void deletar(Gerente func){
        Connection con = BaseDAOImpl.getConnection();
        //String rua = func.getId();
        String sql = "DELETE FROM tb_gerentes WHERE cpf_gerente = ?";
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
	public void alterar(Gerente func){
        Connection con = BaseDAOImpl.getConnection();
        String sql = "UPDATE tb_gerentes SET nome = ?, senha = ?, endereco = ? WHERE cpf_gerente = ?";
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
	    public ResultSet buscar (Gerente entity) {

        String sql = "SELECT * FROM tb_gerentes WHERE nome=? OR cpf=?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getNome()); // Parâmetro para o nome
            ptst.setString(2, entity.getCPF()); // Parâmetro para o CPF
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    //=================================== LISTAR ===========================================
	public List<Gerente> listar(){
		Connection con = BaseDAOImpl.getConnection();
        String sql = "SELECT * FROM tb_gerentes";
        List<Gerente> lista = new ArrayList<>();
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