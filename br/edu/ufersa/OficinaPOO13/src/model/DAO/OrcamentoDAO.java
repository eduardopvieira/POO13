package model.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.VO.Orcamento;
import model.VO.Pecas;

public class OrcamentoDAO extends BaseDAOImpl <Orcamento>{
    
    @Override
	public void inserir(Orcamento entity) {
            try {
                Connection con = BaseDAOImpl.getConnection();
                String sql = "INSERT INTO tb_orcamentos (cpf, placa, data_orc, precoTotal, isPago, id_orcamento) values (?,?,?,?,?,?,?,?)";
                PreparedStatement statement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setString(1, entity.getCPFClienteOrcamento());
                statement.setString(2, entity.getPlacaOrc());
                statement.setDate(3, entity.getDataOrcamento());
                statement.setDouble(4, entity.getTotalOrcamento());
                statement.setBoolean(5, entity.getIsPago());
                statement.setInt(6, entity.getIdOrcamento());
                statement.execute();
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {closeConnection();}
    	}
    //=======================================================================================

    public void deletar(Orcamento entity) {

        Connection con = getConnection();
        String sql = "DELETE FROM tb_orcamentos WHERE id_orcamento = ?";
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, entity.getIdOrcamento());
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

    public Orcamento alterar (Orcamento entity) throws SQLException{
        Connection con = getConnection();
        String sql = "UPDATE tb_orcamentos SET cpf = ?, placa = ?, precoTotal = ?, data_orc = ?, isPago = ? WHERE id_orcamento = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getCPFClienteOrcamento());
            ps.setString(2, entity.getPlacaOrc());
            ps.setDouble(3, entity.getTotalOrcamento());
            ps.setDate(4, (Date) entity.getDataOrcamento());
            ps.setBoolean(5, entity.getIsPago());
            ps.setInt(6, entity.getIdOrcamento());
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
    
//==================================ALTERAR ISPAGO================================================================
    public void alterarIsPago (Orcamento entity) throws SQLException{
        Connection con = getConnection();
        String sql = "UPDATE tb_orcamentos SET isPago = ? WHERE id_orcamento = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, entity.getIsPago());
            ps.setInt(2, entity.getIdOrcamento());
            ps.execute();
            ps.close();
        }
        catch(SQLException e)
        {
			throw e;
        }
        finally {closeConnection();}
    }
    
//================================================================================================================
    public ResultSet buscar (Orcamento entity) {

        String sql = "SELECT * FROM tb_orcamentos WHERE id_orcamento = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setInt(1, entity.getIdOrcamento());
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
//=======================================================================================
    public ResultSet buscarPorCliente (Orcamento entity) {

        String sql = "SELECT * FROM tb_orcamentos WHERE cpf = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getCPFClienteOrcamento());
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

//=======================================================================================
    public ResultSet buscarPorPlaca (Orcamento entity) {

        String sql = "SELECT * FROM tb_orcamentos WHERE placa = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getPlacaOrc());
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //=======================================================================================
    public ResultSet buscarPorData (Orcamento entity) {

        String sql = "SELECT * FROM tb_orcamentos WHERE data_orc = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setDate(1, (Date) entity.getDataOrcamento());
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
   //=================================================================================
    /*public ResultSet buscarEntreDatas (Orcamento entity) {

        String sql = "SELECT * FROM tb_orcamentos WHERE data_orcamento BETWEEN ? AND ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setDate(1, (Date) entity.getDataInicio()); //data inicial do menu orçamento
            ptst.setDate(2, (Date) entity.getDatafinal());  //data final do menu orcamento
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }*/

    //====================================== LISTAR ==================================
    @Override
    public List<Orcamento> listar()
    {
        Connection con = getConnection();
        String sql = "SELECT * FROM tb_orcamentos";
        List<Orcamento> pc = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
            	Orcamento usu = new Orcamento();

                try
                {
                    usu.setIdOrcamento(rs.getInt("id_orcamento"));
                	usu.setCPFClienteOrcamento(rs.getString("cpf"));
                    usu.setPlacaOrc(rs.getString("placa"));
                    usu.setIsPago(rs.getBoolean("ispago"));
                    usu.setDataOrcamento(rs.getDate("data_orc"));
                    usu.setTotalOrcamento(rs.getDouble("precototal"));
                    
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