package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Pessoa;

public class PessoaDAO extends BaseDAOImpl<Pessoa>{
	@Override
	public Long inserir(Pessoa entity){
		String sql = "INSERT INTO tb_pessoa values (?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getNome());
			ps.setString(2, entity.getCPF());
			ps.setString(3, entity.getEndereco());
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {closeConnection();}
		return null;
	}


//===================================METODO DELETAR============================================

    @Override
	public void deletar(Pessoa entity){
		String sql = "delete from Pessoa where cpf = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, entity.getCPF());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {closeConnection();}
	}

//==================================METODO ALTERAR===========================================

	@Override
	public void alterar(Pessoa entity){
		String sql = "update tb_pessoa set nome = ? where cpf= ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, entity.getNome());
			ptst.setString(2, entity.getCPF());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{closeConnection();}
		
	}
	
//====================================METODO LISTAR========================================
	@Override
	public List<Pessoa> listar(){
		Connection con = BaseDAOImpl.getConnection();
        String sql = "SELECT * FROM tb_pessoas";
        List<Pessoa> lista = new ArrayList<>();
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
//==================================METODO BUSCAR============================================
	
	public ResultSet buscar(Pessoa entity) {
        String sql = "SELECT * FROM atualizarPessoa WHERE nome=? OR cpf=?";
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
    
    
//=================================METODO BUSCAR POR NOME========================================
    
	public ResultSet buscarPorNome(Pessoa entity){
		String sql = "select * from Pessoa where nome = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, entity.getNome());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

//=============================================================================================


}