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
    public void inserir (Automovel entity) {

        Connection con = getConnection();
        String sql = "INSERT INTO tb_automovel (placa, cor, modelo, marca, ano, quilometragem, dono) " + "values (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, entity.getPlaca());
            ps.setString(2, entity.getCor());
            ps.setString(3, entity.getModelo());
            ps.setString(4, entity.getMarca());
            ps.setInt(5, entity.getAno());
            ps.setInt(6, entity.getKm());
            ps.setString(7, entity.getCPFDono());
            ps.execute();
            ps.close();
        
        } catch (SQLException e) {
            e.printStackTrace();   
        }
        finally {closeConnection();}
    }
    //=======================================================================================
    @Override
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
    @Override
    public Automovel alterar (Automovel entity) throws SQLException {
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
            ps.setString(6, entity.getCPFDono());
            ps.execute();
            ps.close();
            return entity;
        }
        catch(SQLException e)
        {
            throw e;
        }
        finally {
        	closeConnection();
        	}
    }

//=======================================================================================
    @Override
    public ResultSet buscar (Automovel entity) {

        String sql = "SELECT * FROM tb_automovel WHERE placa=?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getPlaca());
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

//========================================= BUSCAR POR MODELO =========================================
        public ResultSet buscarPorModelo (Automovel entity) {

        String sql = "SELECT * FROM tb_automovel WHERE modelo = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getModelo());
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //====================================== LISTAR ==================================
    @Override
    public List<Automovel> listar()
    {
        Connection con = getConnection();
        String sql = "SELECT * FROM tb_automoveis";
        List<Automovel> pc = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
            	Automovel usu = new Automovel();

                try
                {
                    usu.setPlaca(rs.getString("placa"));
                    usu.setAno(rs.getInt("ano"));
                    usu.setMarca(rs.getString("marca"));
                    usu.setModelo(rs.getString("modelo"));
                    usu.setKm(rs.getInt("quilometragem"));
                    usu.setCPFDono(rs.getString("dono"));
                    usu.setCor(rs.getString("cor"));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                pc.add(usu);
            }
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {closeConnection();}
        return pc;
    }
}