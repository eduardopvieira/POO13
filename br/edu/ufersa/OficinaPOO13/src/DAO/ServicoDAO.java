package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Servico;

public class ServicoDAO extends BaseDAOImpl <Servico>{
    
    @Override
    public Long inserir (Servico entity) {

        Connection con = getConnection();
        String sql = "INSERT INTO tb_servicos (servico_nome, servico_desc, servico_preco) " + "values (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, entity.getServicoNome());
            ps.setString(2, entity.getServicoDescricao());
            ps.setDouble(3, entity.getServicoPreco());
            ps.execute();
            ps.close();
        
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {closeConnection();
            System.out.println("Chegou aqui!"); }
            return null;
    }
    //=======================================================================================

    public void deletar(Servico entity) {

        Connection con = getConnection();
        String sql = "DELETE FROM tb_servicos WHERE id_servico = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, entity.getIdServico());
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

    public void alterar (Servico entity) {
        Connection con = getConnection();
        String sql = "UPDATE tb_servicos SET servico_nome = ?, servico_preco = ? WHERE id_servico = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getServicoNome());
            ps.setDouble(2, entity.getServicoPreco());
            ps.setInt(3, entity.getIdServico());
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
    public ResultSet buscar (Servico entity) {

        String sql = "SELECT * FROM tb_servicos WHERE servico_nome = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getServicoNome()); // Parâmetro para o nome
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //====================================== LISTAR ==================================
    @Override
    public List<Servico> listar(){
		Connection con = BaseDAOImpl.getConnection();
        String sql = "SELECT * FROM tb_servicos";
        List<Servico> lista = new ArrayList<>();
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