package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Pecas;

public class PecasDAO extends BaseDAOImpl <Pecas>{
    
    @Override
    public Long inserir (Pecas entity) {

        Connection con = getConnection();
        String sql = "INSERT INTO tb_pecas (desc_peca, fab_peca, preco_peca, estoque_peca) " + "values (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, entity.getDescricaoItem());
            ps.setString(2, entity.getFabricante());
            ps.setDouble(3, entity.getPrecoItem());
            ps.setInt(4, entity.getEstoqueItem());
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

    public void deletar(Pecas entity) {

        Connection con = getConnection();
        String sql = "DELETE FROM tb_pecas WHERE id_peca = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, entity.getIdItem());
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

    public void alterar (Pecas entity) {
        Connection con = getConnection();
        String sql = "UPDATE tb_pecas SET desc_peca = ?, fab_peca = ?, preco_peca = ?, estoque_peca = ? WHERE id_peca = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getDescricaoItem());
            ps.setString(2, entity.getFabricante());
            ps.setDouble(3, entity.getPrecoItem());
            ps.setInt(4, entity.getEstoqueItem());
            ps.setInt(5, entity.getIdItem());
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
    public ResultSet buscar (Pecas entity) {

        String sql = "SELECT * FROM tb_pecas WHERE desc_item = ? OR fab_peca = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getDescricaoItem()); // Parâmetro para o nome
            ptst.setString(2, entity.getFabricante()); // Parâmetro para o CPF
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //====================================== LISTAR ==================================
    @Override
    public List<Pecas> listar(){
		Connection con = BaseDAOImpl.getConnection();
        String sql = "SELECT * FROM tb_pecas";
        List<Pecas> lista = new ArrayList<>();
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