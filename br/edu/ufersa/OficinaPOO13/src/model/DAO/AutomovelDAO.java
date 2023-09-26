package model.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.VO.Automovel;

public class AutomovelDAO extends BaseDAOImpl <Automovel>{
    
    @Override
    public Long inserir (Automovel entity) {

        Connection con = getConnection();
        String sql = "INSERT INTO tb_automovel (placa, cor, modelo, ano, quilometragem, dono) " + "values (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, entity.getPlaca());
            ps.setString(2, entity.getCor());
            ps.setString(3, entity.getModelo());
            ps.setInt(4, entity.getAno());
            ps.setInt(5, entity.getKm());
            ps.setString(6, entity.getDono().getCPF());
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

    public void deletar(Automovel entity) {

        Connection con = getConnection();
        String sql = "DELETE FROM tb_automovel WHERE placa = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, entity.getPlaca());
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

    public void alterar (Automovel entity) {
        Connection con = getConnection();
        String sql = "UPDATE tb_automovel SET placa = ?, cor = ?, modelo = ?, ano = ?, quilometragem = ? WHERE dono = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getPlaca());
            ps.setString(2, entity.getCor());
            ps.setString(3, entity.getModelo());
            ps.setInt(4, entity.getAno());
            ps.setInt(5, entity.getKm());
            ps.setString(6, entity.getDono().getCPF());
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
    public ResultSet buscar (Automovel entity) {

        String sql = "SELECT * FROM tb_automovel WHERE placa=?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getPlaca()); // Parâmetro para o PLACA
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

//========================================= BUSCAR POR MODELO =========================================
        public ResultSet buscarPorModelo (Automovel entity) {

        String sql = "SELECT * FROM tb_automovel WHERE modelo=?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getModelo()); // Parâmetro para o PLACA
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //====================================== LISTAR ==================================
    @Override
    public List<Automovel> listar(){
		Connection con = BaseDAOImpl.getConnection();
        String sql = "SELECT * FROM tb_automovel";
        List<Automovel> lista = new ArrayList<>();
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