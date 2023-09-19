package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.entity.Cliente;

public class ClienteDAO extends BaseDAOImpl <Cliente>{
    
    //====================================== INSERIR =======================================
    @Override
    public Long inserir (Cliente entity) {

        Connection con = getConnection();
        String sql = "INSERT INTO tb_clientes (cpf_cliente, nome_cliente, endereco_cliente) " + "values (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, entity.getCPF());
            ps.setString(2, entity.getNome());
            ps.setString(3, entity.getEndereco());
            ps.execute();
            ps.close();
            System.out.println("Adicionado com sucesso.");
        
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {closeConnection();
            System.out.println("Chegou aqui!"); }
            return null;
    }
    //=======================================================================================

    public void deletar(Cliente entity) {

        Connection con = getConnection();
        String sql = "DELETE FROM tb_clientes WHERE cpf_cliente = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, entity.getCPF());
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

    public void alterar (Cliente entity) {
        Connection con = getConnection();
        String sql = "UPDATE tb_clientes SET nome_cliente = ?, endereco = ? WHERE cpf_cliente = ?";

        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, entity.getNome());
            ps.setString(2, entity.getCPF());
            ps.setString(3, entity.getEndereco());
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
    public ResultSet buscar (Cliente entity) {

        String sql = "SELECT * FROM tb_clientes WHERE cpf_cliente = ?";
        PreparedStatement ptst;
        ResultSet rs = null;
    
        try {
            ptst = getConnection().prepareStatement(sql);
            ptst.setString(1, entity.getCPF()); // Parâmetro para o CPF
            System.out.println(ptst);
            rs = ptst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
//=======================================================================================
    @Override
    public List<Cliente> listar(){
		Connection con = BaseDAOImpl.getConnection();
        String sql = "SELECT * FROM tb_clientes";
        List<Cliente> lista = new ArrayList<>();
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
