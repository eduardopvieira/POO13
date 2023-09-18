package DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Orcamento;

public class OrcamentoDAO extends BaseDAOImpl <Orcamento>{
    
    @Override
    public Long inserir (Orcamento entity) {

        Connection con = getConnection();
        String sql = "INSERT INTO tb_orcamento (cpf_cliente, placa_carro, id_pecas, id_servico, preco_orcamento, data_orcamento) " + "values (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, entity.getClienteOrcamento().getCPF());
            ps.setString(2, entity.getAutomovelOrcamento().getPlaca());
            ps.setInt(3, entity.getPecasOrcamento().getIdItem());
            ps.setInt(4, entity.getServicoOrcamento().getIdServico());
            ps.setDouble(5, entity.getTotalOrcamento());
            ps.setDate(6, (Date) entity.getDataOrcamento());
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

    public void alterar (Orcamento entity) {
        Connection con = getConnection();
        String sql = "UPDATE tb_orcamentos SET cpf_cliente = ?, placa_carro = ?, id_pecas = ?, id_servico = ?, preco_orcamento = ?, data_orcamento = ? WHERE id_orcamento = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getClienteOrcamento().getCPF());
            ps.setString(2, entity.getAutomovelOrcamento().getPlaca());
            ps.setInt(3, entity.getPecasOrcamento().getIdItem());
            ps.setInt(4, entity.getServicoOrcamento().getIdServico());
            ps.setDouble(5, entity.getTotalOrcamento());
            ps.setDate(6, (Date) entity.getDataOrcamento());
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
    public ResultSet buscar (Orcamento entity) {

        String sql = "SELECT * FROM tb_orcamentos WHERE placa_auto = ? OR data_orcamento = ? OR cpf_cliente = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getAutomovelOrcamento().getPlaca()); // Parâmetro para o nome
            ptst.setDate(2, (Date) entity.getDataOrcamento()); // Parâmetro para o CPF
            ptst.setString(3, entity.getClienteOrcamento().getCPF());
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //====================================== LISTAR ==================================
    @Override
    public List<Orcamento> listar(){
		Connection con = BaseDAOImpl.getConnection();
        String sql = "SELECT * FROM tb_orcamentos";
        List<Orcamento> lista = new ArrayList<>();
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