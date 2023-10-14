package model.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.VO.Orcamento;

public class OrcamentoDAO extends BaseDAOImpl <Orcamento>{
    
    @Override
	public void inserir(Orcamento entity) {
            try {
                Connection con = BaseDAOImpl.getConnection();
                String sql = "INSERT INTO tb_orcamentos (cpf, placa, id_peca, servico_id, data_orc, precoTotal, isPago) " + "values (?,?,?,?,?,?,?)";
                PreparedStatement statement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setString(1, entity.getCPFClienteOrcamento());
                statement.setString(2, entity.getPlacaOrc());
                statement.setInt(3, entity.getIdPecaOrcamento());
                statement.setInt(4, entity.getIdServOrc());
                statement.setDate(5, entity.getDataOrcamento());
                statement.setDouble(6, entity.getTotalOrcamento());
                statement.setBoolean(7, entity.getIsPago());
                int affectedRows = statement.executeUpdate();
                if (affectedRows == 0) {
                    throw new Exception("A inserção de orçamento falhou. Nenhuma linha foi inserida.");
                }
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    entity.setIdOrcamento(generatedKeys.getInt(1));
                } else {
                    throw new Exception("A inserção falhou de orçamento falhou. Nenhum id foi retornado.");
                }
                statement.close();
                BaseDAOImpl.closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        String sql = "UPDATE tb_orcamentos SET cpf = ?, placa = ?, id_peca = ?, id_servico = ?, precoTotal = ?, data_orc = ?, isPago = ?, WHERE id_orcamento = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getCPFClienteOrcamento());
            ps.setString(2, entity.getPlacaOrc());
            ps.setInt(3, entity.getIdPecaOrcamento());
            ps.setInt(4, entity.getIdServOrc());
            ps.setDouble(5, entity.getTotalOrcamento());
            ps.setDate(6, (Date) entity.getDataOrcamento());
            ps.setBoolean(7, entity.getIsPago());
            ps.setInt(8, entity.getIdOrcamento());
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

//=======================================================================================
    public ResultSet buscar (Orcamento entity) {

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
    public ResultSet listar() {
        ResultSet rs = null;
        try {
            Connection con = BaseDAOImpl.getConnection();
            String sql = "SELECT * FROM tb_orcamentos";
            PreparedStatement statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            BaseDAOImpl.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

}