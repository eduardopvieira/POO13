package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.VO.Pecas;
import model.VO.Servico;

public class ServicoDAO extends BaseDAOImpl <Servico>{
    	
	@Override
	public void inserir(Servico entity) {
            try {
                Connection con = BaseDAOImpl.getConnection();
                String sql = "INSERT INTO tb_servicos (servico_nome, servico_desc, servico_preco, servico_id) " + "values (?,?,?,?)";
                PreparedStatement statement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setString(1, entity.getServicoNome());
                statement.setString(2, entity.getServicoDescricao());
                statement.setDouble(3, entity.getServicoPreco());
                statement.setInt(4, entity.getServicoId());
                int affectedRows = statement.executeUpdate();
                if (affectedRows == 0) {
                    throw new Exception("A inserção falhou. Nenhuma linha foi alterada.");
                }
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    entity.setServicoId(generatedKeys.getInt(1));
                } else {
                    throw new Exception("A inserção falhou. Nenhum id foi retornado.");
                }
                statement.close();
                BaseDAOImpl.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
    	}
 
//=================================== Inserir ====================================================
	@Override
    public void deletar(Servico entity) {

        Connection con = getConnection();
        String sql = "DELETE FROM tb_servicos WHERE servico_id = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, entity.getServicoId());
            ps.execute();
            ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally {closeConnection();}
    }
//=======================================================================================
	@Override
    public Servico alterar (Servico entity) throws SQLException{
        Connection con = getConnection();
        String sql = "UPDATE tb_servicos SET servico_nome = ?, servico_desc = ?, servico_preco = ? WHERE servico_id = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getServicoNome());
            ps.setString(2, entity.getServicoDescricao());
            ps.setDouble(3, entity.getServicoPreco());
            ps.setInt(4, entity.getServicoId());
            ps.execute();
            ps.close();
            return entity;
        }
        catch(SQLException e)
        {
        	throw e;
        }
        finally {closeConnection();}
    }

    //===============================BUSCAR POR ID====================================================
	@Override
	public ResultSet buscar(Servico entity) {

        String sql = "SELECT * FROM tb_servicos WHERE servico_id = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setInt(1, entity.getServicoId());
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
	
//================================BUSCAR POR NOME=======================================
	public ResultSet buscarPorNome (Servico entity) {

        String sql = "SELECT * FROM tb_servicos WHERE servico_nome = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getServicoNome());
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //====================================== LISTAR ==================================
	@Override
	public ResultSet listar() {
        ResultSet rs = null;
        try {
            Connection con = BaseDAOImpl.getConnection();
            String sql = "SELECT * FROM tb_servicos";
            PreparedStatement statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            BaseDAOImpl.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

}